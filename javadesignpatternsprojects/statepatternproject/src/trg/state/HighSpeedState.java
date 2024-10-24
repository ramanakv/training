package trg.state;

public class HighSpeedState implements State {

	@Override
	public void showFanStatus() {
		System.out.println("Fan is running at high speed");
	}

}
