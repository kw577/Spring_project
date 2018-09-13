<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>  <!-- przyjeto ze tagi rozpoczynajace sie od sf:  - naleza do funckja formularza Springa  -->
<div class="container">

	<div class="row">
	
	
	<!-- jesli obiekt message wygenerowany w klasie ManagementController showManageProducts nie jest pusty - a wiec udalo sie dodac obiekt--> 		
		<c:if test="${not empty message}">	
			
			<div class="col-xs-12 col-md-offset-2 col-md-8">			
				<div class="alert alert-success alert-dismissible">
				
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				
				</div>				
	
		</div>
	</c:if>
	
	
		<div class="col-md-offset-2 col-md-8">
		
			<div class="panel panel-primary">
			
				<div class="panel-heading">
				
					<h4>Product Management</h4>
				
				</div>
			
				<div class="panel-body">
					
					<!-- Form Elements - formularz zarzadzania produktami -->
					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products"
						method ="POST"
					> <!-- product - nazwa obiektu zwracanego w ManagementController.java przez metode showManageProducts() - nastepuje to polaczenia kontrolera ManagementController.java z tym formularzem-->
					
						<div class="form-group">
						
							<label class="control-label col-md-4" for="name">Enter Product Name:</label>
							<div class="col-md-8">
							
								<sf:input type="text" path="name" id="name" placeholder="Product Name" class="form-control"/> <!-- Placeholder - napisz w polu formularza wyswietlany zanim zacznie sie do niego cos wpisywac -->
								<!-- path="name" - odpowiada nazwie atrybutu klasy Product.java -->
							</div>
						
						</div>
						<div class="form-group">
						
							<label class="control-label col-md-4" for="brand">Enter Brand Name:</label>
							<div class="col-md-8">
							
								<sf:input type="text" path="brand" id="brand" placeholder="Brand Name" class="form-control"/> <!-- Placeholder - napisz w polu formularza wyswietlany zanim zacznie sie do niego cos wpisywac -->
								<!-- path="brand" - odpowiada nazwie atrybutu klasy Product.java -->
							</div>
						
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="description">Product Description</label>
							<div class="col-md-8">
								<sf:textarea path="description" id="description" rows="4" placeholder="Write a desription for the product"  class="form-control"/> <!-- Placeholder - napisz w polu formularza wyswietlany zanim zacznie sie do niego cos wpisywac -->			
								<!-- path="description" - odpowiada nazwie atrybutu klasy Product.java -->
							</div>
						</div>	
											
						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Enter Unit Price:</label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" id="unitPrice" placeholder="Unit Price In &#8364;" class="form-control"/> <!-- Placeholder - napisz w polu formularza wyswietlany zanim zacznie sie do niego cos wpisywac -->
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Quantity Available:</label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity" placeholder="Quantity available" class="form-control"/> <!-- Placeholder - napisz w polu formularza wyswietlany zanim zacznie sie do niego cos wpisywac -->
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">Select Category:</label>
							<div class="col-md-8">
								<sf:select class="form-control" id="categoryId" path="categoryId"
									items="${categories}" 
									itemLabel="name"
									itemValue="id"
								/> <!-- ${categories} - oznaczone jako @ModelAttribute("categories") w ManagementController.java -->
							</div>
						</div>
						
						
						
						
						<div class="form-group">
						

							<div class="col-md-offset-4 col-md-8">
							
								<input type="submit" name="submit" id="submit" value="Submit" class="btn btn-primary"> <!-- Placeholder - napisz w polu formularza wyswietlany zanim zacznie sie do niego cos wpisywac -->
							
								<!-- Pozostale atrubuty klasy Product.java ustawione jako "hidden" -->
								<sf:hidden path="id"/>
								<sf:hidden path="code"/>
								<sf:hidden path="supplierId"/>
								<sf:hidden path="active"/>
								<sf:hidden path="purchases"/>
								<sf:hidden path="views"/>
							</div>
						
						</div>
						
					</sf:form>
					
					
				</div>
			
			</div>
						
		</div> 
		
	</div>

</div>