<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bInfo</title>
</head>
<body>
	<div align="center">
		<h1> Board Info </h1>
	</div>
	<div align="center">
		<table border="1">
			<tr>
				<td>Board Number</td>
				<td>${bdto.num }</td>
			</tr>
				
			<tr>
				<td>ReadCount</td>
				<td>${bdto.readCount }</td>
			</tr>
			<tr>
				<td>Writer</td>
				<td>${bdto.writer }</td>
			</tr>
			<tr>
				<td>RegDate</td>
				<td>${bdto.regDate }</td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td>${bdto.email }</td>
			</tr>
			<tr>
				<td>Subject</td>
				<td>${bdto.subject }</td>
			</tr>
			<tr>
				<td>Content</td>
				<td>${bdto.content }</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><!-- reply/update/delete/main -->
					<button onclick="location.href='boardReplyWrite?num=${bdto.num}'">Reply</button>
					<button onclick="location.href='boardUpdate?num=${bdto.num}'">Update</button>
					<button onclick="location.href='boardDelete?num=${bdto.num}'">Delete</button>
					<button onclick="location.href='boardList'">Main</button>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>