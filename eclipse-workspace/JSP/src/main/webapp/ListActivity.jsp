<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>

<head>
<title>User ToDolist Activity</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>
	<%
	if (session.getAttribute("email") == null) {
		response.sendRedirect("login.jsp");
	}
	%>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Activity</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${activity != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${activity == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${activity != null}">
                                    Edit Activity
                                </c:if>
						<c:if test="${activity == null}">
                                    Add New Activity
                                </c:if>
					</h2>
				</caption>

				<c:if test="${activity != null}">
					<input type="hidden" name="id"
						value="<c:out value='${activity.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Activity</label> <input type="text"
						value="<c:out value='${activity.activity}' />"
						class="form-control" name="activity" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Description</label> <input type="text"
						value="<c:out value='${activity.description}' />"
						class="form-control" name="description">
				</fieldset>

				<fieldset class="form-group">
					<label>Date</label> <input type=value=
						"<c:out value='${activity.date}' />" class="form-control"
						name="date">
				</fieldset>
				<fieldset class="form-group">
					<label>status</label> <input type="text"
						value="<c:out value='${activity.status}' />" class="form-control"
						name="status">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>