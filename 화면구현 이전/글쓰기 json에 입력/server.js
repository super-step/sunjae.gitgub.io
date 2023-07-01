const express = require('express');
const app = express();
const fs = require('fs');

let contentArray = [];

app.use(express.urlencoded({ extended: true }));
app.use(express.json());
app.use(express.static('public'));

app.post('/addContent', (req, res) => {
  let newContent = req.body.content;

  // 줄바꿈 문자 제거
  newContent = newContent.trim();

  // 새로운 객체로 내용 추가
  const newObject = {
    content: newContent
  };

  contentArray.push(newObject);

  // 업데이트된 JSON 파일 저장
  fs.writeFileSync('data.json', JSON.stringify(contentArray));

  res.send('내용이 추가되었습니다.');
});

app.get('/getContent', (req, res) => {
  // 기존 JSON 파일 읽기
  const jsonContent = fs.readFileSync('data.json');
  contentArray = JSON.parse(jsonContent);
  res.send(contentArray);
});

app.listen(8000, () => {
  console.log('서버가 실행되었습니다. http://localhost:8000');
});
