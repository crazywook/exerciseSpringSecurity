/**
 * 
 */
export default document.querySelector.bind(document);

export const $settings = {
	"post" : function(body) {
		let headers = {
			
		};
		headers[csrf.headerName] = csrf.token;
		const settings = {
				
				"headers" : headers,
				"method" : "POST",			
//				"data" : body
		};
		
		console.log(arguments);
		console.log(csrf.headerName);
		console.log(csrf.token);		
		
		if(typeof arguments[0] === "string") settings.url = arguments[0];
		else if(arguments[0] instanceof Object) settings.data = arguments[0];
		
		if(arguments.length == 2 && arguments[1] instanceof Object ) settings.data = arguments[1];		
		
		return settings;
	}
};

