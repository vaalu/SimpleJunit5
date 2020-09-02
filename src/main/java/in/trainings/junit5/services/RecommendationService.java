/**
 * 
 */
package in.trainings.junit5.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mohanavelp
 *
 */
@Service
public class RecommendationService {

	static Map<String, StockInfo> RECOMMENDATIONS = new HashMap<>();
	static {
		RECOMMENDATIONS.put("AAPL", new StockInfo("AAPL", 	129.85f));
		RECOMMENDATIONS.put("MSFT", new StockInfo("MSFT", 	225.53f));
		RECOMMENDATIONS.put("ORCL", new StockInfo("ORCL", 	57.22f));
		RECOMMENDATIONS.put("GOOD", new StockInfo("GOOGL", 	1629.15f));
		RECOMMENDATIONS.put("TSLA", new StockInfo("TSLA", 	498.05f));
		RECOMMENDATIONS.put("CRED", new StockInfo("CRED", 	34));
		RECOMMENDATIONS.put("CITI", new StockInfo("CITI", 	51.12f));
		RECOMMENDATIONS.put("BOFA", new StockInfo("BOFA", 	25.74f));
		RECOMMENDATIONS.put("FRAF", new StockInfo("FRNK", 	24.47f));
		RECOMMENDATIONS.put("THO", new StockInfo("THO", 	94.39f));
		RECOMMENDATIONS.put("BOEN", new StockInfo("BOEN", 	189.25f));
		RECOMMENDATIONS.put("ZM", new StockInfo("ZOOM", 	277.28f));
	}
	
	@Autowired
	RatingsService ratingsService;
	
	public String isGoodToBuy(String stock, float price) {
		String recommended = "NA " + stock;
		if (ratingsService.isBest(stock) && (RECOMMENDATIONS.get(stock).getPrice() < (price * (2/100)))) {
			recommended = "BUY NOW " + stock;
		}
		else if (ratingsService.isGood(stock) && (RECOMMENDATIONS.get(stock).getPrice() < (price * (2/100)))) {
			recommended = "BUY LATER " + stock;
		}
		else if (ratingsService.isOk(stock) && (RECOMMENDATIONS.get(stock).getPrice() < (price * (2/100)))) {
			recommended = "WAIT " + stock;
		}
		else {
			recommended = "NOT RECOMMENDED " + stock;
		}
		return recommended;
	}
	
	public String isGoodToSell(String stock, float price) {
		String recommended = "NA " + stock;
		if (ratingsService.isBest(stock) && (RECOMMENDATIONS.get(stock).getPrice() > (price * (2/100)))) {
			recommended = "SELL NOW " + stock;
		}
		else if (ratingsService.isGood(stock) && (RECOMMENDATIONS.get(stock).getPrice() > (price * (2/100)))) {
			recommended = "SELL LATER "+ stock;
		}
		else if (ratingsService.isOk(stock) && (RECOMMENDATIONS.get(stock).getPrice() > (price * (2/100)))) {
			recommended = "WAIT " + stock;
		}
		else {
			recommended = "NOT RECOMMENDED " + stock;
		}
		return recommended;
	}
	
	private static class StockInfo {
		
		private String stock;
		private float price;
		
		public StockInfo(String stock, float price) {
			this.setStock(stock);
			this.setPrice(price);
		}

		/**
		 * @return the stock
		 */
		public String getStock() {
			return stock;
		}

		/**
		 * @param stock the stock to set
		 */
		public void setStock(String stock) {
			this.stock = stock;
		}

		/**
		 * @return the price
		 */
		public float getPrice() {
			return price;
		}

		/**
		 * @param price the price to set
		 */
		public void setPrice(float price) {
			this.price = price;
		}
	}
}
















