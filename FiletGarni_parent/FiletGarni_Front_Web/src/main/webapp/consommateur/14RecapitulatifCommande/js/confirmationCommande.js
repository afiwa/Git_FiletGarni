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
