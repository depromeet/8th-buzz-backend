-- 카테고리
insert into category(id,name) values
(1,'살림'),
(2,'패션'),
(3,'뷰티'),
(4,'푸드'),
(5,'가전'),
(6,'스포츠'),
(7,'잡화');



-- 유저
insert into user(user_Id,name,thumbnail) values ('1','공백','https://drive.google.com/file/d/1709Q3i8xvyUA4_DH1j9e7CgQ8YrfLbBJ/view?usp=sharing');
insert into user(user_Id,name,thumbnail) values ('2','250디자인','https://drive.google.com/file/d/12yvFKpwCbQLHhQohm-Qukngr4NbR9cI0/view?usp=sharing');
insert into user(user_Id,name,thumbnail) values ('3','낫포유','https://drive.google.com/file/d/17g1NAummP1yk-W6OwWJEinp0-5DxMSvD/view?usp=sharing');
insert into user(user_Id,name,thumbnail) values ('4','생활도감','https://drive.google.com/file/d/1NQKPDKR2BlWBWkAzf3qQbF4SM97TmcA4/view?usp=sharing');
insert into user(user_Id,name,thumbnail) values ('5','타월로지스트','https://drive.google.com/file/d/1BCXFBkZj8LiHAdoQf9jVYq0eHVanuxRi/view?usp=sharing');
insert into user(user_Id,name,thumbnail) values ('6','나이키','https://drive.google.com/file/d/1WgiUJa0r1dsNJBkeDvUSteWRGdAeVLUK/view?usp=sharing');
insert into user(user_Id,name,thumbnail) values ('7','타미힐피거','https://drive.google.com/file/d/13uHNQBykj44maVfm8eSYd9eyjjMlCJH7/view?usp=sharing');
insert into user(user_Id,name,thumbnail) values ('8','챔피온','https://drive.google.com/file/d/1DgW0mGhDmrj7pJ56tcNUxo_id8j0YHhz/view?usp=sharing');
insert into user(user_Id,name,thumbnail) values ('9','잔스포츠','https://drive.google.com/file/d/1P_V5Fku1t_L232UlgZb1SBhOHPCWJP43/view?usp=sharing');
insert into user(user_Id,name,thumbnail) values ('10','버켄스탁','https://drive.google.com/file/d/1u8jcEEoaQdMlPkpWTv2S0N3piGliacm_/view?usp=sharing');
insert into user(user_Id,name,thumbnail) values ('11','칼하트','https://drive.google.com/file/d/1oWhWY4e117CFDP-8i9dtENdlUJTqcYB_/view?usp=sharing');
insert into user(user_Id,name,thumbnail) values ('12','아쿠아 드 폴리','https://drive.google.com/file/d/1ctxWPM-GDY6pYLEuFS4T9UMnoBhu_qzk/view?usp=sharing');
insert into user(user_Id,name,thumbnail) values ('13','헤지스맨 룰429','');
insert into user(user_Id,name,thumbnail) values ('14','','');
insert into user(user_Id,name,thumbnail) values ('15','','');
insert into user(user_Id,name,thumbnail) values ('16','','');
insert into user(user_Id,name,thumbnail) values ('17','','');
insert into user(user_Id,name,thumbnail) values ('18','','');
insert into user(user_Id,name,thumbnail) values ('19','','');
insert into user(user_Id,name,thumbnail) values ('20','','');
insert into user(user_Id,name,thumbnail) values ('21','','');
insert into user(user_Id,name,thumbnail) values ('22','','');
insert into user(user_Id,name,thumbnail) values ('23','','');
insert into user(user_Id,name,thumbnail) values ('24','','');
insert into user(user_Id,name,thumbnail) values ('25','','');
insert into user(user_Id,name,thumbnail) values ('26','','');
insert into user(user_Id,name,thumbnail) values ('27','','');
insert into user(user_Id,name,thumbnail) values ('28','','');
insert into user(user_Id,name,thumbnail) values ('29','','');
insert into user(user_Id,name,thumbnail) values ('30','','');
insert into user(user_Id,name,thumbnail) values ('31','','');
insert into user(user_Id,name,thumbnail) values ('32','','');
insert into user(user_Id,name,thumbnail) values ('33','','');
insert into user(user_Id,name,thumbnail) values ('34','','');
insert into user(user_Id,name,thumbnail) values ('35','','');
insert into user(user_Id,name,thumbnail) values ('36','리베르','https://drive.google.com/file/d/1pO8kSmGLAPyoflzO9mbhhwsnrTVFNI4Y/view?usp=sharing');
insert into user(user_Id,name,thumbnail) values ('37','스탠리','https://drive.google.com/file/d/19GuZyUgrFqoSCh6OVEJINHJj8f1O50Za/view?usp=sharing');
insert into user(user_Id,name,thumbnail) values ('38','워터탱크베이스먼트','https://drive.google.com/file/d/1kuW451FDTMhTyr4qQ5FHLqvxEsym1WsY/view?usp=sharing');
insert into user(user_Id,name,thumbnail) values ('39','칼리타','https://drive.google.com/file/d/1pcFibEoAvBJ13kkwIyS5ZOkgrna7ot1I/view?usp=sharing');


