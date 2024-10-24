package trg.state;

public class OffState implements State{

	@Override
	public void showFanStatus() {
		System.out.println("Fan is switched off");
	}

}
