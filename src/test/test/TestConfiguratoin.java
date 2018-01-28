package test.test;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class TestConfiguratoin {
	
	public static void main(String[] args) {
		
		Configurations configs = new  Configurations();
		try {
			configs.properties("properties/oauth/oAuth.properties");
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(configs.toString());
	}
}
