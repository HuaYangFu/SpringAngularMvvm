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

@Controller
public class IndexController{

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
    	return "index";
    }
    
}