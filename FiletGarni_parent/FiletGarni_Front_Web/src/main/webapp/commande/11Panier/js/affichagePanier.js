$(document).ready(function () {
    /* Remplir ici le panier, le prix du total panier */
    /* DEBUT Mise à jour du prix total panier */
    // var $prixPanier = 0;
    // $(this).find('#total-panier').html($prixPanier + ' \u20ac');
    
    /* FIN Mise à jour du prix total panier */
});


$('.minus-btn').on('click', function(e) {
    e.preventDefault();
	/* DEBUT Mise à jour du prix total article */
	var $input = $(this).closest('div').find('input');
	var value = parseInt($input.val());
    if (value > 0) {
        --value;
		majTotalArticle($(this), value);
		$input.val(value);
    } else {
        value = 0;
    }

});

$('.plus-btn').on('click', function(e) {
    e.preventDefault();
	/* DEBUT Mise à jour du prix total article */
	var $input = $(this).closest('div').find('input');
	var value = parseInt($input.val());
    if (value < 100) {
        ++value;
		majTotalArticle($(this), value);
	$input.val(value);
    }
});

$('.qty').on('keyup', function() {
	console.log("test");
	var element = $(this);
	var valeur = $(this).val();
		console.log(valeur);
	majTotalArticle($(this), $(this).val());
});

$('.like-btn').on('click', function() {
    $(this).toggleClass('is-active');
});

$('.delete-btn').on('click', function() {
	var totalArticle = parseInt($(this).parent().parent().find('.total-article').text().replace(' \u20ac',''));
	majTotalPanier(-totalArticle);
	console.log(-totalArticle);
	$(this).parent().parent().remove(".item");
	
});

function majTotalArticle(element, value) {

	/* Récupérer prix de l'article, prix total des articles, total du panier et difference de prix avant-après*/
	var parent = element.parent().parent();
	var prixArticle = parseInt(parent.find('.article-price').text().replace(' \u20ac',''));
	var prixTotalArticleAncien = parseInt(parent.find('.total-article').text().replace(' \u20ac',''));
	var prixTotalArticleNouveau = prixArticle * value;
	var differenceDePrix = -prixTotalArticleAncien + prixTotalArticleNouveau ;

	/*Renseigner la nouvelle valeur de total article et écrire prixTotal dans son HTML */
	parent.find('.total-article').html(prixTotalArticleNouveau + ' \u20ac');

	/* Mettre à jour le total Panier */
	majTotalPanier(differenceDePrix);
}

function majTotalPanier(valeur) {
	console.log("maj panier");
	console.log(valeur);
	/* DEBUT Mise à jour du prix total panier */
	var $prixPanier = parseInt($('#total-panier').text().replace(' \u20ac',''));
	$prixPanier += valeur;
	$('#total-panier').html($prixPanier + ' \u20ac');
}
