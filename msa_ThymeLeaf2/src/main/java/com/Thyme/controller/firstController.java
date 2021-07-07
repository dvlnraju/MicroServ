package com.Thyme.controller;

import java.net.Authenticator.RequestorType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class firstController {

	@Autowired
	private utilities util;
	
	//@ResponseBody
	@GetMapping(value="/thy2/init")
	public String welcome() {
		System.out.println("welcome");
		return "welcome";
	}
	
	
	@GetMapping(value="/thy2/proj")
	public ModelAndView proj() {
		System.out.println("proj");
		ModelAndView mv = new ModelAndView("projTemplate");
		mv.addObject("message", "this project is part of microservice deployment");
		return mv;
	}
	
	@GetMapping(value="/thy2/obj")
	public ModelAndView obj() {
		System.out.println("obj");
		ModelAndView mv = new ModelAndView("object");
		Map<String, String>uriVariables=new HashMap<>();
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Obj>> responseEntity = restTemplate.exchange("http://127.0.0.1:8091/thy1/objprov", HttpMethod.POST, util.getHttpEntity(MediaType.APPLICATION_JSON, new ProcessResponse()), 
				new ParameterizedTypeReference<List<Obj>>() {
				}, uriVariables);
		List<Obj> objArray = responseEntity.getBody();
		return mv.addObject("objects",responseEntity.getBody());
	}
	
	@GetMapping(value="/thy2/det")
	public ModelAndView preForm() {
		System.out.println("det");
		ModelAndView mv = new ModelAndView("classform");
		Obj obj = new Obj(); obj.setClassName("test1");
		mv.addObject("object",obj);
		return mv;
	}
	
	@RequestMapping(value="/thy2/detForm", method = RequestMethod.POST)
	public ModelAndView postForm(/* @RequestBody Obj obj */  @ModelAttribute Obj obj ) {
		System.out.println("detForm");
		ModelAndView mv = new ModelAndView("classform");
		obj.setProperties(obj.getProperties()+" : saved");
		mv.addObject("object",obj);
		return mv;
	}
	
	public ProcessResponse getResponseBoody(String url, HttpMethod method, Class<ProcessResponse> class1, Map<String, String> uriVariables) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<ProcessResponse> httpEntity = util.getHttpEntity(MediaType.APPLICATION_JSON, new ProcessResponse());
		ResponseEntity<ProcessResponse> responseEntity = restTemplate.exchange(url, method, httpEntity, class1, uriVariables);
		System.out.println("Status Code: " + responseEntity.getStatusCode());
		return responseEntity.getBody();
	}
}
