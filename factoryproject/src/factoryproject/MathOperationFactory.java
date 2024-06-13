package factoryproject;

import javax.management.RuntimeErrorException;

public class MathOperationFactory {

	public static MathOperation getMathOperator(String opr) {

		switch (opr) {

		case "add":
			return new Adder();
		case "multiply":
			return new Multiplier();
		case "subtract":
			return new Subtracter();

		default:
			throw new RuntimeException("No such operation available");

		}
	}

	private static class Adder implements MathOperation {

		@Override
		public int operate(int x, int y) {
			return x + y;
		}

	}

	private static class Multiplier implements MathOperation {

		@Override
		public int operate(int x, int y) {
			return x * y;
		}

	}

	private static class Subtracter implements MathOperation {

		@Override
		public int operate(int x, int y) {
			return x - y;
		}

	}

}
