/* ------------------------------------- CARTE PRODUCTEURS --------------------------------- */
var producteurs ;
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
    
    var bounds = new google.maps.LatLngBounds();
    
    producteurs.forEach(function (feature) {
    	bounds.extend(feature.position);
    	
        var marker = new google.maps.Marker({
            position: feature.position,
            icon: 'marker.png',
            map: carteProducteur
        });
        carteProducteur.fitBounds(bounds);
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
}



    
    