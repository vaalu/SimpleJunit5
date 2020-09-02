/**
 * 
 */
package in.trainings.junit5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.trainings.junit5.db.entities.UserEntity;
import in.trainings.junit5.db.repos.UserRepository;

/**
 * @author mohanavelp
 *
 */
@Service
public class EmployeeService {
	
	@Autowired
	UserRepository userRepo;
	
	public UserEntity getUser(long id) {
		UserEntity entity = userRepo.findById(id).get();
		return entity;
	}
	public boolean isAdmin(long id) {
		UserEntity entity = userRepo.findById(id).get();
		
		return "ADMIN".equalsIgnoreCase(entity.getRole());
	}
}
