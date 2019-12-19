package au.com.optus.ctc.service;

import au.com.optus.ctc.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by optus on 12/11/19.
 */

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        au.com.optus.ctc.model.User user = userRepository.findByUsername(username);
       /* if("shree".equals(username)) {
            return new User("shree", "password", new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }*/

        if(user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPasssword(), new ArrayList<>());
    }


    public au.com.optus.ctc.model.User save(au.com.optus.ctc.model.User user) {
        au.com.optus.ctc.model.User userdetails = new au.com.optus.ctc.model.User();
        userdetails.setUsername(user.getUsername());
        userdetails.setPasssword(bcryptEncoder.encode(user.getPasssword()));
        return userRepository.save(user);
    }
}
