<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<div class="sideImgCard viewOff">
	<div class="sns imgCardList">
		<div class="sns imgCard">
			<div class="card img">
				<img src="${rootPath }/files/${FILE.i_uploadName}" width="100px" />
				<span data-seq="${FILE.i_seq }"
					data-filename="${FILE.i_originalName }"></span>
			</div>
			<div class="card text">요약된 내용</div>
		</div>

	</div>
</div>

<div class="sideInputForm viewOff">
	<form:form action="${rootPath}/posts/post/insert"
		modelAttribute="POSTDTO" method="POST" enctype="multipart/form-data">
		<div id="inputTitleBox">
			<label>title</label>
			<form:input path="sp_title" type="text" placeholder="제목을 입력하세요" />
		</div>
		<div id="inputContentsBox">
			<label>contents</label>
			<form:textarea path="sp_content" rows="2" cols="1" maxlength="55"></form:textarea>
		</div>
		<div id="inputImageBox">
			<label>이미지 첨부</label> <input name="sp_images" type="file"
				multiple="multiple" accept="image/*" />
		</div>
		<form:hidden path="sp_mkseq" />
		<div id="inputFormBtn">
			<button type="button">UPLOAD</button>
		</div>
	</form:form>
</div>

<div class="mdetailMotal viewOff">
	<div>디테일 모달창</div>
</div>