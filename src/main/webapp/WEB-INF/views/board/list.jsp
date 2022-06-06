<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jspf" %>
<div class="container">
	<h2>자유게시판</h2>
	<div class="searchArea">
		<form action="${contextPath}/board/list" id="searchForm">
			<div class="row">
			<div class="col-sm-8">
			<select name="type">
				<option value="">--</option>
				<option value="T" ${pageMaker.criteria.type eq 'T' ? 'selected':''}>제목</option>
				<option value="C" ${pageMaker.criteria.type eq 'C' ? 'selected':''}>내용</option>
				<option value="W" ${pageMaker.criteria.type eq 'W' ? 'selected':''}>작성자</option>
			</select>
			<input type="text" name="keyword" value="${pageMaker.criteria.keyword}"/>
			<button>검색</button>
			</div>
			<div class="col-sm-4 text-right">
				<a href="${contextPath}/board/list">새로고침</a>
			</div>
			</div>
		</form>
	</div>
	
	<table class="table">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>등록일</th>
			<th>수정일</th>
			<th>작성자</th>
		</tr>
		<c:forEach items="${list}" var="b">
		<tr>
			<td>${b.bno}</td>
			<td>
				<a href="${contextPath}/board/read?bno=${b.bno}">${b.title}</a>
			</td>
			<td>${b.regDate}</td>
			<td>${b.updateDate}</td>
			<td>${b.writer}</td>
		</tr>
		</c:forEach>
	</table>
	<div class="pagination">
		<form action="${contextPath}/board/list" id="pageForm">
			<input type="hidden" name="page" value="${pageMaker.criteria.page}">
			<input type="hidden" name="keyword" value="${pageMaker.criteria.keyword}"/>
			<input type="hidden" name="type" value="${pageMaker.criteria.type}">
		<c:if test="${pageMaker.startPage!=1}">
			<a href="1">[첫페이지로]</a>
		</c:if>
		<c:if test="${pageMaker.prev}">
			<a href="${pageMaker.startPage-1}">[이전]</a>
		</c:if>
		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="pageNum">
			<a href="${pageNum}" class="${pageNum == pageMaker.criteria.page ? 'on':''}">[${pageNum}]</a>
		</c:forEach>
		<c:if test="${pageMaker.next}">
			<a href="${pageMaker.endPage + 1 }">[다음]</a>
		</c:if>
		</form>
	</div>
</div>
<style>
.on { font-weight: 700; color:red}
</style>
<script>
	// 페이지 이동
	let pageForm = $('#pageForm');
	$('#pageForm a').on('click',function(e){
		e.preventDefault();
		
		pageForm.find('input[name="page"]').val($(this).attr('href'));
		
		if(pageForm.find('input[name="keyword"]').val() == ''){
			let pageNum = $('input[name="page"]').clone();
			pageForm.empty();
			pageForm.append(pageNum);
		}
		pageForm.submit();
	})
	
	// 검색 유효성 검사 
	let searchForm = $('#searchForm');
	

</script>

<%@ include file="/WEB-INF/views/layout/footer.jspf" %>
    