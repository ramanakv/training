package com.proxy;

public class ProxyMain {

	public static void main(String[] args) {
		ComplexProxy proxy = new ComplexProxy();
		proxy.display();
		
		CacheProxy cp = new CacheProxy();
		
		System.out.println(cp.getCapital("AP"));
		System.out.println(cp.getCapital("Bihar"));
		System.out.println(cp.getCapital("Kerala"));
		System.out.println(cp.getCapital("orissa"));
		System.out.println(cp.getCapital("AP"));
		System.out.println(cp.getCapital("kerala"));
		System.out.println(cp.getCapital("bihar"));
		System.out.println(cp.getCapital("maharashtra"));
	}

}
