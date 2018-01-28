package test.test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;

import test.CommonController;
import test.annotation.ConfigureProperties;
import test.convert.Transformer;

public class ReflectionTest {
	
	public static void main(String[] args) throws IOException {
		
//		URL url = ClassLoader.class.getClassLoader().getResource("/");
		
		try {
			AuthorizationCodeResourceDetails details = Transformer.copyProperties("properties/oauth/oAuth.properties", AuthorizationCodeResourceDetails.class);
			
			System.out.println(details.toString());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			Method method = CommonController.class.getMethod("annotationTest", HttpServletRequest.class);
			System.out.println("method: "+method.getName());
		} catch ( SecurityException | NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Method[] methods = CommonController.class.getMethods();
		
		
		for(Method mth : methods) {
			
			ConfigureProperties cp = mth.getAnnotation(ConfigureProperties.class);
			if(cp != null) {
				System.out.println("mth: "+mth.getName());
				System.out.println("ann: "+ cp.properties());
			}
		}
		
	}
}
