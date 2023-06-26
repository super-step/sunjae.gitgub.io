document.addEventListener("DOMContentLoaded", () => {
  // 회원계정정보 로드
  let member = JSON.parse(sessionStorage.getItem("member"));

  // 사용자 ID 중복 확인.
  let id_button = document.querySelector("#idcheck");
  let id_input = document.querySelector("#userid");

  let isIdPassed = false;
  id_input.addEventListener("input", () => {
    if (id_input.value.trim() === "") {
      isIdPassed = false;
    } else if (id_input.value.trim().length < 4) {
      id_button.classList.remove("check_passed");
      id_button.innerText = "4자이상";
      isIdPassed = false;
    } else {
      isIdPassed = true;
      member.forEach((element) => {
        if (element.id === id_input.value) {
          isIdPassed = false;
          return false;
        }
      });
      if (isIdPassed) {
        id_button.classList.add("check_passed");
        id_button.innerText = "사용가능";
      } else {
        id_button.classList.remove("check_passed");
        id_button.innerText = "사용불가";
      }
    }
  });

  // 사용자 전화번호 확인.
  let tel_button = document.querySelector("#telcheck");
  let tel_input = document.querySelector("#tel");
  let isTelPassed = false;
  tel_input.addEventListener("input", () => {
    const telRule = /^\d{3}-\d{3,4}-\d{4}$/;
    if (tel_input.value.trim() === "") {
      isTelPassed = false;
    } else if (!telRule.test(tel_input.value)) {
      tel_button.classList.remove("check_passed");
      tel_button.innerText = "형식불가";
      isTelPassed = false;
    } else {
      isTelPassed = true;
      member.forEach((element) => {
        if (element.tel === tel_input.value) {
          isTelPassed = false;
          return false;
        }
      });
      if (isTelPassed) {
        tel_button.classList.add("check_passed");
        tel_button.innerText = "사용가능";
      } else {
        tel_button.classList.remove("check_passed");
        tel_button.innerText = "이미있음";
      }
    }
    console.log(isTelPassed);
  });

  // 빈칸과 유효성 검사와 중복검사 결과에 따라 회원가입으로
  document.querySelector("#join_button").addEventListener("click", () => {
    console.log("짜잔");
    let password = document.querySelector("#password");
    let passwordck = document.querySelector("#password_check");
    let username = document.querySelector("#username");
    let nickname = document.querySelector("#nickname");
    if (username.value.trim() === "") {
      alert("이름을 입력하세요.");
      username.focus();
      return;
    }
    if (nickname.value.trim() === "") {
      alert("닉네임을 입력하세요.");
      nickname.focus();
      return;
    }
    if (password.value.trim() === "") {
      alert("비밀번호를 입력하세요.");
      password.focus();
      return;
    }
    if (passwordck.value.trim() === "") {
      alert("비밀번호를 입력하세요.");
      passwordck.focus();
      return;
    }
    if (!isIdPassed) {
      alert("아이디가 적절하지 않습니다.");
      id_input.focus();
      return;
    }
    if (!isTelPassed) {
      alert("전화번호가 적절하지 않습니다.");
      tel_input.focus();
      return;
    }
    if (password.value !== passwordck.value) {
      alert("비번이 비번확인과 달아.");
      password.focus();
      return;
    }
    // 1. sessionStorage에서 member에 있는 문자열을 가져온다
    // 2. let member 에 sessionStorage에서 member 에서 가져온 문자열을 객체(배열)로 바꾸서 저장한다
    // 3. push를 이용하여 member 배열에 값을 추가해준다.
    // 4. member 배열을 문자열로 바꿔서 sessionStorage "member" 에 다시 저장한다.
    //    ( 기존값을 무시하고 덮어쓰기된다.)
    member.push({
      id: id_input.value,
      password: password.value,
      name: username.value,
      nick: nickname.value,
      tel: tel_input.value,
    });
    sessionStorage.setItem("member", JSON.stringify(member));
    alert("가입이 완료되었습니다 '" + nickname.value + "'님 환영합니다.");
    document.location.href = "login.html";
    console.log(sessionStorage.getItem("member"));
  });
});
