package main.java.com.org.cpcbapi;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
   
    @Scheduled(fixedRate = 50000)
    public void databaseHook() throws Exception {
        log.info("The time is now {}", dateFormat.format(new Date()));
        List<User> usrList=_CPCBDataUploadService.findAll();
		System.out.println("**********saveStationData********" +usrList.size());
		
        springRestClient.createUser(usrList);
        /*get the data from DB
        	call class.uploadmethod (resultSet);
        */
    }
}
