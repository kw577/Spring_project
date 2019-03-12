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
						enctype="multipart/form-data"
					> <!-- product - nazwa obiektu zwracanego w ManagementController.java przez metode showManageProducts() - nastepuje to polaczenia kontrolera ManagementController.java z tym formularzem-->
					
						<div class="form-group">
						
							<label class="control-label col-md-4" for="name">Enter Product Name:</label>
							<div class="col-md-8">
							
								<sf:input type="text" path="name" id="name" placeholder="Product Name" class="form-control"/> <!-- Placeholder - napisz w polu formularza wyswietlany zanim zacznie sie do niego cos wpisywac -->
								<!-- path="name" - odpowiada nazwie atrybutu klasy Product.java -->
								<sf:errors path="name" cssClass="help-block" element="em"/> <!-- wiadomosc pochadzaca z Hibernate Validator - zdefiniowana w Product.java - wyswietli sie gdy to pole formularza nie spelnia warunku walidacji -->
							</div>
						
						</div>
						<div class="form-group">
						
							<label class="control-label col-md-4" for="brand">Enter Brand Name:</label>
							<div class="col-md-8">
							
								<sf:input type="text" path="brand" id="brand" placeholder="Brand Name" class="form-control"/> <!-- Placeholder - napisz w polu formularza wyswietlany zanim zacznie sie do niego cos wpisywac -->
								<!-- path="brand" - odpowiada nazwie atrybutu klasy Product.java -->
								<sf:errors path="brand" cssClass="help-block" element="em"/> <!-- wiadomosc pochadzaca z Hibernate Validator - zdefiniowana w Product.java - wyswietli sie gdy to pole formularza nie spelnia warunku walidacji -->
							</div>
						
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="description">Product Description</label>
							<div class="col-md-8">
								<sf:textarea path="description" id="description" rows="4" placeholder="Write a desription for the product"  class="form-control"/> <!-- Placeholder - napisz w polu formularza wyswietlany zanim zacznie sie do niego cos wpisywac -->			
								<!-- path="description" - odpowiada nazwie atrybutu klasy Product.java -->
								<sf:errors path="description" cssClass="help-block" element="em"/> <!-- wiadomosc pochadzaca z Hibernate Validator - zdefiniowana w Product.java - wyswietli sie gdy to pole formularza nie spelnia warunku walidacji -->
							</div>
						</div>	
											
						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Enter Unit Price:</label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" id="unitPrice" placeholder="Unit Price In &#8364;" class="form-control"/> <!-- Placeholder - napisz w polu formularza wyswietlany zanim zacznie sie do niego cos wpisywac -->
								<sf:errors path="unitPrice" cssClass="help-block" element="em"/> <!-- wiadomosc pochadzaca z Hibernate Validator - zdefiniowana w Product.java - wyswietli sie gdy to pole formularza nie spelnia warunku walidacji -->
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Quantity Available:</label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity" placeholder="Quantity available" class="form-control"/> <!-- Placeholder - napisz w polu formularza wyswietlany zanim zacznie sie do niego cos wpisywac -->
							</div>
						</div>
						
						<!-- Upload plikow - z wykorzystaniem multipart -->
						<div class="form-group">
							<label class="control-label col-md-4" for="file">Select an Image: </label>
							<div class="col-md-8">
								<sf:input type="file" path="file" id="file" class="form-control"/> <!-- Placeholder - napisz w polu formularza wyswietlany zanim zacznie sie do niego cos wpisywac -->
								<sf:errors path="file" cssClass="help-block" element="em"/> <!-- wiadomosc pochadzaca z Hibernate Validator - zdefiniowana w Product.java - wyswietli sie gdy to pole formularza nie spelnia warunku walidacji -->
							</div> <!-- form-control - to klasa Bootstrap -->
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">Select Category:</label>
							<div class="col-md-8">
								<sf:select class="form-control" id="categoryId" path="categoryId"
									items="${categories}" 
									itemLabel="name"
									itemValue="id"
								/> <!-- ${categories} - oznaczone jako @ModelAttribute("categories") w ManagementController.java -->
								<!-- Przycisk widoczny jedynie przy dodawaniu nowego produktua -->
								<c:if test="${product.id == 0}">
										
									<div class="text-right">
										<br/>
										<button type="button" data-toggle="modal" data-target="#myCategoryModal" class="btn btn-warning btn-xs">Add Category</button>		
									</div>
									
								</c:if>
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
	
	<!-- Definicja okna dialogowego bootstrap - pojawia sie przy dodawaniu nowej kategorii -->
	<div class="row">
	
		<div class="modal fade" id="myCategoryModal" role="dialog" tabindex="-1">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span>&times;</span>
							
						</button>
						<h4 class="modal-title">Add New CAtegory</h4>
					</div>
					<div class="modal-body">
						<!-- Formularz dodawnia kategorii - spring form -->
						<sf:form modelAttribute="category" action="${contextRoot}/manage/category" method="POST" class="form-horizontal">
						
						
							<div class="form-group">
								<label for="category_name" class="control-label col-md-4">Category Name</label>
								<div class="col-md-8">
									<sf:input type="text" path="name" id="category_name" class="form-control" placeholder="Category Name" />
								
								</div>
							</div>
							<div class="form-group">
								<label for="category_description" class="control-label col-md-4">Category Description</label>
								<div class="col-md-8">
									<sf:textarea cols="" rows="5" path="description" class="form-control" id="category_description" placeholder="Enter category description here!" />
								</div>
							</div>
						
							<div class="form-group">
								<div class="col-md-offset-4 col-md-8">
									<input type="submit" value="Add Category" class="btn btn primary"/>
								</div>
							</div>
						
						
						</sf:form>
					</div>
				</div>
			
			</div>
		
		</div>
	
	</div>
	
	
	
	
	<div class="row">
		<div class="col-xs-12">
			<h3>Available Products</h3>
		</div>
		
		<div class="col-xs-12">
			<div style="overflow:auto">
			
				
					<!-- Products table for Admin -->				
					<table id="adminProductsTable" class="table table-striped table-borderd">
					
					
						<thead>
						
							<tr>
								<th>Id</th>
								<th>&#160</th> 
								<th>Name</th>
								<th>Brand</th>
								<th>Quantity</th>
								<th>Unit Price</th>
								<th>Active</th>
								<th>Edit</th>
							
							</tr>
						
						</thead>
					
				

						<tfoot>
						
							<tr>
								<th>Id</th>
								<th>&#160</th> 
								<th>Name</th>
								<th>Brand</th>
								<th>Quantity</th>
								<th>Unit Price</th>
								<th>Active</th>
								<th>Edit</th>
							
							</tr>
						
						</tfoot>
					
					
					</table>
				
				
			
			</div>
		</div>
	
	</div>
	
	
	
	
</div>