$('#button-sup').on('click', function(elmtDom) {
	let divPop = $(document).find('#pop-up');
	let divSetting = $(document).find("#settings");
	
	divPop.addClass("pop-up-visible");
	console.log(divPop);
	divSetting.addClass("settings-visible");
	console.log(divSetting);
});

$('.btnPopUpRetour').on('click', function(elmtDom) {
	let divPop = $(document).find('#pop-up');
	let divSetting = $(document).find("#settings");	
	divPop.removeClass("pop-up-visible");
	console.log(divPop);
	divSetting.removeClass("settings-visible");
	console.log(divSetting);	
});