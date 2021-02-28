package com.mthree.uri;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mthree.bean.microThree;
import com.mthree.entity.User;
import com.mthree.service.ApplicationService;
import com.mthree.service.UserService;
import com.mthree.bean.ProcessResponse;
import com.mthree.entity.ApplicationDetails;

@Component
@RestController
public class MicroThreeController<User> {

	@Autowired
	private Configuration config;
	
	@Autowired
	private ApplicationService appService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/info")
	public microThree getServiceInfo() {
		return new microThree(5000,1);
	}
	
	@GetMapping("/proj")
	public Configuration getProjInfo() {
		return config;
	}
	
	@GetMapping("/admin") 
	public List<com.mthree.entity.User> ShowAdminUser() {
		//UserService userService = new UserService();
		return userService.getAllUsers();
	}
	
	@GetMapping("/appm3/{sId}")
	public ProcessResponse appProcessingm3(@PathVariable Integer sId) {
		if (sId != null /* && config.getAppCheck().equals("DVLN") */) {
			ApplicationDetails appDetails = new ApplicationDetails();
			appDetails.setId(sId);
			appDetails.setM3Status("m1_wait");
			//sId = appService.saveApplication(appDetails);
			sId = appService.updateApplicationRepo(appDetails);
			if(sId!=0) {
				return new ProcessResponse(true,"Successfully updated at m3");
			}
		}
		return new ProcessResponse(false,"failure");
	}
	
}
