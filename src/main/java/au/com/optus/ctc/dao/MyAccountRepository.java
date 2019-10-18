package au.com.optus.ctc.dao;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import au.com.optus.ctc.model.AccountProfile;

/**
 * @author revathyms
 */
@Repository
public interface MyAccountRepository extends JpaRepository<AccountProfile,Long>,JpaSpecificationExecutor<AccountProfile>
{

	List<AccountProfile> findAll(Specification<AccountProfile> accWithUserId); 

}