-- 게시글
insert into post(id,product_name,price,thumbnail,detail_page,created_date,closing_date,category_id,user_id,goal)
        values
(1,'공백 세탁조 크리너 실속형 - 1통 4매입',20000,'https://drive.google.com/file/d/1B9bCAtHqvTS4IHPgjRBJDUY7lZCv73fd/view?usp=sharing','https://drive.google.com/file/d/1biucWvVjn6b2PwEmRdddpX8A-JBFUWru/view?usp=sharing','2020-08-21 10:00:00','2020-08-28 23:59:59',1,1,200),
(2,'옷장용 자연제습기 : Water Bottle',28000,'https://drive.google.com/file/d/1krZBopo3cyknnHblRtWAvsq37PC8yew2/view?usp=sharing','https://drive.google.com/file/d/1J0RAS9ZLMCzSiRhqVR27Zp7r4OMtjhPc/view?usp=sharing','2020-08-21 10:00:00','2020-08-28 23:59:59',1,2,200),
(3,'비타클렌징 마이크로필터(녹물제거)',14900,'https://drive.google.com/file/d/1ZcBrOxlzlWPkNfuF2vquAYT-DLcRbRy6/view?usp=sharing','https://drive.google.com/file/d/10NZZY006mv4DPiywgCqoFbx3gyvclcLv/view?usp=sharing','2020-08-21 10:00:00','2020-08-28 23:59:59',1,3,200),
(4,'생활도감 치약 4종 100g',14000,'https://drive.google.com/file/d/1elYyw2boFV3yWdYea_9axIu6yUMsFJMB/view?usp=sharing','https://drive.google.com/file/d/1FtvoMokod63rDvd1ahzYG-sI5nFbi4aJ/view?usp=sharing','2020-08-21 10:00:00','2020-08-28 23:59:59',1,4,200),
(5,'공백 곰팡이 제거젤 5개입',37000,'https://drive.google.com/file/d/1c8cg_OOzC-iKxHD018762mSxY7VRlfDn/view?usp=sharing','https://drive.google.com/file/d/1-1p_Mf1mF1fyDR1GtueGm9_kOjEx1yY4/view?usp=sharing','2020-08-21 10:00:00','2020-08-28 23:59:59',1,1,200),
(6,'프리미엄 솜 타월(10 colors)',15000,'https://drive.google.com/file/d/1eE7phaXGLn5TjUafF_p_ju2EvaqJX9Sp/view?usp=sharing','https://drive.google.com/file/d/18tcMUo6yKDr95t-tnNqrFSlYIdVsmxF9/view?usp=sharing','2020-08-21 10:00:00','2020-08-28 23:59:59',1,5,200),
(7,'나이키_NSW ESSNTL TOP',59900,'https://drive.google.com/file/d/1xg5z0EcGoFiAyoFfOUtHjeivjbIGuj1P/view?usp=sharing','https://drive.google.com/file/d/1DY0bWf9MEgygXqOw_gtSFc5c5AHUDpOY/view?usp=sharing','2020-08-21 10:00:00','2020-08-28 23:59:59',2,6,200),
(8,'타미힐피거 코어 플래그 반팔티 화이트',59000,'https://drive.google.com/file/d/15h7edCa60mvE3IjkJ1Nk58xBHMBKvSJJ/view?usp=sharing','https://drive.google.com/file/d/1XrCQyiUH8lXI03UaxeQS3vnSHwfbgUiI/view?usp=sharing','2020-08-21 10:00:00','2020-08-28 23:59:59',2,7,200),
(9,'클래식 풀랭스 삭스 3SET (WHITE)',21000,'https://drive.google.com/file/d/1wgHbdwY1kCAcJBbqpIiEX9L4RJo2gyoq/view?usp=sharing','https://drive.google.com/file/d/1YbHtmyCvLYGPqxZ0KRu8m8n0ttUGcGDS/view?usp=sharing','2020-08-21 10:00:00','2020-08-28 23:59:59',2,8,200),
(10,'잔스포츠 슈퍼브레이크 블랙',49000,'https://drive.google.com/file/d/19YxiCw8t1J-6hNgwcF3n_eXipO-hFYIX/view?usp=sharing','https://drive.google.com/file/d/1OwwzKH-ajaoB7JZJYTSuqOjDte2QgLI1/view?usp=sharing','2020-08-21 10:00:00','2020-08-28 23:59:59',2,9,200),
(11,'버켄스탁 아리조나 에바 블랙',59000,'https://drive.google.com/file/d/1XepvAP-ZhANk1vXM_0nfcWhQvy5nUjY3/view?usp=sharing','https://drive.google.com/file/d/1uYuOzByiYAsdRZHRk0XXAVZBI36XXTZq/view?usp=sharing','2020-08-21 10:00:00','2020-08-28 23:59:59',2,10,200),
(12,'칼하트 오데사 볼캡 블랙',59000,'https://drive.google.com/file/d/12mVBpUETemiP7Me2-Sic1ROCMajkvbKm/view?usp=sharing','https://drive.google.com/file/d/1YlHShaDSkb_SENTlkaTzWniADqRly4On/view?usp=sharing','2020-08-21 10:00:00','2020-08-28 23:59:59',2,11,200),
(13,'나노 리포좀 헤어 에센스',25000,'https://drive.google.com/file/d/1fYYh4RV-KUrDcEZrk3yGMyHGHddHNeDj/view?usp=sharing','https://drive.google.com/file/d/1v7w3cJ3S3okspfQsRAR_E8SjG0maYHkx/view?usp=sharing','2020-08-20 10:00:00','2020-08-30 23:59:59',3,12,200),
(14,'리베르 섬유향수 80ml',12000,'https://drive.google.com/file/d/1s0ztuQL11GqaS4TXvP8RxYSIOe55EBbg/view?usp=sharing','https://drive.google.com/file/d/1ko0YFrtgkRXBQ-HEEmLrwCD0SidL25AU/view?usp=sharing','2020-08-21 10:00:00','2020-08-28 23:59:59',7,36,200),
(15,'생활도감 10중 스크래퍼 혀클리너',13500,'https://drive.google.com/file/d/1Amg0ywPInMFvWSoG7I4NtEw2-xJoGY0V/view?usp=sharing','https://drive.google.com/file/d/1M6UfXiSKV5BPECvXUDgr3Eao8-g5QQ9E/view?usp=sharing','2020-08-21 10:00:00','2020-08-28 23:59:59',7,4,200),
(16,'스탠리 GO CERAMIVAC',52000,'https://drive.google.com/file/d/1vL2iVeffHh_b2cQ8PVdMjeQEtpuN-cmA/view?usp=sharing','https://drive.google.com/file/d/1-B_0Av05XmySQtCPwmzaF9ZHyIptFl2r/view?usp=sharing','2020-08-21 10:00:00','2020-08-28 23:59:59',7,37,200),
(17,'WATER MELON - gray 인센스 홀더 향꽂이',28000,'https://drive.google.com/file/d/1G6dWmkFl7G4rbTVRlnM0hxN_zRH7ZTKh/view?usp=sharing','https://drive.google.com/file/d/1wwAq6A90eksAWB0llrqqRbS_JA9LGp-G/view?usp=sharing','2020-08-21 10:00:00','2020-08-28 23:59:59',7,38,200),
(18,'칼리타 102LD 드립세트N',50000,'https://drive.google.com/file/d/1Rm9SSWWdncFPnfyTV5xqhT0sZYMl0-Zh/view?usp=sharing','https://drive.google.com/file/d/1sdEmHzbTqVTGpDE0AXPvb_9Zg9YytjQs/view?usp=sharing','2020-08-21 10:00:00','2020-08-28 23:59:59',7,39,200);


