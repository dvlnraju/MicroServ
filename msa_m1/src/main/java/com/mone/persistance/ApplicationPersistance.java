package com.mone.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mone.entity.ApplicationDetails;
import com.mone.entity.User;

@Repository
public interface ApplicationPersistance extends CrudRepository<ApplicationDetails, Integer>  {

	@Query("from ApplicationDetails ad where ad.applicationId=:applicationId order by ad.id")
	public List<ApplicationDetails> findByapplicationId(@Param("applicationId") Integer applicationId);
	 
	 
}
