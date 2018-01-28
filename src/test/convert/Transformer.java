package test.convert;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;

public class Transformer {
	
	@SuppressWarnings("unchecked")
	public static <T> T copyProperties(String propertypath, Class<T> returnType) throws Exception{
		
		System.out.println("returnType: "+returnType.getName());
//		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(propertypath);
		InputStream is = Transformer.class.getClassLoader().getResourceAsStream("properties/oauth/oAuth.properties");
		
		Properties properties = new Properties();
		properties.load(is);
		is.close();		
		System.out.println("properties: "+properties);

		Map map = new HashMap<>();
		properties.forEach( (k , v)->{
			String parent = "facebook.client";
			int parentLength = parent.length()+1;
			String oKey = k.toString();
			if(oKey.contains(parent)) {
				System.out.println(k+"/"+oKey.substring(parentLength));
				map.put(oKey.substring(parentLength), v);
			}
		});
		System.out.println(map);
		T t = null;
		ObjectMapper mapper = new ObjectMapper();
		t = (T)mapper.convertValue(map, returnType);
		System.out.println("TransFormer: "+t.toString());
		return t;
	}
	
//	public static void main(String[] args) {
//		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("properties/oauth/oAuth.properties");
////		System.out.println("is: "+is.read());
//		Properties properties = new Properties();
//		try {
//			properties.load(is);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(properties);
//	}
}
