function addData() {
    var newData = {
        "name": "John Doe",
        "age": 25,
        "email": "johndoe@example.com"
    };

    // 이전 데이터 가져오기
    var existingData = localStorage.getItem('data');
    if (existingData) {
        existingData = JSON.parse(existingData);
    } else {
        existingData = [];
    }

    // 새로운 데이터 추가
    existingData.push(newData);

    // JSON 문자열로 변환하여 저장
    localStorage.setItem('data', JSON.stringify(existingData));

    alert('데이터가 추가되었습니다.');
}
