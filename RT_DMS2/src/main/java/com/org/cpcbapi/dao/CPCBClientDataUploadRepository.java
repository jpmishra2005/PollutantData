package main.java.com.org.cpcbapi.dao;

import java.util.List;

import main.java.com.org.cpcbapi.entity.IndustryDeviceMap;
import main.java.com.org.cpcbapi.entity.PollutantData;
import main.java.com.org.cpcbapi.entity.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CPCBClientDataUploadRepository extends CrudRepository<PollutantData, String> {
	//  @Query("select u from user u where u.firstname like %?1")
	//List<IndustryData> findIndustryData(String industryId);
	 // @Query("select u from mydb.student u where u.name like %?1")
	
//	@Query("select p from pollutant_data p inner join industry_device_map i where p.Industry_Device_Map_ID=i.mappingID")
		List<PollutantData> findAll();
}
