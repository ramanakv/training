package com.str;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class StringIOMain {

	public static void main(String[] args) throws IOException {
		
		String str = """		
				   CREATE TABLE EMPLOYEE
				   (
				      ID INT NOT NULL DEFAULT 0 ,
				      FIRST_NAME VARCHAR(50) NOT NULL ,
				      LAST_NAME VARCHAR(50) NULL ,
				      STAT_CD INT NOT NULL DEFAULT 0
				   );
					 """;
							
		Files.writeString(Path.of("Sample.txt"), str);
		
		String out = Files.readString(Path.of("Sample.txt")) ;
		
		System.out.println(out);
		
	}

}
