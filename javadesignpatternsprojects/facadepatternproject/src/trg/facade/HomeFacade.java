package trg.facade;

public class HomeFacade {

	AC ac = new AC();
	Television tv = new Television();
	SecurtyAlarm alarm = new SecurtyAlarm();

	public void leaveHome() {

		ac.switchOff();
		tv.switchOff();
		alarm.activate();
	}

	public void returnToHome() {

		ac.switchOn();
		tv.switchOn();
		alarm.deactivate();
	}

}
