package com.itbulls.learnit.javacore.patterns.structural.proxy;

import java.util.ArrayList;
import java.util.List;

public class ProxyInternet implements Internet {
	
	private Internet internet = new DefaultInternet();
	private static List<String> bannedSites;

	static {
		bannedSites = new ArrayList<String>();
		bannedSites.add("facebook.com");
		bannedSites.add("instagram.com");
	}

	@Override
	public void connectToHost(String url) {
		if (bannedSites.contains(url.toLowerCase())) {
			throw new RuntimeException("Access Denied: connecting to " + url);
		}
		internet.connectToHost(url);
	}

}
