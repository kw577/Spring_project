// podswietlanie aktualnie wybranej funkcji na pasku nawigacji - active menu

$(function() {
	// solving the active menu problem - aktualnie uruchomiony przycisk na pasku nawigacji jest podswietlony
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
		case 'Manage Products':
			$('#manageProducts').addClass('active'); // #manageProducts to id przycisku zdefiniowanego w navbar.jsp
			break;	
		default:
			if(menu == "Home") break;
			$('#listProducts').addClass('active'); 
			$('#a_'+menu).addClass('active'); // '#a_'+menu to id przycisku zdefiniowanego w side.jsp
			break;	
	
	}
		
	// ten skrypt jest uruchamiany w page.jsp - ktory zawiera odniesienia do plikow navbar.jsp, sidebar.jsp - a w tych plikach jes zdefiniowany elementy o id #about, #contact itd.
	
	// !!!!!!!!!!!!!!!!!!!!!!!
	// nalezy czasami wyczyscic historie przegladarki internetowej bo pliki moga byc przechowywane w pamieci cache przegladdarki
	// !!!!!!!!!!!!!!!!!!!!!!!
	
	
	// code for JQuery dataTable  - tabela do wyswietlania listy produktow
	// code for jquery dataTable
	// create a dataset
	// stale dane do celow testowych 
	/*
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
	*/
	var $table = $('#productListTable'); // productListTable - to id tabeli w listProducts.jsp
	
	// kod ponizej jest wykonywany gdy tabela o id productListTable (plik listProducts.jsp) nie jest pusta
	if($table.length) { 
		//console.log('Inside the table!');
		
		var jsonUrl = '';
		if(window.categoryId == '') { // uzytkownik chce wyswietlic wszystkie produkty - nie wybral kategorii
			// zmienna pomocnicza categoryId utworzona w listProducts.jsp
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}
		else { // uzytkownik wybral kategorie dla ktorej chce wyswietlic wszystkie produkty
			jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId +'/products';
		}
		
		
		
		// formatowanie tablei wyswietlajacej produkty
		$table.DataTable( { // zmienna zdefiniowana w jquery.dataTables.js
			// ustawienie parametrow tabeli
			lengthMenu: [[3,5,10,-1], ['3 Records', '5 Records', '10 Records', 'ALL']], // zmienna zdefiniowana w jquery.dataTables.js - zmienna okresla - lista rozwijana z iloscia produktow jakie ma wyswietlac tabela
			pageLength: 5, // zmienna zdefiniowana w jquery.dataTables.js
			//data: products // do celow testowych - zrodlo danych - tabela products zdefiniowana powyzej - zmienna zdefiniowana w jquery.dataTables.js
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
						{
			        	  data: 'code',
			        	  bSortable: false,
			        	  mRender: function(data, type, row) {
			        		  
			        		  return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
			        		  
			        	}
		          		},
						{
							data: 'name' // odpowiada nazwie atrybutow w zwracanym pliku json (bedzie wiec rowniez odpowiadac nazwie atrybutow klasy Product)
						},
						{
							data: 'brand'
						},
						{
							data: 'unitPrice',
							mRender: function(data, type, row) {
				        		  return '&#8364; ' + data //'&#8364; ' HTML ENTITY CODE  - generuje nietypowy znak - symbol waluty
				        	}
						},
						{
				        	  data: 'quantity',
				        	  mRender: function(data, type, row) {
					        		
				        		  if(data < 1) { // jesli ilosc szt. danego produktu jest < 1 pojawi sie dodatkowy komunikat na czerwono
				        			  return '<span style="color:red">Out of Stock!</span>';
				        		  }
				        		  
				        		  return data;
				        	  }
				        },
				        {
				        	  data: 'id',
				        	  bSortable: false, //wylazenie funkcji sortowania potej kolumnie
				        	  mRender: function(data, type, row) {
				        		  // dodanie przycisku podgladu oraz dodania do koszyka (glyphicon - funkcja tym przypisane beda ikonki zamiast napisu)
				        		  var str = '';
				        		  str += '<a href="'+window.contextRoot+ '/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
				        		  
				        		  if(row.quantity < 1) { // jesli ilosc szt. danego produktu < 1 - przycisk dodawania produktu do koszyka jest nieaktywny 
				        			  str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
				        		  }
				        		  else {
				        			  
				        			  str += '<a href="'+window.contextRoot+ '/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';  
				        		  }
				        		  
				        		  return str;
				        	  }
				        	  
				          }
						
						]
			
			 
			
			
		});
		
		
	}
	
	// !!!!!!!!!!!!!!!!!!!!!!!
	// nalezy czasami wyczyscic historie przegladarki internetowej bo pliki moga byc przechowywane w pamieci cache przegladdarki
	// !!!!!!!!!!!!!!!!!!!!!!!
	
	
	
	
	
	// usuniecie okna z informacja o dodaniu nowego produktu (po 3 sekundach)
	var $alert = $('.alert');
	if($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000);
	}
	
	
	// -----------------
	
	// Aktywacja i dezaktywacja produktu przez administratora
	// okno dialogowe ktore poajwia sie gdy admin nacisnie przelacznie dezaktywacji produktu
	$('.switch input[type="checkbox"]').on('change' , function() {							
					
		var checkbox = $(this);
		var checked = checkbox.prop('checked');
		var dMsg = (checked)? 'You want to activate the product?':
							  'You want to deactivate the product';
		
		
		var value = checkbox.prop('value');
		
		// okno dialogowe z wykorzystaniem BootBox.js
		bootbox.confirm({
			size: 'medium',
			title: 'Product Activation & Deactivation',
			message: dMsg,
			callback: function(confirmed){
				
				if(confirmed){
					// po potwierdzeniu pojawia sie kolejne okno z informacja
					console.log(value);
					bootbox.alert({
						size: 'medium',
						title: 'Information',
						message: 'You are going to perform operation on product' + value
					});
					
				}
				else{
					checkbox.prop('checked', !checked);
				}
			}
			
		});
		
		
	});
	
	
	
	//---------------------------
	// data table for admin - na podstawie wczesniejszej tabeli dla uzytkownikow sklepu - z wykorzystaniem dataTable.js
	//---------------------------
	
	var $adminProductstable = $('#adminProductsTable'); // adminProductsTable  - id tabeli zdefiniowanej w manageProducts.jsp
	
	// kod ponizej jest wykonywany gdy tabela o id productListTable (plik listProducts.jsp) nie jest pusta
	if($adminProductstable.length) { 
		
		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
		
		
		
		// formatowanie tablei wyswietlajacej produkty
		$adminProductstable.DataTable( { // zmienna zdefiniowana w jquery.dataTables.js
			// ustawienie parametrow tabeli
			lengthMenu: [[10,30,50,-1], ['10 Records', '30 Records', '50 Records', 'ALL']], // zmienna zdefiniowana w jquery.dataTables.js - zmienna okresla - lista rozwijana z iloscia produktow jakie ma wyswietlac tabela
			pageLength: 30, // zmienna zdefiniowana w jquery.dataTables.js
			//data: products // do celow testowych - zrodlo danych - tabela products zdefiniowana powyzej - zmienna zdefiniowana w jquery.dataTables.js
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
						{
							data: 'id'
						},
						{
			        	  data: 'code',
			        	  bSortable: false,
			        	  mRender: function(data, type, row) {
			        		  
			        		  return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="adminDataTableImg"/>';
			        		  
			        	}
		          		},
						{
							data: 'name' // odpowiada nazwie atrybutow w zwracanym pliku json (bedzie wiec rowniez odpowiadac nazwie atrybutow klasy Product)
						},
						{
							data: 'brand'
						},
						{
				        	  data: 'quantity',
				        	  mRender: function(data, type, row) {
					        		
				        		  if(data < 1) { // jesli ilosc szt. danego produktu jest < 1 pojawi sie dodatkowy komunikat na czerwono
				        			  return '<span style="color:red">Out of Stock!</span>';
				        		  }
				        		  
				        		  return data;
				        	  }
				        },
						{
							data: 'unitPrice',
							mRender: function(data, type, row) {
				        		  return '&#8364; ' + data //'&#8364; ' HTML ENTITY CODE  - generuje nietypowy znak - symbol waluty
				        	}
						},
				        {
				        	  data: 'active',
				        	  bSortable: false,
				        	  mRender: function(data, type, row){
				        		  var str = '';
				        		
				        		  
				        		//renderowanie przelacznika aktywny - nieaktywny 
								str += '<label class="switch">'
									
								if(data){
									str += '<input type="checkbox" checked="checked" value="'+row.id+'"/>'
								}
								else{
									str += '<input type="checkbox" value="'+row.id+'"/>'
								}
									
								str += '<div class="slider"></div></label>'
									
									return str;
								
				        	  }
				        	  
				          },
				          {
				        	  data: 'id',
				        	  bSortable: false,
				        	  mRender: function(data, type, row){
				        		 
				        		  var str = '';
				        		  // przycisk przenoszacy do strony edycji produktu
				  				str += '<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning">';
								str += '<span class="glyphicon glyphicon-pencil"></span></a>'
							
				        		return str;
				        		  
				        	  }
				          }
						
						],
						
						initComplete: function() {
							var api = this.api();
							
							
							// Aktywacja i dezaktywacja produktu przez administratora 
							// okno dialogowe ktore poajwia sie gdy admin nacisnie przelacznie dezaktywacji produktu
							api.$('.switch input[type="checkbox"]').on('change' , function() {							
											
								var checkbox = $(this);
								var checked = checkbox.prop('checked');
								var dMsg = (checked)? 'You want to activate the product?':
													  'You want to deactivate the product';
								
								
								var value = checkbox.prop('value');
								
								// okno dialogowe z wykorzystaniem BootBox.js
								bootbox.confirm({
									size: 'medium',
									title: 'Product Activation & Deactivation',
									message: dMsg,
									callback: function(confirmed){
										
										if(confirmed){
											// po potwierdzeniu pojawia sie kolejne okno z informacja
											console.log(value);
											
											//update produktu w bazie danych z wykorzystaniem AJAX
											var activationUrl = window.contextRoot + '/manage/product/' + value + '/activation';
											
											$.post(activationUrl, function(data) {
												bootbox.alert({
													size: 'medium',
													title: 'Information',
													message: data
												});
											})
											
											
											//------------------------------------
											

											
										}
										else{
											checkbox.prop('checked', !checked);
										}
									}
									
								});
								
								
							});
						}
			
			 
			
			
		});
		
		
	}
	
	
	
	
	//-----------------------
	// jquery validator - walidacja dodawania nowej kategorii
	$categoryForm = $('#categoryForm'); // categoryForm to id przypisane do formularza Spring w manageProducts.jsp
	
	if($categoryForm.length) {//jesli faormularz jest niepusty
		
		$categoryForm.validate({			
				rules: {
					name: {//pole o id name w formularzu
						required: true,
						minlength: 3
					},
					description: { //pole o id desription w formularzu
						required: true,
						minlength: 3					
					}				
				},
				messages: {					
					name: {
						required: 'Please add the category name!',
						minlength: 'The category name should not be less than 3 characters'
					},
					description: {
						required: 'Please enter category name!',
						minlength: 'Please enter atleast 3 characters'
					}					
				},
				errorElement : "em",
				errorPlacement : function(error, element) {
					
					error.addClass('help-block');
					
					//informacja o bledzie dodana pod polem ktorego ten blad dotyczy
					error.insertAfter(element);
					
					//errorPlacement(error, element);
				}				
			}
		
		);
		
	}
	
	//-----------------------
	
});