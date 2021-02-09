<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>bSimpleList</title>
</head>
<body>
	<div align="center">
		<h1>
			MVC2_Model_Advance
		</h1>
		<table border="1">
			<div>
				<button onclick="location.href='boardWrite'">write</button>
			</div>
			<thead>
				<tr>
					<th>order</th>
					<th>subject</th>
					<th>writer</th>
					<th>regDate</th>
					<th>view</th> <!-- rCount -->
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${simpleList }">
					<tr align="center">
						<td>${board.num }</td>
						<td><a href="boardInfo?num=${board.num}">${board.subject }</a></td>
						<td>${board.writer }</td>
						<td><fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd" /></td>
						<td>${board.readCount }</td> <!-- rCount -->
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>