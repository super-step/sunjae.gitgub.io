document.addEventListener("DOMContentLoaded", () => {
  let member = JSON.parse(sessionStorage.getItem("member"));
  const sessionUser = JSON.parse(sessionStorage.getItem("user"));

  // 세션유무에 따른 메뉴바 처리
  let isLogin = false;
  const menuBar = document.querySelector("nav.cyy_nav");
  for (i = 0; i < member.length; i++) {
    if (sessionUser?.id === member[i].id) {
      isLogin = true;
      break;
    }
  }
  if (isLogin) {
    menuBar.querySelector("#login")?.remove();
    let logout = document.querySelector("#logout");
    let logoutText = logout?.getAttribute("data-link");
    logout?.setAttribute(
      "data-link",
      logoutText + "(" + sessionUser?.nick + ")"
    );
  } else {
    menuBar.querySelector("#mypage")?.remove();
    menuBar.querySelector("#logout")?.remove();
  }

  // todo : 메뉴버튼 마다 링크 달기
  document.querySelector("nav.cyy_nav")?.addEventListener("click", (e) => {
    const menu = e.target;

    if (menu.id === "home") {
      document.location.href = "/index.html";
    } else if (menu.id === "login") {
      document.location.href = "/login/login.html";
    } else if (menu.id === "profile") {
      document.location.href = "/profile/profile.html";
    } else if (menu.id === "mypage") {
      document.location.href = "/mypage/mypage.html";
    } else if (menu.id === "logout") {
      sessionStorage.removeItem("user");
      document.location.href = "/index.html";
    }
  });

  // 과거코드 지워 된다고 함. 혹시몰라서.
  const gj_map = document.querySelector("area[title='gj_map']");
  const main_intro = document.querySelector(".main_intro");
  // main_intro.addEventListener("mouseenter", (main_intro.style.color = "red"));
});
