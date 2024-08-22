package trg.helidon;

import io.helidon.config.Config;
import io.helidon.webserver.Routing;
import io.helidon.webserver.WebServer;
import io.helidon.webserver.http.HttpRouting;

public class Main 
{
    public static void main( String[] args )
    {
    	Config config = Config.create();
        Config.global(config);

        WebServer server = WebServer.builder() 
                .config(config.get("server"))
                .routing(Main::routing)
                .build()
                .start(); 

        
        System.out.println("WEB server is up! http://localhost:" + server.port()+"/books" );
    }
    
    static void routing(HttpRouting.Builder routing) {
        routing.register("/books", new BookService()); 
    }
}
