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


    /*var contentString = '<div id="content">' +
        '<div id="siteNotice">' +
        '</div>' +
        '<h1 id="firstHeading" class="firstHeading">Uluru</h1>' +
        '<div id="bodyContent">' +
        '<p><b>Uluru</b>, also referred to as <b>Ayers Rock</b>, is a large ' +
        'sandstone rock formation in the southern part of the ' +
        'Northern Territory, central Australia. It lies 335&#160;km (208&#160;mi) ' +
        'south west of the nearest large town, Alice Springs; 450&#160;km ' +
        '(280&#160;mi) by road. Kata Tjuta and Uluru are the two major ' +
        'features of the Uluru - Kata Tjuta National Park. Uluru is ' +
        'sacred to the Pitjantjatjara and Yankunytjatjara, the ' +
        'Aboriginal people of the area. It has many springs, waterholes, ' +
        'rock caves and ancient paintings. Uluru is listed as a World ' +
        'Heritage Site.</p>' +
        '<p>Attribution: Uluru, <a href="https://en.wikipedia.org/w/index.php?title=Uluru&oldid=297882194">' +
        'https://en.wikipedia.org/w/index.php?title=Uluru</a> ' +
        '(last visited June 22, 2009).</p>' +
        '</div>' +
        '</div>';*/

   var contentString = '<div class="cd-tabs">'+
                    '<nav>'+
                        '<ul class="cd-tabs-navigation">'+
                            '<li><a data-content="info" class="selected" href="#0">Information</a></li>'+
                        '</ul>'+
                        '<!-- cd-tabs-navigation -->'+
                    '</nav>'+

                    '<ul class="cd-tabs-content">'+
                        '<li data-content="info" class="selected">'+
                            '<img class="photo" src="images/producteurs/kevin.jpg"/>'+
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
            icon: 'images/marker.png',
            map: carteProducteur
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
