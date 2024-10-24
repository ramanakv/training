package trg.state;

public class FanRegulator {
	
	State [] states = {new OffState(), new LowSpeedState(), new MediumSpeedState(), new HighSpeedState()};
	
	CeilingFan fan = new CeilingFan(states[0]);
	int x = 0;
	
	public void rotate() {
		fan.setState(states[++x%states.length]);
		fan.showRunningStatus();
	}

}
