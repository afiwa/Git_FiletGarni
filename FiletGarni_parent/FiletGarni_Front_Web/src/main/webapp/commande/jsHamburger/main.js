
//Own part
function overFunction(domElem){
	let sousMenuCible = $(domElem).find(".sous-menu");
    let allSousMenu = $(document).find(".sous-menu");
    if (allSousMenu.length != 0) {
      for (let i = 0; i <= allSousMenu.length; i++) {
           $(allSousMenu[i]).removeClass("sous-menu-active");
       }
    }
    sousMenuCible.addClass("sous-menu-active");
}

function outFunction(domElem){
	$(domElem).removeClass("sous-menu-active");
}

$('#header-1').on('click', '.search-toggle', function(e) {
	  var selector = $(this).data('selector');

	  $(selector).toggleClass('show').find('.search-input').focus();
	  $(this).toggleClass('active');

	  e.preventDefault();
	});