/**
 * 
 */
package in.trainings.junit5.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.trainings.junit5.services.RatingsService;
import in.trainings.junit5.services.RecommendationService;

/**
 * @author mohanavelp
 *
 */
@RestController
@RequestMapping("/api")
public class RatingsController {

	@Autowired
	RatingsService ratingsService;
	
	@Autowired
	RecommendationService recommendationService;
	
	@RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
	public String echo(@PathVariable("name") String name) {
		return "Hello " + name;
	}
	
	@RequestMapping(value = "/isbest/{stock}", method = RequestMethod.GET)
	public String isBest(@PathVariable("stock") String stock) {
		return "Best: " + ratingsService.isBest(stock);
	}

	@RequestMapping(value = "/isgood/{stock}", method = RequestMethod.GET)
	public String isGood(@PathVariable("stock") String stock) {
		return "Good: " + ratingsService.isGood(stock);
	}

	@RequestMapping(value = "/isok/{stock}", method = RequestMethod.GET)
	public String isOk(@PathVariable("stock") String stock) {
		return "Ok: " + ratingsService.isOk(stock);
	}

	@RequestMapping(value = "/isworst/{stock}", method = RequestMethod.GET)
	public String isWorst(@PathVariable("stock") String stock) {
		return "Worst: " + ratingsService.isWorst(stock);
	}

	@RequestMapping(value = "/isGoodToBuy/{stock}/{price}", method = RequestMethod.GET)
	public String isGoodToBuy(@PathVariable("stock") String stock, @PathVariable("price") float price) {
		return "Buy recommendation: " + recommendationService.isGoodToBuy(stock, price);
	}

	@RequestMapping(value = "/isGoodToSell/{stock}/{price}", method = RequestMethod.GET)
	public String isGoodToSell(@PathVariable("stock") String stock, @PathVariable("price") float price) {
		return "Buy recommendation: " + recommendationService.isGoodToSell(stock, price);
	}
}
