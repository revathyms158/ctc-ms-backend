package au.com.optus.ctc.service;

import java.util.List;

import au.com.optus.ctc.model.AccountProfile;

public interface MyAccountServiceIF {

    String createProfile(AccountProfile profile);

    boolean verifyProfile(AccountProfile profile);

	List<AccountProfile> getUserProfile(String UserId);

}
