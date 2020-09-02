/**
 * 
 */
package in.trainings.junit5.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * @author mohanavelp
 *
 */
@Service
public class RatingsService {

	static List<String> AAA = new ArrayList<>();
	static List<String> AAB = new ArrayList<>();
	static List<String> BBB = new ArrayList<>();
	static {
		AAA.add("AAPL");
		AAA.add("MSFT");
		AAA.add("ORCL");
		AAA.add("GOOG");
		AAA.add("TSLA");
		AAA.add("CRED");
		
		AAB.add("CITI");
		AAB.add("BOFA");
		AAB.add("FRAF");
		
		BBB.add("THO");
		BBB.add("BOEN");
		BBB.add("ZM");
	}
	
	public String getCategoryRating(String stock) {
		if (AAA.contains(stock)) {
			return "AAA";
		} else if (AAB.contains(stock)) {
			return "AAB";
		} else if (BBB.contains(stock)) {
			return "BBB";
		}
		return "NA";
	}
	
	public boolean isBest(String stock) {
		System.out.println("Name of the stock");
		return AAA.contains(stock);
	}

	public boolean isGood(String stock) {
		return AAA.contains(stock) || AAB.contains(stock);
	}

	public boolean isOk(String stock) {
		return AAA.contains(stock) || AAB.contains(stock) || BBB.contains(stock);
	}

	public boolean isWorst(String stock) {
		return !(AAA.contains(stock) || AAB.contains(stock) || BBB.contains(stock));
	}
}
