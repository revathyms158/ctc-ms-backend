package au.com.optus.ctc.model;

import java.io.Serializable;

/**
 * Created by optus on 11/11/19.
 */
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -718915062778599649L;

    private final String jwttoken;
    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }
    public String getToken() {
        return this.jwttoken;
    }
}
