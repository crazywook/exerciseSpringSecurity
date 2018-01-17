/**
 *
 */

var currentPriceRenderer = DataModelRenderer.getRenderer();

var currentPriceConfigure = {
	"convertor" : {

	},
	"actionResolver" : {

	}
}

currentPriceRenderer.setConfigure(currentPriceConfigure);

var currentPriceRender = function render(){

};

currentPriceRenderer.setRender(currentPriceRender);

tradeController.setDomAppender("trade", currentPriceRenderer);