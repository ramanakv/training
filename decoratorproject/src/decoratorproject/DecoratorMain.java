package decoratorproject;

public class DecoratorMain {

	public static void main(String[] args) {
		Animal a = new LivingAnimal();
	//	a.describe();
		
		LegDecorator ld = new LegDecorator(a);
	//	ld.describe();
		
		WingsDecorator wd = new WingsDecorator(ld);
		wd.describe();
	}

}
