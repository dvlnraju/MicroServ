package com.mthree.uri;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mthree.bean.ProcessResponse;

@RestController
public class m3RestController {

	@GetMapping("appm3/m3Avail")
	ProcessResponse fetchm3Availability(){
		return new ProcessResponse(true,"available");
	}
	
}
