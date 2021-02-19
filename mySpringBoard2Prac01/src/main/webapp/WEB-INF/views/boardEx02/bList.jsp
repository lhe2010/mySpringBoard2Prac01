<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bList</title>
<script src="resources/js/jquery-3.5.1.min.js"></script>
<script>
	$().ready(function(){
		$("#getSearchBoard").click(function(){
 			var onePageViewCount = 10; // 일단은 페이징 처리 전이므로 패스
			var searchKeyword = $("#searchKeyword").val();	// select id
			var searchWord = $("#searchWord").val();			// input text id 
			location.href = "boardList?onePageViewCount=" + onePageViewCount + "&searchKeyword="+searchKeyword+"&searchWord="+searchWord;
		});
	});
</script>
</head>
<body>
	<div align="center">
		<h1>
			MVC2_Model_Advance 
		</h1>
		<h2>total entries = ${totalBoardCount}</h2>
		<div>
			<button onclick="location.href='boardWrite'">write</button>
		</div>
		<table border="1">
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
				<c:forEach var="board" items="${boardList }">
					<tr align="center">
						<td>${board.num }</td>
						<td>
							<c:if test="${board.reStep > 1 }">
								<c:forEach var="j" begin="0" end="${(board.reLevel-1)*5 }">
								&nbsp;
								</c:forEach> >>							
							</c:if>
							<a href="boardInfo?num=${board.num}">${board.subject }</a></td>
						<td>${board.writer }</td>
						<td><fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd" /></td>
						<td>${board.readCount }</td> <!-- rCount -->
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5" align="center">
						<select id="searchKeyword">
							<option <c:if test="${searchKeyword eq 'total'}">selected</c:if> value="total">total</option>
							<option <c:if test="${searchKeyword eq 'writer'}">selected</c:if>  value="writer">writer</option>
							<option <c:if test="${searchKeyword eq 'subject'}">selected</c:if>  value="subject">subject</option>
						</select>
						<input type="text" id="searchWord" name="searchWord" value="${searchWord }">
						<input type="button" id="getSearchBoard" value="Search">					
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	

</body>
</html>