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
  // 아이디 비밀번호 찾기에서 쓸 코드

  document
    .querySelector(".modal_body_email_button")
    ?.addEventListener("click", () => {
      const modal_form = document.querySelector(".modal_body_email");
      const modal_id = modal_form.querySelector("input[name='findid']");
      const modal_tel = modal_form.querySelector("input[name='findtel']");
      if (!modal_id.value) {
        alert("id를 입력해주세요 ㅠ");
        modal_id.focus;
        return false;
      }
      if (!modal_tel.value) {
        alert("전화번호를 입력해주세요 ㅠ");
        modal_tel.focus;
        return false;
      }
      let index;
      console.log(member[0]);
      for (index = 0; index < member.length; index++) {
        console.log(member[index]);

        if (
          modal_id.value === member[index].id &&
          modal_tel.value === member[index].tel
        ) {
          alert(" 아이디는 ' " + member[index].id + " ' 입니다.");

          break;
        }
      }
    });

  document
    .querySelector(".modal_body_idpass_button")
    ?.addEventListener("click", () => {
      const modal_password = document.querySelector(
        ".modal_body_idpass_password"
      );
      // console.log(modal_password.value.trim() + "sdss");
      if (modal_password.value.trim() == "") {
        alert("패스워드를 입력해 주세요");
        modal_password.focus;
        return;
      }

      // // member.push({ password: modal_password.value });
      // sessionStorage.setItem("member", JSON.stringify(member));
      // // alert("변경이 완료되었습니다.");
    });

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
      console.log(member[i]); //?
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
