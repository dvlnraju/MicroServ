package com.feature.feign;

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

@Component
@FeignClient("msaIntGWLB") 
//@FeignClient(value = "${feign.client1}", url = "${feign.url1}"/* ,fallback = FeignClientm2.class */)
//@LoadBalancerClient(name = "common", configuration = CloudProviderConfiguration.class)
public interface FeignClientGW {
	
	@GetMapping("/checkValidity")
	ResponseEntity<String> checkValidity(@RequestHeader("Authorization") String token);
	
}
