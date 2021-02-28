package com.mthree.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.persistance.ApplicationPersistance;
import com.mthree.repositiries.ApplicationRepository;
import com.mthree.entity.ApplicationDetails;

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
		appDetails.setM2Status("m3_confirmed");
		ApplicationDetails appdetail = appPersist.save(appDetails);
		return (appdetail != null)?appdetail.getId():0;
	}
	
	public int updateApplicationRepo(ApplicationDetails appDetails) {
		appDetails.setM2Status("m3_confirmed");
		return  appRepo.update(appDetails)>0? (appPersist.findById(appDetails.getId()).get().getId()):(0);
	}
	
}
