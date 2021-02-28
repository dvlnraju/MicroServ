package com.mthree.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Application_Details", schema = "db_local")
public class ApplicationDetails {

	@Id
	private int id;
	
	@Column(name = "action_name",nullable = true)
	private String actionName;    
	
	@Column(name= "m1_status",nullable = true)
	private String m1Status;  
	
	@Column(name = "m2_status",nullable = true)
	private String m2Status;    
	
	@Column(name= "m3_status",nullable = true)
	private String m3Status;  
	
	@Column(name="application_Id",nullable = false)
	private int applicationId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getM1Status() {
		return m1Status;
	}

	public void setM1Status(String m1Status) {
		this.m1Status = m1Status;
	}

	public String getM2Status() {
		return m2Status;
	}

	public void setM2Status(String m2Status) {
		this.m2Status = m2Status;
	}

	public String getM3Status() {
		return m3Status;
	}

	public void setM3Status(String m3Status) {
		this.m3Status = m3Status;
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	
	
	
}
