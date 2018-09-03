// podswietlanie aktualnie wybranej funkcji na pasku nawigacji - active menu

$(function() {
	// solving the active menu problem
	switch(menu) {   // zmienna menu zdefiniowana w page.jsp  - jest jej przypisywana nazwa zmiennej title (title zwracana przez PageController)
	
		case 'About Us':
			$('#about').addClass('active');
			break;
		case 'Contact Us':
			$('#contact').addClass('active'); // #contact to id przycisku zdefiniowanego w navbar.jsp
			break;
		case 'All Products':
			$('#listProducts').addClass('active'); // #listProducts to id przycisku zdefiniowanego w navbar.jsp
			break;	
		default:
			$('#listProducts').addClass('active'); 
			$('#a_'+menu).addClass('active'); // '#a_'+menu to id przycisku zdefiniowanego w side.jsp
			break;	
	
	}
		
	// ten skrypt jest uruchamiany w page.jsp - ktory zawiera odniesienia do plikow navbar.jsp, sidebar.jsp - a w tych plikach jes zdefiniowany elementy o id #about, #contact itd. 
});