/**
 * 
 */
var app = (function() {
  let riskMapping = 0;
  return {
	riskMapping
  };
})();

$(function() {
	registerMouseWheel(".wrapper");
	$("#ctrl-measure-factor").carousel();
	$("#audit-unit").carousel();
	registerNavLinkActive("#ctrl-measure-factor-body");
	registerNavLinkActive("#audit-unit-body");
	findRiskItemOptions();
});
const registerNavLinkActive = (selector) => {
	$(`${selector} > .navbar-nav > .nav-item > .nav-link`).on("click", function() {
		if ($(this).hasClass("active")) {
			$(this).removeClass("active"); return;
		}
		$(this).parent().parent().find(".nav-item > .nav-link").removeClass("active");
		$(this).addClass("active");
	});
}

const findRiskItemOptions = (period, unit, option) =>{
	mapping = new Map();
	$.ajax({
		url : "/data/riskGroupItems.json",
		success : function(res) {
			res.data.forEach(function(value, index, array){
				if (mapping.has(value.gropuId)){
					let items = mapping.get(value.gropuId);
					items.push(value);
				}else{
					let items = [];
					items.push(value);
					mapping.set(value.gropuId, items)
				}	
			});
			for (let [key, value] of mapping) {
				console.log(key);
			    if (mapping.has(key)) {
					console.log(mapping[key].at(0));
			    }
			}
		}
	});

}
const renderRiskItemOption = (value) => {
	let html = [];
	html.push(``);
}