package com.itbulls.learnit.javacore.patterns.structural.facade;

import java.util.Date;
import java.util.List;

public class Demo {
	public static void main(String[] args) {
		TravelFacade travelFacade = new TravelFacade();
		List<TravelRoute> travelRoutes = 
				travelFacade.getTravelRoutes(new Date(), new Date());
		
		if (travelRoutes != null && travelRoutes.size() > 0) {
			travelFacade.bookTravelRoute(travelRoutes.get(0));
		}
		
	}
}
