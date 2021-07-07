package com.mone.uri;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
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

import com.mone.bean.ProcessResponse;
import com.mone.bean.microOne;
import com.mone.entity.ApplicationDetails;
import com.mone.feign.FeignClientm2;
import com.mone.service.ApplicationService;
import com.mone.util.utilities;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
@RestController
//@Path("/appm1")
public class MicroOneController {

	@Autowired
	private Configuration config;
	
	@Autowired
	private FeignClientm2 feignm2;
	
	@Autowired  ApplicationService appService;
	
	@Autowired
	private utilities util;
	
	@GetMapping("/appm1/info")
	public microOne getServiceInfo() {
		return new microOne(1000,1);
	}
	
	@GetMapping("/appm1/proj")
	//@Produces
	//@Consumes
	public Configuration getProjInfo() {
		return config;
	}
	
	@GetMapping("/appm1/{applicationId}/{action}")
	//@CircuitBreaker(name = "msam2", fallbackMethod = "appProcessingm1fallback")
	//@RateLimiter(name = "msam2")
	//@Retry(name = "msam2")
	//@Bulkhead(name = "msam2")
	public ProcessResponse appProcessingm1(@PathVariable Integer applicationId,@PathVariable String action) {
		if(applicationId!=null && action!=null && applicationId>1000 && config.getActionsAllowed().contains(action)
				&& util.checkm2Availability().isStatusFlag()) {
			ApplicationDetails appDetails = new ApplicationDetails();
			appDetails.setApplicationId(applicationId);
			appDetails.setActionName(action);
			appDetails.setM1Status("m2_wait");
			List<ApplicationDetails> appDetailsChk = appService.getByApplicationId(applicationId);
			Integer sId = 0;
			if(appDetailsChk==null || appDetailsChk.size()==0) {
				sId = appService.saveApplication(appDetails);
			}else if(appDetailsChk.size()>0) {
				if(appDetailsChk.get(0).getActionName().equals(action)) {
					return new ProcessResponse(false,"This Action was taken recently, cannot act same consequitively");
				}else {
					sId = appDetailsChk.get(0).getId();
					appDetailsChk.get(0).setActionName(action);
					appService.updateAction(appDetailsChk.get(0)); 
				}
			}
			if(sId!=0) {
				Map<String, String>uriVariables=new HashMap<>();  
				uriVariables.put("sId",sId.toString());  
				//ProcessResponse response = getResponseBoody("http://127.0.0.1:8081/appm2/{sId}",  HttpMethod.GET, ProcessResponse.class, uriVariables);
				ProcessResponse response = feignm2.appProcessingm2(sId).getBody();
				if(response.isStatusFlag()) { 
			    	ApplicationDetails appDetail = new ApplicationDetails(); appDetail.setId(sId);
			    	appService.updateApplicationRepo(appDetail); 
			    }
				return response;
			}
		}
		return new ProcessResponse(false,"failure");
	}
	
	public ProcessResponse appProcessingm1fallback(@PathVariable Integer applicationId,@PathVariable String action,Throwable t) {
		return new ProcessResponse(false,"m2 is down");
	}
	
	public ProcessResponse getResponseBoody(String url, HttpMethod method, Class<ProcessResponse> class1, Map<String, String> uriVariables) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<ProcessResponse> httpEntity = util.getHttpEntity(MediaType.APPLICATION_JSON, new ProcessResponse());
		ResponseEntity<ProcessResponse> responseEntity = restTemplate.exchange(url, method, httpEntity, class1, uriVariables);
		System.out.println("Status Code: " + responseEntity.getStatusCode());
		return responseEntity.getBody();
	}
	
}
