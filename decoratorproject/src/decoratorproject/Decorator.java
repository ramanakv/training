package decoratorproject;

public abstract class Decorator implements Animal{
	Animal animal;

	public Decorator(Animal animal) {
		super();
		this.animal = animal;
	}
	
}
