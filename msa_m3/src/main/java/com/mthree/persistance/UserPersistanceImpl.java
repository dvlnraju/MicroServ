package com.mthree.persistance;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Component;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mthree.entity.User;
//@Component
@Repository
public interface UserPersistanceImpl extends CrudRepository<User, String>  {

	/*
	 * @Query("from Auction a join a.category c where c.name=:categoryName") public
	 * Iterable<User> findByCategory(@Param("categoryName") String categoryName);
	 */
	
	@Query("from User c where c.name=:categoryName") public
	  Iterable<User> findByCategory(@Param("categoryName") String categoryName);
	 
}
