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
@RequestMapping("/user")
public class UserController{

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @ResponseBody
    public String getAllUsers() {
    	JSONObject json = new JSONObject();
    	List<User> users = userService.getAllUsers();
    	json.put("users", users);
        return json.toString();
    }
    
    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getUser(@PathVariable("id") long id) {
    	User user = userService.getUser(id);
    	JSONObject json = new JSONObject();
    	if(user != null) {
    		json.put("user", user);
    	}
    	else {
    		json.put("error", "user not exit");
    	}
        return json.toString();
    }
}