package au.com.optus.ctc.dao;

import au.com.optus.ctc.model.AccountProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class MyAccountFilterSpecification {
	private static final Logger LOG = LoggerFactory.getLogger(MyAccountFilterSpecification.class);

	public static Specification<AccountProfile> hasWithSameEmail(String email) {
		return (accountProfile, cq, cb) -> cb.like(accountProfile.get("email"), "%" + email + "%");
	}

}
