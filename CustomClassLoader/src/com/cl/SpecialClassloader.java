package com.cl;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class SpecialClassloader extends ClassLoader {
	String host;
	int port;

	public Class findClass(String name) {
		byte[] b = loadClassData();
		return defineClass(name, b, 0, b.length);
	}

	private byte[] loadClassData() {

		byte data[];
		try {
			FileInputStream fis = new FileInputStream("d:/Dummy.class");
			ByteArrayOutputStream bos = new ByteArrayOutputStream();

			while (true) {
				int val = fis.read();
				if (val == -1)   // end of file
					break;
				bos.write(val);
			}

			fis.close();
			
			data = bos.toByteArray();

			bos.close();
			return data;

		} catch (IOException e) {
			e.printStackTrace();

			System.exit(0);
		}

		return null;
	}
	
	
	public String toString() {
		return "Name: SpecialClassLoader  created for training purpose";
	}
	public static void main(String args[]) throws Exception {
		SpecialClassloader loader = new SpecialClassloader();
		Class<?> cls = loader.findClass("com.cls.Dummy");
		System.out.println(cls.getClassLoader());
		
		Object obj = cls.newInstance();
		
		cls.getMethod("showMessage").invoke(obj);
	}
}