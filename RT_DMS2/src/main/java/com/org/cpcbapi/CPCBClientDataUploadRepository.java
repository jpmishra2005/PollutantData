package main.java.com.org.cpcbapi;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CPCBClientDataUploadRepository extends CrudRepository<User, String> {
	//  @Query("select u from user u where u.firstname like %?1")
	//List<IndustryData> findIndustryData(String industryId);
	 // @Query("select u from mydb.student u where u.name like %?1")
		List<User> findByName(String name);
}
