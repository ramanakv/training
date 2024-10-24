package trg.observer;

public class ObserverMain {

	public static void main(String[] args) {
		
		DisplayObserver obs1 = new DisplayObserver();
		StorageObserver  obs2 = new StorageObserver();
		
		NameStore store = new NameStore();
		
	// adding abervers	
		store.addObserver(obs1);
		store.addObserver(obs2);
		
		store.setname("Hyderabad");
		store.setname("Chennai");
		store.setname("Kanpur");
		
	// removing one of the observers	
		store.removeObserver(obs1);
		
		store.setname("Mumbai");
		store.setname("Kolkatta");
		
		obs2.showAllNames();
	}

}
