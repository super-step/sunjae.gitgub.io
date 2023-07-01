var container = document.querySelector("map");
var options = {
  center: new kakao.maps.LatLng(35.16, 126.8512),
  level: 7,
};

var map = new kakao.maps.Map(container, options);

let positions = JSON.parse(JSON.stringify(TestFile)).gj;
console.log(positions);
// 마커 이미지의 이미지 주소입니다
var imageSrc =
  "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

// var imageSrc = "./image/icon/down-arrow.png";

for (var i = 0; i < positions.length; i++) {
  // 마커 이미지의 이미지 크기 입니다
  var imageSize = new kakao.maps.Size(24, 35);

  // 마커 이미지를 생성합니다
  var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

  // 마커를 생성합니다
  var marker = new kakao.maps.Marker({
    map: map, // 마커를 표시할 지도
    position: new kakao.maps.LatLng(
      positions[i].Latitude,
      positions[i].longitude
    ), // 마커를 표시할 위치
    image: markerImage, // 마커 이미지
  });
}
  marker.setMap(map);

