const members = [
  {
    id: "test",
    password: "test",
    name: "곽두팔",
    nick: "고양이",
    tel: "010-1111-1111",
  },
];
let member = sessionStorage.getItem("member");
if (member === null) {
  console.log(member);
  member = members;
  sessionStorage.setItem("member", JSON.stringify(member));
  // console.log(sessionStorage.getItem("member"));
  member.push({
    id: "newid",
    password: "1234",
    name: "김새로",
    nick: "프로도",
    tel: "010-2222-2222",
  });
  sessionStorage.setItem("member", JSON.stringify(member));
  console.log(sessionStorage.getItem("member"));
}
