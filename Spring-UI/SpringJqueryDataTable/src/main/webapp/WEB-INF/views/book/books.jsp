<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>List Of Books</title>
<link rel="stylesheet" 	href='<c:url value="/web-resources/lib/bootstrap-3.3.6/css/bootstrap.min.css"/>'>
<link rel="stylesheet" 	href='<c:url value="/web-resources/lib/jquery/jquery-ui-1.10.4.custom.css"/>'>
<link href='<c:url value="/web-resources/css/jquery.dataTables.min.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="/web-resources/css/buttons.dataTables.min.css"/>' rel="stylesheet" type="text/css">

<style type="text/css">
th {
	text-align: left
}
</style>
</head>

<body>
	<div style="width: 95%; margin: 0 auto;">

		<div id="bookDialog" style="display: none;">
			<%@ include file="bookForm.jsp"%>
		</div>

		<h1>List Of Books</h1>

		<button class="btn btn-primary" onclick="addBook()">
			<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Add Book
		</button><br>
		<br>
		<table id='example23' class='display nowrap' cellspacing='0' width='100%'>
			<thead>
				<tr>
					<th width="4%">S.N</th>
					<th width="12%">Name</th>
					<th width="12%">Code</th>
					<th width="12%">Price</th>
					<th width="12%">Authors</th>
					<th width="12%">ISBN</th>
					<th width="12%">Publisher</th>
					<th width="12%">Published On</th>
					<th width="12%"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${bookList}" var="book" varStatus="loopCounter">
					<tr>
						<td><c:out value="${loopCounter.count}" /></td>
						<td><c:out value="${book.name}" /></td>
						<td><c:out value="${book.code}" /></td>
						<td><c:out value="${book.price}" /></td>
						<td><c:out value="${book.authors}" /></td>
						<td><c:out value="${book.isbn}" /></td>
						<td><c:out value="${book.publisher}" /></td>
						<td><c:out value="${book.publishedOn}" /></td>

						<td><nobr>
								<button class="btn btn-primary"
									onclick="editBook(${book.id});">

									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Edit
								</button>

								<a class="btn btn-primary"
									onclick="return confirm('Are you sure you want to delete this book?');"
									href="delete/${book.id}"> 
									<span class="glyphicon glyphicon-trash" aria-hidden="true"></span> Delete
								</a>

							</nobr></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

	<!--  It is advised to put the <script> tags at the end of the document body so they don't block rendering of the page -->
	<script type="text/javascript" src='<c:url value="/web-resources/lib/jquery/jquery-1.10.2.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/web-resources/lib/jquery/jquery-ui-1.10.4.custom.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/web-resources/lib/jquery/jquery.ui.datepicker.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/web-resources/lib/bootstrap-3.3.6/js/bootstrap.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/web-resources/js/js-for-listBooks.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/web-resources/js/custom.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/web-resources/js/jquery.dataTables.min.js"/>'></script>
	<!-- start - This is for export functionality only -->
	<script type="text/javascript" src='<c:url value="/web-resources/js/export/dataTables.buttons.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/web-resources/js/export/buttons.flash.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/web-resources/js/export/jszip.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/web-resources/js/export/pdfmake.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/web-resources/js/export/vfs_fonts.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/web-resources/js/export/buttons.html5.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/web-resources/js/export/buttons.print.min.js"/>'></script>
	<!-- end - This is for export functionality only -->
	<script>
	    
	    $('#example23').DataTable( {
	        dom: 'Bfrtip',
	        buttons: [
	            'copy', 'csv', 'excel', 'pdf', 'print'
	        ]
	    });
	  </script>	
</body>
</html>