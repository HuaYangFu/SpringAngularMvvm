package com.restful.controller;

import com.restful.entity.User;
import com.restful.service.UserService;

import org.json.JSONArray;
import org.json.JSONObject;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController{

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    @ResponseBody
    public String getAllUsers() {
    	JSONObject json = new JSONObject();
    	List<User> users = userService.findAllUsers();
    	json.put("users", users);
        return json.toString();
    }
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getUser(@PathVariable("id") long id) {
    	User user = userService.findById(id);
    	JSONObject json = new JSONObject();
    	if(user != null) {
    		json.put("user", user);
    	}
    	else {
    		json.put("error", "user not exit");
    	}
        return json.toString();
    }
     
    //-------------------Create a User--------------------------------------------------------
     
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public String createUser(@RequestBody User user) {
        String result = "success";
        if (userService.isUserExist(user)) {
        	result = "A User with name " + user.getUsername() + " already exist";
            return result;
        }
 
        userService.saveUser(user);
 
        return result;
    }
 
    
     
    //------------------- Update a User --------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable("id") long id, @RequestBody User user) {
    	String result = "success";
        User currentUser = userService.findById(id);
         
        if (currentUser==null) {
        	result = "User with id " + id + " not found";
            return result;
        }
 
        currentUser.setUsername(user.getUsername());
        currentUser.setAddress(user.getAddress());
        currentUser.setEmail(user.getEmail());
         
        userService.updateUser(currentUser);
        return result;
    }
 
    
    
    //------------------- Delete a User --------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") long id) {
    	String result = "success";
        User user = userService.findById(id);
        if (user == null) {
        	result = "Unable to delete. User with id " + id + " not found";
            return result;
        }
 
        userService.deleteUserById(id);
        return result;
    }
 
     
    
    //------------------- Delete All Users --------------------------------------------------------
     
    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public String deleteAllUsers() {
    	String result = "success";
        userService.deleteAllUsers();
        return result;
    }
}