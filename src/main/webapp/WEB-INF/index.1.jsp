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
			<h1>What is your question?</h1>

			<form method="POST" action="/create/question">
				<label name="products">Add Products:
					<p style="color:red">${errors1.errors1} ${errors4.errors4}</p>
					<textarea name="question" id="question" cols="50" rows="5"></textarea>
				</label>
				<br>
				<label name="tag">Add Tags:
					<p style="color:red">${errors3.errors3} ${errors2.errors2}</p>
					<input type="text" name="tag" >
				</label><br>
				<input type="submit" class="btn btn-primary" value="Submit" />
			</form>
		</div>
	</body>
</html>