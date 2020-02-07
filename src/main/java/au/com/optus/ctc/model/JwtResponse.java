package au.com.optus.ctc.model;

import java.io.Serializable;

/**
 * Created by optus on 6/2/20.
 */
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = 1700922602917998830L;
    private final String jwttoken;
    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }
    public String getToken() {
        return this.jwttoken;
    }
}
