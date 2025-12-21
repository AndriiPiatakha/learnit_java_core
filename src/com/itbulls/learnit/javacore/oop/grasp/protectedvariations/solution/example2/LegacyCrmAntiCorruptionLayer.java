package com.itbulls.learnit.javacore.oop.grasp.protectedvariations.solution.example2;

//Anti Corruption Layer: translates legacy records into our clean model.
//If legacy naming/segmentation changes, only this class changes.

public class LegacyCrmAntiCorruptionLayer implements CrmGateway {

	private final LegacyCrmApi legacyCrmApi;

	public LegacyCrmAntiCorruptionLayer(LegacyCrmApi legacyCrmApi) {
		this.legacyCrmApi = legacyCrmApi;
	}

	@Override
	public CustomerProfile loadProfile(String customerId) {
		LegacyCrmContactRecord record = legacyCrmApi.fetchContactByCustomerId(customerId);

		CustomerProfile.Segment segment = mapSegment(record.getSegmentCode());

		return new CustomerProfile(record.getMailAddress(), segment);
	}

	private CustomerProfile.Segment mapSegment(String segmentCode) {
		if ("SEG_A".equals(segmentCode)) {
			return CustomerProfile.Segment.VIP;
		}
		return CustomerProfile.Segment.STANDARD;
	}
}
