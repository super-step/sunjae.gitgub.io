const express = require('express');
const app = express();
const fs = require('fs');

let contentArray = [];

// 기존 JSON 파일 읽기
fs.readFile('data.json', (err, data) => {
  if (err) {
    console.error('JSON 파일을 읽을 수 없습니다.', err);
    return;
  }
  contentArray = JSON.parse(data);
});

app.use(express.urlencoded({ extended: true }));
app.use(express.json());
app.use(express.static('public'));

app.post('/addContent', (req, res) => {
  let newContent = req.body.content;
  let newMkseq = req.body.mkseq;

  // 줄바꿈 문자 제거
  newContent = newContent.trim();
  newMkseq = newMkseq.trim();

  // 새로운 객체로 내용 추가
  const newObject = {
    content: newContent,
    mkseq: newMkseq
  };

  contentArray.push(newObject);

  // 업데이트된 JSON 파일 저장
  fs.writeFile('data.json', JSON.stringify(contentArray), (err) => {
    if (err) {
      console.error('JSON 파일을 저장할 수 없습니다.', err);
      return;
    }
    res.send('내용이 추가되었습니다.');
  });
});

app.get('/getContent', (req, res) => {
  res.send(contentArray);
});

app.listen(8000, () => {
  console.log('서버가 실행되었습니다. http://localhost:8000');
});
