package trg.msg;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("mb")
public class MessageBuilder {
	
	public String sayHello() {
		return "Hello Spring";
	}

}
