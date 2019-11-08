package au.com.optus.ctc.dao;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import au.com.optus.ctc.model.AccountProfile;
@Configuration
public interface AccountProfileRepository extends JpaRepository<AccountProfile, String> {

}
