package com.itbulls.learnit.javacore.patterns.behavioral.state;

import static com.itbulls.learnit.javacore.patterns.behavioral.state.InModerationState.*;

public class Demo {
	
	public static void main(String[] args) {
		var document = new Document();
		User adminUser = new User(ADMIN_ROLE, "andrii_p");
		User contentCreatorUser = new User(CONTENTCREATOR_ROLE, "evgeniy_m");
		
		document.printStatus();
		
		document.publish(contentCreatorUser);
		document.printStatus();
		
		document.publish(contentCreatorUser);
		document.printStatus();
		
		document.publish(adminUser);
		document.printStatus();
		
		document.publish(adminUser);
		
	}

}
