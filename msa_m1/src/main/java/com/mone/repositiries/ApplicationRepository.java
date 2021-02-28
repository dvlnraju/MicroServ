package com.mone.repositiries;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mone.entity.ApplicationDetails;
import com.mone.util.utilities;

@Repository
public class ApplicationRepository {

	@Autowired
	private utilities util;
	
	public int update(ApplicationDetails appDetails) {
		String query= "update db_local.application_details set m3_status=? where id=?";
		return util.getJDBCTemplate().update(query,appDetails.getM3Status(),appDetails.getId());
	}

	public int updateAction(ApplicationDetails appDetails) {
		String query= "update db_local.application_details set m3_status=?,action_name=? where id=?";
		return util.getJDBCTemplate().update(query,appDetails.getM3Status(),appDetails.getActionName(),appDetails.getId());
	}
	
	
	
}
