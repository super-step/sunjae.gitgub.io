let mPReceivedLike = document.querySelector("span#mPReceivedLike");
let mPMostHeart = document.querySelector("span#mPMostHeart");
let myLogout = document.querySelector(".mPProfileLogout");
let myName = document.querySelector(".mPProfileName");
let mpPostListBox = document.querySelector("#mpPostListBox");

let member = JSON.parse(sessionStorage.getItem("member"));
let snsCotents = JSON.parse(sessionStorage.getItem("snsCotents"));
const sessionUser = JSON.parse(sessionStorage.getItem("user"));

myName.innerHTML = `${sessionUser.name}`;
myLogout.addEventListener("click", () => {
  sessionStorage.removeItem("user");
  document.location.href = "./index.html";
});
if (mpPostListBox.firstChild) {
  mpPostListBox.removeChild(mpPostListBox.firstChild);
}
let nowHeart = 0;
let mostHeart = 0;
let totalPostList = "";
snsCotents.forEach((element) => {
  console.log(element.userId);
  console.log(element.heart);
  if (element.userId == sessionUser.id) {
    nowHeart = nowHeart + element.heart;
    const PostboxString = `

        <div class="mPPostBox">
        <img class="mPPostImg" src="${element.img}" alt="" />
        <div class="mPPostTitlebox">
          <div class="mPPostMapTitle">${element.mName}</div>
          <div class="mPPostHeart">
            <span class="mPPostHeartCount">${element.heart}</span>
            <img src="../image/icon_heart.png" alt="" />
          </div>
        </div>
        <div class="mPPostTitle">${element.title}</div>
      </div>


    `;
    totalPostList = totalPostList + PostboxString;

    if (element.heart > mostHeart) {
      mostHeart = element.heart;
    }
  }
  console.log(nowHeart);
});
mpPostListBox.innerHTML = totalPostList;
mPReceivedLike.innerHTML = nowHeart;
mPMostHeart.innerHTML = mostHeart;
