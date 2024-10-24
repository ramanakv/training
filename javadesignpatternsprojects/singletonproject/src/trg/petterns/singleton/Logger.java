package trg.petterns.singleton;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDateTime;

public class Logger {
	
	private static Logger logger = new Logger();
	
	 PrintStream ps;
	
	private Logger() {
		
		try {
			ps = new PrintStream("e:/logging.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public static Logger getInstance() {
		return logger;
	}
	
	public void logMessage(String message) {
		ps.println(LocalDateTime.now()+" "+message);
	}

}
