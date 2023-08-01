<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />


<section>
	<article>
		<h1>나의 발자국 보기</h1>
		<table class="memberlist">
			<tr>
				<th class="seq">글번호</th>
				<th class="title">제목</th>
				<th class="date">입력날짜</th>
			</tr>
			<c:forEach items="${MYPAGEPOST}" var="MYPAGEPOST">
				<tr>
					<td class="textseq">${MYPAGEPOST.sp_seq}</td>
					<td class="texttitle">${MYPAGEPOST.sp_title}</td>
					<td class="textdate">${MYPAGEPOST.sp_cdate}</td>
				</tr>
			</c:forEach>
		</table>

	</article>
</section>
