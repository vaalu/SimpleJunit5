/**
 * 
 */
package in.trainings.junit5.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.trainings.junit5.db.entities.UserEntity;
import in.trainings.junit5.db.repos.UserRepository;
import in.trainings.junit5.services.EmployeeService;

/**
 * @author mohanavelp
 *
 */
@RestController
@RequestMapping("/api")
public class TrainingAppRestController {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	EmployeeService empService;
	
	@RequestMapping(value = "/echo/{name}", method = RequestMethod.GET)
	public String echo(@PathVariable("name") String name) {
		return "Hello " + name;
	}
	
	@RequestMapping(value = "/createusers", method = RequestMethod.GET)
	public String creeate() {
		UserEntity entity = new UserEntity();
		entity.setName("Adam");
		entity.setPassword("adam@123");
		entity.setRole("USER");
		userRepo.save(entity);
		
		entity = new UserEntity();
		entity.setName("Scott");
		entity.setPassword("scott@123");
		entity.setRole("ADMIN");
		userRepo.save(entity);
		
		entity = new UserEntity();
		entity.setName("Mark");
		entity.setPassword("mark@123");
		entity.setRole("DBA");
		userRepo.save(entity);
		
		return "Users created";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<UserEntity> getAllUsers() {
		List<UserEntity> usersList = new ArrayList<UserEntity>();
		Iterable<UserEntity> users = userRepo.findAll();
		users.forEach((entity) -> usersList.add(entity));
		return usersList;
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public UserEntity getUser(@PathVariable("id") Long id) {
		return empService.getUser(id);
	}

	@RequestMapping(value = "/isadmin/{id}", method = RequestMethod.GET)
	public boolean isAdmin(@PathVariable("id") Long id) {
		return empService.isAdmin(id);
	}
}
