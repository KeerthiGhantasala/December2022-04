package com.acme.mytrader.price;

import java.util.ArrayList;
import java.util.List;

public class PriceSorceImpl implements PriceSource {

	List<PriceListener> listeners = new ArrayList<PriceListener>();

	@Override
	public void addPriceListener(PriceListener listener) {
		listeners.add(listener);
	}

	@Override
	public void removePriceListener(PriceListener listener) {
		listeners.remove(listener);
	}

	@Override
	public void triggerMoniterUpdate(String security, double price) {
		listeners.forEach(listener -> listener.priceUpdate(security, price));
	}

}
