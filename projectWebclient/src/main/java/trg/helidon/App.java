package trg.helidon;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.helidon.common.media.type.MediaTypes;
import io.helidon.http.Status;
import io.helidon.webclient.api.ClientResponseTyped;
import io.helidon.webclient.api.WebClient;
import jakarta.json.JsonArray;

// Webclient to access project2SE

public class App {
	static WebClient client;
	static 	ObjectMapper mapper = new ObjectMapper();
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {

		 client = 
				WebClient
				    .builder()
				    .baseUri("http://localhost:8080")
				    .build();

	//getBook(900);

	//	getBookList();
		
		saveBook(new Book(900,"SQL Handbook","Kailash"));
	}

	static void getBook(int id) throws JsonMappingException, JsonProcessingException {
		ClientResponseTyped<String> response = 
				client.get()
				      .path("/books/"+id)
				      .accept(MediaTypes.APPLICATION_JSON)
				      .request(String.class);
		
		if (response.status() == Status.OK_200) {
			Book book = mapper.readValue(response.entity(), Book.class);
			System.out.println(book);
		
		} else {
			System.out.println(response.entity());
		}
	}

	static void getBookList() throws JsonMappingException, JsonProcessingException {
		
		ClientResponseTyped<JsonArray> response = 
				client.get()
				      .path("/books")
				      .request(JsonArray.class);
		
		List<Book> bookList = new ArrayList<>();
		
		for (var obj : response.entity()) {
			Book book = mapper.readValue(obj.toString(), Book.class);
			bookList.add(book);
		}

		bookList.forEach(System.out::println);
	}
	
	static void saveBook(Book book) throws JsonProcessingException {
		
		String entity = mapper.writeValueAsString(book);
		
		ClientResponseTyped<String> response = 
				client.post()
				      .path("/books")
				      .contentType(MediaTypes.APPLICATION_JSON)
				      .submit(entity,String.class);
				   
		System.out.println(response.entity());
		
		
	}
	
}
