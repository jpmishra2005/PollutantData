package main.java.com.org.cpcbapi;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CpcbRTUploadRestController {
  
 /*
  @RequestMapping(method=RequestMethod.GET)
  public List<Contact> getAll() {
    return repo.findAll();
  }
  */
	
  @RequestMapping("/home")
  public String create() {
    //return repo.save(contact);
	 System.out.println("********" );
	 return "hi";
  }
  
 /* @RequestMapping(method=RequestMethod.DELETE, value="{id}")
  public void delete(@PathVariable String id) {
    repo.delete(id);
  }
  
  @RequestMapping(method=RequestMethod.PUT, value="{id}")
  public Contact update(@PathVariable String id, @RequestBody Contact contact) {
    Contact update = repo.findOne(id);
    update.setAddress(contact.getAddress());
    update.setEmail(contact.getEmail());
    update.setFacebookProfile(contact.getFacebookProfile());
    update.setFirstName(contact.getFirstName());
    update.setGooglePlusProfile(contact.getGooglePlusProfile());
    update.setLastName(contact.getLastName());
    update.setLinkedInProfile(contact.getLinkedInProfile());
    update.setPhoneNumber(contact.getPhoneNumber());
    update.setTwitterHandle(contact.getTwitterHandle());
    return repo.save(update);
  }
*/
}
