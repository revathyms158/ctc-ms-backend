package au.com.optus.ctc.dao;

import au.com.optus.ctc.model.AccountProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author revathyms
 */
@Repository
public interface MyAccountRepository extends JpaRepository<AccountProfile, Long> {

}
