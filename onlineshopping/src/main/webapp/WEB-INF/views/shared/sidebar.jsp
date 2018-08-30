<p class="lead">Shop Name</p>
<div class="list-group">
	<!-- petla forEach z biblioteki jstl -->
	<c:forEach items="${categories}" var="category">

		<a href="#" class="list-group-item">${category.name}</a> <!-- zmienna category utworzona w petli forEach -->

	</c:forEach>



</div>