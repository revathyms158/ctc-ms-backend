package au.com.optus.ctc.service;

import au.com.optus.ctc.dao.AccountProfileRepository;
import au.com.optus.ctc.model.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by optus on 6/2/20.
 */



@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    AccountProfileRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        au.com.optus.ctc.model.AccountProfile user = repository.findByEmailAddress(username);
        CustomUserDetails userDetails = null;

        if(user != null) {
            userDetails = new CustomUserDetails();
            userDetails.setUser(user);
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);

        }

        return userDetails;
    }
}
