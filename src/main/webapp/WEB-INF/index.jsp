<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="/css/style.css">
	</head>

	<body>
		<div class="container">
			<h1>Questions Dashboard</h1>

			<table class="table table-striped" style>
				<thead>
					<tr>
						<th>questions</th>
						<th>Tags</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${questions}" var="question">
						<tr>
							<td><a href="/answer/${question.id}">${question.question}</a></td>
							<td>
							<c:forEach items="${question.qtags}" var="tag">
								<p>${tag.subject}</p>
							</c:forEach>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="/question/new" style="float:right">New Question</a>
		</div>
	</body>
</html>
