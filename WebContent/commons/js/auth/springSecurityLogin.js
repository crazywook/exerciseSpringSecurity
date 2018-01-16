/**
 * 
 */
console.log("before $: ", $)
import $$ from "../commons/myQuery.js";
import {$settings} from "../commons/myQuery.js";
//console.log(($ == undefined));
//if($ == undefined) var $ = $$;  
console.log("$: ", $);

document.addEventListener("submit", loginProcess)

function loginProcess(e) {
	console.log("loginProcess");
	e.preventDefault();
	const form = document.loginForm;	
	const body = $(form).serializeArray();
	const url = "/j_spring_security_check";
	const settings = $settings.post(url, body);
	console.log(body);
	console.log("data",settings.data);
	$.ajax(settings)
		.done(handleSuccess)
		.fail(handleFailure);	
	
//	settings.body = new FormData(document.loginForm);
//	settings.body = '{"j_username": "kim"}';
	
//	fetch(url, settings)
//		.then(function(r) {
//			if(r.ok) {
//				handleSuccess(r.json());				
//			}else {				
//				return Promise.reject(r);
//			}
//		}).catch(function(r){
//			console.log(r);
//		});	
	
	function handleSuccess(r) {		
		console.log(r);
		const responseJSON = JSON.parse(r);
		const redirectUrl = responseJSON.redirectUrl;
		location.href = redirectUrl;
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
}
