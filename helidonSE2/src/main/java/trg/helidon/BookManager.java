package trg.helidon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class BookManager {

	static private ConcurrentMap<Integer, Book> store = new ConcurrentHashMap<>();

	static {
		store.put(100, new Book(100, "Java", "Jhonson"));
		store.put(200, new Book(200, "Helidon", "Suresh Rao"));
		store.put(300, new Book(300, "Spring Boot", "Abhinesh"));
		store.put(400, new Book(400, "Microservices", "Kishore Jain"));
		store.put(500, new Book(500, "Learn C++", "Surath Kumar"));
	}

	public static boolean add(Book book) {
		if (store.containsKey(book.getId()))
			return false;
		store.put(book.getId(), book);
		return true;
	}

	public static Book get(Integer id) {
		return store.get(id);
	}

	public static List<Book> getAll() {

		List<Book> list = new ArrayList<Book>(store.values());
		return list;
	}

	public static boolean update(Book book) {
		if (store.containsKey(book.getId())) {
			store.put(book.getId(), book);
			return true;
		}
		return false;
	}

	public static boolean delete(int id) {
		if (store.containsKey(id)) {
			store.remove(id);
			return true;
		}
		return false;
	}

}
