package com.config.persistance;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.config.bean.UserInfo;

@Repository
public interface UserInfoPersistace extends CrudRepository<UserInfo, Integer> {
	
	@Query("from UserInfo c where c.username=:username") 
	public UserInfo findByUserName(@Param("username") String username);

}
