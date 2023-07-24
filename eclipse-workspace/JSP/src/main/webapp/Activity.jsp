<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>

<head>
<title>ToDolist Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");

	if (session.getAttribute("email") == null)
	{
		response.sendRedirect("login.jsp");
	}
	%>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="navbar-brand">Activity</a></li>
			</ul>
			<div>


				<a href="login.jsp" class="navbar-brand"> logout</a>
			</div>
		</nav>
	</header>
	<br>

	<div class="row">


		<div class="container">
			<h3 class="text-center">List of Activity</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Activity</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>ACTIVITY</th>
						<th>DESCRIPTION</th>
						<th>DATE</th>
						<th>STATUS</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="activity" items="${activity}">

						<tr>
							<td><c:out value="${activity.id}" /></td>
							<td><c:out value="${activity.activity}" /></td>
							<td><c:out value="${activity.description}" /></td>
							<td><c:out value="${activity.date}" /></td>
							<td><c:out value="${activity.status}" /></td>

							<td><a href="edit?id=<c:out value='${activity.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${activity.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>