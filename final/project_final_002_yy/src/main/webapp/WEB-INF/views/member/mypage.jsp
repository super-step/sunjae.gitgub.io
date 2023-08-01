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
					<img src="${rootPath}/static/image/image/profile_basic_image.jpeg"
						alt="" />
					<div class="mPProfileChange">프로필 사진 변경하기</div>
				</div>
				<div class="mPProfileName">이름</div>
				<div class="mPProfileLogout">로그아웃</div>
			</div>
			<div class="myPageSetting">


				<div class="mPContentTitle">기본페이지</div>
				<div class="mPContentBox">
					<div class="mPNicSet">
						<%
						/*   닉네임은 기존 label에서 modal로 사용하던걸 input으로 변경    */
						%>
						<%
						/*form 시작*/
						%>


						<form:form modelAttribute="MEMBERLOGIN">
						<div>
							<label>닉네임 : <span>${PUTMEMBER.mb_nick}</span></label>
							<form:input path="mb_nick" placeholder="변경할 닉네임을 입력해 주세요"
								name="mb_nick" class="mPNowNic"/>
						</div>
							
		

							<button class="mPNicChange mPBtn">변경하기</button>

						</form:form>
						<%
						/*form 끝*/
						%>


					</div>
					<div class="mPPWSet">
						<%
						/*  비밀번호 변경도 input tag로 변경 */
						%>
						<%
						/*form 시작*/
						%>
						<form:form action="" modelAttribute="MEMBERLOGIN">
							<div>

								<label>비밀번호 변경</label>
								<form:input path="mb_password" placeholder="변경할비밀번호를 입력해 주세요"
									name="mb_password" class="mPPWChange" />
							</div>

							<button class="mPPWChange mPBtn">변경하기</button>
						</form:form>
					</div>
					<%
					/*form 끝*/
					%>
				</div>
			</div>
		</div>


		<div class="myPagePost">
			<div class="mPContentTitle">발자국 관리</div>
			<div class="mPContentBox" id="mpPostListBox">
				<div class="mPPostCount">
					지금까지 '<span id="mPPostNumber">999</span>'개의 발자국을 남겼어요!
				</div>
				<div class="mPPostManage mPBtn">발자국 관리하기</div>
			</div>
		</div>


	</div>
</article>

