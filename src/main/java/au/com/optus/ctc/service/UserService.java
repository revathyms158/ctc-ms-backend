/*
package au.com.optus.ctc.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

*/
/**
 * Created by optus on 14/11/19.
 *//*


@Service
public class UserService implements UserDetailsService {

    */
/*@Autowired
    private UserRepository userRepository;*//*


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        */
/*User user = null;
        user = userRepository.findByUsername(username);*//*

        if("javainuse".equals(username)) {
            return new User("javainuse", "$2a$10$s1YQmyNdGzTn7ZLBXBChF0C9f6kFjAqPhccnP6Dx1WXx21Pk1C3G6", new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

}
*/
