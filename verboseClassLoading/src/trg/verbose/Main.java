package trg.verbose;

// run with  -verbose:class 
public class Main {

	static {

		System.out.println("This is static block");
	}

	public static void main(String[] args) {
		
		System.out.println("Hello world");

	}
	
	
	
	static {
		
		System.out.println("This is second static block");
	}

}
