package res.sogou.com.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import res.sogou.com.models.User;
/**
 * Created by wefit on 16/2/12.
 */
public class UserValidator implements Validator{
    public boolean supports(Class<?>klass){
        return User.class.isAssignableFrom(klass);
    }

    public void validate(Object target, Errors errors){
        User user = (User)target;
        ValidationUtils.rejectIfEmpty(errors, "username", "username", "yy");
    }
}
