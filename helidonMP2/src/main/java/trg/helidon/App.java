package trg.helidon;

import java.io.IOException;

import io.helidon.microprofile.server.Server;

public class App {

	public static void main(final String[] args) throws IOException {
		Server server = Server.create().start();
		System.out.println("Webserver running http://localhost:" + server.port() + "/books");
	}

}
