package factoryproject;

public class FactoryMain {

	public static void main(String[] args) {
		
		MathOperation m = MathOperationFactory.getMathOperator("divide");
		
		System.out.println(m.operate(23,45));

	}

}

