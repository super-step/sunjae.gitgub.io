document.addEventListener("DOMContentLoaded", () => {
  // 회원계정정보 로드
  let member = JSON.parse(sessionStorage.getItem("member"));

  // let member = members;
  // sessionStorage.setItem("member", JSON.stringify(members));
  // console.log(sessionStorage.getItem("member"));
  // member.push({
  //   id: "newid",
  //   password: "1234",
  //   name: "newname",
  //   nick: "newnick",
  // });
  // sessionStorage.setItem("member", JSON.stringify(member));
  // console.log(sessionStorage.getItem("member"));
  // member = JSON.parse(sessionStorage.getItem("member"));
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
});
