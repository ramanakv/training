package trg.adapter;

public class TempReporterImpl  extends CelciusReporter implements TempReporter {
// no data required here

	public void setTempInF(double tempF) {
		setTemp(fToC(tempF));
	}

	public void setTempInC(double tempC) {
		setTemp(tempC);
	}

	public double getTempInF() {
		return cToF(getTemp());
	}

	public double getTempInC() {
		return getTemp();
	}

	private double cToF(double c) {
		return ((c * 9 / 5) + 32);
	}

	private double fToC(double f) {
		return ((f-32)*5/9);
		
	}
}
