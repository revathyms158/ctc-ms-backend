package au.com.optus.ctc.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import au.com.optus.ctc.model.AccountProfile;

@Component
public class MyAccountFilterSpecification {
	private static final Logger LOG = LoggerFactory.getLogger(MyAccountFilterSpecification.class);

	public static Specification<AccountProfile> accWithUserId(String userId) {
		LOG.info("MyAccountFilterSpecification :: accWithUserId : START");
		return (accSummaryRoot, cq, cb) -> cb.like(accSummaryRoot.get("id_users"), "%" + userId + "%");
	}
}
