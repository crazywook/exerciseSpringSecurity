package test.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import test.annotation.ValidEmail;

public class EmailValidator implements ConstraintValidator<ValidEmail, String>{	
	
	
//	@Override
//    public void initialize(ValidEmail constraintAnnotation) {       
//    }
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext arg1) {
		 
		String emailPattern = "^[_A-Za-z0-9-+]+ (.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(.[A-Za-z0-9]+)* (.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(emailPattern);
		Matcher matcher = pattern.matcher(email);
		
		return Pattern.matches(emailPattern, email);
	}

}
