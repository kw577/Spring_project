<div class="container">

	<div class="row">

		<!-- Display sidebar -->
		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp" %>


		</div>

		<!-- Display products -->

		<div class="col-md-9">
			<!-- Added breadcrumb compponent - its included in bootstrap - Indicate the current page location within a navigational hierarchy that automatically adds separators via CSS-->
		
			<div class="row">

				<div class="col-lg-12">
					
					<!-- Wyswietla ta zawartosc jesli uzytkownik kliknie "All Products" -->
					<c:if test="${userClickAllProducts == true }">
						
						<script>
							window.categoryId = '';
						</script>
						
						<ol class="breadcrumb"> 
					
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li> 
					
						</ol>
					</c:if>
					<!-- window.nazwaZmiennej  -  oznacza zmienne globalne - window to obiekt przechowujacy zmienne globalne -->
					<!-- Wyswietla ta zawartosc jesli uzytkownik wybierz okreslona kategorie  -->
					<c:if test="${userClickCategoryProducts == true }">
						<script>
							window.categoryId = '${category.id}';
						</script>
						<ol class="breadcrumb"> <!-- Wyswietla w formacie np.:   Home/Category/Television   (Home jest linkiem do strony glownej) -->
					
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>  <!-- Obiekt category generowany w PageController.java -->
						</ol>
					</c:if>
					
					
				</div>
			</div>



			<div class="row">
			
				<div class="col-xs-12">
				
					
					<table id="productListTable" class="table table-striped table-borderd">
					
					
						<thead>
						
							<tr>
								<th></th> <!-- ta kolumna przechowuje zdjecie -->
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>
								<th></th> <!-- ta kolumna przechowuje przyciski akcji podgladu produktu i dodania go do koszyka -->
							
							</tr>
						
						</thead>
					

						<tfoot>
						
							<tr>
								<th></th> 
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>
								<th></th>
							
							</tr>
						
						</tfoot>
					
					
					</table>
				
				</div>
			
			</div>
			
			
			</div>

		</div>
	</div>




</div>