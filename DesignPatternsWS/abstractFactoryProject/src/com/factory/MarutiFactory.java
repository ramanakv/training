package com.factory;

import com.product.Engine;
import com.product.MarutiEngine;
import com.product.MarutiTransmission;
import com.product.Transmission;

public class MarutiFactory extends CarFactory {

	@Override
	public Engine getEngine() {
		return new MarutiEngine();
	}

	@Override
	public Transmission getTransmission() {
		return new MarutiTransmission();
	}

}
