var Container = document.getElementById("map");
var option = {
  center: new kakao.maps.LatLng(35.16, 126.8512),
  level: 7,
};

var map = new kakao.maps.Map(Container, option); // 지도를 생성합니다

let positions = JSON.parse(JSON.stringify(TestFile));
// 마커를 표시할 위치와 title 객체 배열입니다
// var positions = [
//   {
//     name: "국제 그린카 전시회",
//     latitude: 35.1467152588,
//     longitude: 126.8405588979,
//   },
//   {
//     name: "광주비엔날레",
//     latitude: 35.1825648257,
//     longitude: 126.8902647155,
//   },
// ];

// 마커 이미지의 이미지 주소입니다
var imageSrc =
  "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

for (var i = 0; i < positions.length; i++) {
  // 마커 이미지의 이미지 크기 입니다
  var imageSize = new kakao.maps.Size(24, 35);

  // 마커 이미지를 생성합니다
  var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

  // 마커를 생성합니다
  var marker = new kakao.maps.Marker({
    map: map, // 마커를 표시할 지도

    position: new kakao.maps.LatLng(
      positions.gj[i].Latitude,
      positions.gj[i].longitude
    ),
    // 마커를 표시할 위치
    title: positions[i].name, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
    image: markerImage, // 마커 이미지
  });
}
