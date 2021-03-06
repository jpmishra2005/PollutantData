package main.java.com.org.cpcbapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import main.java.com.org.cpcbapi.DTO.Data;
import main.java.com.org.cpcbapi.dao.CPCBClientDataUploadRepository;
import main.java.com.org.cpcbapi.entity.IndustryDeviceMap1;
import main.java.com.org.cpcbapi.entity.PollutantData;
import main.java.com.org.cpcbapi.entity.User;
import main.java.com.org.cpcbapi.service.CPCBDataUploadService;

@Component(value="CPCBDataUploadServiceImpl")
public class CPCBDataUploadServiceImpl implements CPCBDataUploadService {

	 @Autowired
	    private CPCBClientDataUploadRepository repository;

	    @Override
	    public List<PollutantData> findAll(){
	    	System.out.println(" ****CPCBDataUploadServiceImpl findByName ");
	    	List<PollutantData> pollutantDataList=new ArrayList<PollutantData>();
	    	pollutantDataList=repository.findAll();
	       	return pollutantDataList;
	    }
	    @Override
	    public void saveFailuerData(PollutantData pollutantData){
	    	System.out.println(" ****CPCBDataUploadServiceImpl Failure Data ");
	    	//PollutantData pollutantData=new PollutantData();
	    	repository.save(pollutantData);
	    }
}
