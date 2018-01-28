package test.util;

import org.springframework.security.web.util.UrlUtils;

public class UrlCalc {
	
	static boolean contextRelative;
	
	public static String calculateRedirectUrl(String contextPath, String url) {
		if (!UrlUtils.isAbsoluteUrl(url)) {
			if (isContextRelative()) {
				return url;
			}
			else {
				return contextPath + url;
			}
		}

		// Full URL, including http(s)://

		if (!isContextRelative()) {
			return url;
		}

		// Calculate the relative URL from the fully qualified URL, minus the last
		// occurrence of the scheme and base context.
		url = url.substring(url.lastIndexOf("://") + 3); // strip off scheme
		url = url.substring(url.indexOf(contextPath) + contextPath.length());

		if (url.length() > 1 && url.charAt(0) == '/') {
			url = url.substring(1);
		}

		return url;
	}

	/**
	 * If <tt>true</tt>, causes any redirection URLs to be calculated minus the protocol
	 * and context path (defaults to <tt>false</tt>).
	 */
	public static void setContextRelative(boolean useRelativeContext) {
		contextRelative = useRelativeContext;
	}

	/**
	 * Returns <tt>true</tt>, if the redirection URL should be calculated
	 * minus the protocol and context path (defaults to <tt>false</tt>).
	 */
	public static boolean isContextRelative() {
		return contextRelative;
	}
}
