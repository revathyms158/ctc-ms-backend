package au.com.optus.ctc.service;

import au.com.optus.ctc.model.AccountProfile;

public interface MyAccountServiceIF {

    String createProfile(AccountProfile profile);

    boolean verifyProfile(AccountProfile profile);

}
