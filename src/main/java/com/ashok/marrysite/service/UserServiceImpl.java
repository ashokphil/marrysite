package com.ashok.marrysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashok.marrysite.dao.userDAO;
import com.ashok.marrysite.model.SearchCriteria;
import com.ashok.marrysite.model.User;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private userDAO userdao;

	public void addUser(User user) {
		// TODO Auto-generated method stub
		userdao.addUser(user);
		
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userdao.updatePerson(user);
		
	}

	public List<User> listPersons() {
		// TODO Auto-generated method stub
		List<User> users=userdao.Users();
		return users;
	}

	public List<User> search(SearchCriteria searchcriteria,int firstresult) {
		// TODO Auto-generated method stub
		List<User> users=userdao.searchUsers(searchcriteria,firstresult);
		return users;
	}
	
	public void mergeUser(User userexpress){
		userdao.mergeUser(userexpress);
	}

	public Long searchsize(SearchCriteria searchcriteria) {
		// TODO Auto-generated method stub
		Long pageno=userdao.searchsize(searchcriteria);
		return pageno;
	}

	
}
