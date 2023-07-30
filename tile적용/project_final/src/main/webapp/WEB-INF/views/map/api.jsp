<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=37962b2a8c893984a4d2139de5dc0061"></script>
<article class="API_nav_container">
	<ul>
		<li class="API_nav_item" id="nav_sns_all">전체</li>
		<li class="API_nav_item" id="nav_sns_fes">축제</li>
		<li class="API_nav_item" id="nav_sns_travel">관광지</li>
		<li class="API_nav_item" id="nav_sns_res">식당</li>
		<li class="API_nav_item" id="nav_sns_upload">글쓰기</li>
	</ul>
</article>
<article class="API_map_box" >
	<div class="API_map" data-name="${SUBDIST.sdis_code}" data-lati = "${SUBDIST.sdis_lati}" data-longi="${SUBDIST.sdis_longi}" data-level="${SUBDIST.sdis_zoomlv }" ></div>
	<div class="side_right">
		<tiles:insertAttribute name="side" />
	</div>
</article>



