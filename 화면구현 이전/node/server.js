const express = require('express');
const app = express();
const fs = require('fs');

let contentArray = [];

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
  const newContent = req.body.content;
  const newMkseq = req.body.mkseq;

  const trimmedContent = newContent.trim();
  const trimmedMkseq = newMkseq.trim();

  const newObject = {};

  if (trimmedContent) {
    newObject.content = trimmedContent;
  }

  if (trimmedMkseq) {
    newObject.mkseq = trimmedMkseq;
  }

  contentArray.push(newObject);

  fs.writeFile('data.json', JSON.stringify(contentArray), (err) => {
    if (err) {
      console.error('JSON 파일을 저장할 수 없습니다.', err);
      res.status(500).send('내용을 추가하는 중에 오류가 발생했습니다.');
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
