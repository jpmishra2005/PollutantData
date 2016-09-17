package main.java.com.org.cpcbapi;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CPCBDataUploadService {
	//public List<IndustryData> findIndustryData(String industryId);
	public List<User> findAll();
}
