package au.com.optus.ctc.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Query;

@Configuration
public interface MyAccountServiceIF {

	

	@Query(value = "select count(*) from user_details where email = ?", nativeQuery = true)
	public int findEmail(String email);

}
