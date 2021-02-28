package com.mtwo.uri;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mtwo.util.utilities;
import com.mtwo.bean.ProcessResponse;
import com.mtwo.entity.ApplicationDetails;
import com.mtwo.feign.FeignClientm3;
import com.mtwo.service.ApplicationService;
import com.mtwo.bean.microTwo;

@Component
@RestController
public class MicroTwoController {

	@Autowired
	private Configuration config;
	 
	@Autowired
	private ApplicationService appService;
	
	@Autowired
	private utilities util;
	
	@Autowired
	private FeignClientm3 feignm3;
	
	@GetMapping("/info")
	public microTwo getServiceInfo() {
		return new microTwo(1000,1);
	}
	
	@GetMapping("/proj")
	public Configuration getProjInfo() {
		return config;
	}
	
	@GetMapping("/appm2/{sId}")
	public ProcessResponse appProcessingm2(@PathVariable Integer sId) {
		if (sId != null && /* config.getAppend().equals("RAJU") && */ util.checkm3Availability().isStatusFlag()) {
			ApplicationDetails appDetails = new ApplicationDetails();
			appDetails.setId(sId);
			appDetails.setM2Status("m3_wait");
			//sId = appService.saveApplication(appDetails);
			sId = appService.updateApplicationRepo(appDetails);
			if(sId!=0) {
				Map<String, String>uriVariables=new HashMap<>();  
				uriVariables.put("sId", sId.toString());  
				System.out.println("calling appm3");
				//ProcessResponse response = getResponseBoody("http://127.0.0.1:8082/appm3/{sId}",  HttpMethod.GET, ProcessResponse.class, uriVariables);
				ProcessResponse response = feignm3.appProcessingm3(sId).getBody();
				return response;
			}
		}
		return new ProcessResponse(false,"failure");
	}
	
	public ProcessResponse getResponseBoody(String url, HttpMethod method, Class<ProcessResponse> class1, Map<String, String> uriVariables) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<ProcessResponse> httpEntity = util.getHttpEntity(MediaType.APPLICATION_JSON, new ProcessResponse());
		ResponseEntity<ProcessResponse> responseEntity = restTemplate.exchange(url, method, httpEntity, class1, uriVariables);
		System.out.println("Status Code: " + responseEntity.getStatusCode());
		return responseEntity.getBody();
	}
	
}
