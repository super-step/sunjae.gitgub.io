var container = document.getElementById("sns_api_map");
var options = {
  center: new kakao.maps.LatLng(33.450701, 126.570667),
  level: 3,
};

var map = new kakao.maps.Map(container, options);
