package com.acme.mytrader.price;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.acme.mytrader.execution.ExecutionServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PriceListenerImplTest {

	PriceListerImpl priceListerImpl;

	@Mock
	ExecutionServiceImpl executionServiceImpl;

	@Before
	public void setup() {

		priceListerImpl = new PriceListerImpl(100);
		priceListerImpl.executionService = executionServiceImpl;
	}

	@Test
	public void testPriceUpdateForIncrease() {
		priceListerImpl.priceUpdate("IBM", 60);
		Mockito.verify(executionServiceImpl, Mockito.times(0)).buy("IBM", 160, 100);

	}

	@Test
	public void testPriceUpdateForDecrease() {
		priceListerImpl.priceUpdate("IBM", -60);
		Mockito.verify(executionServiceImpl, Mockito.times(1)).buy("IBM", 40, 100);

	}

	@Test
	public void testPriceUpdateForIncraeseCase2() {
		priceListerImpl.priceUpdate("IBM", 50);
		Mockito.verify(executionServiceImpl, Mockito.times(0)).buy("IBM", 150, 100);

	}

	@Test
	public void testPriceUpdateForDecraeseCase2() {
		priceListerImpl.priceUpdate("IBM", -45);
		Mockito.verify(executionServiceImpl, Mockito.times(0)).buy("IBM", 55, 100);

	}

}
