var coreservlets = {};

coreservlets.accordionLinkClass = "accordionLink";

coreservlets.accordionDivClass = "accordion-div";

coreservlets.findAccordionSelectionByHash = function(linkClass, divId) {
  var accordionLinkPattern = "#content ." + divId + " a." + linkClass;
  coreservlets.accordionSelection = -1;
  $(accordionLinkPattern).each(function(index) {
    if (("#" + this.href.split("#")[1]) == window.location.hash) {
      coreservlets.accordionSelection = index;
      return(false);
    }
  });
  if (coreservlets.accordionSelection == -1) {
    coreservlets.accordionSelection = false;
  } 
};

coreservlets.clickHandler = function(event, ui) {
  if (ui.newHeader.length > 0) {  // Opening a closed section
	var div = $(event.target);
	var heading = $(ui.newHeader[0]);
	var link = $("a", heading);
	window.location.hash = link.attr("href");
  }
};

$(function() {
    coreservlets.findAccordionSelectionByHash("accordionLink", "accordion-div");
	var accordion =
    $("#content div." + coreservlets.accordionDivClass).accordion({ 
	  collapsible: true, autoHeight: false, active: coreservlets.accordionSelection,
	  change: coreservlets.clickHandler 
	});
});

