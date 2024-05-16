package observerpatternproject;

public class ObserverMain {

	public static void main(String[] args) {
		
		NumberStore ns = new NumberStore();
		//ceate observers
		Observer ob1 = new DisplayObserver();
		Observer ob2 = new StorageObserver();
		
		// register observers
		ns.register(ob1);
		ns.register(ob2);
		
		// keep making changes to NumberStore
		ns.setNumber(250);
		ns.setNumber(350);
		ns.setNumber(120);
		
		// getdata from StorageObserver
		
		StorageObserver sob = (StorageObserver)ob2;
		sob.getAllNumbers();
		
	}

}
