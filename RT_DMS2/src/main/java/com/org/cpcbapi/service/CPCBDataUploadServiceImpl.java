package main.java.com.org.cpcbapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import main.java.com.org.cpcbapi.DTO.Data;
import main.java.com.org.cpcbapi.dao.CPCBClientDataUploadRepository;
import main.java.com.org.cpcbapi.entity.IndustryDeviceMap;
import main.java.com.org.cpcbapi.entity.PollutantData;
import main.java.com.org.cpcbapi.entity.User;
import main.java.com.org.cpcbapi.service.CPCBDataUploadService;

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
	    public List<PollutantData> findAll(){
	    	System.out.println(" ****CPCBDataUploadServiceImpl findByName ");
	    	List<PollutantData> pollutantDataList=new ArrayList<PollutantData>();
	    	pollutantDataList=repository.findAll();
	    	  /*for(PollutantData pdata:pollutantDataList){
	       	   System.out.println("****" +pdata.toString());
	           System.out.println("****" +pdata.getIndustryDeviceMap().getDeviceID());
	       	   
	       	   Data pollutedData=new Data(); 
	           	pollutedData.setDeviceId(pdata.getIndustryDeviceMap().getDeviceID());
	           	
	    	  }*/
	    	return pollutantDataList;
	    }
}
