package decoratorproject;

public class LegDecorator extends Decorator {

	public LegDecorator(Animal animal) {
		super(animal);
	}

	@Override
	public void describe() {
		animal.describe();
		System.out.println("I have legs and can walk");
dance();
	}
	
	private void  dance() {
		System.out.println("I can dance");
	}

}
