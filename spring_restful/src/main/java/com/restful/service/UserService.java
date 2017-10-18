package com.restful.service;

import com.restful.dao.UserDAO;
import com.restful.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service("userService")
public class UserService {
	
    @Autowired
    private UserDAO userDAO;
    
	public List<User> findAllUsers() {
		return userDAO.getAllUsers();
	}
	
	public User findById(long id) {
		List<User> users = userDAO.getAllUsers();
		for(User user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public User findByName(String name) {
		List<User> users = userDAO.getAllUsers();
		for(User user : users){
			if(user.getUsername().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	
	public void saveUser(User user) {
		userDAO.savelUser(user);
	}

	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	public void deleteUserById(long id) {
		User user = this.findById(id);
		userDAO.deleteUser(user);
	}

	public boolean isUserExist(User user) {
		return findByName(user.getUsername())!=null;
	}
	
	public void deleteAllUsers(){
		List<User> users = this.findAllUsers();
		for(User user : users) {
			userDAO.deleteUser(user);
		}
	}
	
}
