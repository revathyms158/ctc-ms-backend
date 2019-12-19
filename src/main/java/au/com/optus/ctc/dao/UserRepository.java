package au.com.optus.ctc.dao;

import au.com.optus.ctc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by optus on 12/11/19.
 */


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
