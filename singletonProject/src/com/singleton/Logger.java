package com.singleton;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDateTime;

public class Logger {

	private PrintStream writer;

	private static Logger logr = null;

	private Logger() {

		String now = LocalDateTime.now().toString().replaceAll(":", "-");
		System.out.println(now);

		String name = "e:\\logFile_" + now.toString().substring(0, 19) + ".txt";
		try {
			writer = new PrintStream(name);
			System.out.println("Log file " + name + " created");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			System.exit(0);
		}

	}

	public void writeMessage(String message) {

		writer.println(message);
	}

	public static Logger getLogger() {
		if (logr == null)
			logr = new Logger();
		return logr;
	}
}
