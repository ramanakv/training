package trg.state;

public class CeilingFan {
	
	State state;
	
	public CeilingFan(State state) {
		this.state = state;
	}
	
	public void setState(State state) {
		this.state= state;
	}
	
	public void showRunningStatus() {
		state.showFanStatus();
	}

}
