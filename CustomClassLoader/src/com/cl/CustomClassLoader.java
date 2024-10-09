package com.cl;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;


// run with -verbose:class to see the loaded classes
public class CustomClassLoader extends ClassLoader {

	@Override
	public Class findClass(String name) throws ClassNotFoundException {
		byte[] b;
		try {
			b = loadClassData(name);
			return defineClass(name, b, 0, b.length);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private byte[] loadClassData(String fileName) throws FileNotFoundException {

		InputStream inputStream;

		inputStream = new FileInputStream("E:\\GithubFolder\\backup\\DummyImpl.class");

		// InputStream inputStream = getClass().getClassLoader().getResourceAsStream(
		// fileName.replace('.', File.separatorChar) + ".class");
		byte[] buffer;
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		int nextValue = 0;
		try {
			while ((nextValue = inputStream.read()) != -1) {
				byteStream.write(nextValue);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		buffer = byteStream.toByteArray();

		return buffer;
	}

	public static void main(String args[])
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		CustomClassLoader loader = new CustomClassLoader();

		//d = (Dummy) cls.getDeclaredConstructor().newInstance();
		//Dummy d = (Dummy) loader.findClass("com.cl.DummyImpl").newInstance();
		//d.show();
		
		Class<?> cls = loader.findClass("com.cl.DummyImpl");
		Object obj = cls.newInstance();
		cls.getMethod("show").invoke(obj);

	}
}