<div class="container">

	<div class="row">
	
		<div class="col-md-offset-2 col-md-8">
		
			<div class="panel panel-primary">
			
				<div class="panel-heading">
				
					<h4>Product Management</h4>
				
				</div>
			
				<div class="panel-body">
					
					<!-- Form Elements - formularz zarzadzania produktami -->
					<form class="form-horizontal">
					
						<div class="form-group">
						
							<label class="control-label col-md-4" for="name">Enter Product Name:</label>
							<div class="col-md-8">
							
								<input type="text" name="name" id="name" placeholder="Product Name" class="form-control"> <!-- Placeholder - napisz w polu formularza wyswietlany zanim zacznie sie do niego cos wpisywac -->
								<em class="help-block">Please enter Product Name!</em>
							
							</div>
						
						</div>
						<div class="form-group">
						
							<label class="control-label col-md-4" for="brand">Enter Brand Name:</label>
							<div class="col-md-8">
							
								<input type="text" name="brand" id="brand" placeholder="Brand Name" class="form-control"> <!-- Placeholder - napisz w polu formularza wyswietlany zanim zacznie sie do niego cos wpisywac -->
								<em class="help-block">Please enter Brand Name!</em>
							
							</div>
						
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="description">Product Description</label>
							<div class="col-md-8">
								<textarea name="description" id="description" rows="4" placeholder="Write a desription"  class="form-control"></textarea><!-- Placeholder - napisz w polu formularza wyswietlany zanim zacznie sie do niego cos wpisywac -->			
							</div>
						</div>	
											
						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Enter Unit Price:</label>
							<div class="col-md-8">
								<input type="number" name="unitPrice" id="unitPrice" placeholder="Unit Price In &#8364;" class="form-control"> <!-- Placeholder - napisz w polu formularza wyswietlany zanim zacznie sie do niego cos wpisywac -->
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Quantity Available:</label>
							<div class="col-md-8">
								<input type="number" name="quantity" id="quantity" placeholder="Quantity available" class="form-control"> <!-- Placeholder - napisz w polu formularza wyswietlany zanim zacznie sie do niego cos wpisywac -->
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">Select Category:</label>
							<div class="col-md-8">
								<select class="form-control" id="categoryId" name="categoryId">
									<option value="1">Category One</option>
									<option value="2">Category Two</option>
								</select>
							</div>
						</div>
						
						
						
						
						<div class="form-group">
						

							<div class="col-md-offset-4 col-md-8">
							
								<input type="submit" name="submit" id="submit" value="Submit" class="btn btn-primary"> <!-- Placeholder - napisz w polu formularza wyswietlany zanim zacznie sie do niego cos wpisywac -->
							
							</div>
						
						</div>
						
					</form>
					
					
				</div>
			
			</div>
						
		</div> 
		
	</div>

</div>