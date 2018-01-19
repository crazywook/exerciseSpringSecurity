/**
 * 
 */
console.log("import signup");
import $$ from "/js/commons/myQuery.js";
import {$settings} from "/js/commons/myQuery.js";

export default function singup(e) {
	console.log("singupProcess");
	e.preventDefault();	
	
	console.log("calle: ", arguments.calle);
	const form = document.signupForm;	
	const body = $(form).serializeArray();
	const url = "/api/v0/user";
	const settings = $settings.post(url, body);	
	
	console.log(body);
	console.log("data",settings.data);
	console.log(settings);
	$.ajax(settings)
		.done(handleSuccess)
		.fail(handleFailure);	
	
	function handleSuccess(r) {		
//		console.log(r);
		const responseJSON = JSON.parse(r);
		const redirectUrl = responseJSON.redirectUrl;
		console.log("redirectUrl: "+redirectUrl);
		if(redirectUrl) location.href = redirectUrl;
//		
//		replaceDocument(r);
	}
	
	function replaceDocument(r) {
		const doc = new DOMParser().parseFromString(r, "text/html");
		console.log(doc);
		console.log(doc.childNodes)
		const htmlNode = doc.childNodes[1];
		const el = doc.childNodes[1];
		const oldHtml = document.childNodes[1];
		document.replaceChild(el, oldHtml);	
	}
	
	function handleFailure(r, err, msg) {
		console.log(r);
		console.log("reason: ", r.responseText);		
		console.log("status: ", r.status);		
	}	
	
	return false;
};