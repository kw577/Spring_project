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
			if(menu == "Home") break;
			$('#listProducts').addClass('active'); 
			$('#a_'+menu).addClass('active'); // '#a_'+menu to id przycisku zdefiniowanego w side.jsp
			break;	
	
	}
		
	// ten skrypt jest uruchamiany w page.jsp - ktory zawiera odniesienia do plikow navbar.jsp, sidebar.jsp - a w tych plikach jes zdefiniowany elementy o id #about, #contact itd.
	
	
	
	
	
	
	// code for JQuery dataTable  - tabela do wyswietlania listy produktow
	// code for jquery dataTable
	// create a dataset
	// stale dane do celow testowych 
	var products = [
	                
	                	['1', 'ABC'],
	                	['2', 'CYX'],
	                	['3', 'PQR'],
	                	['4', 'MNO'],
	                	['5', 'WVB'],
	                	['6', 'CFG'],
	                	['7', 'HIK'],
	                	['8', 'LMP']
	                	                
	                ];
	
	var $table = $('#productListTable'); // productListTable - to id tabeli w listProducts.jsp
	
	// kod ponizej jest wykonywany gdy tabela o id productListTable (plik listProducts.jsp) nie jest pusta
	if($table.length) { 
		//console.log('Inside the table!');
		
		$table.DataTable( { // zmienna zdefiniowana w jquery.dataTables.js
			// ustawienie parametrow tabeli
			lengthMenu: [[3,5,10,-1], ['3 Records', '5 Records', '10 Records', 'ALL']], // zmienna zdefiniowana w jquery.dataTables.js - zmienna okresla - lista rozwijana z iloscia produktow jakie ma wyswietlac tabela
			pageLength: 5, // zmienna zdefiniowana w jquery.dataTables.js
			data: products // zrodlo danych - tabela products zdefiniowana powyzej - zmienna zdefiniowana w jquery.dataTables.js
		});
		
		
	}
	
	
	
	
});