package commandpatternproject;

public class CommandMain {

	public static void main(String[] args) {

		Accumulator accum = new Accumulator();
		Command command1 = new AddCommand(accum, "addOneValue", new Integer[] { 300 });

		Command command2 = new AddCommand(accum, "addTwoValues", new Integer[] { 100, 200 });

		invoke(command1);

		invoke(command2);

		int accuValue = accum.getLatestValue();

		System.err.println(accuValue);

	}

	static void invoke(Command cmd) {

		cmd.execute();
	}

}
