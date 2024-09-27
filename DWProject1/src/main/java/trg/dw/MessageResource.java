package trg.dw;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("app")
public class MessageResource {

	MessageConfiguration config;

	public MessageResource(MessageConfiguration config) {
		super();
		this.config = config;
	}

	@Path("greet/{name}")      //localhost:8080/app/greet/Ramana
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String greetUser(@PathParam("name") String userName) {
		return config.getGreet() + " " + userName;
	}

	@Path("greet")   //localhost:8080/app/greet
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String greetUnknownUser() {
		return config.getGreet() + " Unknown user";
	}

}
