/**
 * 
 */
package in.trainings.junit5.db.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import in.trainings.junit5.db.entities.UserEntity;

/**
 * @author mohanavelp
 *
 */
public interface UserRepository extends CrudRepository<UserEntity, Long> {

	List<UserEntity> findByName(String name);
	
}
