/**
 * 
 */
package in.trainings.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import in.trainings.junit5.db.entities.UserEntity;

/**
 * @author mohanavelp
 *
 */
public class J02SimpleAssertion {

	@Test
	public void testUserEntity() {
		UserEntity entity = new UserEntity();
		entity.setName("test");
		assertEquals("test", entity.getName());
	}
	
}
