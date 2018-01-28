package test.aspect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;

import test.annotation.ConfigureProperties;
import test.convert.Transformer;

@EnableAspectJAutoProxy
@Configuration
@Aspect
public class ConfigureAspect {
	
//	@Around("execution(@ConfigureProperties * * *..*(..))")
	public Object configureProperties(ProceedingJoinPoint joinPoint) throws Throwable{
		
		System.out.println("target: "+joinPoint.getTarget());
		System.out.println("###############aspect#############");
		Object proceed = joinPoint.proceed();
		
		return proceed;
	}
	
//	@Around("execution(public String *..annotationTest(..))")
	public Object test(ProceedingJoinPoint joinPoint) throws Throwable{
		
		System.out.println("target: "+joinPoint.getTarget());
		System.out.println("###############aspect#############");
		Object proceed = joinPoint.proceed();
		
		return proceed;
	}
	
	@Around("@annotation(test.annotation.ConfigureProperties)")
	public Object annotationAopTest(ProceedingJoinPoint joinPoint) throws Throwable{
		
		Object target = joinPoint.getTarget();
		Class<?> instance = target.getClass();
		String kind = joinPoint.getKind();
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		ConfigureProperties cp = method.getAnnotation(ConfigureProperties.class);
		
//		Class<?> returnType = signature.getReturnType();
		Class<?> returnType = AuthorizationCodeResourceDetails.class;
		System.out.println("properties: "+cp.properties());
		
		Object object = Transformer.copyProperties(cp.properties(), returnType);
		
//		String name = signature.getName();
//		System.out.println("length: "+instance.getMethods().length);
//		System.out.println("target: "+target);
//		System.out.println("instance: "+instance);
//		System.out.println("kind: "+ kind);
//		System.out.println("signature: "+ signature);
//		System.out.println("name: "+ name);
//		System.out.println("###############annotationAopTest#############");
//		if(kind.equals("method-execution-a")) {
//			method = instance.getMethod(name);
//			System.out.println("properties: "+cp.properties());
//		}
//		
		
		Object proceed = joinPoint.proceed();
		return object;
	}
	
	public static void main(String[] args) throws Exception {
//		URL url = ClassLoader.getSystemClassLoader().getResource("");
//		System.out.println(url);
//		InputStream is = Transformer.class.getClassLoader().getResourceAsStream("properties/oauth/oAuth.properties");
		AuthorizationCodeResourceDetails resource = Transformer.copyProperties("properties/oauth/oAuth.properties", AuthorizationCodeResourceDetails.class);
	 	System.out.println("main: "+resource.toString());
	 	System.out.println(resource.getAccessTokenUri());
	 	
	}
}
