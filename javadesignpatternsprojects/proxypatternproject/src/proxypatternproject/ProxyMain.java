package proxypatternproject;

public class ProxyMain {

	public static void main(String[] args) {
		Handler h = new StatesHandlerProxy();
		
		System.out.println(h.getCapital("AP"));
		System.out.println(h.getCapital("Chennai"));
		System.out.println(h.getCapital("MP"));
		
		System.out.println(h.getCapital("AP"));
		
		System.out.println(h.getCapital("MP"));
		System.out.println(h.getCapital("Bihar"));

	}

}
