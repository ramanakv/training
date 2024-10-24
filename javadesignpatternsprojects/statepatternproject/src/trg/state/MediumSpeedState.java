package trg.state;

public class MediumSpeedState implements State{

	@Override
	public void showFanStatus() {
		System.out.println("Fan is running at medium speed");
	}

}
