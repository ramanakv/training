package com.proxy;

public class ProxyMain {

	public static void main(String[] args) {
		States st = new StateCacheProxy();
		
		System.out.println( st.getCapital("ap"));
		
		System.out.println( st.getCapital("up"));
		System.out.println( st.getCapital("ap"));
		System.out.println( st.getCapital("bihar"));
		System.out.println( st.getCapital("punjab"));
		
		System.out.println( st.getCapital("MP"));
		
		System.out.println( st.getCapital("bihar"));

	}

}
