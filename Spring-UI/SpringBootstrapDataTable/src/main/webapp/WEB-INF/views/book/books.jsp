<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>List Of Books</title>
<link rel="stylesheet" 	href='<c:url value="/web-resources/lib/jquery/jquery-ui-1.10.4.custom.css"/>'>
<link href='<c:url value="/web-resources/css/buttons.dataTables.min.css"/>' rel="stylesheet" type="text/css">
<link rel="stylesheet"	href='<c:url value="/web-resources/lib/bootstrap-3.3.6/css/bootstrap.min.css"/>'>
<link href='<c:url value="/web-resources/bootstrapdatatable/css/dataTables.bootstrap.min.css"/>' rel="stylesheet">
<link href='<c:url value="/web-resources/bootstrapdatatable/css/buttons.bootstrap.min.css"/>' rel="stylesheet">
<link href='<c:url value="/web-resources/bootstrapdatatable/css/fixedHeader.bootstrap.min.css"/>' rel="stylesheet">
<link href='<c:url value="/web-resources/bootstrapdatatable/css/responsive.bootstrap.min.css"/>' rel="stylesheet">
<link href='<c:url value="/web-resources/bootstrapdatatable/css/scroller.bootstrap.min.css"/>' rel="stylesheet">

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
		<table id='datatable-buttons' class='table table-striped table-bordered' cellspacing='0' width='100%'>
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
	
	 <!-- jQuery -->
    <script type="text/javascript" src='<c:url value="/web-resources/lib/jquery/jquery.min.js"/>'></script>
    <!-- Bootstrap -->
    <script type="text/javascript" src='<c:url value="/web-resources/lib/bootstrap-3.3.6/js/bootstrap.min.js"/>'></script>
     <!-- Datatables -->
	<script src='<c:url value="/web-resources/bootstrapdatatable/js/jquery.dataTables.min.js"/>'></script>
	<script src='<c:url value="/web-resources/bootstrapdatatable/js/dataTables.bootstrap.min.js"/>'></script>
	<script src='<c:url value="/web-resources/bootstrapdatatable/js/dataTables.buttons.min.js"/>'></script>
	<script src='<c:url value="/web-resources/bootstrapdatatable/js/buttons.bootstrap.min.js"/>'></script>
	<script src='<c:url value="/web-resources/bootstrapdatatable/js/buttons.flash.min.js"/>'></script>
	<script src='<c:url value="/web-resources/bootstrapdatatable/js/buttons.html5.min.js"/>'></script>
	<script src='<c:url value="/web-resources/bootstrapdatatable/js/buttons.print.min.js"/>'></script>
	<script src='<c:url value="/web-resources/bootstrapdatatable/js/dataTables.fixedHeader.min.js"/>'></script>
	<script src='<c:url value="/web-resources/bootstrapdatatable/js/dataTables.responsive.min.js"/>'></script>
	<script src='<c:url value="/web-resources/bootstrapdatatable/js/responsive.bootstrap.js"/>'></script>
	<script src='<c:url value="/web-resources/bootstrapdatatable/js/jszip.min.js"/>'></script>
	<script src='<c:url value="/web-resources/bootstrapdatatable/js/pdfmake.min.js"/>'></script>
	<script src='<c:url value="/web-resources/bootstrapdatatable/js/vfs_fonts.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/web-resources/js/js-for-listBooks.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/web-resources/lib/jquery/jquery-ui-1.10.4.custom.js"/>'></script>
	   <!-- Datatables -->
    <script>
      $(document).ready(function() {
        var handleDataTableButtons = function() {
          if ($("#datatable-buttons").length) {
            $("#datatable-buttons").DataTable({
              dom: "Bfrtip",
              buttons: [
                {
                  extend: "copy",
                  className: "btn-sm"
                },
                {
                  extend: "csv",
                  className: "btn-sm"
                },
                {
                  extend: "excel",
                  className: "btn-sm"
                },
                {
                  extend: "pdfHtml5",
                  className: "btn-sm"
                },
                {
                  extend: "print",
                  className: "btn-sm"
                },
              ],
              responsive: true
            });
          }
        };

        TableManageButtons = function() {
          "use strict";
          return {
            init: function() {
              handleDataTableButtons();
            }
          };
        }();
       TableManageButtons.init();
      });
    </script>
    <!-- /Datatables -->
</body>
</html>