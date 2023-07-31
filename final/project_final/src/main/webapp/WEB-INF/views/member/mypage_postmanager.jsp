<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />



<section>
	<article>


		<h1>도서 정보 관리</h1>
		<table class="book">
			<tr>
				<th>도서코드</th>
				<th>도서명</th>
				<th>저자</th>
				<th>출판사</th>
				<th>대여가격</th>
			</tr>

			<%
			/*
					<!-- 도서정보가 비어있다면 -->
					<!-- controller에 BOOKS로 받은걸 BOOK으로 바꿔 사용 -->
					*/
			%>

			<c:forEach items="${MYPAGEPOST}" var="MYPAGEPOST">
				<tr>
					<td>${MYPAGEPOST.sp_seq}</td>
					<td>${MYPAGEPOST.sp_title}</td>
					<td>${MYPAGEPOST.sp_cdate}</td>
				</tr>
			</c:forEach>
		</table>

	</article>
</section>
