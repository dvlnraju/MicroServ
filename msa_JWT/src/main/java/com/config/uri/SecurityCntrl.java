package com.config.uri;

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

import com.config.security.SpringUserDetails;
import com.config.util.AuthNRequest;
import com.config.util.AuthNResponse;
import com.config.util.JwtUtil;

@RestController
public class SecurityCntrl {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private SpringUserDetails springUserDetails;
	
	@Autowired
	private JwtUtil jwtuti;
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login() {
		return "HelloWelcome";
	}
	
	@PostMapping(value = "/authN")
	public ResponseEntity<?> authenticate(@RequestBody AuthNRequest authnrequest) throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authnrequest.getUsername(),authnrequest.getPassword()));
		}catch (BadCredentialsException e){
			throw new Exception("Incorrect Credentilas", e);
		}
		
		final UserDetails userDetails = springUserDetails.loadUserByUsername(authnrequest.getUsername());
		
		final String jwt = jwtuti.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthNResponse(jwt));
	}
	
	@GetMapping("/checkValidity")
	public String checkValidity(@RequestHeader("Authorization") String token) {
		return "Success";
	}
	
	@GetMapping("/inValid")
	public String inValid() {
		return "failure";
	}

}
