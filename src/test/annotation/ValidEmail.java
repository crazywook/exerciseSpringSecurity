/**
 * 
 */
package test.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import test.validator.EmailValidator;

@Documented
@Retention(RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
@Target({ TYPE, FIELD, ANNOTATION_TYPE })
public @interface ValidEmail {
	
	String message() default "Invalid Email";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
