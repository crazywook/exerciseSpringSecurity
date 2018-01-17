/**
 *
 */
console.log("index.js");
loadScript("/commons/js/event/eventRegister.js", baseProcess);
console.log("loadProcess");

var pageApp = {};
pageApp.event = {};
pageApp.event.list =
[
 ["button", "click", function(){location.href = "/main" }]
];

function baseProcess() {

	basicComponent.event.addComponentEventListener(pageApp.event);
}
