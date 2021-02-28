package com.mtwo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mtwo.bean.ProcessResponse;

@Component
@FeignClient("msaIntGWLB")
//@FeignClient(value="${feign.client1}",url="${feign.url1}")
public interface FeignClientm3 {
	
	@GetMapping("/appm3/{sId}")
	ResponseEntity<ProcessResponse> appProcessingm3(@PathVariable Integer sId);
	
	@GetMapping("appm3/m3Avail")
	ResponseEntity<ProcessResponse> fetchm3Availability();
}
