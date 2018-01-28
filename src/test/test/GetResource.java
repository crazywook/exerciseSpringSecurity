package test.test;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.beans.BeanUtils;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;

public class GetResource {
	
	
	void getResourceLoaderPath(String path) {
		
		Enumeration<URL> urls = null;
		InputStream is = null;
		try {
//			urls = this.getClass().getClassLoader().getResources(path);
//			showEnum(urls);
			is = this.getClass().getClassLoader().getResourceAsStream(path);
			System.out.println(is.read());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	void getResourcePath(String path) {
		
		URL classUrl = getClass().getResource(path);
		System.out.println("classUrl: "+classUrl.getPath());
	}
	
	void showEnum(Enumeration em) {
		int i = 0;
		while(em.hasMoreElements()) {
			Object obj = em.nextElement();
			System.out.println((++i)+":"+obj.toString());
		}
	}
	
	void getFilePath(String path) {
		File file = new File(path);
		System.out.println("filepath: "+file.getAbsolutePath());
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
	
	public static void main(String[] args) throws Exception{
		GetResource gr = new GetResource();
		String filepath0 = "";
		String filepath = "test/test/test.txt";
		String filepath1 = "properties/oauth/oAuth.properties";
		String filepath2 = "test/test/GetByte.java";
		
		String fpath = "";
		gr.getResourceLoaderPath(filepath1);
//		gr.getFilePath(fpath);
//		gr.getResourcePath(filepath0);
		
		TestClass testClass = new TestClass();
		AuthorizationCodeResourceDetails resource = gr.copyProperties(filepath1, new AuthorizationCodeResourceDetails());
		System.out.println("resource: "+resource.getAccessTokenUri());
		
	}

	
}
