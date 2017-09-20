var content = document.querySelector('#hamburger-content');
var sidebarBody = document.querySelector('#hamburger-sidebar-body');
var button = document.querySelector('#hamburger-button');
var overlay = document.querySelector('#hamburger-overlay');
var activatedClass = 'hamburger-activated';

sidebarBody.innerHTML = content.innerHTML;			

button.addEventListener('click', function(e) {
	e.preventDefault();

	this.parentNode.classList.add(activatedClass);
});

button.addEventListener('keydown', function(e) {
	if (this.parentNode.classList.contains(activatedClass))
	{
		if (e.repeat === false && e.which === 27)
			this.parentNode.classList.remove(activatedClass);
	}
});

overlay.addEventListener('click', function(e) {
	e.preventDefault();

	this.parentNode.classList.remove(activatedClass);
});

function clickFunction(elmt){
    switch(elmt){
        case 1:
            if(document.getElementById("sous-menu1").classList.contains("sous-menu-active")){
                document.getElementById("sous-menu1").className = "sous-menu";
            }
            else{
                document.getElementById("sous-menu1").className = "sous-menu-active";
            }
            document.getElementById("sous-menu2").className = "sous-menu";
            document.getElementById("sous-menu3").className = "sous-menu";
            document.getElementById("sous-menu4").className = "sous-menu";
            
            break;
        case 2:
            if(document.getElementById("sous-menu2").classList.contains("sous-menu-active")){
                document.getElementById("sous-menu2").className = "sous-menu";
            }
            else{
                document.getElementById("sous-menu2").className = "sous-menu-active";
            }
            document.getElementById("sous-menu1").className = "sous-menu";
            document.getElementById("sous-menu3").className = "sous-menu";
            document.getElementById("sous-menu4").className = "sous-menu";
            break;
        case 3:
            if(document.getElementById("sous-menu3").classList.contains("sous-menu-active")){
                document.getElementById("sous-menu3").className = "sous-menu";
            }
            else{
                document.getElementById("sous-menu3").className = "sous-menu-active";
            }
            document.getElementById("sous-menu2").className = "sous-menu";
            document.getElementById("sous-menu1").className = "sous-menu";
            document.getElementById("sous-menu4").className = "sous-menu";
            break;
        case 4:
            if(document.getElementById("sous-menu4").classList.contains("sous-menu-active")){
                document.getElementById("sous-menu4").className = "sous-menu";
            }
            else{
                document.getElementById("sous-menu4").className = "sous-menu-active";
            }
            document.getElementById("sous-menu2").className = "sous-menu";
            document.getElementById("sous-menu3").className = "sous-menu";
            document.getElementById("sous-menu1").className = "sous-menu";
            break;
               }
}