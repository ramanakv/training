package com.factory;

import com.product.Engine;
import com.product.ToyotEngine;
import com.product.ToyotaTransmission;
import com.product.Transmission;

public class ToyotaFactory extends CarFactory{
	
	@Override
	public Engine getEngine() {
		return new ToyotEngine();
	}

	@Override
	public Transmission getTransmission() {
		return new ToyotaTransmission();
	}

}
