package trg.petterns.singleton;


public class Main {

	public static void main(String[] args) {
		Logger log1 = Logger.getInstance();
		log1.logMessage("this is first message from main() of "+ Main.class.getName());
		
		Utility util = new Utility();
		util.doSomeThing();
		
		
		Logger log2 = Logger.getInstance();
		
		log2.logMessage("this is another message from main() of "+ Main.class.getName());
				
		
	}

}
