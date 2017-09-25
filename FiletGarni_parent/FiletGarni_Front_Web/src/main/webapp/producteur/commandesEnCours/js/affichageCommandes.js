$(document).ready(function(){


$("#btnCmdPrete").on("click", function() {
	if($(this).children().attr('checked')){
		$(this).children().attr('checked', false);
	} else {
		$(this).children().attr('checked', true);
	}
});

//
//
// TOGGLE contenu Commande
//
//
$('#btnToggle').on('click', function () {
    $(this).parent().parent().parent().parent().children('.toggler').toggle(1000);
});

$('#lblPdtIndispo').on('click', function () {
	console.log("ok");
	$(this).parent().children('#qteIndispo').toggle();
});

$('#pdtIndispo').on('click', function () {
	console.log("ok");
	$(this).parent().children('#qteIndispo').toggle();
	$(this).parent().parent().parent().style('borderColor','red');
});

});
