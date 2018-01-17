package test.modifier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.log4j.Logger;

public class CustomHttpServletRequestWrapper extends HttpServletRequestWrapper{

	private Map headerMap;	
	Logger logger = Logger.getLogger(getClass());
	
	
	public CustomHttpServletRequestWrapper(HttpServletRequest request){
		super(request);
		headerMap = new HashMap();
	}	
	
	public void addHeader(String name, String value){
		headerMap.put(name, new String(value));
	}
	
	public Enumeration<String> getHeaderNames(){
		HttpServletRequest request = (HttpServletRequest)getRequest();
		List<String> list = new ArrayList<>();		
		for( Enumeration<String> e = request.getHeaderNames() ;  e.hasMoreElements() ; ) {
			String headerName = e.nextElement();
			logger.info(headerName+" : "+request.getHeader(headerName));
			list.add(headerName);
		}			
		for( Iterator<String> i = headerMap.keySet().iterator() ; i.hasNext() ; ){
			list.add(i.next());
		}
		return Collections.enumeration(list);
	}
	
	public String getHeader(String name){
		Object value;
		if((value = headerMap.get(name)) != null) {
			logger.info(name+": "+value);			
			return value.toString();
		}else {
			return ((HttpServletRequest)getRequest()).getHeader(name);
		}
	}	
}
