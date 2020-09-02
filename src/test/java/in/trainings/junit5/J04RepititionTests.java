/**
 * 
 */
package in.trainings.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

/**
 * @author mohanavelp
 *
 */
public class J04RepititionTests {

	@RepeatedTest(5)
    void repeatedTestWithRepetitionInfo(RepetitionInfo repetitionInfo) {
		System.out.println("Repition index " + repetitionInfo.getCurrentRepetition());
        assertEquals(5, repetitionInfo.getTotalRepetitions());
    }
	
//	@RepeatedTest(value = 2, name = "{displayName} {currentRepetition}/{totalRepetitions}")
//    @DisplayName("Repeat!")
//    void customDisplayName(TestInfo testInfo) {
//        assertEquals("Repeat! 1/1", testInfo.getDisplayName());
//    }
	
}
