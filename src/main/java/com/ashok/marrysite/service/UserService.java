package com.ashok.marrysite.service;

import java.util.List;

import com.ashok.marrysite.model.SearchCriteria;
import com.ashok.marrysite.model.User;

public interface UserService {

	public void addUser(User user);
	public void updateUser(User user);
	public List<User> listPersons();
	public List<User> search(SearchCriteria searchcriteria,int firstresult);
	public void mergeUser(User userexpress);
	public Long searchsize(SearchCriteria searchcriteria);
	 
	
}
