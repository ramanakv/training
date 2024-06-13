package com.adapter;

public class TempObjectAdapter implements TempAdapter {

	CelciusReporter rep = new CelciusReporter();

	@Override
	public void setTempInC(double tc) {
		rep.setTempInC(tc);
	}

	@Override
	public void setTempInF(double ft) {
		rep.setTempInC(FtoC(ft));
	}

	@Override
	public double getTempInC() {
		return rep.getTempInC();
	}

	@Override
	public double getTempInF() {

		return CtoF(rep.getTempInC());
	}

	private double CtoF(double t) {
		return ((t * 9 / 5) + 32);
	}

	private double FtoC(double t) {
		return ((t - 32) * 5 / 9);
	}

}
