package statepatternproject;

public class HighSpeedState implements State {

	@Override
	public void nextStateAction(CeilingFan fan) {
		System.out.println("Fan is switched off");
		fan.setCurrentState(new OffState());
	}

}