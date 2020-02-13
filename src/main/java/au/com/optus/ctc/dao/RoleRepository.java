package au.com.optus.ctc.dao;

import au.com.optus.ctc.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by optus on 13/2/20.
 */


public interface RoleRepository extends JpaRepository<Role, Long> {
}
