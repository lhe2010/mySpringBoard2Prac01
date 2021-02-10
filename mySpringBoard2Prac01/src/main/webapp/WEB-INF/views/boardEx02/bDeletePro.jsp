<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DeletePro</title>
</head>
<body>
	<c:choose>
		<c:when test="${success eq true}">
			<script>
				alert("삭제완료");
				location.href="boardSimpleList";
			</script>
		</c:when>
		<c:otherwise>
			<script>
				alert("비밀번호 재확인 요망");
				history.back(-1);
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>