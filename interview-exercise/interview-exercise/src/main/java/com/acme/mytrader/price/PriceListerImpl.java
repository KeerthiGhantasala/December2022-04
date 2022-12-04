package com.acme.mytrader.price;

import com.acme.mytrader.execution.ExecutionServiceImpl;

public class PriceListerImpl implements PriceListener {

	private final static double THRESHOLD_PRICE_IBM = 55;
	private double currentPrice;
	ExecutionServiceImpl executionService = new ExecutionServiceImpl();

	public PriceListerImpl(double currentPrice) {
		super();
		this.currentPrice = currentPrice;
	}

	@Override
	public void priceUpdate(String security, double price) {

		double updatedPrice = 0;

		synchronized (this) {
			updatedPrice = this.currentPrice + price;
			this.currentPrice = updatedPrice;
			if (updatedPrice < getThresholdPrice(security)) {
				executionService.buy(security, updatedPrice, 100);
			}
		}

	}

	private double getThresholdPrice(String security) {
		if ("IBM".equalsIgnoreCase(security)) {
			return THRESHOLD_PRICE_IBM;
		}
		return 0;

	}

}
