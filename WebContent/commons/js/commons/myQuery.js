/**
 * 
 */
export default document.querySelector.bind(document);

export const $settings = {
	"post" : function(body) {
		let headers = {};
		headers[csrf.headerName] = csrf.token;
		const settings = {
				
				"headers" : headers,
				"method" : "POST",			
				"data" : body
		};
		
		if(typeof arguments[0] === "String") settings.url = arguments[0];
		else if(arguments[0] instanceof Object) settings.data = body = arguments[0];
		if(typeof arguments[1] === "String") settings.url = arguments[0];
		
		console.log(csrf.headerName);
		console.log(csrf.token);	
		
		return settings;
	}
};

