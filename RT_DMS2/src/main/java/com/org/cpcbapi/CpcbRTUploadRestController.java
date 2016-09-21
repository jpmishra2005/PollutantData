package main.java.com.org.cpcbapi;

import java.util.List;

import main.java.com.org.cpcbapi.dao.UserDao;
import main.java.com.org.cpcbapi.entity.IndustryData;
import main.java.com.org.cpcbapi.entity.OldUser;
import main.java.com.org.cpcbapi.entity.User;
import main.java.com.org.cpcbapi.service.CPCBDataUploadService;

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
@RequestMapping(value="/v1.0")
public class CpcbRTUploadRestController {

  @Autowired
  private UserDao _userDao;
  @Autowired
  private CPCBDataUploadService _CPCBDataUploadService;
  
  @RequestMapping(value = "/save/", method = RequestMethod.POST,consumes = "application/json",produces="application/json")
  public ResponseEntity<List<OldUser>> createUser(@RequestBody List<OldUser> users,UriComponentsBuilder ucBuilder) {
	 System.out.println("--------------->>>>>>>>>>Creating User ");
	  //System.out.println("Creating User " + user.getName());

     /* if (userService.isUserExist(user)) {
          System.out.println("A User with name " + user.getName() + " already exist");
          return new ResponseEntity<Void>(HttpStatus.CONFLICT);
      }*/

      _userDao.save(users);

      HttpHeaders headers = new HttpHeaders();
     // headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
      return new ResponseEntity<List<OldUser>>(users, HttpStatus.CREATED);
  }
  @RequestMapping(value = "/industry/{industryId}/station/{stationId}/data", method = RequestMethod.POST)
	public ResponseEntity<IndustryData> saveStationData(@PathVariable("industryId")String industryId, @PathVariable("stationId")String stationId, @RequestBody IndustryData industryData){
		System.out.println("**********saveStationData********" +industryId +"*****" +stationId);
		//IndustryData industryData =new IndustryData();
		//_CPCBDataUploadService.findIndustryData(industryId);
		System.out.println("Device If *****" +industryData.getStationData().getDeviceId());
		/*List<User> usrList=_CPCBDataUploadService.findAll();
		System.out.println("**********saveStationData********" +usrList.size());
		for(int i=0;i<usrList.size();i++){
			System.out.println("**********saveStationData********" +usrList.get(i).getEmail());
				
		}*/
		//System.out.println(" ******* "+usr.getEmail());
		return new ResponseEntity<IndustryData>(industryData, HttpStatus.OK);
	} 
  @RequestMapping(value = "/industry/{industryId}/data", method = RequestMethod.POST)
	public ResponseEntity<IndustryData> saveIndustryData(@PathVariable("industryId")String industryId, @PathVariable("stationId")String stationId, @RequestBody IndustryData industryData){
		System.out.println("**********saveIndustryData********" +industryId +"*****" +stationId);
		//IndustryData industryData =new IndustryData();
		//_CPCBDataUploadService.findIndustryData(industryId);
		System.out.println("Device If *****" +industryData.getStationData().getDeviceId());
		/*List<User> usrList=_CPCBDataUploadService.findAll();
		System.out.println("**********saveStationData********" +usrList.size());
		for(int i=0;i<usrList.size();i++){
			System.out.println("**********saveStationData********" +usrList.get(i).getEmail());
				
		}*/
		//System.out.println(" ******* "+usr.getEmail());
		return new ResponseEntity<IndustryData>(industryData, HttpStatus.OK);
	} 
  @RequestMapping(value = "/industry/{industryId}/station/{stationId}/correction", method = RequestMethod.POST)
	public ResponseEntity<IndustryData> saveCorrectionData(@PathVariable("industryId")String industryId, @PathVariable("stationId")String stationId, @RequestBody IndustryData industryData){
		System.out.println("**********saveCorrectionData********" +industryId +"*****" +stationId);
		//IndustryData industryData =new IndustryData();
		//_CPCBDataUploadService.findIndustryData(industryId);
		System.out.println("Device If *****" +industryData.getStationData().getDeviceId());
		/*List<User> usrList=_CPCBDataUploadService.findAll();
		System.out.println("**********saveStationData********" +usrList.size());
		for(int i=0;i<usrList.size();i++){
			System.out.println("**********saveStationData********" +usrList.get(i).getEmail());
				
		}*/
		//System.out.println(" ******* "+usr.getEmail());
		return new ResponseEntity<IndustryData>(industryData, HttpStatus.OK);
	} 
  @RequestMapping(value = "/sms/{industryId}", method = RequestMethod.POST)
	public ResponseEntity<IndustryData> saveSMSData(@PathVariable("industryId")String industryId, @PathVariable("stationId")String stationId, @RequestBody IndustryData industryData){
		System.out.println("**********saveSMSData********" +industryId +"*****" +stationId);
		//IndustryData industryData =new IndustryData();
		//_CPCBDataUploadService.findIndustryData(industryId);
		System.out.println("Device If *****" +industryData.getStationData().getDeviceId());
		/*List<User> usrList=_CPCBDataUploadService.findAll();
		System.out.println("**********saveStationData********" +usrList.size());
		for(int i=0;i<usrList.size();i++){
			System.out.println("**********saveStationData********" +usrList.get(i).getEmail());
				
		}*/
		//System.out.println(" ******* "+usr.getEmail());
		return new ResponseEntity<IndustryData>(industryData, HttpStatus.OK);
	} 
} 
