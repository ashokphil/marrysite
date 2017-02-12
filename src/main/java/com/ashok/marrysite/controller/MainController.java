package com.ashok.marrysite.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.ashok.marrysite.dao.userDAO;
import com.ashok.marrysite.model.Login;
import com.ashok.marrysite.model.Role;
import com.ashok.marrysite.model.SearchCriteria;
import com.ashok.marrysite.model.User;
import com.ashok.marrysite.service.CustomUserDetailsService;
import com.ashok.marrysite.service.UserService;
import com.mysql.jdbc.Blob;
@Controller
@SessionAttributes({"viewuser","user"})

public class MainController {
	@Autowired
	UserService userservice;
	@Autowired
	userDAO userdao;
	@Autowired
	@Qualifier("userValidator")
	private Validator validator;

	

	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(Model model){
        User userForm = new User();
       
        model.addAttribute("userForm", userForm);
			
		return "register";
		
	}
	
	
	  @ExceptionHandler({SQLException.class,DataAccessException.class})
	  public String databaseError() {
	    // Nothing to do.  Returns the logical view name of an error page, passed
	    // to the view-resolver(s) in usual way.
	    // Note that the exception is NOT available to this view (it is not added
	    // to the model) but see "Extending ExceptionHandlerExceptionResolver"
	    // below.
	    return "databaseError";
	  }
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public String search(Model model){
        SearchCriteria searchcriteria = new SearchCriteria();
       
        model.addAttribute("searchcriteria", searchcriteria);
			
		return "search";
		
	}
	
	@RequestMapping(value="/searchaction",method=RequestMethod.GET)
	public String searchAction(@RequestParam("gender")String gender,@RequestParam("religion")String religion,Model model,@RequestParam("page")String page){
		//String gender="";
		//System.out.println(searchcriteria.getAgefrom()+searchcriteria.getAgeto()+searchcriteria.getReligion())
		/*if(male){
		 gender="male";
			
		}else*/
		//@RequestParam("male") 
		
		//String religion="christian";
			
			//gender="female";
		SearchCriteria searchcriteria=new SearchCriteria();
		//System.out.println(male);
		System.out.println(religion);
		
		searchcriteria.setGender(gender);
		searchcriteria.setReligion(religion);
		Long pageno=userservice.searchsize(searchcriteria);
		System.out.println(pageno);
		int firstresult=Integer.parseInt(page)*10;
	    List<User> users=userservice.search(searchcriteria,firstresult);
        model.addAttribute("pageno",pageno);
        model.addAttribute("userList", users);
        model.addAttribute("gender",gender);
        model.addAttribute("religion",religion);
			
		return "search";
		
	}
	
	@RequestMapping(value="/viewall",method=RequestMethod.GET)
	public String viewallaction(@RequestParam("loginname")String loginname,Model model){
        System.out.println(getPrincipal());
        System.out.println(loginname);
        
        User user=userdao.findByUsername(loginname);
        System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");

        model.addAttribute("viewuser", user );
                
        
		return "viewall";
		
	}
	
	
	@RequestMapping(value="/interests",method=RequestMethod.GET)
	public String interestaction(@ModelAttribute("user") User user,Model model){

		List<User>interestlist=user.getExpressedinterests();
        
       model.addAttribute("viewinterest", interestlist );
                
        
		return "viewinterest";
		
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(Model model){
        Login login = new Login();    
        model.addAttribute("login", login );
			
		return "login";
		
	}
	
	@RequestMapping(value="/loginaction",method=RequestMethod.GET)
	public String loginaction(Model model){
        System.out.println(getPrincipal());
        
        User user=userdao.findByUsername(getPrincipal());
        System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");

        model.addAttribute("user", user );
                
        
		return "home";
		
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String editsuccess(@ModelAttribute("user") User user,Model model){
		
		userservice.updateUser(user);		
		model.addAttribute("user", user);
		
		return "home";
	}
	
	@RequestMapping(value="/express",method=RequestMethod.GET)
	public String expresssuccess(@ModelAttribute("viewuser") User viewuser,@ModelAttribute("user") User user,Model model){
		User userexpress=userdao.findByUsername(viewuser.getLoginname());
		userexpress.getExpressedinterests().add(user);
		userservice.updateUser(userexpress);		
		model.addAttribute("user", user);
		
		return "home";
	}
	
	@RequestMapping(value="/registersuccess",method=RequestMethod.GET)
	public String registersuccess(@ModelAttribute("userForm") User user,BindingResult bindingResult,Model model){
		
		validator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			return "register";
		}
		 Role role=new Role();
	     role.setRole_name("nonadmin");
	     user.setRole(role);
		userservice.addUser(user);
		model.addAttribute("success", "you hve successfully registered.Please login to continue");
		
		return "forward:/login";
	}
	    @RequestMapping(value = "/admin", method = RequestMethod.GET)
	    public String adminPage(ModelMap model) {
	        model.addAttribute("user", getPrincipal());
	        return "admin";
	    }
	 
	    @RequestMapping(value = "/db", method = RequestMethod.GET)
	    public String dbaPage(ModelMap model) {
	        model.addAttribute("user", getPrincipal());
	        return "dba";
	    }
	 
	    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	    public String accessDeniedPage(ModelMap model) {
	        model.addAttribute("user", getPrincipal());
	        return "accessDenied";
	    }
	 
	   	 
	    @RequestMapping(value="/logout", method = RequestMethod.GET)
	    public String logoutPage (HttpServletRequest request, HttpServletResponse response,SessionStatus status) {
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null){    
	            new SecurityContextLogoutHandler().logout(request, response, auth);
	        }
	        status.setComplete();
	        return "redirect:/login?logout";
	    }
	 
	    private String getPrincipal(){
	        String userName = null;
	        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 
	        if (principal instanceof UserDetails) {
	            userName = ((UserDetails)principal).getUsername();
	        } else {
	            userName = principal.toString();
	        }
	        return userName;
		
	}

}
