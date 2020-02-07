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

    public int calculateAge(Date dob) throws UsernameNotFoundException {
        int age = 0;


       /* SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateWithoutTime = sdf.parse(sdf.format(new Date()));*/


        SimpleDateFormat dateformat3 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //Date dateOfBirth = dateformat3.parse(dob.toString());
            Date dateOfBirth = dateformat3.parse(dateformat3.format(dob));
            Calendar today = Calendar.getInstance();
            Calendar birthDate = Calendar.getInstance();
            birthDate.setTime(dateOfBirth);
            if (birthDate.after(today)) {
                throw new IllegalArgumentException("Can't be born in the future");
            }
            age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

            // If birth date is greater than todays date (after 2 days adjustment of leap year) then decrement age one year
            if ( (birthDate.get(Calendar.DAY_OF_YEAR) - today.get(Calendar.DAY_OF_YEAR) > 3) ||
                    (birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH ))){
                age--;

                // If birth date and todays date are of same month and birth day of month is greater than todays day of month then decrement age
            }else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH )) &&
                    (birthDate.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH ))){
                age--;
            }
            System.out.println(age);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return age;
    }

}
