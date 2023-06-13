document.addEventListener("DOMContentLoaded", () => {
  var winX = window.pageXOffset;
  var winY = window.pageYOffset;
  const main_to_map = document.querySelector(".main_to_map img");
  const main_map_img_Top = document.querySelector(".main_map_img").offsetTop;

  main_to_map.addEventListener("click", window.scrollTo({
    top : main_map_img_Top,
    behavior : "smooth"
  }));
});