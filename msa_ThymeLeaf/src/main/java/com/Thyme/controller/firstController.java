package com.Thyme.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class firstController {

	//@ResponseBody
	@RequestMapping(value="/init",method = RequestMethod.GET)
	public String welcome() {
		System.out.println("welcome");
		return "welcome";
	}
	
	
	@RequestMapping(value="/proj",method = RequestMethod.GET)
	public ModelAndView proj() {
		System.out.println("proj");
		ModelAndView mv = new ModelAndView("projTemplate");
		mv.addObject("message", "this project is part of microservice deployment");
		return mv;
	}
	
	@RequestMapping(value="/obj",method = RequestMethod.GET)
	public ModelAndView obj() {
		System.out.println("obj");
		ModelAndView mv = new ModelAndView("object");
		List<Obj> objs = new ArrayList<Obj>();
		Obj obj1 = new Obj(); obj1.setClassName("test1");
		Obj obj2 = new Obj(); obj2.setClassName("test2");
		objs.add(obj1);objs.add(obj2);
		mv.addObject("objects",objs);
		return mv;
	}
	
	@RequestMapping(value="/det",method = RequestMethod.GET)
	public ModelAndView preForm() {
		System.out.println("det");
		ModelAndView mv = new ModelAndView("classform");
		Obj obj = new Obj(); obj.setClassName("test1");
		mv.addObject("object",obj);
		return mv;
	}
	
	@RequestMapping(value="/detForm",method = RequestMethod.POST)
	public ModelAndView postForm(/* @RequestBody Obj obj */@ModelAttribute Obj obj) {
		System.out.println("detForm");
		ModelAndView mv = new ModelAndView("classform");
		obj.setProperties(obj.getProperties()+" : saved");
		mv.addObject("object",obj);
		return mv;
	}
}
