package com.mtwo.repositiries;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mtwo.entity.ApplicationDetails;
import com.mtwo.util.utilities;

@Repository
public class ApplicationRepository {

	@Autowired
	private utilities util;

	public int update(ApplicationDetails appDetails) {
		String query= "update db_local.application_details set m1_status=?,m2_status=? where id=?";
		return util.getJDBCTemplate().update(query,appDetails.getM1Status(),appDetails.getM2Status(),appDetails.getId());
	}
	
	
	
}
