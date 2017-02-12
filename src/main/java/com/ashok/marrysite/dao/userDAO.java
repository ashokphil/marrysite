package com.ashok.marrysite.dao;

import java.util.List;

import com.ashok.marrysite.model.SearchCriteria;
import com.ashok.marrysite.model.User;

public interface userDAO {
	
	public void addUser(User user);
	public void updatePerson(User user);
	public List<User> Users();
    public User findByUsername(String username);
	public List<User> searchUsers(SearchCriteria searchcriteria,int firstresult);
	public void mergeUser(User userexpress);
	public Long searchsize(SearchCriteria searchcriteria);

}
