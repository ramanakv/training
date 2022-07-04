package project2;

public class Overload {

	public int add(int x, int y) {
		System.out.println("Two argument addition");
		return x + y;
	}

	public int add(int x, int y, int z) {
		System.out.println("Three argument addition");
		return x + y + z;
	}

	public static void main(String[] args) {

		Overload t = new Overload();
		int result;
		result=t.add(20,30);
		System.out.println(result);
		result=t.add(10,20,30);
		System.out.println(result);
	}
}