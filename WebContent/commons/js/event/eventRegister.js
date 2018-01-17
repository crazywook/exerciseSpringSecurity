/**
 *
 */
var basicComponent = basicComponent || {};
basicComponent.event = basicComponent.event || {};
basicComponent.event.addComponentEventListener = function addComponentEventListener(event)
{

	"use strict";
	console.log(event);
	let list = event.list;
	if(typeof event.list[0] === "string" ){
		singleEventProcess(list)
	}else if(event.list[0] instanceof Array ){
		multiEventProcess(list)
	}

	function singleEventProcess(elt) {

		if(elt.length < 3) throw new ("잘못된 정보입니다.");
		document.querySelectorAll(elt[0]).addEventListener(elt[1], function(e){
			console.log(e.target);
			event.list[2]();
		});
	}

	function multiEventProcess(elt) {

		elt.forEach(function(lElt){
			console.log(lElt);
			if(lElt.length < 3) throw new ("잘못된 정보입니다.");
			console.log(lElt);
			console.log(document.querySelector(lElt[0]));
			document.querySelector(lElt[0]).addEventListener(lElt[1], function(e){
				lElt[2]();
			});
		});
	}
};
console.log("basicComponent.event.addComponentEventListener is loaded.");