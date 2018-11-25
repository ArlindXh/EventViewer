/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EVPS;

/**
 *
 * @author darda
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Arbër Suka
 */

public class EmailValidator {



/**
 *
 * @author Arbër Suka
 */
    private Pattern pattern;
    private Matcher matcher;
    
    private static final String PHONE_PATTERN = 
        "^((\\+|00)(38649|37744|37745|38643 )[0-9]{6})";
    
    
    
    public boolean validate(final String hex) {

        this.pattern = Pattern.compile(PHONE_PATTERN);
        matcher = this.pattern.matcher(hex);
        return matcher.matches();

    }

    
    public static boolean validateEmail(String email)
    { 
        boolean status=false;
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                                     + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        
        if(matcher.matches())
        { 
            status = true; 
        }
        else
        { 
            status = false;
        } 
        return status; 
    }
}


