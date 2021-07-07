package com.kc.uri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kc.security.SpringUserDetails;
import com.kc.util.AuthNRequest;
import com.kc.util.AuthNResponse;

@RestController
public class SecurityCntrl {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login() {
		return "HelloWelcome";
	}
	
	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> authenticate(@RequestBody AuthNRequest authnrequest) throws Exception{
		String resp = null;
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authnrequest.getUsername(),authnrequest.getPassword()));
			//kcutil.login
			resp = "success";
		}catch (BadCredentialsException e){
			resp = "failure";
			throw new Exception("Incorrect Credentilas", e);
		}
		return ResponseEntity.ok(new AuthNResponse(resp));
	}
	
	@GetMapping("/checkAuthenticity")
	public String checkValidity(@RequestHeader("Authorization") String token) {
		return "Success";
	}
	
	@GetMapping("/inValid")
	public String inValid() {
		return "failure";
	}

}
