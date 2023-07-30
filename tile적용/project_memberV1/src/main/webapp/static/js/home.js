document.addEventListener("DOMContentLoaded", () => {
  const main_ham_ckeck = document.querySelector('input[id="main_ham_trigger"]');
  const main_ham = document.querySelector('label[for="main_ham_trigger"]');
  const main_nav = document.querySelector("div.main_nav ul");
  main_ham.addEventListener("click", () => {
    // alert("클릭함");
    if (!main_ham_ckeck.checked) {
      // alert("체크됨");
      main_nav.classList.add("main_nav_open");
    } else if (main_ham_ckeck.checked) {
      main_nav.classList.remove("main_nav_open");
    }
  });

  function logout() {
    // 서버로 로그아웃 요청을 보내는 Ajax
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/logout", true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function () {
      if (xhr.readyState === 4 && xhr.status === 200) {
        // 로그아웃 성공 시, 홈페이지로 이동
        window.location.href = "/";
      }
    };
    xhr.send();
  }
});
