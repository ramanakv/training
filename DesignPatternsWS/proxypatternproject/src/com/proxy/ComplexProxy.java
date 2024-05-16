package com.proxy;

public class ComplexProxy {

	Complex comp ;
	
	public void display() {
		
		if(comp == null) {
			comp = new Complex();
		}
		
		comp.displaY();
	}
}
