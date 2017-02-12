package com.ashok.marrysite.controller;

import java.io.BufferedOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ashok.marrysite.dao.UserDAOImpl;
import com.ashok.marrysite.dao.userDAO;
import com.ashok.marrysite.model.IP;
import com.ashok.marrysite.model.JsonLogo;
import com.ashok.marrysite.model.User;
import com.ashok.marrysite.service.UserService;

@Controller
public class FileUploadController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	@Autowired
	UserService userservice;
	@Autowired
	userDAO userdao;
	@Autowired
	MailSender mailSender;
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public 	@ResponseBody String uploadFileHandler(MultipartHttpServletRequest request,@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) {
		System.out.println("tttttttttttttttttttttttttttttttttt");
		

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				System.out.println(dir);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File("C:\\test" +File.separator + name);
				System.out.println(serverFile);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				

				return "You successfully uploaded file=" + name;
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name
					+ " because the file was empty.";
		}
	}
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String upload(){
		
		return "upload";
	}
	
	@RequestMapping(value="/AddUser.htm",method=RequestMethod.GET)
	public String showForm(Model m){
		m.addAttribute("name", "");
		return "AddUser";
	} 
	
	@RequestMapping(value="/AddUser.htm",method=RequestMethod.POST)
	public @ResponseBody String addUser(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file ){ 
		String returnText;
		System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeee");
		
		
			returnText = "Sorry, an error has occur. User has not been added to list.";
		
		return returnText;
	}
	@RequestMapping(value = "upload-logo", method = RequestMethod.POST)
	@ResponseBody
	public JsonLogo uploadLogo(MultipartHttpServletRequest request,@RequestParam("idLogoFile") MultipartFile file) {
	    try {
	    	System.out.println("inside uploadlogo");
	    	logger.info("inside uploadlogo");
	    	
	    	System.out.println("religion.required");
	 //Iterator<String> itr = request.getFileNames();
	 //System.out.println(itr.next());
	 //MultipartFile multipartFile=null;
	 //multipartFile = request.getFile(itr.next());
	 User user=userdao.findByUsername(getPrincipal());
	 JsonLogo logo = new JsonLogo();
	 if (file.getBytes().length > 0) {   
		 System.out.println("next picture");
		 System.out.println(file.getOriginalFilename());
		 System.out.println(Base64.encodeBase64(file.getBytes()).length);
	     logo.setImage(new String(Base64.encodeBase64(file.getBytes())));
	 }   
	 //System.out.println(logo.getImage());
	 
	 user.setJsonLogo(logo);
	 userservice.updateUser(user);
	 //user=userdao.findByUsername(getPrincipal());
	 //System.out.println(logo.getImage());
	 //System.out.println(user.getJsonLogo().getImage());
	 return logo;
	    } catch (Exception e) {
	 //Handle exception if any
	    e.printStackTrace();
	    }
	    return null;
	}
	
	@RequestMapping(value = "check-user", method = RequestMethod.GET)
	@ResponseBody
	public String checkuser(@RequestParam("username") String username) {
	    System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
		String check="";
	 User user=userdao.findByUsername(username);
	 if (user!=null){
		 check="username already exists";
	 }else
		 check="         ";
    
	    return check;
	}
	@Value("${test}")
	private String test;
	

	
	@RequestMapping(value = "contact", method = RequestMethod.GET)
	@ResponseBody
	public String contact(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("phone") String phone,@RequestParam("message") String messagemail) {
	    System.out.println(test);
	    System.out.println(email);
	    SimpleMailMessage message = new SimpleMailMessage();	    
	    message.setTo("ashokphil@gmail.com");
	    message.setSubject("help");
	    message.setText(messagemail);
	    mailSender.send(message);
	 return "success";
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
    
    @RequestMapping(value = "ip", method = RequestMethod.GET)
    private String  getEmployees()
    {
    	final String uri = "http://geo.groupkt.com/ip/172.217.3.14/json";
    	
    	RestTemplate restTemplate = new RestTemplate();
    	List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();

    	//Add the Jackson Message converter
    	messageConverters.add(new MappingJackson2HttpMessageConverter());

    	//Add the message converters to the restTemplate
    	restTemplate.setMessageConverters(messageConverters); 
    	
    	IP result = restTemplate.getForObject(uri, IP.class);
        //String  result1 = restTemplate.getForObject(uri, String.class);
    	
    	System.out.println(result);
    	//System.out.println(result1);
    	
    	
    	return "myip";
    }


}
