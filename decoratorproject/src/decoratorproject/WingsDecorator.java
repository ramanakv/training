package decoratorproject;

public class WingsDecorator extends Decorator {

	public WingsDecorator(Animal animal) {
		super(animal);
	}

	@Override
	public void describe() {
		animal.describe();
		System.out.println("I have wings and can fly");

	}

}
