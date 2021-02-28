package com.mthree.repositiries;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mthree.entity.ApplicationDetails;

@Repository
public class ApplicationRepository {

	@Autowired DataSource dataSource;

	private JdbcTemplate jdbc;

	public int update(ApplicationDetails appDetails) {
		String query= "update db_local.application_details set m2_status=?,m3_status=? where id=?";
		return new JdbcTemplate(dataSource).update(query,appDetails.getM2Status(),appDetails.getM3Status(),appDetails.getId());
	}
	
	
	
}
