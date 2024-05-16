package statepatternproject;

public class MediumSpeedState implements State {

	@Override
	public void nextStateAction(CeilingFan fan) {
		System.out.println("Fan changed to high speed");
		fan.setCurrentState(new HighSpeedState());	
	}

}