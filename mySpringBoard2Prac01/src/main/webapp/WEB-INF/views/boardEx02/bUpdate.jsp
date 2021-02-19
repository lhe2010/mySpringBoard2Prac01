<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bUpdate</title>
</head>
<body>
	<div align="center">
		<h1> Board Update </h1>
	</div>
	<div align="center">
		
		<form action="boardUpdate" method="post">
			<table border="1">
				<tr>
					<td align="center">Writer</td>
					<td>${bdto.writer }</td>
				</tr>
				<tr>
					<td>RegDate</td>
					<td>${bdto.regDate }</td>
				</tr>
				<tr>
					<td align="center">Subject</td>
					<td><input type="text" id="subject" name="subject" value="${bdto.subject }"></td>
				</tr>
				<tr>
					<td align="center"><span style="color:red">*</span>password</td>
					<td><input type="password" id="password" name="password"></td>
				</tr>
				<tr>
					<td align="center">Content</td>
					<td><textarea rows="10" cols="50" id="content" name="content">${bdto.content }</textarea></td>
				</tr>
				<tr align="center">
					<td colspan="2">
						<input type="hidden" name="num" value="${bdto.num }">
						<input type="submit" value="Modify">
						<input type="reset" value="Reset">
						<input type="button" value="Main" onclick="location.href='boardList'">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>