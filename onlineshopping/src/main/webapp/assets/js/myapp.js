// podswietlanie aktualnie wybranej funkcji na pasku nawigacji - active menu

$(function() {
	// solving the active menu problem
	switch(menu) {   // zmienna menu zdefiniowana w page.jsp 
	
		case 'About Us':
			$('#about').addClass('active');
			break;
		case 'Contact Us':
			$('#contact').addClass('active');
			break;
		default:
			$('#home').addClass('active');
			break;	
	
	}
		
	
});