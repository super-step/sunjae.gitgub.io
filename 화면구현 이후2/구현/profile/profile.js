function openModal() {
  // AJAX 요청
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function () {
    if (this.readyState === 4 && this.status === 200) {
      // 성공적으로 응답을 받았을 때 처리
      var modalContent = this.responseText;

      // 모달 창에 내용 삽입
      document.getElementById("developer-modal").innerHTML = modalContent;

      // 모달 창 표시
      document.getElementById("developer-modal").style.display = "block";
      document.getElementById("developer-modal").style.display = "inline-block";
    }
  };
  xhttp.open("GET", "developer.html", true);
  xhttp.send();
}
function closeModal() {
  document.getElementById("developer-modal").style.display = "none";
}
document.addEventListener("DOMContentLoaded", () => {
  // 모달 창 닫기

  // 개발자 정보 모달 열기 버튼 클릭 시
  //   document
  //     .getElementById("open-modal-button")
  //     .addEventListener("click", openModal);
  // 모달 닫기 버튼 클릭 시
  document
    .getElementsByClassName("close")[0]
    .addEventListener("click", closeModal);
});
