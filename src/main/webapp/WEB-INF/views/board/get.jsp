<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jspf" %>
<div class="container">
	<div class="board_get">
		<h3>${board.title}</h3>
		<p>${board.regDate}</p>
		<p> 작성자 : ${board.writer} </p>
	</div>
	<div>
	
	</div>
</div>
<%@ include file="/WEB-INF/views/layout/footer.jspf" %>