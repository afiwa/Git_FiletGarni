$(document).ready(function () {
    /* Remplir ici le panier, le prix du total panier */
    /* DEBUT Mise � jour du prix total panier */
    // var $prixPanier = 0;
    // $(this).find('#total-panier').html($prixPanier + ' \u20ac');
    
    /* FIN Mise � jour du prix total panier */
});

//
//$('.minus-btn').on('click', function(e) {
//    e.preventDefault();
//	/* DEBUT Mise � jour du prix total article */
//	var $input = $(this).closest('div').find('input');
//	var value = parseInt($input.val());
//    if (value > 0) {
//        --value;
//		majTotalArticle($(this), value);
//		$input.val(value);
//    } else {
//        value = 0;
//    }
//    console.log("diminution !");
//});
//
//
//
//$('.plus-btn').on('click', function(e) {
//    e.preventDefault();
//	/* DEBUT Mise � jour du prix total article */
//	var $input = $(this).closest('div').find('input');
//	var value = parseInt($input.val());
//    if (value < 100) {
//        ++value;
//		majTotalArticle($(this), value);
//	$input.val(value);
//    }
//});
//
//$('.qty').on('keyup', function() {
//	console.log("test");
//	var element = $(this);
//	var valeur = $(this).val();
//		console.log(valeur);
//		
//		console.log("changement de sens!");
//		alert($('#form-client\\:propertyId').val());
//		
//	majTotalArticle($(this), $(this).val());
//
//});

$('.like-btn').on('click', function() {
    $(this).toggleClass('is-active');
});

//$('.delete-btn').on('click', function() {
//	var totalArticle = parseInt($(this).parent().parent().find('.total-article').text().replace(' \u20ac',''));
//	majTotalPanier(-totalArticle);
//	console.log(-totalArticle);
//	$(this).parent().parent().remove(".item");
//	
//});
//
//function majTotalArticle(element, value) {
//
//	/* R�cup�rer prix de l'article, prix total des articles, total du panier et difference de prix avant-apr�s*/
//	var parent = element.parent().parent();
//	var prixArticle = parseFloat(parent.find('.article-price').text().replace(' \u20ac',''));
//	var prixTotalArticleAncien = parseFloat(parent.find('.total-article').text().replace(' \u20ac',''));
//	var prixTotalArticleNouveau = prixArticle * value;
//	var differenceDePrix = -prixTotalArticleAncien + prixTotalArticleNouveau ;
//
//	/*Renseigner la nouvelle valeur de total article et �crire prixTotal dans son HTML */
//	parent.find('.total-article').html(prixTotalArticleNouveau + ' \u20ac');
//
//	/* Mettre � jour le total Panier */
//	majTotalPanier(differenceDePrix);
//}
//
//function majTotalPanier(valeur) {
//	console.log("maj panier avec "+valeur);
//	console.log(valeur);
//	/* DEBUT Mise � jour du prix total panier */
//	var $prixPanier = parseFloat($('.total-panier').text().replace(' \u20ac',''));
//	$prixPanier += valeur;
//	$('.total-panier').html($prixPanier + ' \u20ac');
//	console.log("ok");
//}
