$(".hover").mouseleave(
    function () {
        $(this).removeClass("hover");
    }
);



// Incremente le panier
//$('.image_plus').on('click', function (e) {
//    console.log("function");
//    e.preventDefault();
//    var $this = $(this);
//    var $parent = $this.parent();
//    var nombreArticle = parseInt($parent.find('.nbArticle').text().replace('0', '0'));
//
//    if (nombreArticle < 100) {
//        nombreArticle += 1;
//
//        $parent.find('.nbArticle').html(nombreArticle);
//
//    } else {
//        value = 100;
//    }
//    $input.val(value);
//
//});

//decremente le panier
//$('.image_minus').on('click', function (e) {
//    console.log("function");
//    e.preventDefault();
//    var $this = $(this);
//    var $parent = $this.parent();
//    var nombreArticle = parseInt($parent.find('.nbArticle').text().replace('0', '0'));
//
//    if (nombreArticle > 0) {
//        nombreArticle -= 1;
//
//        $parent.find('.nbArticle').html(nombreArticle);
//
//    } else {
//        value = 0;
//    }
//    $input.val(value);
//
//});







jQuery(document).ready(function ($) {
    var cartWrapper = $('.cd-cart-container');
    //product id - you don't need a counter in your real project but you can use your real product id
    var productId;
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
            //recup id produit
            productId = Produit.find('.id-produit').attr('value');
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

        //update item quantity
        cartList.on('change', 'select', function (event) {
            quickUpdateCart();
        });

        //reinsert item deleted from the cart
        undo.on('click', 'a', function (event) {
            clearInterval(undoTimeoutId);
            event.preventDefault();
            cartList.find('.deleted').addClass('undo-deleted').one('webkitAnimationEnd oanimationend msAnimationEnd animationend', function () {
                $(this).off('webkitAnimationEnd oanimationend msAnimationEnd animationend').removeClass('deleted undo-deleted').removeAttr('style');
                quickUpdateCart();
            });
            undo.removeClass('visible');
        });
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

    function addToCart(trigger) {
        var cartIsEmpty = cartWrapper.hasClass('empty');
        //update cart product list
        addProduct();
        //update number of items 
        updateCartCount(cartIsEmpty, Number(NbArticle));
        //update total price
        updateCartTotal(PrixProduitNum, true, NbArticle);
        //show cart
        cartWrapper.removeClass('empty');
    }

    function addProduct() {
        //this is just a product placeholder
        //you should insert an item with the selected product info
        //replace productId, productName, price and url with your real product info
    	
        var productAdded = $('<li class="product"><div class="product-image"><a href="#0"><img src=' + ImageProduit + ' alt="placeholder"></a></div><div class="product-details"><h3><a href="#0" id="product-name">' + NomProduit + '</a></h3><span class="price">' + PrixProduit + '</span><div class="actions"><a href="#0" class="delete-item">Supprimer</a><div class="quantity"><label for="cd-product-' + productId + '">Quantite</label><span class="select"><select id="cd-product-' + productId + '" name="quantity">'+ quantiteParDefaut(NbArticle)+'</select></span></div></div></div></li>');
        cartList.prepend(productAdded);
    }

    function removeProduct(product) {
        clearInterval(undoTimeoutId);
        cartList.find('.deleted').remove();

        var topPosition = product.offset().top - cartBody.children('ul').offset().top,
            productQuantity = Number(product.find('.quantity').find('select').val()),
            productTotPrice = Number(product.find('.price').text().replace('€', '').replace(',','.')) * productQuantity;

        product.css('top', topPosition + 'px').addClass('deleted');

        //update items count + total price
        updateCartTotal(productTotPrice, false);
        updateCartCount(true, -productQuantity);
        undo.addClass('visible');

        //wait 8sec before completely remove the item
        undoTimeoutId = setTimeout(function () {
            undo.removeClass('visible');
            cartList.find('.deleted').remove();
        }, 8000);
    }

    function quickUpdateCart() {
        var quantity = 0;
        var prixUnite = 0;
        var price = 0;

        cartList.children('li:not(.deleted)').each(function () {
            var singleQuantity = Number($(this).find('select').val());
            quantity = quantity + singleQuantity;
            prixUnite = Number($(this).find('.price').text().replace(' €', '').replace(',','.'));
            price = price + singleQuantity * prixUnite;
        });
        
        cartTotal.text(price.toFixed(2));
        cartCount.find('li').eq(0).text(quantity);
        cartCount.find('li').eq(1).text(quantity + 1);
    }

    function updateCartCount(emptyCart, quantity) {
        if (typeof quantity === 'undefined') {
            var actual = Number(cartCount.find('li').eq(0).text()) + 1;
            var next = actual + 1;

            if (emptyCart) {
                cartCount.find('li').eq(0).text(actual);
                cartCount.find('li').eq(1).text(next);
            } else {
                cartCount.addClass('update-count');

                setTimeout(function () {
                    cartCount.find('li').eq(0).text(actual);
                }, 150);

                setTimeout(function () {
                    cartCount.removeClass('update-count');
                }, 200);

                setTimeout(function () {
                    cartCount.find('li').eq(1).text(next);
                }, 230);
            }
        } else {
            var actual = Number(cartCount.find('li').eq(0).text()) + quantity;
            var next = actual + 1;

            cartCount.find('li').eq(0).text(actual);
            cartCount.find('li').eq(1).text(next);
            
        }
    }

    function updateCartTotal(price, bool, quantity) {
        console.log('Text ='+(Number(cartTotal.text())));
        console.log('price ='+Number(price));
        if (typeof quantity === 'undefined') {
        bool ? cartTotal.text((Number(cartTotal.text()) + Number(price)).toFixed(2)) : cartTotal.text((Number(cartTotal.text()) - Number(price)).toFixed(2));
        }else{
            bool ? cartTotal.text((Number(cartTotal.text()) + Number(price) * Number(quantity)).toFixed(2)) : cartTotal.text(Number(cartTotal.text()) - Number(price) * Number(quantity));
        }
    }

    function quantiteParDefaut(quantite) {
        var option;
        switch (quantite) {
            case '1':
                option = '<option value="1" selected>1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option>';
                break;
            case '2':
                option = '<option value="1">1</option><option value="2" selected>2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option>';
                break;
            case '3':
                option = '<option value="1">1</option><option value="2" >2</option><option value="3" selected>3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option>';
                break;
            case '4':
                option = '<option value="1">1</option><option value="2" >2</option><option value="3" >3</option><option value="4" selected>4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option>';
                break;
            case '5':
                option = '<option value="1">1</option><option value="2" >2</option><option value="3" >3</option><option value="4" >4</option><option value="5" selected>5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option>';
                break;
            case '6':
                option = '<option value="1">1</option><option value="2" >2</option><option value="3" >3</option><option value="4" >4</option><option value="5" >5</option><option value="6" selected>6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option>';
                break;
            case '7':
                option = '<option value="1">1</option><option value="2" >2</option><option value="3" >3</option><option value="4" >4</option><option value="5" >5</option><option value="6">6</option><option value="7" selected>7</option><option value="8">8</option><option value="9">9</option>';
                break;
            case '8':
                option = '<option value="1">1</option><option value="2" >2</option><option value="3" >3</option><option value="4" >4</option><option value="5" >5</option><option value="6">6</option><option value="7">7</option><option value="8" selected>8</option><option value="9">9</option>';
                break;
            case '9':
                option = '<option value="1">1</option><option value="2" >2</option><option value="3" >3</option><option value="4" >4</option><option value="5" >5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9" selected>9</option>';
                break;
        };
        return option;

    }
});
