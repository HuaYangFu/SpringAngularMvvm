package com.restful.controller;

import com.restful.entity.User;
import com.restful.service.UserService;

import org.json.JSONObject;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Lexel PRO
 * @version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController{

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public JSONObject getAllUsers() {
    	JSONObject json = new JSONObject();
        return json;
    }
    
    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public JSONObject getAllUsers(@PathVariable("id") Long id) {
    	JSONObject json = new JSONObject();
        return json;
    }
}