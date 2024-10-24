package trg.adapter;

public interface TempReporter {
	void setTempInF(double tempF);

	void setTempInC(double tempC);

	double getTempInF();

	double getTempInC();
}
