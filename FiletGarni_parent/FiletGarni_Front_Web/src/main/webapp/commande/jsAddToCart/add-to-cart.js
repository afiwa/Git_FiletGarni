$(".hover").mouseleave(
    function () {
        $(this).removeClass("hover");
    }
);


jQuery(document).ready(function ($) {
    var cartWrapper = $('.cd-cart-container');
    //product id - you don't need a counter in your real project but you can use your real product id
    var productId = 0;
    var Produit;
    var ImageProduit;
    var NomProduit;
    var PrixProduit;
    var PrixProduitNum;
    var Ferme;
    var Poids;
    var PrixKilo;
    var NbArticle;
    var addToCartBtn = $('.cd-add-to-cart');
    var cartWrapper = $('.cd-cart-container');

    console.log(cartWrapper);
    if (cartWrapper.length > 0) {
        //store jQuery objects
        var cartBody = cartWrapper.find('.body')
        var cartList = cartBody.find('ul').eq(0);
        var cartTotal = cartWrapper.find('.checkout').find('span');
        var cartTrigger = cartWrapper.children('.cd-cart-trigger');
        var cartCount = cartTrigger.children('.count')
        var addToCartBtn = $('.cd-add-to-cart');
        var undo = cartWrapper.find('.undo');
        var undoTimeoutId;

        //add product to cart
        addToCartBtn.on('click', function (event) {
            //recup fiche produit
            Produit = $(this).parent().parent().parent();
            //recup img
            ImageProduit = Produit.find('.image_principale').attr('src');
            //recup le nb article
            NbArticle = Produit.find('.nbArticle').text();
            //recup nom produit
            NomProduit = Produit.find('.nomProduit').text();
            //recup prix produit
            PrixProduit = Produit.find('.prixProduit').text();
            console.log(PrixProduit);
            PrixProduitNum = PrixProduit.replace(' €', '');
            PrixProduitNum = PrixProduitNum.replace(',','.');
            console.log(PrixProduitNum);
            //recup nom de la ferme
            Ferme = Produit.find('.ferme').text();
            //recup poids
            Poids = Produit.find('.poids').text();
            //recup prix au kilo;
            PrixKilo = Produit.find('.prixKilo').text();
            event.preventDefault();
            addToCart($(this));
        });

        //open/close cart
        cartTrigger.on('click', function (event) {
            event.preventDefault();
            toggleCart();
        });

        //close cart when clicking on the .cd-cart-container::before (bg layer)
        cartWrapper.on('click', function (event) {
            if ($(event.target).is($(this))) toggleCart(true);
        });

        //delete an item from the cart
        cartList.on('click', '.delete-item', function (event) {
            event.preventDefault();
            removeProduct($(event.target).parents('.product'));
        });

        //reinsert item deleted from the cart
        /*undo.on('click', 'a', function (event) {
            clearInterval(undoTimeoutId);
            event.preventDefault();
            cartList.find('.deleted').addClass('undo-deleted').one('webkitAnimationEnd oanimationend msAnimationEnd animationend', function () {
                $(this).off('webkitAnimationEnd oanimationend msAnimationEnd animationend').removeClass('deleted undo-deleted').removeAttr('style');
                quickUpdateCart();
            });
            undo.removeClass('visible');
        });*/
    }
    function removeProduct(product) {
        clearInterval(undoTimeoutId);
        cartList.find('.deleted').remove();

        var topPosition = product.offset().top - cartBody.children('ul').offset().top;

        product.css('top', topPosition + 'px').addClass('deleted');

        undo.addClass('visible');

        //wait 8sec before completely remove the item
        undoTimeoutId = setTimeout(function () {
            undo.removeClass('visible');
            cartList.find('.deleted').remove();
        }, 8000);
    }

function toggleCart(bool) {
    var cartIsOpen = (typeof bool === 'undefined') ? cartWrapper.hasClass('cart-open') : bool;

    if (cartIsOpen) {
        cartWrapper.removeClass('cart-open');
        //reset undo
        clearInterval(undoTimeoutId);
        undo.removeClass('visible');
        cartList.find('.deleted').remove();

        setTimeout(function () {
            cartBody.scrollTop(0);
            //check if cart empty to hide it
            if (Number(cartCount.find('li').eq(0).text()) == 0) cartWrapper.addClass('empty');
        }, 500);
    } else {
        cartWrapper.addClass('cart-open');
    }
}
});



