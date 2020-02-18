package au.com.optus.ctc.model;

import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;

/**
 * Created by optus on 6/2/20.
 */
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = 1700922602917998830L;
    private final String jwttoken;


    private UserDetails userDetails;

    public JwtResponse(String jwttoken, UserDetails userDetails) {
        this.jwttoken = jwttoken;
        this.userDetails = userDetails;
    }
    public String getToken() {
        return this.jwttoken;
    }


    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}
