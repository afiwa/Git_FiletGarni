var coordonnee;
var pointrelais;
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

    var mapPR = new Map();
    var cartePointRelais = new google.maps.Map(document.getElementById("cartePointRelais"), mapOptions);

    pointrelais.forEach(function (feature) {
        var marker = new google.maps.Marker({
            position: feature.position,
            icon: 'images/marker.png',
            map: cartePointRelais
        });
        
        mapPR.set(marker,feature);
        
        marker.addListener('click', function () {
           
           for(var [markers, pointrelais] of mapPR){
        	   markers.setIcon('images/marker.png');
           }
            marker.setIcon('images/marker-select2.png');
            let myEncart = document.getElementById("historique-choix");
            var contentString = 
            	'<div class="cd-tabs">'+
            		'<nav>'+
            			'<ul class="cd-tabs-navigation">'+
            				'<li><a data-content="adresse" class="selected" href="#0">Adresse</a></li>'+
            				'<li><a data-content="horaire" href="#0">Horaire </a></li>'+
            			'</ul>'+
            	'<!-- cd-tabs-navigation -->'+
            		'</nav>'+
            		'<ul class="cd-tabs-content">'+
            			'<li data-content="adresse" class="selected">'+
            				'<h3 class="historique-pr-nom">'+mapPR.get(marker).nom+'</h3>'+
            				'<div class="historique-pr-ville">'+mapPR.get(marker).ville +
            				'<div class="historique-pr-cp">'+mapPR.get(marker).cp+'</div>'+
            				'</div>'+
            				'<div class="historique-pr-adresse">'+mapPR.get(marker).adresse+'</div>'+
            			'</li>'+

           				'<li data-content="horaire">'+
           					'<div class="historique-pr-horaire-lundi">Lundi : 8h30 - 19h</div>'+
           					'<div class="historique-pr-horaire-mardi">Mardi : 8h30 - 19h</div>'+
           					'<div class="historique-pr-horaire-mercredi">Mercredi : 8h30 - 19h</div>'+
           					'<div class="historique-pr-horaire-jeudi">Jeudi : 8h30 - 19h</div>'+
           					'<div class="historique-pr-horaire-vendredi">Vendredi : 8h30 - 19h</div>'+
           					'<div class="historique-pr-horaire-samedi">Samedi : 8h30 - 19h</div>'+
           					'<div class="historique-pr-horaire-dimanche">Dimanche : 8h30 - 19h</div>'+
           				'</li>'+
           			'</ul>'+
            	'<!-- cd-tabs-content -->'+
            	'</div>'+
            	'<!-- cd-tabs -->';
            if(myEncart.hasChildNodes()){
            	let child = myEncart.firstChild;
            	myEncart.removeChild(child);
            }
            myEncart.insertAdjacentHTML('afterbegin', contentString);
           initTab();
        });

       
    });
    
    var marker = new google.maps.Marker({
    	position: new google.maps.LatLng(48.817173, 2.452648),
        icon: 'images/maison32.png',
        map: cartePointRelais
    });
    
    var marker = new google.maps.Marker({
    	position: new google.maps.LatLng(48.817173, 2.442648),
        icon: 'images/travail32.png',
        map: cartePointRelais
    });
}

function initMarker(){
	
}
/*
var slider = document.getElementById("myRange");
var output = document.getElementById("demo");
output.innerHTML = slider.value; // Display the default slider value

// Update the current slider value (each time you drag the slider handle)
slider.oninput = function() {
    output.innerHTML = this.value;
}*/



function initTab(){
var tabs = $('.cd-tabs');
	
	tabs.each(function(){
		var tab = $(this),
			tabItems = tab.find('ul.cd-tabs-navigation'),
			tabContentWrapper = tab.children('ul.cd-tabs-content'),
			tabNavigation = tab.find('nav');

		tabItems.on('click', 'a', function(event){
			event.preventDefault();
			var selectedItem = $(this);
			if( !selectedItem.hasClass('selected') ) {
				var selectedTab = selectedItem.data('content'),
					selectedContent = tabContentWrapper.find('li[data-content="'+selectedTab+'"]'),
					slectedContentHeight = selectedContent.innerHeight();
				
				tabItems.find('a.selected').removeClass('selected');
				selectedItem.addClass('selected');
				selectedContent.addClass('selected').siblings('li').removeClass('selected');
				//animate tabContentWrapper height when content changes 
				tabContentWrapper.animate({
					'height': slectedContentHeight
				}, 200);
			}
		});

		//hide the .cd-tabs::after element when tabbed navigation has scrolled to the end (mobile version)
		checkScrolling(tabNavigation);
		tabNavigation.on('scroll', function(){ 
			checkScrolling($(this));
		});
	});
	
	$(window).on('resize', function(){
		tabs.each(function(){
			var tab = $(this);
			checkScrolling(tab.find('nav'));
			tab.find('.cd-tabs-content').css('height', 'auto');
		});
	});

	function checkScrolling(tabs){
		var totalTabWidth = parseInt(tabs.children('.cd-tabs-navigation').width()),
		 	tabsViewport = parseInt(tabs.width());
		if( tabs.scrollLeft() >= totalTabWidth - tabsViewport) {
			tabs.parent('.cd-tabs').addClass('is-ended');
		} else {
			tabs.parent('.cd-tabs').removeClass('is-ended');
		}
	}
}
