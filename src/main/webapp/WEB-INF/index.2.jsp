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
			<h1>${question.question}</h1>
			<div class="row">
				<div class="col-xs-6">
					<h3>Tags</h3>
					<c:forEach items="${question.qtags}" var="tag">
						<button>${tag.subject}</button>
					</c:forEach>
					<table class="table table-striped" style>
						<thead>
							<tr>
								<th>Answers</th>
							</tr>
						</thead>
						<tbody>
								<c:forEach items="${answers}" var="answer">
									<tr>
									<c:if test="${answer.question.id == question.id}">
										<td>${answer.answer}</td>
									</c:if>
									</tr>
								</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="col-xs-6">
					<h3>Add your answer:</h3>
					<form method="POST" action="/answer/new/${question.id}">
						<label name="newanswer">Add Products:
							<textarea name="answer" id="answer" cols="50" rows="5"></textarea>
						</label>
						<br>
						<input type="submit" class="btn btn-primary" value="Answer it!" />
					</form>
				</div>
			</div>
			<a href="/" style="float:right">New Question</a>
		</div>
	</body>
</html>