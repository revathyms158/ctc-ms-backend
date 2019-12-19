package au.com.optus.ctc.model;

import java.io.Serializable;

/**
 * Created by optus on 11/11/19.
 */
public class JwtRequest implements Serializable {
    private static final long serialVersionUID = 8619608902527228930L;

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
