<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bWrite</title>
</head>
<body>

	<div align="center">
	
		<h1>Board Write</h1>
		
		<form action="boardWrite" method="post">
			<table border="1">
				<tr>
					<td align="center"><span style="color:red">*</span>Writer</td>
					<td><input type="text" id="writer" name="writer"></td>
				</tr>
				<tr>
					<td align="center"><span style="color:red">*</span>subject</td>
					<td><input type="text" id="subject" name="subject"></td>
				</tr>
				<tr>
					<td align="center"><span style="color:red">*</span>email</td>
					<td><input type="email" id="email" name="email"></td>
				</tr>
				<tr>
					<td align="center"><span style="color:red">*</span>password</td>
					<td><input type="password" id="password" name="password"></td>
				</tr>
				<tr>
					<td align="center">Content</td>
					<td><textarea rows="10" cols="50" id="content" name="content"></textarea></td>
				</tr>
				<tr align="center">
					<td colspan="2">
						<input type="submit" value="Write">
						<input type="reset" value="Reset">
						<input type="button" value="Main" onclick="location.href='boardList'">
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>