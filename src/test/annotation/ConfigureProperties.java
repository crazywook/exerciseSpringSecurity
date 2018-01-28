package test.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Properties;

@Documented
@Retention(RUNTIME)
@Target({ TYPE, FIELD, PARAMETER, LOCAL_VARIABLE, METHOD })
public @interface ConfigureProperties {
	
	String properties();
	String get() default "aaa";	
}
