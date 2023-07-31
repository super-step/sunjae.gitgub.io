<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<article>
	<div class="myPageHeader">
		<div>마이페이지</div>
	</div>
	<div class="myPageBody">
		<div class="myPageList">
			<div class="myPageUserProfile">
				<div class="mPProfileImg">
					<img
						src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTQDEJ9uT3a8ZN65Mek-wN7xzJxnNJzDwwqYlXpEZOuZQ&s"
						alt="" />
				</div>
			</div>
			<div class="myPageUserHeart"></div>
		</div>
		<div class="myPageContent">
			<div class="myPageSetting">
				<div class="mPContentTitle">마이페이지</div>
				<div class="mPContentBox">
					<div class="mPNicSet">
						<form:form modelAttribute="MEMBERLOGIN">
							<div>닉네임</div>
							<form:input path="mb_nick" placeholder="닉네임 입력하셔야 해요 ㅠㅠ"
								name="mb_nick" class="mPNowNic" pattern="^\S.*$"
								title="빈칸은 안돼용 ㅠ" required="true" />
							<button class="nickbutton" id="my_modal_change_btn">변경하기</button>
						</form:form>
					</div>
					<div class="mPPWSet">
						<form:form action="" modelAttribute="MEMBERLOGIN">
							<div>비밀번호 변경</div>
							<form:input path="mb_password" placeholder="비밀번호 입력하셔야 해요 ㅠㅠ"
								name="mb_password" class="mPPWChange mPBtn" pattern="^\S.*$"
								title="빈칸안돼용 ㅠ" required="true" />
							<button class="passbutton" id="my_modal_change_btn">변경하기</button>
						</form:form>
					</div>
				</div>
				
			</div>
		</div>
	</div>
	
						<a id="login_join" class="textlist" href="${rootPath}/member/mypage_postmanager">발자국
							관리하기</a>
					
	<div class="myPageImgContainer">
		<img src="/image/자전거.png" alt="" />
	</div>
	<div id="modal" class="modal-overlay">
		<div class="modal-window">
			<div class="my_modal_header">
				<div class="my_modal_title">
					
				</div>
			</div>
			<div class="my_modal_content"></div>
		</div>
	</div>
</article>

