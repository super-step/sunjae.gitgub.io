<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${rootPath}/static/css/home.css?${version}" rel="stylesheet">
<title>Insert title here</title>
<script>
	// JSP 에서 사용하는 rootPath 변수를 
	// JS 코드에서 사용하기 위한 rootPath 변수로 재설정
	var rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/home.js"></script>
<script src="${rootPath}/static/js/main_nav.js?004"></script>
</head>
<body>
	<header>
		<div class="main_logo">
			<img src="${rootPath}/static/image/footprint/발자국_simple.png" alt="" />
		</div>
		<div class="main_nav main_nav_open">
			<ul>
				<li class="home">HOME</li>
				<li class="developer">개발자 소개</li>
				
			
			<%/*httpsession이 없을경우 나타날 로그아웃*/ %>
				<c:if test="${MEMBERLOGIN==null}">
					<li class="login">로그인</li>
				</c:if>
		
		<li class="login">임시로그인</li>
		
		<%/*httpsession이 있을 경우 나타날 로그아웃*/ %>
				<c:if test="${MEMBERLOGIN!=null}">
					<li class="home" onclick="logout()" >로그아웃</li>
				</c:if>
		
		<%/*httpsession이 있을 경우 나타날 마이페이지*/ %>
				<c:if test="${MEMBERLOGIN!=null}">
					<li class="mypage">마이페이지</li>
				</c:if>
				
			</ul>
		</div>
		<div class="main_ham">
			<input type="checkbox" id="main_ham_trigger" /> <label
				for="main_ham_trigger"> <span></span> <span></span> <span></span>
			</label>
		</div>
	</header>
	<section>
		<article></article>
	</section>
	<footer>
		<p>CopyRight &copy; dbsdudsw@icloud.com</p>
	</footer>
</body>
</html>