package com.adapter;

public class TempObjectAdapter implements TempAdapter {

	CelciusReporter celciusReporter;

	public TempObjectAdapter() {
		celciusReporter = new CelciusReporter();
	}

	@Override
	public double getTempInF() {

		double c = celciusReporter.getTempC(); 

		double f = cTof(c);
		return f;
	}

	@Override
	public double getTempInC() {
		return celciusReporter.getTempC();
	}

	@Override
	public void setTempInC(double tempC) {
		celciusReporter.setTempC(tempC);
	}

	@Override
	public void setTempInF(double TempF) {
		double c = fToc(TempF);
		celciusReporter.setTempC(c);
	}

	private double cTof(double c) {
		return ((c * 9 / 5) + 32);
	}

	private double fToc(double f) {
		return (f - 32) * 5 / 9;
	}

}
