package main.java.com.org.cpcbapi;


import java.util.ArrayList;
import java.util.List;

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
 
    public static final String REST_SERVICE_URI = "http://localhost:8081/RT_DMS2/user";
 
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
  /*  
    
     * Send a GET request to get list of all users.
     
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static void listAllUsers(){
        System.out.println("\nTesting listAllUsers API-----------");
        RestTemplate restTemplate = new RestTemplate(); 
        
        HttpEntity<String> request = new HttpEntity<String>(getHeaders());
        ResponseEntity<List> response = restTemplate.exchange(REST_SERVICE_URI+"/user/", HttpMethod.GET, request, List.class);
        List<LinkedHashMap<String, Object>> usersMap = (List<LinkedHashMap<String, Object>>)response.getBody();
        
        if(usersMap!=null){
            for(LinkedHashMap<String, Object> map : usersMap){
                System.out.println("User : id="+map.get("id")+", Name="+map.get("name")+", Age="+map.get("age")+", Salary="+map.get("salary"));;
            }
        }else{
            System.out.println("No user exist----------");
        }
    }
     
    
     * Send a GET request to get a specific user.
     
    private static void getUser(){
        System.out.println("\nTesting getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request = new HttpEntity<String>(getHeaders());
        ResponseEntity<User> response = restTemplate.exchange(REST_SERVICE_URI+"/user/1", HttpMethod.GET, request, User.class);
        User user = response.getBody();
        System.out.println(user);
    }
     */
    /*
     * Send a POST request to create a new user.
     */
    @Async
    public static void createUser(List<User> userList) throws InterruptedException {
        System.out.println("\nTesting create User API----------" +Thread.currentThread().getName());
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        User user = new User();
       /* List<User> userList=new ArrayList<User>();
        for(int i=0;i<3;i++){
        user.setEmail("jp3@gmail.com"+i);
        user.setName("jp3"+i);
        user.setId(i);
        userList.add(user);
         }
    	*///HttpEntity<Message> requestEntity = new HttpEntity<Message>(message, headers);
        Long starttime= System.currentTimeMillis();
        HttpEntity<Object> request = new HttpEntity<Object>(userList, getHeaders());
        Long endtime= System.currentTimeMillis();
        System.out.println("Time it took for a lot of bla to execute: " + (endtime - starttime) / 1000.0 + " seconds.");
        System.out.println("Location : "+request.toString());
       /* URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/save/", request, User.class);
        System.out.println("Location : "+uri.toASCIIString());*/
       /* ResponseEntity<List<User>> response = 
        		restTemplate.postForEntity(REST_SERVICE_URI+"/1/save", request, new ParameterizedTypeReference<List<User>>() {});
       */ 
        
        ResponseEntity<List<User>> res = restTemplate.exchange(REST_SERVICE_URI+"/save/",HttpMethod.POST,request,new ParameterizedTypeReference<List<User>>() {});
		//System.out.println(response.getBody().getEmail());
        //System.out.println(response.getBody().getName());
        System.out.println(res.getStatusCode());
        Thread.sleep(1000L);
       // return new AsyncResult<Void>(null);
    }
 
  
     /* Send a PUT request to update an existing user.*/
     
    public static void updateUser() {
        System.out.println("\nTesting update User API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user  = new User("Tomy@gmail.com","Tomy");
        HttpEntity<Object> request = new HttpEntity<Object>(user, getHeaders());
        ResponseEntity<User> response = restTemplate.exchange(REST_SERVICE_URI+"/user/1", HttpMethod.PUT, request, User.class);
        System.out.println(response.getBody());
    }
 
  /*  
      Send a DELETE request to delete a specific user.
     
    private static void deleteUser() {
        System.out.println("\nTesting delete User API----------");
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request = new HttpEntity<String>(getHeaders());
        restTemplate.exchange(REST_SERVICE_URI+"/user/3", HttpMethod.DELETE, request, User.class);
    }
 
 
    
     * Send a DELETE request to delete all users.
     
    private static void deleteAllUsers() {
        System.out.println("\nTesting all delete Users API----------");
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request = new HttpEntity<String>(getHeaders());
        restTemplate.exchange(REST_SERVICE_URI+"/user/", HttpMethod.DELETE, request, User.class);
    }
 */

  /* public static void main(String args[]) throws Exception{
        
    	//listAllUsers();
    	SpringRestClient sp=new SpringRestClient();
    	sp.run();
        //getUser();
    	
    	 System.out.println(" **********************");
        //listAllUsers();

        updateUser();
        listAllUsers();

        deleteUser();
        listAllUsers();

        deleteAllUsers();
        listAllUsers();
    createUser();
	   }*/

}