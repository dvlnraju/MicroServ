package com.mtwo.uri;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mtwo.bean.ProcessResponse;
import com.mtwo.entity.ApplicationDetails;

@RestController
public class m2RestController {
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping("appm2/m2Avail")
	ProcessResponse fetchm2Availability(){
		return new ProcessResponse(true,"available");
	}
	
	@PostMapping("appm2/arrange")
	@ResponseBody
	public List<ApplicationDetails> arrange(@RequestBody List<ApplicationDetails> appDetails){
		System.out.println("Inside m2 Arrange :"+port);
		Comparator<ApplicationDetails> compareById = ((ApplicationDetails o1, ApplicationDetails o2) -> o1.getId()>o2.getId()?1:0 );
		Collections.sort(appDetails, compareById.reversed());
		/*
		 * or can also be done by ( implements comparaable in AppliationDetails) and
		 * implementing comparTo => using Collections.sort
		 */
		return appDetails;
	}
	
	@PostMapping("appm2/arrangeall")
	@ResponseBody
	public List<ApplicationDetails> arrangeall(@RequestBody List<ApplicationDetails> appDetails){
		System.out.println("Inside m2 ArrangeAll :"+port);
		Comparator<ApplicationDetails> compareById = ((ApplicationDetails o1, ApplicationDetails o2) -> o1.getApplicationId()>o2.getApplicationId()?1:0 );
		Collections.sort(appDetails, compareById.reversed());
		return appDetails;
	}
	
	
}
