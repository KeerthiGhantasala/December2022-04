package com.acme.mytrader.strategy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.acme.mytrader.price.PriceSorceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TradingStrategyTest {

	private TradingStrategy tradingStrategy;

	@Mock
	PriceSorceImpl priceSorceImpl;

	@Before
	public void setup() {
		tradingStrategy = new TradingStrategy();
		tradingStrategy.priceSource = priceSorceImpl;
	}

	@Test
	public void testStartTradingWithChangeisPositive() {
		tradingStrategy.startTrading("IBM", 50, 100);
		Mockito.verify(priceSorceImpl, Mockito.times(1)).triggerMoniterUpdate("IBM", 50);

	}

	@Test
	public void testStartTradingWithChangeisNegative() {
		tradingStrategy.startTrading("IBM", -50, 100);
		Mockito.verify(priceSorceImpl, Mockito.times(1)).triggerMoniterUpdate("IBM", -50);

	}

}
