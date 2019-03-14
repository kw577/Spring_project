
		</div>

		<!-- Footer - w tym miejscu jest wstawiony kod z pliku footer.jsp -->
		<%@include file="../../shared/footer.jsp"%>

		<!-- Korzysta ze zmiennych utworzonych np w  <spring:url var="js" value="/resources/js"/>  -->
		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>
		
		<!-- jQuery validator -->
		<script src="${js}/jquery.validate.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>

		<!-- DataTable Plugin - jQuery - tabela do wyswietlania produktow -->
		<script src="${js}/jquery.dataTables.js"></script>

		<!-- DataTable Bootstrap Script - jQuery - tabela do wyswietlania produktow - wazna jest kolejnosc linkowania tych plikow .js-->
		<script src="${js}/dataTables.bootstrap.js"></script>

		<!-- DBootbox - okno dialogowe -->
		<script src="${js}/bootbox.min.js"></script>

		<!-- Self coded javascript - Active menu - podswietlanie aktualnie wybranej opcji na pasku nawigacji -->
		<script src="${js}/myapp.js"></script>

	</div>

</body>

</html>