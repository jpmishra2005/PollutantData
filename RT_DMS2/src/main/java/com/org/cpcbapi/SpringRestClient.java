package main.java.com.org.cpcbapi;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import main.java.com.org.cpcbapi.DTO.CPCBDiagnostics;
import main.java.com.org.cpcbapi.DTO.CPCBParams;
import main.java.com.org.cpcbapi.DTO.Data;
import main.java.com.org.cpcbapi.entity.IndustryDeviceMap;
import main.java.com.org.cpcbapi.entity.Params;
import main.java.com.org.cpcbapi.entity.PollutantData;
import main.java.com.org.cpcbapi.entity.User;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.mysql.fabric.xmlrpc.base.Array;


@Component
public class SpringRestClient {

	public static final String REST_SERVICE_URI = "http://localhost:8080/api/v1.0";

	/*
	 * Add HTTP Authorization header, using Basic-Authentication to send
	 * user-credentials.
	 */
	private static HttpHeaders getHeaders() {
		String plainCredentials = "user:12345";
		String base64Credentials = new String(
				Base64.encodeBase64(plainCredentials.getBytes()));

		HttpHeaders headers = new HttpHeaders();
		// headers.setContentType(new MediaType("application","json"));
		// headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");
		//headers.add("Authorization", "Basic " + base64Credentials);
		// headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return headers;
	}

	@Async
	public static void createUser(List<PollutantData> pollutantDataList)
			throws InterruptedException {
		System.out.println("\nTesting create User API----------"
				+ Thread.currentThread().getName());
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());
		Map<IndustryDeviceMap, List<Data>> dataListMap = new HashMap<IndustryDeviceMap, List<Data>>();
		for(PollutantData pdata:pollutantDataList){

			IndustryDeviceMap deviceMap=pdata.getIndustryDeviceMap();

			if(!dataListMap.containsKey(deviceMap)){
				dataListMap.put(deviceMap, new ArrayList<Data>());

			}


			List<Data> existingListData=dataListMap.get(deviceMap);

			boolean deviceIDPreExistsCheck=false;

			if(existingListData.contains(new Data(pdata.getDeviceID()))){
				deviceIDPreExistsCheck=true;
			}


			if(deviceIDPreExistsCheck){
				for(Data d:existingListData){
					if(d.getDeviceId()==pdata.getDeviceID()){

						if(pdata.getParameter()!=0){
							CPCBParams par = new CPCBParams();
							par.setParameter(pdata.getParameter());
							par.setFlag(pdata.getFlag());
							par.setTimeStamp(new Date());
							par.setUnit(pdata.getMeasurement_Unit());
							par.setValue(pdata.getMeasurementRange());
							d.getParams().add(par);
						}
						else{
							CPCBDiagnostics diag = new CPCBDiagnostics();
							diag.setDiagParam(pdata.getDiagParamName());
							diag.setTimeStamp(new Date());
							diag.setValue(pdata.getDiagValue());
							d.getDiagnostics().add(diag);

						}
					}
				}
			}
			
			else{
				Data newDevice=new Data();
				newDevice.setDeviceId(pdata.getDeviceID());
				
				if(pdata.getParameter()!=0){
					CPCBParams par = new CPCBParams();
					par.setParameter(pdata.getParameter());
					par.setFlag(pdata.getFlag());
					par.setTimeStamp(new Date());
					par.setUnit(pdata.getMeasurement_Unit());
					par.setValue(pdata.getMeasurementRange());
					newDevice.getParams().add(par);
				}
				else{
					CPCBDiagnostics diag = new CPCBDiagnostics();
					diag.setDiagParam(pdata.getDiagParamName());
					diag.setTimeStamp(new Date());
					diag.setValue(pdata.getDiagValue());
					newDevice.getDiagnostics().add(diag);

				}
				
				existingListData.add(newDevice);
			}






		}

























		System.out.println("=============" + pollutantDataList.size());
/*
		// for(PollutantData pdata:pollutantDataList)
		List<Data> pDataList=null;
		IndustryDeviceMap preIdMap = null;




























		for (int i = 0; i < 100; i++) {

			IndustryDeviceMap idMap=pollutantDataList.get(i).getIndustryDeviceMap();

			if (!dataListMap.containsKey(idMap)) {

				dataListMap.put(pollutantDataList.get(i)
						.getIndustryDeviceMap(),new ArrayList<Data>());
				if(pDataList !=null){
					dataListMap.get(preIdMap).addAll(pDataList);
				}
				pDataList=new ArrayList<Data>();

			}
			Data indData = new Data();
			indData.setDeviceId(pollutantDataList.get(i).getDeviceID());

			if (pollutantDataList.get(i).getParameter() != 0) {
				CPCBParams par = new CPCBParams();
				par.setParameter(pollutantDataList.get(i).getParameter());
				par.setFlag(pollutantDataList.get(i).getFlag());
				par.setTimeStamp(new Date());
				par.setUnit(pollutantDataList.get(i).getMeasurement_Unit());
				par.setValue(pollutantDataList.get(i).getMeasurementRange());
				indData.getParams().add(par);

			} else {
				CPCBDiagnostics diag = new CPCBDiagnostics();
				diag.setDiagParam(pollutantDataList.get(i).getDiagParamName());
				diag.setTimeStamp(new Date());
				diag.setValue(pollutantDataList.get(i).getDiagValue());

				indData.getDiagnostics().add(diag);
			}
			preIdMap=idMap;
			pDataList.add(indData);



		}*/
		 Long starttime= System.currentTimeMillis();
HttpEntity<Object> 	 request = null ;
		 Long endtime= System.currentTimeMillis();
		 System.out.println("Time it took for a lot of bla to execute: " +
		 (endtime - starttime) / 1000.0 + " seconds.");
	// System.out.println("Location : "+request.toString());
		System.out.println(dataListMap.toString());
		
		
		
