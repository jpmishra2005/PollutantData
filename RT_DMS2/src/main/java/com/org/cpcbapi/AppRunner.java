package main.java.com.org.cpcbapi;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);
    
    
    private final SpringRestClient springRestClient;

    public AppRunner(SpringRestClient springRestClient) {
        this.springRestClient = springRestClient;
    }
    @Override
    public void run(String... args) throws Exception {
    	// TODO Auto-generated method stub
    	Future<Void> page1= springRestClient.createUser(); 
    //	Future<Void> page2= springRestClient.createUser(); 
    //	Future<Void> page3= springRestClient.createUser(); 
    	System.out.println(" ********************RUN ....");
    	//for(int i=0;i<2;i++){
    		  
    		  /*if(!page1.isDone()){
    				 System.out.println("SLEEP  ********* MODE *****");
    				 Thread.sleep(10);
    			 }*/
    		//  	 }
    	 while (!(page1.isDone())) {
             Thread.sleep(10); //10-millisecond pause between each check
         }
    	 
    	 
    }
}
