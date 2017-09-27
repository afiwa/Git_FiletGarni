var formFalse = false;

$('#placeorderbtn').on('click', function(e) {
	// if(function(isCheckedTermsConditions)){
	// }
	if(  $('#iaccept-1').is(':checked') == false ){
		if( formFalse == false){
			$(".termsAndConditions").append("<span id='termsAndConditionsCheck'>Veuillez accepter les termes et conditions d'utilisation pour valider votre commande.</span>");
			$(".termsAndConditions2").append("<span id='termsAndConditionsCheck2'>Veuillez renseigner tous les champs obligatoires.</span>");
			$(".btn-primary").css("margin-bottom","5px");
			formFalse = true;
		}
	} else {
		window.location.href = "../11Panier/panier.jsf";
	}
});


$(document).ready(function(){
	var tabs = $('.cd-tabs');

	tabs.each(function(){
		var tab = $(this),
		tabItems = tab.find('ul.cd-tabs-navigation'),
		tabContentWrapper = tab.children('ul.cd-tabs-content'),
		tabNavigation = tab.find('nav');

		tabItems.on('click', 'a', function(event){
			event.preventDefault();
			var selectedItem = $(this);
			if( !selectedItem.hasClass('selected') ) {
				var selectedTab = selectedItem.data('content'),
				selectedContent = tabContentWrapper.find('li[data-content="'+selectedTab+'"]'),
				selectedContentHeight = selectedContent.innerHeight();

				tabItems.find('a.selected').removeClass('selected');
				selectedItem.addClass('selected');
				selectedContent.addClass('selected').siblings('li').removeClass('selected');
				//animate tabContentWrapper height when content changes 
				tabContentWrapper.animate({
					'height': selectedContentHeight
				}, 200);
			}
		});

		//hide the .cd-tabs::after element when tabbed navigation has scrolled to the end (mobile version)
		checkScrolling(tabNavigation);
		tabNavigation.on('scroll', function(){ 
			checkScrolling($(this));
		});
	});

	$(window).on('resize', function(){
		tabs.each(function(){
			var tab = $(this);
			checkScrolling(tab.find('nav'));
			tab.find('.cd-tabs-content').css('height', 'auto');
		});
	});

	function checkScrolling(tabs){
		var totalTabWidth = parseInt(tabs.children('.cd-tabs-navigation').width()),
		tabsViewport = parseInt(tabs.width());
		if( tabs.scrollLeft() >= totalTabWidth - tabsViewport) {
			tabs.parent('.cd-tabs').addClass('is-ended');
		} else {
			tabs.parent('.cd-tabs').removeClass('is-ended');
		}
	}
});