package com.adapter;

public class TempClassAdapter extends CelciusReporter implements TempAdapter {

	
	@Override
	public void setTempInC(double tc) {
		super.setTempInC(tc);
	}

	@Override
	public void setTempInF(double ft) {
		super.setTempInC(FtoC(ft));
	}

	@Override
	public double getTempInC() {
		return super.getTempInC();
	}

	@Override
	public double getTempInF() {

		return CtoF(super.getTempInC());
	}

	private double CtoF(double t) {
		return ((t * 9 / 5) + 32);
	}

	private double FtoC(double t) {
		return ((t - 32) * 5 / 9);
	}

}
