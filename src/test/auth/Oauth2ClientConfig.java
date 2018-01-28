package test.auth;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.servlet.FilterRegistration;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import test.test.TestClass;
import test.user.CustomUserDetailManager;
import test.annotation.*;
import test.convert.Transformer;

@Configuration
@EnableOAuth2Client
public class Oauth2ClientConfig {
	
	@Autowired
	OAuth2ClientContext oAuth2ClientContext;
	
	@Autowired
	CustomUserDetailManager userMgr;

	@Autowired
	ObjectMapper mapper;
	
	@Bean
	ObjectMapper mapper() {
		return new ObjectMapper();
	}
	
	@Bean
	@ConfigureProperties(properties="properties/oauth/oAuth.properties")
	AuthorizationCodeResourceDetails facebook() throws Exception{
		AuthorizationCodeResourceDetails resource;
		resource = Transformer.copyProperties("properties/oauth/oAuth.properties", AuthorizationCodeResourceDetails.class);
		return resource;
	}
	
	private <T> T copyProperties(String propertypath, T pojo) throws Exception{
		
		Properties testProp = new Properties();
		
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(propertypath);
//		System.out.println("is: "+is.read());
		testProp.load(is);
		
		System.out.println("testProp: "+testProp);
		
		Map map = new HashMap<>();
		testProp.forEach( (k , v)->{
			String parent = "facebook.client";
			int parentLength = parent.length()+1;
			String oKey = k.toString();
			if(oKey.contains(parent)) {
				System.out.println(k+"/"+oKey.substring(parentLength));
				map.put(oKey.substring(parentLength), v);
			}
		});
		System.out.println(map);
		ObjectMapper mapper = new ObjectMapper();
		pojo = (T)mapper.convertValue(map, pojo.getClass());
		System.out.println(pojo.toString());
		return pojo;
	}
}
