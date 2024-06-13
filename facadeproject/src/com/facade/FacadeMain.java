package com.facade;

public class FacadeMain {

	public static void main(String[] args) {
		
		ProductFacade pf = new ProductFacade();
		
		boolean b = pf.isItemBelowROL(100);
		if(b) {
			System.out.println("product quantity not at comfortable level");
		}
		else {
			System.out.println("product quantity is OK");
		}

	}

}
