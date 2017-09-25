var coordonnee;
var pointrelais;
var consommateur;
var cartePointRelais;
var mapPR = new Map();
var slider = document.getElementById("myRange");
var villeSelection;
var choixDepart;
var markerSelected;
var distanceMax;

function myMap() {

    var mapOptions = {
        center: consommateur[0].positionDomicile,
        zoom: 12,

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

    
    cartePointRelais = new google.maps.Map(document.getElementById("cartePointRelais"), mapOptions);

    initMarkerAndMapPR();
    
    consommateur.forEach(function (feature) {
    	console.log(feature.positionDomicile);
    	var marker = new google.maps.Marker({
    		position: feature.positionDomicile,
    		icon: 'images/maison32.png',
    		map: cartePointRelais
    	});
    	console.log(feature.positionTravail);
    	var marker = new google.maps.Marker({
    		position: feature.positionTravail,
    		icon: 'images/travail32.png',
    		map: cartePointRelais
    	});
    });
}

function initMarkerAndMapPR(){
	pointrelais.forEach(function (feature) {
        let marker = new google.maps.Marker({
            position: feature.position,
            icon: 'images/marker.png',
            map: cartePointRelais
        });
        
        let contentDistance = '<div class="infoMarker">'+
	                           feature.distanceDomicile+'Km'+
                                '</div>';

        let infowWindow = new google.maps.InfoWindow({
            content:contentDistance
        });
        
        let contentString = 
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
            				'<h3 class="historique-pr-nom">'+feature.nom+'</h3>'+
            				'<div class="historique-pr-ville">'+feature.ville +
            				'<div class="historique-pr-cp">'+feature.cp+'</div>'+
            				'</div>'+
            				'<div class="historique-pr-adresse">'+feature.adresse+'</div>'+
            			'</li>'+

           				'<li data-content="horaire">';
           				$.each(feature.listehoraires, function(idx,obj){
           					contentString = contentString + '<div class="historique-pr-horaire">' + obj.jour +' : ' + obj.debut +'  - ' + obj.fin +' </div>';
           				});
           				contentString = contentString +'</li>'+
           			'</ul>'+
            	'<!-- cd-tabs-content -->'+
            	'</div>'+
            	'<!-- cd-tabs -->';
        
        feature.infowindow = infowWindow;
        
        feature.contentString = contentString;
        
        

       mapPR.set(marker,feature);
        
        marker.addListener('click', function () {
           
           for(var [markers, pointrelais] of mapPR){
        	   markers.setIcon('images/marker.png');
               pointrelais.infowindow.close(cartePointRelais,marker);
           }
           feature.infowindow.open(cartePointRelais,marker);
            marker.setIcon('images/marker-select2.png');
            markerSelected = marker;
            let myEncart = document.getElementById("historique-choix");
            if(myEncart.hasChildNodes()){
            	let child = myEncart.firstChild;
            	myEncart.removeChild(child);
            }
            myEncart.insertAdjacentHTML('afterbegin', feature.contentString);
           initTab();
        });
        
        marker.addListener('mouseover', function () {
           
           infowWindow.open(cartePointRelais,marker);
           
       });
       
       marker.addListener('mouseout', function () {
           
           infowWindow.close(cartePointRelais,marker);
           
       });
    });
}

function initInfoDistance(){
    
   for(var [markers, pointrelais] of mapPR){ 
    
    let contentDistance; 
       
    switch(choixDepart){
        case 'domicile':
        	
            contentDistance = '<div class="infoMarker">'+
	                   pointrelais.distanceDomicile+'Km'+
                        '</div>';
            break;
        case 'travail':
            contentDistance = '<div class="infoMarker">'+
	                   pointrelais.distanceTravail+'Km'+
                        '</div>';
            break;
        case 'ville':
        	
            pointrelais.distance = calculDistanceVille(pointrelais.position.lat,pointrelais.position.lgn);
            contentDistance = '<div class="infoMarker">'+
	                   pointrelais.distance+'Km'+
                        '</div>';
            break;
                        }
       pointrelais.infowindow.setContent(contentDistance);
   }
}

$(document).ready(function(){
	choixDepart = $("input[name=adresse]:checked").val();
	console.log(choixDepart);
	$("input[name=adresse]").change(function(){
		choixDepart = $("input[name=adresse]:checked").val();
		setMarkerVisible(distanceMax);
		changeCenterOfMap();
		initInfoDistance();
	});
	
	slider.oninput = function() {
	    //output.innerHTML = this.value;
		distanceMax = slider.value;
		setMarkerVisible(distanceMax);
	}
});

function setMarkerVisible(distanceMax){

    switch(choixDepart){
    case 'domicile':
    	for(var [marker, pointrelais] of mapPR){
    		if( pointrelais.distanceDomicile > distanceMax){
    			marker.setVisible(false);
    		}else{
    			marker.setVisible(true);
    		}
    	}
        break;
    case 'travail':
    	for(var [marker, pointrelais] of mapPR){
    		if( pointrelais.distanceTravail > distanceMax){
    			marker.setVisible(false);
    		}else{
    			marker.setVisible(true);
    		}
    	}
        break;
    case 'ville':
    	for(var [marker, pointrelais] of mapPR){
    		if( pointrelais.distance > distanceMax){
    			marker.setVisible(false);
    		}else{
    			marker.setVisible(true);
    		}
    	}
        break;
    }
}

function calculDistanceVille(lat,lgn){
    let resultDistance;
    /* A FAIRE */
    return resultDistance;
}

function changeCenterOfMap(){
    switch(choixDepart){
    case 'domicile':
    	cartePointRelais.panTo(consommateur[0].positionDomicile);
        break;
    case 'travail':
    	cartePointRelais.panTo(consommateur[0].positionTravail);
        break;
    case 'ville':
    	cartePointRelais.panTo(villeSelection);
        break;
    }
}


/*

var output = document.getElementById("demo");
output.innerHTML = slider.value; // Display the default slider value
*/
// Update the current slider value (each time you drag the slider handle)




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

           let  coordonnee = $("#nom_ville").getSelectedItemData().coordonnees_gps;
            villeSelection = new google.maps.LatLng(coordonnee[0],coordonnee[1]);
            choixDepart = 'ville';
            initInfoDistance();
            changeCenterOfMap();
        },
        onHideListEvent: function () {
            
        }
    },
    theme: "round"
};

$("#nom_ville").easyAutocomplete(options);
/*
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

