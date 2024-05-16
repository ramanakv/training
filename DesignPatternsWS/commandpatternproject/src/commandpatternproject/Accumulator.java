package commandpatternproject;

public class Accumulator {
	
	private int num=0;
	
	public void addOneValue(Integer x) {
		num = num + x;
	}

	public void addTwoValues(Integer x, Integer y) {
		num = num + x + y;
	}
	
	public int getLatestValue() {
		return num;
	}
}
