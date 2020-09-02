/**
 * 
 */
package in.trainings.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import in.trainings.junit5.rest.TrainingAppRestController;

/**
 * @author mohanavelp
 *
 */
@ExtendWith(MockitoExtension.class)
public class J03ParameterizedTests {

	@Mock
    private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Spy
	TrainingAppRestController controller;

	@BeforeEach // For Junit5
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
	
	@Test
	public void testEcho() {
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/api/echo/test"))
			.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"test1", "test2", "test3"})
	public void testEcho2(String name) {
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/api/echo/" + name))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.content().string("Hello " + name));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
