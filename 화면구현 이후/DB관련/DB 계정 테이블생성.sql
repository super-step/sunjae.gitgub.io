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

-- footprintDB 사용시작
use footprintDB;

-- 행정구역
CREATE TABLE tb_district(
dis_code	VARCHAR(4)		PRIMARY KEY,
dis_name	VARCHAR(10)	NOT NULL,	
dis_deeplv	INT	NOT NULL	
);

-- 하위행정구역
CREATE TABLE tb_subdist(
sdis_code	VARCHAR(18)		PRIMARY KEY,
sdis_name	VARCHAR(10)	NOT NULL,	
sdis_lati	VARCHAR(14)	NOT NULL,	
sdis_longi	VARCHAR(14)	NOT NULL,	
sdis_zoomlv	INT	NOT NULL,	
sdis_discode	VARCHAR(4)	NOT NULL
);
-- ALTER TABLE tb_subdist
-- ADD FOREIGN KEY (sdis_discode) REFERENCES tb_district(dis_code);

-- api지도마커데이터
CREATE TABLE tb_apimark(
mk_seq	BIGINT	AUTO_INCREMENT	PRIMARY KEY,
mk_name	VARCHAR(30)	NOT NULL,	
mk_lati	VARCHAR(14)	NOT NULL,	
mk_longi	VARCHAR(14)	NOT NULL,	
mk_type	INT	NOT NULL,	
sdis_code2	VARCHAR(18)	NOT NULL	
);
--  ALTER TABLE tb_apimark
-- ADD FOREIGN KEY (sdis_code2) REFERENCES tb_subdist(sdis_code);


-- sns게시글
CREATE TABLE tb_snspost(
sp_seq	BIGINT	AUTO_INCREMENT	PRIMARY KEY,
sp_title	VARCHAR(30)	NOT NULL,	
sp_content	VARCHAR(400)	NOT NULL,	
sp_cdate	VARCHAR(10)	NOT NULL,	
sp_mdate	VARCHAR(10)	NOT NULL,	
sp_mkseq	BIGINT,		
mb_seq	BIGINT		
);
-- ALTER TABLE tb_snspost
-- ADD FOREIGN KEY (sp_mkseq) REFERENCES tb_apimark(mk_seq);
-- ALTER TABLE tb_snspost
-- ADD FOREIGN KEY (mb_seq) REFERENCES tb_member(mb_seq);



-- sns게시글이미지
CREATE TABLE tb_snsimg(
spi_seq	BIGINT	AUTO_INCREMENT	PRIMARY KEY,
spi_uri	VARCHAR(100)	NOT NULL,	
spi_cdate	VARCHAR(10)	NOT NULL,	
spi_spseq	BIGINT	NOT NULL	
);
-- ALTER TABLE tb_snsimg
-- ADD FOREIGN KEY (spi_spseq) REFERENCES tb_snspost(sp_seq);



-- 하트
CREATE TABLE tb_snsheart(
sh_spseq	BIGINT,
sh_mbseq	BIGINT	NOT NULL,
PRIMARY KEY(sh_spseq,sh_mbseq)
);
-- ALTER TABLE tb_snsheart
-- ADD FOREIGN KEY (sh_spseq) REFERENCES tb_snspost(sp_seq);
-- ALTER TABLE tb_snsheart
-- ADD FOREIGN KEY (sh_mbseq) REFERENCES tb_member(mb_seq);

-- DESC tb_snsheart;


-- 좋아하는 발가락
CREATE TABLE tb_follow(
fol_seq	BIGINT	AUTO_INCREMENT	PRIMARY KEY,
followin	BIGINT	NOT NULL	NOT NULL,
follower	BIGINT	NOT NULL	NOT NULL
);

-- ALTER TABLE tb_follow
-- ADD FOREIGN KEY (sh_spseq) REFERENCES tb_member(mb_seq);
-- ALTER TABLE tb_follow
-- ADD FOREIGN KEY (sh_mbseq) REFERENCES tb_member(mb_seq);




-- 회원
CREATE TABLE tb_member(
mb_seq	BIGINT	AUTO_INCREMENT	PRIMARY KEY,
mb_id	VARCHAR(30)	NOT NULL,	
mb_password	VARCHAR(100)	NOT NULL,	
mb_nick	VARCHAR(10)	NOT NULL,	
mb_proimg	VARCHAR(100),		
mb_name	VARCHAR(20)	NOT NULL,	
mb_birth	VARCHAR(10)	NOT NULL,	
mb_tel	VARCHAR(12)	NOT NULL,	
mb_email	VARCHAR(40)	NOT NULL,	
mb_addr	VARCHAR(200)		
);
-- sns코멘트
CREATE TABLE tb_snscom(
sc_spseq	BIGINT,		
sc_mbseq	BIGINT,	
sc_tnick	VARCHAR(10)	NOT NULL,
sc_content	VARCHAR(200)	NOT NULL,	
sc_cdate	VARCHAR(10)	NOT NULL,
sc_mdate	VARCHAR(10)	NOT NULL,	
PRIMARY KEY(sc_spseq,sc_mbseq)
);
-- ALTER TABLE tb_snscom
-- ADD FOREIGN KEY (sc_spseq) REFERENCES tb_member(mb_seq);
-- ALTER TABLE tb_snscom
-- ADD FOREIGN KEY (sc_mbseq) REFERENCES tb_snspost(sp_seq);



-- foreign key 삭제
alter table tb_subdist
drop FOREIGN KEY tb_subdist_ibfk_1;





