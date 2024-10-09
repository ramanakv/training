
public class StringTest {
	public static void main(String args[]) {
		String s = new String();
		long start = System.nanoTime();
		for (char ch = 'A'; ch <= 'Z'; ch++)
			s = s + ch;
		long end = System.nanoTime();
		System.out.println(s);
		
		System.out.println("String Code Time: " + (end - start) + " nanos");

		StringBuffer sbuffer = new StringBuffer();
		start = System.nanoTime();
		for (char ch = 'A'; ch <= 'Z'; ch++)
			sbuffer.append(ch);
		end = System.nanoTime();
		System.out.println(sbuffer);
		
		System.out.println("StringBuffer Time: " + (end - start) + " nanos");

		StringBuilder sbuilder = new StringBuilder();
		start = System.nanoTime();
		for (char ch = 'A'; ch <= 'Z'; ch++)
			sbuilder.append(ch);
		end = System.nanoTime();
		System.out.println(sbuffer);
	
		System.out.println("StringBuilder Time: " + (end - start) + " nanos");
	}

}
