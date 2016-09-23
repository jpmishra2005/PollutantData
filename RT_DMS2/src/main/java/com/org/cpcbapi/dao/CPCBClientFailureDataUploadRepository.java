package main.java.com.org.cpcbapi.dao;

import java.util.List;

import main.java.com.org.cpcbapi.entity.IndustryDeviceMap1;
import main.java.com.org.cpcbapi.entity.PollutantData;
import main.java.com.org.cpcbapi.entity.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CPCBClientFailureDataUploadRepository{
		void save();
}
