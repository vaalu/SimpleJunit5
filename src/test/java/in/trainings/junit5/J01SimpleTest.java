/**
 * 
 */
package in.trainings.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
//@ExtendWith(SpringExtension.class)
//@WebAppConfiguration()
//@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class J01SimpleTest {

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
	
	@Test
	public void testEcho2() {
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/api/echo/test"))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.content().string("Hello test"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
