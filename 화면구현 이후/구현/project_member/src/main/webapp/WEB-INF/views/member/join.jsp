<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${rootPath}/static/css/home.css?${version}" rel="stylesheet">
<link href="${rootPath}/static/css/join.css?${version}" rel="stylesheet">
<script src="${rootPath}/static/js/main_nav.js?004"></script>

<title>Insert title here</title>
</head>
<body>
	<header>

		<img src="..\image\footprint\발자국_simple.png" alt="" />
		<div class="cyy_ham_container">
			<input type="checkbox" id="cyy_ham_trigger" /> <label
				for="cyy_ham_trigger"> <span></span> <span></span> <span></span>
			</label>
			<nav class="cyy_nav">
				<a id="logout" data-link="로그아웃"></a> <a id="mypage"
					data-link="마이페이지"></a> <a id="login" data-link="로그인"></a> <a
					id="profile" data-link="개발자 소개"></a> <a id="home" data-link="HOME"></a>
			</nav>
		</div>
	</header>
	<section>
		<article class="map_container"></article>
	</section>
	<article id="join_container">
		<!-- 회원가입 화면 -->
		<section id="join_box">
			<div id="join_title">
				<h2>회원가입</h2>
			</div>
			
			<c:if test="${not empty MESSAGE && MESSAGE == 'NAME_TEL'}">
			<h2>이름과 전화번호가 이미 등록되어 있습니다</h2>
			</c:if>
			
			<c:if test="${not empty MESSAGE && MESSAGE =='ID'}">
			<h2>이미 등록된 ID입니다</h2>
			</c:if>
			
			<c:if test="${not empty MESSAGE && MESSAGE =='NICKNAME'}">
			<h2>이미 등록된 닉네임 입니다</h2>
			</c:if>
			
			<c:if test="${not empty MESSAGE && MESSAGE =='EMAIL'}">
			<h2>이미 등록된 이메일입니다</h2>
			</c:if>
			
			
			
			<div id="join_body">
			<%/*controller 에서 가져온 modelAttribute*/ %>
				<form:form id="join_form" modelAttribute="MEMBER" >
					<div class="join_rowbox">
						<form:input path="mb_id" name="mb_id" type="text"  id="userid" placeholder="사용자 ID는 4글자이상" />
						 </div>
					<form:input path="mb_password" name="mb_password"  type="password"  id="password" placeholder="비밀번호는 4글자 이상" />
					<%/*이미지는 마이페이지에서 추가*/ %>
					<form:input path="mb_nick"	name="mb_nick" type="text"  id="nickname" placeholder="닉네임" />
					<form:input path="mb_name"	name="mb_name" type="text"  id="nickname" placeholder="이름" />
					<form:input path="mb_birth"	name="mb_birth" type="text"  id="username" placeholder="생일" />
					<form:input path="mb_tel"  name="mb_tel" type="text" id="nickname" placeholder="전화번호" />
					<form:input path="mb_email" name="mb_email" type="text"  id="nickname" placeholder="이메일" />
					<form:input path="mb_addr" name="mb_addr" type="text" id="nickname" placeholder="주소" />
					<div class="join_rowbox">
						
						
					</div>
					<button type="submit" id="join_button">회원가입</button>
			</div>
			</form:form>
		</section>
	</article>
	<footer>
		<p>CopyRight &copy; dbsdudsw@icloud.com</p>
	</footer>
</body>
</html>