package main.java.com.org.cpcbapi;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import main.java.com.org.cpcbapi.DTO.CPCBDiagnostics;
import main.java.com.org.cpcbapi.DTO.CPCBParams;
import main.java.com.org.cpcbapi.DTO.Data;
import main.java.com.org.cpcbapi.entity.IndustryDeviceMap;
import main.java.com.org.cpcbapi.entity.Params;
import main.java.com.org.cpcbapi.entity.PollutantData;
import main.java.com.org.cpcbapi.entity.User;

import org.apache.commons.codec.binary.Base64;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class SpringRestClient  {
 
    public static final String REST_SERVICE_URI = "http://localhost:8081/RT_DMS2/v1.0";
 
    /*
     * Add HTTP Authorization header, using Basic-Authentication to send user-credentials.
     */
    private static HttpHeaders getHeaders(){
    	String plainCredentials="user:12345";
    	String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes()));
    	
    	HttpHeaders headers = new HttpHeaders();
    	//headers.setContentType(new MediaType("application","json"));
    	//headers.setContentType(MediaType.APPLICATION_JSON);
    	 headers.add("Accept", "application/json");
         headers.add("Content-Type", "application/json");
    	headers.add("Authorization", "Basic " + base64Credentials);
    	//headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	return headers;
    }
 
    @Async
    public static void createUser(List<PollutantData> pollutantDataList) throws InterruptedException {
        System.out.println("\nTesting create User API----------" +Thread.currentThread().getName());
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
       
        
        List<Data> dataList=new ArrayList<Data>();
        
        System.out.println("============="+pollutantDataList.size());
  //     for(PollutantData pdata:pollutantDataList)
       for(int i=0;i<5;i++){
    //	 System.out.println(pdata.toString());
    	   
    	   Data pollutedData=new Data(); 
        	pollutedData.setDeviceId(pollutantDataList.get(i).getIndustryDeviceMap().getDeviceID());
        	
        	if(pollutantDataList.get(i).getParameter()!=  0){
        		CPCBParams par=new CPCBParams();
        		par.setParameter(pollutantDataList.get(i).getParameter());
        		par.setFlag(pollutantDataList.get(i).getFlag());
        		par.setTimeStamp(new Date());
        		par.setUnit(pollutantDataList.get(i).getMeasurement_Unit());
        		par.setValue(pollutantDataList.get(i).getMeasurementRange());
        		
        		
        		pollutedData.getParams().add(par);
        	}
        	else{
        		CPCBDiagnostics diag=new CPCBDiagnostics();
        		diag.setDiagParam(pollutantDataList.get(i).getDiagParamName());
        		diag.setTimeStamp(new Date());
        		diag.setValue(pollutantDataList.get(i).getDiagValue());
        		
        		pollutedData.getDiagnostics().add(diag);
        	}
        	
        	dataList.add(pollutedData);
        }
        
       
 System.out.println(dataList.toString());       
       
        /*Long starttime= System.currentTimeMillis();
        HttpEntity<Object> request = new HttpEntity<Object>(pollutantDataList, getHeaders());
        Long endtime= System.currentTimeMillis();
        System.out.println("Time it took for a lot of bla to execute: " + (endtime - starttime) / 1000.0 + " seconds.");
        System.out.println("Location : "+request.toString());*/
       /* URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/save/", request, User.class);
        System.out.println("Location : "+uri.toASCIIString());*/
       /* ResponseEntity<List<User>> response = 
        		restTemplate.postForEntity(REST_SERVICE_URI+"/1/save", request, new ParameterizedTypeReference<List<User>>() {});
       */ 
        
      // ResponseEntity<List<User>> res = restTemplate.exchange(REST_SERVICE_URI+"/save/",HttpMethod.POST,request,new ParameterizedTypeReference<List<User>>() {});
		//System.out.println(response.getBody().getEmail());
        //System.out.println(response.getBody().getName());
     //   System.out.println(res.getStatusCode());
      //  Thread.sleep(1000L);
       // return new AsyncResult<Void>(null);
    }
 
  
    @Async
    public static void saveStationData(List<User> userList) throws InterruptedException {
    	  Long starttime= System.currentTimeMillis();
          
        System.out.println("\nTesting saveStationData API----------" +Thread.currentThread().getName());
        Long endtime= System.currentTimeMillis();
        System.out.println("Time it took for a lot of bla to execute: " + (endtime - starttime) / 1000.0 + " seconds.");
      
     }
    @Async
    public static void saveIndustryData(List<User> userList) throws InterruptedException {
    	  Long starttime= System.currentTimeMillis();
          
          
    	System.out.println("\nTesting saveIndustryData API----------" +Thread.currentThread().getName());
        Long endtime= System.currentTimeMillis();
        System.out.println("Time it took for a lot of bla to execute: " + (endtime - starttime) / 1000.0 + " seconds.");
      
     }
    @Async
    public static void saveCorrectionData(List<User> userList) throws InterruptedException {
    	  Long starttime= System.currentTimeMillis();
          
          
    	System.out.println("\nTesting saveCorrectionData API----------" +Thread.currentThread().getName());
        Long endtime= System.currentTimeMillis();
        System.out.println("Time it took for a lot of bla to execute: " + (endtime - starttime) / 1000.0 + " seconds.");
      
     }
    @Async
    public static void saveSMSData(List<User> userList) throws InterruptedException {
    	  Long starttime= System.currentTimeMillis();
          
          
    	System.out.println("\nTesting saveSMSData API----------" +Thread.currentThread().getName());
        Long endtime= System.currentTimeMillis();
        System.out.println("Time it took for a lot of bla to execute: " + (endtime - starttime) / 1000.0 + " seconds.");
      
     }
 
  
}