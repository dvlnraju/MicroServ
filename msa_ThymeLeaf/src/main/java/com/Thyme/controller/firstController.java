package com.Thyme.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class firstController {

	//@ResponseBody
	@GetMapping(value="/thy1/init")
	public String welcome() {
		System.out.println("welcome");
		return "welcome";
	}
	
	
	@GetMapping(value="/thy1/proj")
	public ModelAndView proj() {
		System.out.println("proj");
		ModelAndView mv = new ModelAndView("projTemplate");
		mv.addObject("message", "this project is part of microservice deployment");
		return mv;
	}
	
	@GetMapping(value="/thy1/obj")
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
	
	@ResponseBody
	@PostMapping(value="/thy1/objprov", produces = "application/json")
	public ArrayList<Obj> objprov() {
		System.out.println("objprov");
		ArrayList<Obj> objs = new ArrayList<Obj>();
		Obj obj1 = new Obj(); obj1.setClassName("test1");
		Obj obj2 = new Obj(); obj2.setClassName("test2");
		objs.add(obj1);objs.add(obj2);
		return objs;
	}
	
	@GetMapping(value="/thy1/det")
	public ModelAndView preForm() {
		System.out.println("det");
		ModelAndView mv = new ModelAndView("classform");
		Obj obj = new Obj(); obj.setClassName("test1");
		mv.addObject("object",obj);
		return mv;
	}
	
	@PostMapping(value="/thy1/detForm")
	public ModelAndView postForm(@RequestBody Obj obj/* @ModelAttribute Obj obj */) {
		System.out.println("detForm");
		ModelAndView mv = new ModelAndView("classform");
		obj.setProperties(obj.getProperties()+" : saved");
		mv.addObject("object",obj);
		return mv;
	}
}
