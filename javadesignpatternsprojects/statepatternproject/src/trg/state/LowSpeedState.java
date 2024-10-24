 package trg.state;

public class LowSpeedState implements State{

	@Override
	public void showFanStatus() {
		System.out.println("Fan is running at low speed");
	}

}
