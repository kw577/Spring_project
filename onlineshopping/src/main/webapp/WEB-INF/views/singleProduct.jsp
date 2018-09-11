<div class="container">

	<!-- Breadcrumb -->
	<div class="row">
		
		<div class="col-xs-12">
		
			
			<ol class="breadcrumb">
			
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">Products</a></li>
				<li class="active">${product.name}</li>
			
			</ol>
		
		
		</div>
	
	
	</div>
	
	
	<div class="row">
	
		<!-- Display the product image -->
		<div class="col-xs-12 col-sm-4">
		
			<div class="thumbnail">
							
				<img src="${images}/${product.code}.jpg" class="img img-responsive"/>
						
			</div>
		
		</div>
	
		
		<!-- Display the product description -->	
		<div class="col-xs-12 col-sm-8">
		
			<h3>${product.name}</h3>
			<hr/>
			
			<p>${product.description}</p>
			<hr/>
			
			<h4>Price: <strong> &#8364; ${product.unitPrice} /-</strong></h4>
			<hr/>	
					
			<!-- c:choose - funkcja z biblioteki jstl - jesli ilosc dostepnych szt. danego produktu < 1 wyswitetli sie dodatkowy komunikat-->
			<c:choose>
				<c:when test="${product.quantity < 1}">
					<h6>Qty. Available: <span style="color:red">Out of Stock!</span></h6>
				</c:when>
				<c:otherwise>
					<h6>Qty. Available: ${product.quantity}</h6>
				</c:otherwise>
			</c:choose>
					
					
			<!-- Przycisk dodawania produktu od koszyka bedzie aktywny gdy ilosc szt. danego produtu jest > 0 -->		
			<c:choose>
				<c:when test="${product.quantity < 1}">
					<!-- Przycisk dodania produktu do koszyka - nieaktywny - link href jest nieaktywny - strike - oznacza przekreslony tekst -->
					<a href="javascript:void(0)" class="btn btn-success disabled"><strike>
					<span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart</strike></a>
				</c:when>
				<c:otherwise>
					<!-- Przycisk dodania produktu do koszyka - link do kolejnego widoku - aktywny-->
					<a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success">
					<span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart</a>
				</c:otherwise>
			</c:choose>	
					
					
			
			<!-- Przycisk powrotu do widoku wszystkich produktow - poprzez dopowiedni link -->
			<a href="${contextRoot}/show/all/products" class="btn btn-primary">
				Back</a>
					
		</div>

	
	</div>

</div>