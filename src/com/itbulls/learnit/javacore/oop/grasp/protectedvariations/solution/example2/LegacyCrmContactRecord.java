package com.itbulls.learnit.javacore.oop.grasp.protectedvariations.solution.example2;

//Simulates a legacy system model that does not match our domain.
public class LegacyCrmContactRecord {

	private final String contactKey;
	private final String mailAddress;
	private final String segmentCode; // legacy concept

	public LegacyCrmContactRecord(String contactKey, String mailAddress, String segmentCode) {
		this.contactKey = contactKey;
		this.mailAddress = mailAddress;
		this.segmentCode = segmentCode;
	}

	public String getContactKey() {
		return contactKey;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public String getSegmentCode() {
		return segmentCode;
	}
}
