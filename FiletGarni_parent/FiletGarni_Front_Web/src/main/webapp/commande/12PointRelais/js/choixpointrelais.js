var coordonnee;
/*
var options = {
    url: "json/communes_idf.json",

    getValue: "nom_commune",


    requestDelay: 500,

    list: {
        match: {
            enabled: true
        },
        onSelectItemEvent: function () {
            var selectedItemValue = $("#nom_ville").getSelectedItemData().code_postal;

            $("#code_postal").val(selectedItemValue).trigger("change");

            coordonnee = $("#nom_ville").getSelectedItemData().coordonnees_gps;



        },
        onHideListEvent: function () {
            initLatLonMap(coordonnee[0], coordonnee[1]);
        }
    },
    theme: "round"
};

$("#nom_ville").easyAutocomplete(options);

var options2 = {
    url: "json/communes_idf.json",

    getValue: "code_postal",


    requestDelay: 500,

    list: {
        match: {
            enabled: true
        },
        onSelectItemEvent: function () {
            var selectedItemValue = $("#code_postal").getSelectedItemData().nom_commune;
            coordonnee = $("#code_postal").getSelectedItemData().coordonnees_gps;



        },
        onHideListEvent: function () {
            initLatLonMap(coordonnee[0], coordonnee[1]);
        }
    },
    theme: "round"
};
$("#code_postal").easyAutocomplete(options2);
*/


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

    var tabMarker = [];
    var cartePointRelais = new google.maps.Map(document.getElementById("cartePointRelais"), mapOptions);

    producteurs.forEach(function (feature) {
        var marker = new google.maps.Marker({
            position: feature.position,
            icon: 'images/marker.png',
            map: cartePointRelais
        });
        
        tabMarker.push(marker);
        
       marker.addListener('click', function () {
           
           tabMarker.forEach(function (mark){
                mark.setIcon('images/marker.png');
            });
           
            marker.setIcon('images/marker-select2.png');
            
        });

       
    });
    
    var marker = new google.maps.Marker({
    	position: new google.maps.LatLng(48.817173, 2.452648),
        icon: 'images/maison1.png',
        map: cartePointRelais
    });
    
    var marker = new google.maps.Marker({
    	position: new google.maps.LatLng(48.827173, 2.432648),
        icon: 'images/maison2.png',
        map: cartePointRelais
    });
    
    var marker = new google.maps.Marker({
    	position: new google.maps.LatLng(48.817173, 2.442648),
        icon: 'images/travail.png',
        map: cartePointRelais
    });
}
/*
var slider = document.getElementById("myRange");
var output = document.getElementById("demo");
output.innerHTML = slider.value; // Display the default slider value

// Update the current slider value (each time you drag the slider handle)
slider.oninput = function() {
    output.innerHTML = this.value;
}*/
