package com.mone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mone.bean.ProcessResponse;
import com.mone.entity.ApplicationDetails;
import com.mone.persistance.ApplicationPersistance;
import com.mone.repositiries.ApplicationRepository;

@Service
public class ApplicationService {

	@Autowired
	private ApplicationPersistance appPersist;
	
	@Autowired
	private ApplicationRepository appRepo;

	public int saveApplication(ApplicationDetails appDetails) {
		ApplicationDetails appdetail = appPersist.save(appDetails);
		appdetail = appdetail != null? (appPersist.findByapplicationId(appdetail.getApplicationId())).get(0) : appdetail;
		return (appdetail != null)?appdetail.getId():0;
	}
	
	public int updateApplication(ApplicationDetails appDetails) {
		appDetails.setM3Status("m1_confirmed");
		ApplicationDetails appdetail = appPersist.save(appDetails);
		return (appdetail != null)?appdetail.getId():0;
	}
	
	public int updateApplicationRepo(ApplicationDetails appDetails) {
		appDetails.setM3Status("m1_confirmed");
		return  appRepo.update(appDetails);
	}

	public List<ApplicationDetails> getByApplicationId(Integer applicationId) {
		return appPersist.findByapplicationId(applicationId);
	}

	public int updateAction(ApplicationDetails appDetails) {
		appDetails.setM3Status("m1_confirmed");
		return  appRepo.updateAction(appDetails);
	}

	public List<ApplicationDetails> getAll() {
		return (List<ApplicationDetails>) appPersist.findAll();
	}
	
		
}
