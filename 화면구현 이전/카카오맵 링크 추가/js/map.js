var container = document.querySelector(".API_map");
var options = {
  center: new kakao.maps.LatLng(35.16, 126.8512),
  level: 3,
};

var map = new kakao.maps.Map(container, options);

let positions = JSON.parse(JSON.stringify(TestFile)).gj;

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

  // 마커에 표시할 인포윈도우를 생성합니다
  var infowindow = new kakao.maps.InfoWindow({
    content: `<div>${positions[i].name}</div>`, // 인포윈도우에 표시할 내용
  });

  // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
  // 이벤트 리스너로는 클로저를 만들어 등록합니다
  // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
  kakao.maps.event.addListener(
    marker,
    "mouseover",
    makeOverListener(map, marker, infowindow)
  );
  kakao.maps.event.addListener(marker, "mouseout", makeOutListener(infowindow));
}
// 인포윈도우를 표시하는 클로저를 만드는 함수입니다
function makeOverListener(map, marker, infowindow) {
  return function () {
    infowindow.open(map, marker);
  };
}

// 인포윈도우를 닫는 클로저를 만드는 함수입니다
function makeOutListener(infowindow) {
  return function () {
    infowindow.close();
  };
}
(function(marker, title) {
  kakao.maps.event.addListener(marker, 'click', function() {
      searchDetailAddrFromCoords(presentPosition, function(result, status) {
          if (status === kakao.maps.services.Status.OK) {
              detailAddr = !!result[0].road_address ? result[0].road_address.address_name : result[0].address.address_name;
              location.href = "https://map.kakao.com/?sName="+detailAddr+"&eName="+title                                            
          }   
      });
  })

  itemEl.onclick =  function () {
      searchDetailAddrFromCoords(presentPosition, function(result, status) {
          if (status === kakao.maps.services.Status.OK) {
              detailAddr = !!result[0].road_address ? result[0].road_address.address_name : result[0].address.address_name;
              location.href = "https://map.kakao.com/?sName="+detailAddr+"&eName="+title                                            
          }   
      });
  };
})