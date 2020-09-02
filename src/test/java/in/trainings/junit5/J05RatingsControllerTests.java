/**
 * 
 */
package in.trainings.junit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author mohanavelp
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
public class J05RatingsControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testEcho() {
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/api/hello/test"))
			.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"test1", "test2", "test3"})
	public void testEcho2(String name) {
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/api/hello/" + name))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.content().string("Hello " + name));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"AAPL", "ORCL", "TEST"})
	public void testIsBest(String name) {
		try {
			String assertionValue = (name == "AAPL") || (name == "ORCL") ? "Best: true" : "Best: false";
			mockMvc.perform(MockMvcRequestBuilders.get("/api/isbest/" + name))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.content().string(assertionValue));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@ParameterizedTest
	@ValueSource(strings = {"AAPL", "ORCL", "TEST"})
	public void testIsGood(String name) {
		try {
			String assertionValue = (name == "AAPL") || (name == "ORCL") ? "Good: true" : "Good: false";
			mockMvc.perform(MockMvcRequestBuilders.get("/api/isgood/" + name))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.content().string(assertionValue));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
