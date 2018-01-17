/**
 *	@author Sungwook Kim
 *	@startDate 2018-01-15 
 */
export default function route(url) {
	console.log("url: ", url);
	const link = document.createElement("link");
	link.rel = "import";
	link.href = url;
	console.log("context: ",link.import);
	
	link.onload = afterLoad.bind(link);
	link.onerror = handleError.bind(link); 
	document.querySelector("body").append(link);
};

function afterLoad() {
	console.log("loaded");
	const context = this.import;
	console.log(context);	
	const contents = context.querySelector(".contents");
	$("section[role=main]").append(contents);
}

function handleError() {
	console.log("handleError");
}
