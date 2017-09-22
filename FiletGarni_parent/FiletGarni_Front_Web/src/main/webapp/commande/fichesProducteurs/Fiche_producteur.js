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

    var producteurs = [
        {
            position: new google.maps.LatLng(48.814732, 2.74823)
    },
        {
            position: new google.maps.LatLng(48.839594, 2.576569)
    },
        {
            position: new google.maps.LatLng(48.774474, 2.562149)
    },
        {
            position: new google.maps.LatLng(48.860559, 2.326904)
    },
        {
            position: new google.maps.LatLng(48.861462, 2.210175)
    },
        {
            position: new google.maps.LatLng(48.832543, 2.222534)
    },
        {
            position: new google.maps.LatLng(48.790038, 2.263733)
    },
        {
            position: new google.maps.LatLng(48.817173, 2.432648)
    },
        {
            position: new google.maps.LatLng(48.767414, 2.596069)
    },
        {
            position: new google.maps.LatLng(48.778275, 2.973724)
    },
        {
            position: new google.maps.LatLng(49.02112, 3.031403)
    },
        {
            position: new google.maps.LatLng(48.960745, 2.814423)
    },
        {
            position: new google.maps.LatLng(48.767414, 1.851746)
    }
];

   var contentString = '<div class="cd-tabs">'+
                    '<nav>'+
                        '<ul class="cd-tabs-navigation">'+
                            '<li><a data-content="info" class="selected" href="#0">Information</a></li>'+
                        '</ul>'+
                        '<!-- cd-tabs-navigation -->'+
                    '</nav>'+

                    '<ul class="cd-tabs-content">'+
                        '<li data-content="info" class="selected">'+
                            '<img class="photo" src="kevin.jpg"/>'+
                            '<h3 class="historique-pr-nom">Le Point relou</h3>'+
                            '<div class="historique-pr-ville">Bussy-saint-georges'+
                                '<div class="historique-pr-cp">77600</div>'+
                            '</div>'+
                            '<div class="historique-pr-adresse">2 boulvard thibault de champagne</div>'+
                        '</li>'+
                    '</ul>'+
                    '<!-- cd-tabs-content -->'+
                '</div>'+
                '<!-- cd-tabs -->';
    var infowindow = new google.maps.InfoWindow({
        content: contentString
    });


    var carteProducteur = new google.maps.Map(document.getElementById("carteProducteur"), mapOptions);

    producteurs.forEach(function (feature) {
        var marker = new google.maps.Marker({
            position: feature.position,
            icon: 'marker.png',
            map: carteProducteur
        });
       marker.addListener('click', function () {
            infowindow.open(carteProducteur, marker);
        });

    });
}



    
    