-- 댓글
insert into comment(id,created_date, comment,parent_comment_id,post_id,user_id)
values
(1,'2020-08-20 23:59:59','1번',null ,1,1),
(2,'2020-08-20 22:59:59','2번',1 ,1,1),
(3,'2020-08-20 21:59:59','3번',1 ,1,1),
(4,'2020-08-20 23:40:59','4번',1 ,1,1),
(5,'2020-08-20 18:59:59','5번',1 ,1,1),
(6,'2020-08-20 11:59:59','6번',1 ,1,1),
(7,'2020-08-20 23:50:59','7번',1 ,1,1);

-- 할인율
insert into discount(post_id,step,min_require,discount_rate)
values
(1,'FIRST',150,15),
(1,'SECOND',200,20),
(1,'THIRD',230,25),
(2,'FIRST',150,15),
(2,'SECOND',200,20),
(2,'THIRD',230,25),
(3,'FIRST',150,15),
(3,'SECOND',200,20),
(3,'THIRD',230,25),
(4,'FIRST',150,15),
(4,'SECOND',200,20),
(4,'THIRD',230,25),
(5,'FIRST',150,15),
(5,'SECOND',200,20),
(5,'THIRD',230,25),
(6,'FIRST',150,15),
(6,'SECOND',200,20),
(6,'THIRD',230,25),
(7,'FIRST',150,50),
(7,'SECOND',200,60),
(7,'THIRD',230,65),
(8,'FIRST',150,55),
(8,'SECOND',200,60),
(8,'THIRD',230,65),
(9,'FIRST',150,15),
(9,'SECOND',200,20),
(9,'THIRD',230,25),
(10,'FIRST',150,10),
(10,'SECOND',200,15),
(10,'THIRD',230,20),
(11,'FIRST',100,15),
(11,'SECOND',150,20),
(11,'THIRD',200,25),
(12,'FIRST',150,15),
(12,'SECOND',200,20),
(12,'THIRD',230,25),
(13,'FIRST',100,20),
(13,'SECOND',150,25),
(13,'THIRD',200,30),
(14,'FIRST',150,15),
(14,'SECOND',200,20),
(14,'THIRD',230,25),
(15,'FIRST',150,15),
(15,'SECOND',200,20),
(15,'THIRD',230,25),
(16,'FIRST',150,15),
(16,'SECOND',200,20),
(16,'THIRD',230,25),
(17,'FIRST',150,15),
(17,'SECOND',200,20),
(17,'THIRD',230,25),
(18,'FIRST',150,15),
(18,'SECOND',200,20),
(18,'THIRD',230,25);
