package com.ashok.marrysite.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.ashok.marrysite.dao.userDAO;
import com.ashok.marrysite.model.Role;
import com.ashok.marrysite.model.User;
@Component
@Service
public class CustomUserDetailsService implements UserDetailsService{
	 	@Autowired(required=true)
		private userDAO userdao;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("User : "+username);
		System.out.println(userdao);
		User user = userdao.findByUsername(username);
        System.out.println("User : "+user);
        if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
            return new org.springframework.security.core.userdetails.User(user.getLoginname(), user.getPassword(), 
                 "Active".equals("Active"), true, true, true, getGrantedAuthorities(user));
		
	}
	
	
    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
         
        
            authorities.add(new SimpleGrantedAuthority("ROLE_"+user.getRole()));
        
        System.out.print("authorities :"+authorities);
        return authorities;
    }

}
