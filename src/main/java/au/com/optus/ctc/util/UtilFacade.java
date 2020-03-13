package au.com.optus.ctc.util;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by optus on 7/2/20.
 */

@Service
public class UtilFacade {

    public int calculateAge(String dob) throws UsernameNotFoundException {
        int age = 0;
        try {

            Date dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
            Calendar today = Calendar.getInstance();
            Calendar birthDate = Calendar.getInstance();
            birthDate.setTime(dateOfBirth);
            if (birthDate.after(today)) {
                throw new IllegalArgumentException("Can't be born in the future");
            }
            age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
            if ( (birthDate.get(Calendar.DAY_OF_YEAR) - today.get(Calendar.DAY_OF_YEAR) > 3) ||
                    (birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH ))){
                age--;
            }else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH )) &&
                    (birthDate.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH ))){
                age--;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return age;
    }

}
