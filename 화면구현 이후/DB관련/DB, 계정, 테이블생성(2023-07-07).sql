-- DB 생성
CREATE DATABASE footprintDB;

-- 생성된 DB확인
show databases;  

-- 사용자 생성
create user footprint@localhost IDENTIFIED BY '12341234';

-- 권한
grant all PRIVILEGES on footprintDB.* TO footprint@localhost;

-- 권한적용 
FLUSH PRIVILEGES;


use footprintDB;


CREATE TABLE










