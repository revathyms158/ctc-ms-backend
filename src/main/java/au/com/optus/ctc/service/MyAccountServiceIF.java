package au.com.optus.ctc.service;

import org.springframework.context.annotation.Configuration;

import au.com.optus.ctc.model.AccountProfile;

@Configuration
public interface MyAccountServiceIF {

	String createProfile(AccountProfile profile);

	boolean verifyProfile(AccountProfile profile);

}
