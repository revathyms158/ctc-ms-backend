package au.com.optus.ctc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyAccountResponse {
	@JsonProperty
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
