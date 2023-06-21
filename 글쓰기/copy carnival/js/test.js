var isTextAreaVisible = false;

function toggleTextArea() {
  var textAreaContainer = document.getElementById("textAreaContainer");
  isTextAreaVisible = !isTextAreaVisible;
  
  if (isTextAreaVisible) {
    textAreaContainer.style.display = "block";
  } else {
    textAreaContainer.style.display = "none";
  }
}

function saveData() {
  var text = document.getElementById("text").value;

  var data = {
    content: text
  };

  var json = JSON.stringify(data);

  var blob = new Blob([json], { type: "application/json" });
  var url = URL.createObjectURL(blob);

  var a = document.createElement("a");
  a.href = url;
  a.download = "data.json";
  a.click();

  toggleTextArea();
}