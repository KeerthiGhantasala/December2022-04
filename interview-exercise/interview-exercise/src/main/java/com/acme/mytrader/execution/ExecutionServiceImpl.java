package com.acme.mytrader.execution;

public class ExecutionServiceImpl implements ExecutionService {

	@Override
	public void buy(String security, double price, int volume) {
		System.out.println("order placed for " + security + " of price " + price + " for volume " + volume);

	}

	@Override
	public void sell(String security, double price, int volume) {
		// TODO Auto-generated method stub

	}

}
