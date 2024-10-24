package trg.adapter;

public class Main {

	public static void main(String[] args) {
		TempReporterImpl tr = new TempReporterImpl();
		
		tr.setTempInC(34.5);
		System.out.println(tr.getTempInF());
		
		tr.setTempInF(94.1);
		System.out.println(tr.getTempInC());
		

	}

}
