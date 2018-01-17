package test.util;

import java.util.Enumeration;

public class MyToString {
	
	public static void showEnumeration(Enumeration<String> em) {	
		
		
		for(int i = 0; em.hasMoreElements(); i++) {
			
			System.out.println("em["+i+"]"+em.nextElement());
		}
	
	}
}
