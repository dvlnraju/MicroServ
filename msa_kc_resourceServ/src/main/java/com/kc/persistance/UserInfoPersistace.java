package com.kc.persistance;

import org.springframework.stereotype.Repository;

import com.kc.bean.UserInfo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Repository
public interface UserInfoPersistace extends CrudRepository<UserInfo, Integer> {
	
	@Query("from UserInfo c where c.username=:username") 
	public UserInfo findByUserName(@Param("username") String username);

}
