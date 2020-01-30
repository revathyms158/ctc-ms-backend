package au.com.optus.ctc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountProfileResponse {
	@JsonProperty
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
