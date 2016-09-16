package main.java.com.org.cpcbapi;

import java.util.List;

import main.java.com.org.cpcbapi.User;
import main.java.com.org.cpcbapi.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;


@Controller
@RequestMapping(value="/user")
public class UserController {

  @Autowired
  private UserDao _userDao;
  @Autowired
  private CPCBDataUploadService _CPCBDataUploadService;
  @RequestMapping(value="/delete")
  @ResponseBody
  public String delete(long id) {
    try {
      User user = new User(id);
      _userDao.delete(user);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "User succesfully deleted!";
  }
  
  @RequestMapping(value="/get-by-email")
  @ResponseBody
  public String getByEmail(String email) {
    String userId;
    try {
      User user = _userDao.getByEmail(email);
      userId = String.valueOf(user.getId());
    }
    catch(Exception ex) {
      return "User not found";
    }
    return "The user id is: " + userId;
  }

/*  @RequestMapping(value="/save", method = RequestMethod.POST)
  @ResponseBody
  public String create(String email, String name) {
    try {
    	System.out.println("------email----" +email);
    	System.out.println("------name----" +name);
      User user = new User(email, name);
      _userDao.save(user);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "User succesfully saved!";
  }*/
  @RequestMapping(value = "/save/", method = RequestMethod.POST,consumes = "application/json",produces="application/json")
  public ResponseEntity<List<User>> createUser(@RequestBody List<User> users,UriComponentsBuilder ucBuilder) {
	 System.out.println("--------------->>>>>>>>>>Creating User ");
	  //System.out.println("Creating User " + user.getName());

     /* if (userService.isUserExist(user)) {
          System.out.println("A User with name " + user.getName() + " already exist");
          return new ResponseEntity<Void>(HttpStatus.CONFLICT);
      }*/

      _userDao.save(users);

      HttpHeaders headers = new HttpHeaders();
     // headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
      return new ResponseEntity<List<User>>(users, HttpStatus.CREATED);
  }

  @RequestMapping(value = "/industry/{industryId}/station/{stationId}/data", method = RequestMethod.POST)
	public ResponseEntity<IndustryData> saveStationData(@PathVariable("industryId")String industryId, @PathVariable("stationId")String stationId, @RequestBody IndustryData industryData){
		System.out.println("**********saveStationData********" +industryId +"*****" +stationId);
		//IndustryData industryData =new IndustryData();
		//_CPCBDataUploadService.findIndustryData(industryId);
		System.out.println("Device If *****" +industryData.getStationData().getDeviceId());
		List<User> usrList=_CPCBDataUploadService.findByName(industryId);
		System.out.println("**********saveStationData********" +usrList.size());
		for(int i=0;i<usrList.size();i++){
			System.out.println("**********saveStationData********" +usrList.get(i).getEmail());
				
		}
		//System.out.println(" ******* "+usr.getEmail());
		return new ResponseEntity<IndustryData>(industryData, HttpStatus.OK);
	} 

} // class UserController
