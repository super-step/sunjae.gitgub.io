<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${rootPath}/static/css/home.css?${version}" rel="stylesheet">
<link href="${rootPath}/static/css/login.css?${version}" rel="stylesheet">
<script src="${rootPath}/static/js/login.js?001"></script>
<script src="${rootPath}/static/js/main_nav.js?004"></script>


<title>Insert title here</title>
</head>
<body>
<header>
      <img src="..\image\footprint\발자국_simple.png" alt="" />
      <div class="cyy_ham_container">
        <input type="checkbox" id="cyy_ham_trigger" />
        <label for="cyy_ham_trigger">
          <span></span>
          <span></span>
          <span></span>
        </label>
        <nav class="cyy_nav">
          <a id="logout" data-link="로그아웃"></a>
          <a id="mypage" data-link="마이페이지"></a>
          <a id="login" data-link="로그인"></a>
          <a id="profile" data-link="개발자 소개"></a>
          <a id="home" data-link="HOME"></a>
        </nav>
      </div>
    </header>
    <section>
      <article class="map_container"></article>
    </section>
    <article id="login_container">
      <!-- 로그인 화면 -->
      <section id="login_box">
        
     
        
        <%/*form 시작*/ %>
        <form:form id="login_form" modelAttribute="MEMBERLOGIN">
          <h2>여행 발가락</h2>
          
         
             <c:if test="${ERROR == 'NOTID'}">
			<h2>존재하지 않는 아이디입니다</h2>
			</c:if>
        
          <c:if test="${ERROR == 'NOTPASSWORD'}">
			<h2>비밀번호가 틀렸습니다</h2>
			</c:if>
          
          <form:input path="mb_id" type="text" name="username" placeholder="사용자 ID" />
          <form:input path="mb_password"  type="password" name="password" placeholder="비밀번호" />
          <button type="submit" id="login_button">로그인</button>
          <div id="more_text">
            <a id="login_join">회원가입</a>
            <a class="btn-open-popup"> 아이디찾기 / 비밀번호찾기 </a>
          </div>
        </form:form>
      <%/*form 끝*/ %>
      
      
      
      </section>
      <section id="login_right"></section>
    </article>
    <footer>
      <p>CopyRight &copy; dbsdudsw@icloud.com</p>
    </footer>
</body>

  <div class="modal">
    <div class="modal_body">
      <div class="modal_body_text">발자국 찾기</div>



<%/*form 시작*/ %>
   <form:form action="${rootPath}/login" class="modal_body_email" modelAttribute="MEMBERLOGIN">
      
      <form:input path="mb_email" 
      type="text" class="modal_body_idpass_id" 
      placeholder="이메일을 입력해주세요" />
      
      <button type="submit">아이디 찾기</button>
      <c:if test="${FOUND_ID ne null}">
        <h2>아이디는 <span class="found_id">${FOUND_ID}</span> 입니다</h2>
      </c:if>
         
         
      
       
        <input
      
          type="text"
          class="modal_body_email_text"
          placeholder="아이디를 입력해주세요"
        />
           <input
          type="text"
          class="modal_body_email_text"
          placeholder="전화번호를 입력해주세요"
        />
        
       
       <%/* <c:if test="">
       </c:if><h2>비밀번호는입니다</h2>*/ %>
        
        
        
      </form:form>
      <%/*form 끝*/ %>
      
      
      <%/*이거 버튼 옮겨야하는데 피곤하니 나중에 하자*/ %>
      <div class="modal_save_buton" >
      <button class="modal_body_email_button"> 인증받기</button>
    </div>
   <%/*
  
   <div class="modal_body_email_checkbox_line">
   <div class="modal_body_email_checkbox_message">
     인증이 완료되었습니다
   </div>
   <input class="modal_body_email_checkbox" type="checkbox" disabled />
 </div>

   */ %> 
    
     
    
    
  <form action="" class="modal_body_idpass">
    <input
    type="password"
    class="modal_body_idpass_password"
    placeholder="비밀번호 재설정"
  />
</form>

    
    
    
    
    
    
    
      <button class="modal_body_idpass_button">저장</button>
      <form action="">
        <button class="modal_body_close_button">닫기</button>
      </form>
    </div>
  </div>

</html>