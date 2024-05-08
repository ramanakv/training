package com.trg.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.entity.Employee;

public class App {

	public static void main(String[] args) {
		// getHtml();
		// getOneEmployee(100);

		//getAllEmployees();
		
		save(new Employee(888,"Harish",33000,LocalDate.of(1987, 12,23)));
	}

	static void getHtml() {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/gethtml")).GET().build();
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

			// System.out.println(response.body());

			Files.writeString(Path.of("e:/welcome.html"), response.body());

			System.out.println("HTML file created at e:/welcome.html");

		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void getOneEmployee(int eid) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/employees/" + eid))
				.build();
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			int status = response.statusCode();
			if (status != 200)
				System.out.println(response.body());
			else {
				ObjectMapper mapper = new ObjectMapper();
				mapper.registerModule(new JavaTimeModule());
				Employee e = mapper.readValue(response.body(), Employee.class);
				System.out.println(e);
			}

		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void getAllEmployees() {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/employees")).build();
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		//	System.out.println(response.body());
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			Employee[] emps = mapper.readValue(response.body(), Employee[].class);

			Arrays.asList(emps).forEach(System.out::println);
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void save(Employee e) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		String json="";
		try {
			json = mapper.writer().writeValueAsString(e);
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/employees"))
				 .POST(BodyPublishers.ofString(json))
				 .header("content-type", "application/json")
				 .build();
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			System.out.println(response.body());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void asyncGetEmployee(int eid) throws IOException, InterruptedException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/employees/" + eid)).GET()
				.build();

		client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(response -> {
			System.out.println(response.statusCode());
			return response;
		}).thenApply(response -> response.body()).thenAccept(System.out::println).join();

		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
		
		.thenAccept(response -> {
			int status = response.statusCode();
			if (status == 200) {

				Employee e=null;
				try {
					e = mapper.readValue(response.body(), Employee.class);
				} catch (JsonProcessingException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				System.out.println(e);

			} else {
				System.out.println(response.body());
			}

		}).join();

	}
	
}
