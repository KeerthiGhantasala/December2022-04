package com.acme.mytrader.strategy;

import com.acme.mytrader.price.PriceListerImpl;
import com.acme.mytrader.price.PriceSorceImpl;

/**
 * <pre>
 * User Story: As a trader I want to be able to monitor stock prices such
 * that when they breach a trigger level orders can be executed automatically
 * </pre>
 */
public class TradingStrategy {

	PriceSorceImpl priceSource= new PriceSorceImpl();
	PriceListerImpl priceListerImpl;

	public void startTrading(String security, double changeInPrice,double initialPrice) { 
		priceListerImpl= new PriceListerImpl(initialPrice);
		priceSource.addPriceListener(priceListerImpl);
		priceSource.triggerMoniterUpdate(security, changeInPrice);

	}
}
