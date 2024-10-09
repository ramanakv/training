package com.cl;

import java.sql.*;
import java.util.ArrayList;

public class ClassLoaderTest {
	public static void printClassLoaders() throws ClassNotFoundException {

		System.out.println("Classloader of this class:" + ClassLoaderTest.class.getClassLoader());

		System.out.println("Classloader of DriverManager:" + DriverManager.class.getClassLoader());
		
		// this will show null
		// because the bootstrap class loader is written in native code, not Java
		System.out.println("Classloader of ArrayList:" + ArrayList.class.getClassLoader());
	}

	public static void main(String args[]) throws ClassNotFoundException {
		printClassLoaders(); 
		
	}
}
