/**
 *
 */
function loadScript(url, callback) {

	let script = document.createElement("script");
	script.src = url;
	script.async = false;
	script.onload = callback;
	document.querySelector("body").appendChild(script);
}
console.log("import.js finish");