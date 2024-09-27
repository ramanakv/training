package trg.dw;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.core.Configuration;
import jakarta.validation.constraints.NotEmpty;

public class MessageConfiguration extends Configuration{
	
	@NotEmpty
	private String greet;

	@JsonProperty
	public String getGreet() {
		return greet;
	}

	@JsonProperty
	public void setGreet(String greet) {
		this.greet = greet;
	}
	
}
