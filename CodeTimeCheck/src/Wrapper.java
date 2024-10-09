import java.math.BigInteger;

public class Wrapper {
	
	public static void main(String args[]) {
		int x = 10;
		long start = System.nanoTime();
		for (int i = 1; i < 100;i++)
			x+=i;
		long end = System.nanoTime();
		System.out.println(x);
		
		System.out.println("Primitive Code Time: " + (end - start) + " nanos");

		Integer xi = 10;
		 start = System.nanoTime();
		for (int i = 1; i < 100;i++)
			xi+=i;
		 end = System.nanoTime();
		System.out.println(xi);
		
		System.out.println("Wrapper Code Time: " + (end - start) + " nanos");
		
		BigInteger xb = new BigInteger("10");
		 start = System.nanoTime();
		for (int i = 1; i < 100;i++)
			xb.add(new BigInteger(i+""));
		 end = System.nanoTime();
		System.out.println(xb);
		
		System.out.println("BigInteger Code Time: " + (end - start) + " nanos");
		
		
	}



}
