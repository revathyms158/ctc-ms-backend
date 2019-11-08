package au.com.optus.ctc.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import au.com.optus.ctc.dao.AccountProfileRepository;
import au.com.optus.ctc.dao.MyAccountFilterSpecification;
import au.com.optus.ctc.model.AccountProfile;

/**
 * @author revathyms
 */
public class MyAccountServiceImpl implements MyAccountServiceIF {
	private static final Logger LOG = LoggerFactory.getLogger(MyAccountServiceImpl.class);

	@Override
	public String createProfile(AccountProfile profile) {
		return null;
	}

	@Override
	public boolean verifyProfile(AccountProfile profile) {
		return true;
	}

	@Autowired
	AccountProfileRepository repository;

	/*@Override
	public Optional<AccountProfile> getUserProfile(String userId) {
		LOG.info("MyAccountServiceImpl :: getUserProfile : START");
		if (!StringUtils.isBlank(userId)) {
			return repository.findOne(MyAccountFilterSpecification.accWithUserId(userId));
		}
		return null;
	}*/
}
