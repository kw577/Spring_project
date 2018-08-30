<p class="lead">Shop Name</p>
<div class="list-group">
	<!-- petla forEach z biblioteki jstl -->
	<c:forEach items="${categories}" var="category">
		<!-- Po kliknieciu przenosi na adres html onlineshopping/show/category/nrKategorii/products -->
		<a href="${contextRoot}/show/category/${category.id}/products" class="list-group-item">${category.name}</a> <!-- zmienna category utworzona w petli forEach -->

	</c:forEach>



</div>