package main.java.com.org.cpcbapi.service;

import java.util.List;

import main.java.com.org.cpcbapi.entity.IndustryDeviceMap;


import main.java.com.org.cpcbapi.entity.PollutantData;

import org.springframework.stereotype.Service;

@Service
public interface CPCBDataUploadService {
	//public List<IndustryData> findIndustryData(String industryId);
	public List<PollutantData> findAll();
}
