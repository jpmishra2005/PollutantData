package main.java.com.org.cpcbapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import main.java.com.org.cpcbapi.CPCBDataUploadService;

@Component(value="CPCBDataUploadServiceImpl")
public class CPCBDataUploadServiceImpl implements CPCBDataUploadService {

	 @Autowired
	    private CPCBClientDataUploadRepository repository;

	   /* @Override
	    public List<IndustryData> findIndustryData(String industryId){
	    	List<IndustryData> industryIdList=new ArrayList<IndustryData>();
	    	industryIdList=repository.findIndustryData(industryId);
	    	return industryIdList;
	    }*/
	    @Override
	    public List<User> findByName(String name){
	    	List<User> userList=new ArrayList<User>();
	    	userList=repository.findByName(name);
	    	return userList;
	    }
}
