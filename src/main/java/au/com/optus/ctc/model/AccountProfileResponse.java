package au.com.optus.ctc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountProfileResponse {
	@JsonProperty
	private Long id;
	@JsonProperty
	private String errorMessage;
	@JsonProperty
	private int age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
