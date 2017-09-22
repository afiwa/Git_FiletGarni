var content = document.querySelector('#hamburger-content');
var sidebarBody = document.querySelector('#hamburger-sidebar-body');
var button = document.querySelector('#hamburger-button');
var overlay = document.querySelector('#hamburger-overlay');
var activatedClass = 'hamburger-activated';

sidebarBody.innerHTML = content.innerHTML;

button.addEventListener('click', function (e) {
    e.preventDefault();

    this.parentNode.classList.add(activatedClass);
});

button.addEventListener('keydown', function (e) {
    if (this.parentNode.classList.contains(activatedClass)) {
        if (e.repeat === false && e.which === 27)
            this.parentNode.classList.remove(activatedClass);
    }
});

overlay.addEventListener('click', function (e) {
    e.preventDefault();

    this.parentNode.classList.remove(activatedClass);
});

//Own part

function overFunction(domElem) {
    var navBig = document.getElementsByTagName("nav")[0];
    var smNavBig = navBig.getElementsByClassName('sous-menu-active');
    var navSmall = document.getElementsByTagName("nav")[1];
    var smNavSmall = navSmall.getElementsByClassName('sous-menu-active');



    var elmt = domElem.nextSibling.nextSibling;
    if (elmt.classList.contains('sous-menu-active')) {
        elmt.classList.remove('sous-menu-active');
    } else {
        if (smNavBig.length != 0) {
            for (let i = 0; i <= smNavBig.length; i++) {
                smNavBig[i].classList.remove('sous-menu-active');
            }
        }
        if (smNavSmall.length != 0) {
            for (let i = 0; i <= smNavSmall.length; i++) {
                smNavSmall[i].classList.remove('sous-menu-active');
            }
        }
        elmt.classList.add('sous-menu-active');
    }
}


/* ------------------------------------------------- SLIDER RECETTES ----------------------- */


var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
    showSlides(slideIndex += n);
}

function currentSlide(n) {
    showSlides(slideIndex = n);
}

function showSlides(n) {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    var dots = document.getElementsByClassName("dot");
    if (n > slides.length) {
        slideIndex = 1
    }
    if (n < 1) {
        slideIndex = slides.length
    }
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex - 1].style.display = "block";
    dots[slideIndex - 1].className += " active";
}

/* ------------------------------------- CARTE PRODUCTEURS --------------------------------- */

function myMap() {
    var mapOptions = {
        center: new google.maps.LatLng(48.84992, 2.637041),
        zoom: 10,

        /*---------------------------- STYLE CARTE ----------------------------*/
        styles: [
            {
                "featureType": "landscape",
                "stylers": [
                    {
                        "hue": "#FFA800"
            },
                    {
                        "saturation": 0
            },
                    {
                        "lightness": 0
            },
                    {
                        "gamma": 1
            }
        ]
    },
            {
                "featureType": "road.highway",
                "stylers": [
                    {
                        "hue": "#53FF00"
            },
                    {
                        "saturation": -73
            },
                    {
                        "lightness": 40
            },
                    {
                        "gamma": 1
            }
        ]
    },
            {
                "featureType": "road.arterial",
                "stylers": [
                    {
                        "hue": "#FBFF00"
            },
                    {
                        "saturation": 0
            },
                    {
                        "lightness": 0
            },
                    {
                        "gamma": 1
            }
        ]
    },
            {
                "featureType": "road.local",
                "stylers": [
                    {
                        "hue": "#00FFFD"
            },
                    {
                        "saturation": 0
            },
                    {
                        "lightness": 30
            },
                    {
                        "gamma": 1
            }
        ]
    },
            {
                "featureType": "water",
                "stylers": [
                    {
                        "hue": "#00BFFF"
            },
                    {
                        "saturation": 6
            },
                    {
                        "lightness": 8
            },
                    {
                        "gamma": 1
            }
        ]
    },
            {
                "featureType": "poi",
                "stylers": [
                    {
                        "hue": "#679714"
            },
                    {
                        "saturation": 33.4
            },
                    {
                        "lightness": -25.4
            },
                    {
                        "gamma": 1
            }
        ]
    }
        ]

    }

    /* ------------------------------- MULTIPLE MARKERS ------------------------*/

    


   


    var carteProducteur = new google.maps.Map(document.getElementById("carteProducteur"), mapOptions);

    producteurs.forEach(function (feature) {
        var marker = new google.maps.Marker({
            position: feature.position,
            icon: 'images/marker.png',
            map: carteProducteur
        });
        var contentString = 
        '<div class="cd-tabs">'+
	        '<nav>'+
	            '<ul class="cd-tabs-navigation">'+
	                '<li><a data-content="info" class="selected" href="#0">Information</a></li>'+
	            '</ul>'+
	            '<!-- cd-tabs-navigation -->'+
	        '</nav>'+

	        '<ul class="cd-tabs-content">'+
	            '<li data-content="info" class="selected">'+
	                '<img class="photo" src="../Ressources/Images/Images_producteur/'+feature.photo+'"/>'+
	                '<h3 class="historique-pr-nom">'+feature.prenom+' '+feature.nom+'</h3>'+
//	                '<div class="historique-pr-ville">'+feature.ville+
//	                    '<div class="historique-pr-cp">'+feature.cp+'</div>'+
	                '</div>'+
	                '<div class="historique-pr-adresse">'+feature.adresse+'</div>'+
//	                '<div class="categorie_producteur">'+feature.categorie+'</div>'+
	            '</li>'+
	        '</ul>'+
	        '<!-- cd-tabs-content -->'+
	    '</div>'+
	    '<!-- cd-tabs -->';
		var infowindow = new google.maps.InfoWindow({
		content: contentString
		});
       marker.addListener('click', function () {
            infowindow.open(carteProducteur, marker);
        });

    });
 

    /*var marker = new google.maps.Marker({
        position: {
            lat: 48.84992,
            lng: 2.637041
        },
        icon: 'images/marker.png',
        map: carteProducteur
    });*/
}
