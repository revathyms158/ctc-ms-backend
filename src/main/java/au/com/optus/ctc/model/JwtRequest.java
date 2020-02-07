package au.com.optus.ctc.model;

import java.io.Serializable;

/**
 * Created by optus on 6/2/20.
 */
public class JwtRequest implements Serializable {

    private static final long serialVersionUID = -4172636412154786280L;
    private String username;
    private String password;


    public JwtRequest()
    {
    }

    public JwtRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
