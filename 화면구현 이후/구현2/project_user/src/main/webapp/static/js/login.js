document.addEventListener("DOMContentLoaded", () => {
    // 회원계정정보 로드
    let member = JSON.parse(sessionStorage.getItem("member"));
  
    console.log(member);
    // 로그인 클릭
    document.querySelector("#login_button")?.addEventListener("click", () => {
      const login_form = document.querySelector("form#login_form");
      const username = login_form.querySelector("input[name='username']");
      const password = login_form.querySelector("input[name='password']");
      if (!username.value) {
        alert("USER NAME 은 반드시 입력해야 합니다");
        username.focus();
        return false;
      }
      if (!password.value) {
        alert("PASSWORD 는 반드시 입력해야 합니다");
        password.focus();
        return false;
      }
      let i = 0;
      for (i = 0; i < member.length; i++) {
        console.log(member[i]);
        if (
          username.value === member[i].id &&
          password.value === member[i].password
        ) {
          sessionStorage.setItem("user", JSON.stringify(member[i]));
          document.location.href = "/index.html";
          break;
        }
      }
      if (i == member.length) {
        alert("로그인이 실패하였습니다.");
      }
    });
  
    // 하단 text 클릭 : 회원가입, 아이디/비밀번호 찾기
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
  
    // 아이디와 비밀번호 매칭하여 비밀번호를 바꿀수 있는지 확인
    const id = document.querySelector(".modal_body_idpass_id");
    const tel = document.querySelector(".modal_body_email_text");
    const email_button = document.querySelector(".modal_body_email_button");
    let checker = false;
    email_button.addEventListener("click", () => {
      for (let i = 0; i < member.length; i++) {
        checker = false;
        if (member[i].id == id.value && member[i].tel == tel.value) {
          checker = true;
          break;
        }
      }
      if (checker) {
        const checkbox = document.querySelector(".modal_body_email_checkbox");
        checkbox.checked = true;
      } else {
        alert("아이디와 전화번호가 일치하지 않습니다.");
      }
    });
  
    // 바뀐 비밀번호로 저장하기
    const change_button = document.querySelector(".modal_body_idpass_button");
    const password = document.querySelector(".modal_body_idpass_password");
    change_button.addEventListener("click", () => {
      if (!document.querySelector(".modal_body_email_checkbox").checked) {
        alert("전화번호 인증을 하세요.");
      }
      for (let i = 0; i < member.length; i++) {
        if (member[i].id == id.value && member[i].tel == tel.value) {
          member[i].password = password.value;
          checker = true;
          sessionStorage.setItem("member", JSON.stringify(member));
          alert("변경완료");
          document.location.href = "login.html";
          break;
        }
      }
    });
  });
  