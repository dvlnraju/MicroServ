package com.mone.feign;

import java.util.List;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.mone.entity.ApplicationDetails;
import com.mone.bean.ProcessResponse;

@Component
@FeignClient("msaIntGWLB") 
//@FeignClient(value = "${feign.client1}", url = "${feign.url1}"/* ,fallback = FeignClientm2.class */)
//@LoadBalancerClient(name = "common", configuration = CloudProviderConfiguration.class)
public interface FeignClientm2 {
	
	@PostMapping("appm2/arrange")
	ResponseEntity<List<ApplicationDetails>> arrange(@RequestBody List<ApplicationDetails> appDetails);
	
	@PostMapping("appm2/arrangeall")
	ResponseEntity<List<ApplicationDetails>> arrangeall(@RequestBody List<ApplicationDetails> appDetails);

	@GetMapping("/appm2/{sId}")
	ResponseEntity<ProcessResponse>  appProcessingm2(@PathVariable Integer sId);

	@GetMapping("appm2/m2Avail")
	ResponseEntity<ProcessResponse> fetchm2Availability();
	
	@GetMapping("/checkValidity")
	ResponseEntity<String> checkValidity(@RequestHeader("Authorization") String token);
	
}
