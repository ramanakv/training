package decoratorproject;

public class WingsDecorator extends AbstractDecorator{

	
	public WingsDecorator(LivingThing lt) {
		super(lt);
	}
	
	@Override
	public void describe() {
		livingThing.describe();
		System.out.println("I have wings");
		fly();
	}
	
	private void fly() {
		System.out.println("I can fly");
	}
	
}
