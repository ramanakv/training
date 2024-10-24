package trg.facade;

public class FacadeMain {

	public static void main(String[] args) {
		HomeFacade hf = new HomeFacade();

		System.out.println("======= Going to office ==========");

		hf.leaveHome();

		System.out.println("======= Returning Home ==========");
		hf.returnToHome();
	}

}
