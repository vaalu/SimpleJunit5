/**
 * 
 */
package in.trainings.junit5;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import in.trainings.junit5.db.entities.UserEntity;

/**
 * @author mohanavelp
 *
 */
public class J06GroupedAssertions {

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
