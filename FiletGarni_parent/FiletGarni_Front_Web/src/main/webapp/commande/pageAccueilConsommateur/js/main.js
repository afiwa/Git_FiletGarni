
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

function showSlides() {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    var dots = document.getElementsByClassName("dot");
    for (i = 0; i < slides.length; i++) {
       slides[i].style.display = "none";  
    }
    slideIndex++;
    if (slideIndex > slides.length) {slideIndex = 1}    
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex-1].style.display = "block";  
    dots[slideIndex-1].className += " active";
    setTimeout(showSlides, 4000); // Change image every 4 seconds
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

    var tabProd = [];
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
	                '<li><a data-content="info" class="selected" href="#0">Informations</a></li>'+
	            '</ul>'+
	            '<!-- cd-tabs-navigation -->'+
	        '</nav>'+

	        '<ul class="cd-tabs-content">'+
	            '<li data-content="info" class="selected" id="infoEncart">'+
	                '<img class="photo" src="../../Ressources/Images/Images_producteurs/'+feature.photo+'"/>'+
		            '<div id="categorieProducteur">'+feature.categorie+'</div>'+
		            '<h3>'+feature.prenom+' '+feature.nom+'</h3>'+
		            '<div>'+feature.adresse+'</div>'+
		            '<div>'+feature.cp+' '+feature.ville+'</div>'+
	            '</li>'+
	        '</ul>'+
	        '<!-- cd-tabs-content -->'+
	    '</div>'+
	    '<!-- cd-tabs -->';
		var infowindow = new google.maps.InfoWindow({
		content: contentString
		});
		
		var objetProd = {
				marker: marker,
				infowindow: infowindow};
		tabProd.push(objetProd);
       marker.addListener('click', function () {
    	   tabProd.forEach(function (objet){
    		   objet.infowindow.close(carteProducteur, objet.marker);
    	   });
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
