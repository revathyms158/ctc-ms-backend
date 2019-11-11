package au.com.optus.ctc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountProfileResponse {
	@JsonProperty
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
