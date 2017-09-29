$('.coordonneesProd').click(function(e) {
  console.log("Clicked");
  $(this).next().slideToggle();
  $(this).next().next().next().slideToggle();
  
  
})

$('.coordonneesPr').click(function(e) {
  console.log("Clicked");
  $(this).next().slideToggle();
  $(this).next().next().next().slideToggle();
  
  
})

function openCity(evt, cityName) {
                var i, x, tablinks;
                x = document.getElementsByClassName("city");
                for (i = 0; i < x.length; i++) {
                    x[i].style.display = "none";
                }
                tablinks = document.getElementsByClassName("tablink");
                for (i = 0; i < x.length; i++) {
                    tablinks[i].className = tablinks[i].className.replace(" w3-red", "");
                }
                document.getElementById(cityName).style.display = "block";
                evt.currentTarget.className += " w3-red";
            }

function prfunction(elmt){
	x = $(elmt).find(".pr");
	  if(x.style.display == "block"){
		      x.style.display = "none";
	  }
	  else{
		      x.style.display = "block";
	  }
}

function prodfunction(elmt){
	
	x = $(elmt).find(".prod");
console.log(x);
	if(x.style.display == "block"){
		      x.style.display = "none";
	  }
	  else{
		      x.style.display = "block";
	  }
}

function validerCommande(elmt){
	
}