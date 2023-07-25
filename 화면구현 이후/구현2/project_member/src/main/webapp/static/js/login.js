document.addEventListener("DOMContentLoaded", () => {
  // 하단 text 클릭 : 회원가입, 아이디/비밀번호 찾기

  //   아이디 비밀번호 찾기 모달시작
  document.querySelector("#more_text").addEventListener("click", (e) => {
    const menu = e.target;
    if (menu.id === "login_join") {
      document.location.href = "./join.html";
    }
  });
  // 하단 text 클릭 : 회원가입, 아이디/비밀번호 찾기
  const body = document.querySelector("body");
  const modal = document.querySelector(".modal");
  const btnOpenPopup = document.querySelector(".btn-open-popup");

  btnOpenPopup.addEventListener("click", () => {
    modal.classList.toggle("show");

    if (modal.classList.contains("show")) {
      body.style.overflow = "hidden";
    }
  });

  modal.addEventListener("click", (event) => {
    if (event.target === modal) {
      modal.classList.toggle("show");

      if (!modal.classList.contains("show")) {
        body.style.overflow = "auto";
      }
    }
  });
  //   모달 끝
});