		Iterator<IndustryDeviceMap> it=dataListMap.keySet().iterator();
		while(it.hasNext()){
			IndustryDeviceMap deviceMap=it.next();
			int indusID=deviceMap.getIndustryID();
			int staID=deviceMap.getStationID();
			List<Data> dataList1=dataListMap.get(deviceMap);
			System.out.println(dataList1.toString());
			
			JSONArray json=new JSONArray(dataList1);
			System.out.println(json.toString());
			request= new HttpEntity<Object>(dataList1, getHeaders());
			
			System.out.println("helllooo");
			try{
				
			    
		        ResponseEntity<String> res = restTemplate.exchange(REST_SERVICE_URI+"/industry/"+indusID+"/station/"+staID+"/data",HttpMethod.POST,request,new ParameterizedTypeReference<String>() {});

				
				
				
				
				System.out.println(res.getStatusCode());
		        }
		        catch(HttpClientErrorException e){ 
		        	e.printStackTrace();
		        	break;
		        }
		        }
		}
		 
		
		
		
		 
		        	 /*
		 * URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/save/",
		 * request, User.class);
		 * System.out.println("Location : "+uri.toASCIIString());
		 */
		/*
		 * ResponseEntity<List<User>> response =
		 * restTemplate.postForEntity(REST_SERVICE_URI+"/1/save", request, new
		 * ParameterizedTypeReference<List<User>>() {});
		 */

		// ResponseEntity<List<User>> res =
		// restTemplate.exchange(REST_SERVICE_URI+"/save/",HttpMethod.POST,request,new
		// ParameterizedTypeReference<List<User>>() {});
		// System.out.println(response.getBody().getEmail());
		// System.out.println(response.getBody().getName());
		// System.out.println(res.getStatusCode());
		// Thread.sleep(1000L);
		// return new AsyncResult<Void>(null);
	//}

	//@Async
	/*public static void saveStationData(List<PollutantData> pollutantDataList)
			throws InterruptedException {
		Long starttime = System.currentTimeMillis();
		HttpEntity<Object> request = new HttpEntity<Object>(pollutantDataList, getHeaders());
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());

		System.out.println("\nTesting saveStationData API----------"
				+ Thread.currentThread().getName());
		Long endtime = System.currentTimeMillis();
		 try{
		        ResponseEntity<IndustryData> response = restTemplate.postForEntity(REST_SERVICE_URI+"/industry/"+industryId+"/station/"+stationId+"/data", request,new ParameterizedTypeReference<List<Data>>() {});
		        System.out.println(response.getStatusCode());
		        }
		        catch(HttpClientErrorException e){ 
		        	System.out.println("**** HttpStatus error getStatusCode***" +e.getStatusCode());
		        	System.out.println("**** HttpStatus error getResponseBodyAsString***" +e.getResponseBodyAsString());
		        	 if(!e.getStatusCode().equals("200")){
		        		 System.out.println("****HttpStatus not 200 ");
		        		 ResponseEntity<IndustryData> response = restTemplate.postForEntity(REST_SERVICE_URI+"/industry/"+industryId+"/station/"+stationId+"/data", request, IndustryData.class);
		        	        System.out.println("**** HttpStatus error *** "+response.getStatusCode());

		        	 }
		System.out.println("Time it took for a lot of bla to execute: "
				+ (endtime - starttime) / 1000.0 + " seconds.");
		        }
	}

	 */
	@Async
	public static void saveIndustryData(List<User> userList)
			throws InterruptedException {
		Long starttime = System.currentTimeMillis();

		System.out.println("\nTesting saveIndustryData API----------"
				+ Thread.currentThread().getName());
		Long endtime = System.currentTimeMillis();
		System.out.println("Time it took for a lot of bla to execute: "
				+ (endtime - starttime) / 1000.0 + " seconds.");

	}

	@Async
	public static void saveCorrectionData(List<User> userList)
			throws InterruptedException {
		Long starttime = System.currentTimeMillis();

		System.out.println("\nTesting saveCorrectionData API----------"
				+ Thread.currentThread().getName());
		Long endtime = System.currentTimeMillis();
		System.out.println("Time it took for a lot of bla to execute: "
				+ (endtime - starttime) / 1000.0 + " seconds.");

	}

	@Async
	public static void saveSMSData(List<User> userList)
			throws InterruptedException {
		Long starttime = System.currentTimeMillis();

		System.out.println("\nTesting saveSMSData API----------"
				+ Thread.currentThread().getName());
		Long endtime = System.currentTimeMillis();
		System.out.println("Time it took for a lot of bla to execute: "
				+ (endtime - starttime) / 1000.0 + " seconds.");

	}

}