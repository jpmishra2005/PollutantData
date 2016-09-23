package main.java.com.org.cpcbapi;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import main.java.com.org.cpcbapi.entity.IndustryDeviceMap1;
import main.java.com.org.cpcbapi.entity.PollutantData;
import main.java.com.org.cpcbapi.entity.User;
import main.java.com.org.cpcbapi.service.CPCBDataUploadService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	SpringRestClient springRestClient;
	@Autowired
	private CPCBDataUploadService _CPCBDataUploadService;

	@Scheduled(fixedRate = 500000)
	public void databaseIndustryHook() throws Exception {
		log.info("The time is now {}", dateFormat.format(new Date()));
		List<PollutantData> pollutantDataList=_CPCBDataUploadService.findAll();
		System.out.println("**********saveIndustryData********" +pollutantDataList.size());
		springRestClient.saveStationData(pollutantDataList);
		/*get the data from DB
        	call class.uploadmethod (resultSet);
		 */
	}
	/* @Scheduled(fixedRate = 50000)
    public void databaseStationHook() throws Exception {
        log.info("The time is now {}", dateFormat.format(new Date()));
       // List<User> usrList=_CPCBDataUploadService.findAll();
		//System.out.println("**********saveStationData********" +usrList.size());

       //springRestClient.updateUser();
        //get the data from DB
       // 	call class.uploadmethod (resultSet);

    }*/
	/* @Scheduled(fixedRate = 50000)
    public void databaseSMSHook() throws Exception {
        log.info("The time is now {}", dateFormat.format(new Date()));
       // List<User> usrList=_CPCBDataUploadService.findAll();
		//System.out.println("**********saveStationData********" +usrList.size());

       //springRestClient.updateUser();
        //get the data from DB
       // 	call class.uploadmethod (resultSet);

    }*/
	/* @Scheduled(fixedRate = 50000)
    public void databaseCorrectionHook() throws Exception {
        log.info("The time is now {}", dateFormat.format(new Date()));
       // List<User> usrList=_CPCBDataUploadService.findAll();
		//System.out.println("**********saveStationData********" +usrList.size());

       //springRestClient.updateUser();
        //get the data from DB
       // 	call class.uploadmethod (resultSet);

    }*/
}
