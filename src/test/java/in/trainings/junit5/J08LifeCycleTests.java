/**
 * 
 */
package in.trainings.junit5;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import in.trainings.junit5.db.entities.UserEntity;
import in.trainings.junit5.util.JunitTestLifecycleLogger;

/**
 * @author mohanavelp
 *
 */
public class J08LifeCycleTests implements JunitTestLifecycleLogger {

	@Test
	public void groupedTests() {
		UserEntity entity = new UserEntity();
		entity.setId(1L);
		entity.setName("test");
		entity.setPassword("test@123");
		entity.setRole("test-role");
		
		assertAll("User entity tests to be performed at once", 
				() -> assertEquals("test", entity.getName()),
				() -> assertEquals(1, entity.getId()),
				() -> assertEquals("test@123", entity.getPassword()), 
				() -> assertEquals("test-role", entity.getRole())
				);
	}
	
	@Test
	@EnabledIfEnvironmentVariable(named = "ENV", matches = "DEV")
	public void groupedTests2() {
		UserEntity entity = new UserEntity();
		entity.setId(2L);
		entity.setName("test2");
		entity.setPassword("2test@123");
		entity.setRole("test-role2");
		
		assertAll("User entity tests to be performed at once", 
				() -> assertEquals("test2", entity.getName()),
				() -> assertEquals(2, entity.getId()),
				() -> assertEquals("2test@123", entity.getPassword()), 
				() -> assertEquals("test-role2", entity.getRole())
				);
	}
	
	@Test
    void exceptionTesting() {
		Calculator calc = new Calculator();
        Exception exception = assertThrows(ArithmeticException.class, () -> calc.divide(1, 0));
        assertEquals("Divisor cannot be 0", exception.getMessage());
    }
	
	private class Calculator {
		public float divide(float value, float divisor) throws ArithmeticException {
			if (divisor == 0) {
				throw new ArithmeticException("Divisor cannot be 0");
			}
			return value/divisor;
		}
	}
	
}
