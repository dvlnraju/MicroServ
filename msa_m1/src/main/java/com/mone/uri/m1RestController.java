package com.mone.uri;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mone.bean.ProcessResponse;
import com.mone.entity.ApplicationDetails;
import com.mone.feign.FeignClientm2;
import com.mone.service.ApplicationService;
import com.mone.util.ThrowBackException;
import com.mone.util.utilities;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class m1RestController {

	@Autowired
	private FeignClientm2 feignm2;
	
	@Autowired
	private ApplicationService applService;
	
	@Autowired
	private utilities util;
	
	@GetMapping("/appm1/history/{id}")
	@ResponseBody
	public List<ApplicationDetails> getHistory(@PathVariable("id") Integer applicationid){
		System.out.println("Inside m1 getHistory");
		List<ApplicationDetails> appdetails = applService.getByApplicationId(applicationid);
		return util.checkm2Availability().isStatusFlag()? feignm2.arrange(appdetails).getBody() : null;
	}
	
	@GetMapping("/appm1/allhistory")
	@ResponseBody
	public List<ApplicationDetails> getAllHistory(){
		List<ApplicationDetails> appdetails = applService.getAll();
		//System.out.println(appdetails);
		ProcessResponse proResp = util.checkm2Availability();
		System.out.println("FallBack getAllHistory :"+proResp.getStatusMessage());
		return proResp.isStatusFlag()? feignm2.arrangeall(appdetails).getBody() : null;
	}
	
	
}
