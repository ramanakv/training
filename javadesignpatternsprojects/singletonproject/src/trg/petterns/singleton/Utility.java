package trg.petterns.singleton;

public class Utility {
	
	public void doSomeThing() {
		
		Logger log = Logger.getInstance();
		log.logMessage("this is some othe message from  doSomeThing() of " + Utility.class.getName());
	}

}
