use real_estate_news;
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_EMPLOYEE'),(3,'ROLE_CUSTOMER');
INSERT INTO `app_users` VALUES 
('159c674c-d64c-4649-abc0-68564e05dfa0',_binary '','$2a$12$.Mfx0vhTiWRZL723RZD4.uROZM6QVKpYJ4ZM.JSuc54IJVMz7rJAi','admin','abcd'),
('3ebcc654-ecee-4208-9a62-7338d74f9586',_binary '','$2a$12$.Mfx0vhTiWRZL723RZD4.uROZM6QVKpYJ4ZM.JSuc54IJVMz7rJAi','hienplt','abcd'),
('484700e8-56da-4e4f-b904-82cc23c4bd93',_binary '','$2a$12$.Mfx0vhTiWRZL723RZD4.uROZM6QVKpYJ4ZM.JSuc54IJVMz7rJAi','hungnn','abcd');
INSERT INTO `app_users_roles` VALUES
('159c674c-d64c-4649-abc0-68564e05dfa0',1),
('3ebcc654-ecee-4208-9a62-7338d74f9586',2),
('484700e8-56da-4e4f-b904-82cc23c4bd93',3);

insert into images (id, url)
value ( 1 , "https://cdyduochopluc.edu.vn/wp-content/uploads/2019/07/anh-dai-dien-FB-200-1.jpg"),
 ( 2 , "https://cdn.nap.edu.vn/avatar/202192/trend-avatar-facebook-1-1630566628626.jpg");

insert into positions (id, `name`)
value ( 1 , "Nhân Viên"),
  ( 2 , "Kế Toán"),
  ( 3 , "Chuyên Viên"),
  ( 4 , "Trưởng Phòng"),
  ( 5 , "Giám Đốc");

insert into degrees (id, `name`)
value ( 1 , "Trung Cấp"),
  ( 2 , "Cao Đẳng"),
  ( 3 , "Đại Học"),
  ( 4 , "Sau Đại Học");
   insert into customers ( customers.id,customers.address, customers.date_of_birth, customers.deleted, 
customers.email, customers.gender,customers.id_card, customers.`name`, customers.phone_number, customers.app_user_id, customers.image_id)
values("KH-0011","Đà Nẵng", "1997-02-12", 0, "quoctung@gmail.com", "0","197241502", "Lê Quốc Tùng", "0905123321", null, null),
("KH-0002","Quảng Nam", "2000-02-04", 0, "dat@gmail.com", "0","197241502", "Nguyễn Văn Đạt", "0907123456", null, null),
("KH-0003","Hồ Chí Minh", "1990-04-11", 0, "thanhtruc@gmail.com", "1","197241502", "Hoàng Thanh Trúc", "0902345263", null, null),
("KH-0004","Hà Nội", "1994-09-16", 0, "ngocnhat@gmail.com", "0","197241502", "Võ Ngọc Nhật", "0907123123", null, null),
("KH-0005","Cần Thơ", "1996-12-12", 0, "phuocduc@gmail.com", "0","197241502", "Phan Phước Đức", "0902312221", null, null),
("KH-0006","Huế", "1889-05-10", 0, "hoangthien@gmail.com", "0","197241502", "Mai Hoàng Thiện", "0909123897", null, null),
("KH-0007","Quảng Trị", "2002-02-28", 0, "thaovi@gmail.com", "1","197241502", "Nguyễn Thị Thảo Vi", "0907129873", null, null),
("KH-0008","Quảng Bình", "1987-07-24", 0, "tuanhuynh@gmail.com", "0","197241502", "Huỳnh Tuấn", "0934123987", null, null),
("KH-0009","Bình Định", "1995-03-12", 0, "bichtram@gmail.com", "1","197241502", "Ngô Thị Bích Trâm", "0923876982", null, null),
("KH-00010","Phú Yên", "1993-09-09", 0, "nhatminh@gmail.com", "0","197241502", "Phan Nhật Minh", "0905888999", null, null);
  insert into real_estate_type (id, `name`)
value ( 1 , "Đất"),
  ( 2 , "Nhà ở");
    insert into directions (id, `name`)
value ( 1 , 'Đông'),
  ( 2 , "Đông Nam"),
  ( 3 , "Đông Bắc"),
  ( 4 , "Tây"),
  ( 5 , "Tây Nam"),
  ( 6 , "Tây Bắc"),
  ( 7 , "Nam"),
  ( 8 , "Bắc");
  insert into real_estate_news (id,address,approval,area,`description`,kind_of_news,price,
  `status`,title,customer_id,direction_id,real_estate_type_id)
  values
  ("BD-1001", "Đường 2/9, Phường Hòa Cường Bắc, Hải Châu, Đà Nẵng","1",100,
  "Chính chủ cần bán cặp đất mặt tiền đường 2/9, trục đường chính của thành phố Đà Nẵng,
  Nằm trong cụm khai thác tổ hợp khách sạn, du lịch, văn phòng cho thuê...
  Đối diện khu thương mại tổ hợp dịch vụ du lịch bậc nhất Đà Nẵng.",
  "1", 15000000000,"1", "BÁN GẤP CẶP ĐẤT ĐƯỜNG 2/9",
  "KH-0002", 1, 1);
   insert into real_estate_news (id,address,approval,area,`description`,kind_of_news,price,
  `status`,title,customer_id,direction_id,real_estate_type_id)
  values
  ("BD-1002", "Nguyễn Hữu Thọ, Thanh Khê, Đà Nẵng","1",100,
  "Bán đất nền trung tâm thành phố, Đường rộng, mặt tiền gần sân bay gần trung tâm",
  "1", 15000000000,"1", "Bán đất mặt tiền Nguyễn Hữu Thọ",
  "KH-0002", 4, 1),
("BD-1011", "Trần Phú, Hải Châu, Đà Nẵng","1",200,
"Sở hữu vị trí trung tâm của trung tâm thành phố Đà Nẵng",
 2, 450000000,1, "MẶT BẰNG ĐƯỜNG TRẦN PHÚ-BẠCH ĐẰNG",
 "KH-0003", 2, 2),
 ("BD-1003", "Hòa Xuân, Đà Nẵng","1",100,
"Sở hữu vị trí trung tâm của trung tâm thành phố Đà Nẵng",
 1, 4000000000,1, "Bán lô góc Hòa Xuân giá rẻ",
 "KH-0003", 3, 1),
 ("BD-1004", "Đường Nại Nam, Phường Hòa Cường Bắc, Hải Châu, Đà Nẵng","1",100,
"Chính chủ cần bán gấp căn nhà phố ngay trung tâm Đà Nẵng - Cạnh siêu thị Lotte mart.
Nhà phố thương mại, đồng bộ mặt ngoài giúp cho dãy phố sang trọng, khác biệt với các khu phố hiện trạng tại Đà Nẵng.",
 1, 400000000,1, "NHÀ PHỐ 4 TẦNG CẠNH LOTTE MART",
 "KH-0003", 3, 2),
  ("BD-1005", "Đường Bạch Đằng, Phường Hòa Thuận Đông, Hải Châu, Đà Nẵng","1",100,
"Chính chủ cần bán gấp căn nhà phố ngay trung tâm Đà Nẵng - Cạnh siêu thị Lotte mart.
Nhà phố thương mại, đồng bộ mặt ngoài giúp cho dãy phố sang trọng, khác biệt với các khu phố hiện trạng tại Đà Nẵng.",
 1, 8000000000,1, "CẦN BÁN LÔ ĐẤT MẶT TIỀN ĐƯỜNG BẠCH ĐẰNG",
 "KH-0004", 1, 2),
("BD-1006", "Bán căn hộ chung cư tại HaDo Centrosa Garden - Quận 10 - Hồ Chí Minh","1",100,
"Cần bán căn hộ Hà Đô Centrosa Garden, Q10:
- Căn 2pn loại 86m2.
- Lầu 6 trở lên.
- Theo giá thị trường. (6 - 6,3 tỷ).",
 1, 13000000,1, "Cần mua Hà Đô Centrosa căn 2pn",
 "KH-0005", 1, 2),
 ("BD-1007", "Bán căn hộ chung cư tại Quận Nam Từ Liêm - Hà Nội","1",100,
"- Loanh quanh bán kính 1 - 2km so với Nguyễn Văn Giáp, Hàm Nghi, Vinhome Gardenia, Lê Đức Thọ, Trần Hữu Dực:
- Không cần mới nhưng không bàn giao cũ quá 10 năm.
- Có quỹ bảo trì của ban quản trị.
- Loanh quanh 2 tỷ.",
 1, 13000000,1, "Cần bán chung cư cũ 2 - 3 PN",
 "KH-0005", 1, 2),
  ("BD-1008", "Xã Ngọc Thanh - Thành phố Phúc Yên - Vĩnh Phúc","1",1000,
"Hiện tại mình đang muốn cho thuê đất tại khu vực Đại Lải, Phúc Yên.
Diện tích 1000m2. View hồ hoặc trong khu đô thị, full thổ cư.
Giá từ 10 - 15 tỷ.",
 2, 150000000,1, "Cho thuê đất khu vực Đại Lải, Phúc Yên, Vĩnh Phúc",
 "KH-0006", 1, 1),
("BD-1009", "Phường An Hòa - Thành phố Biên Hòa - Đồng Nai","1",100,
"Hiện tại tôi đang có một số khách đầu tư cần bán đất khu vực P. An Hòa.
Diện tích từ 60m2 đổ lên, nằm trên đường giao thông thuận tiện,
không dính quy hoạch. Đất có thổ cư",
 2, 1300000,1, "Cần thuê đất phường An Hoà",
 "KH-0007", 1, 2),
    ("BD-1010", "Quận 2, Thành phố Thủ Đức - Hồ Chí Minh","1",100,
"Nguồn khách có nhu cầu bán đất nhà phố biệt thự ở kinh doanh và đầu tư khu vực quận 2,
tp Thủ Đức. Các phường Bình An, An Phú An Khánh, Thảo điền. Diện tích 5x20m, 8x20m, 10x20m,
 20x20m hoặc lớn hơn hoặc đất biệt thự 500 đến 600m2 hoặc nhà mới đẹp...",
 2, 1300000000,1, "Cần mua đất nhà phố biệt thự quận 2, tp Thủ Đức",
 "KH-0009", 6, 1)
;
insert into employees (id, address, date_of_birth,deleted, email, gender,id_card, `name`, phone_number, app_user_id
,degree_id, image_id,position_id) 
VALUES ("NV-1001","Đà Nẵng","1998-10-30", 0,"quoctung@gmail.com","1","197241502","Lê Quốc Tùng","0911111111",null,1,1,1);
insert into employees (id, address, date_of_birth,deleted, email, gender, id_card, `name`, phone_number, app_user_id
,degree_id, image_id,position_id) 
values("NV-0002","Huế","1988-10-30", 0,"bichphuong@gmail.com","0","197241502","Mai Thị Bích Phương","0911111111",null,1,1,1),
  ("NV-0003","Quảng Trị","1989-12-30", 0,"nam@gmail.com","1","197241502","Nguyễn Văn Nam","0911111111",null,3,2,1),
  ("NV-0004","Quảng Ngãi","1992-04-30", 0,"phamkhoa@gmail.com","1","197241502","Phạm Khoa","0911111111",null,2,1,1),
  ("NV-0005","Cần Thơ","1995-12-12", 0,"nhatvuong@gmail.com","1","197241502","Phạm Khoa","0911111111",null,2,1,1),
  ("NV-0006","Quảng Bình","1997-04-12", 0,"hathu@gmail.com","0","197241502","Trương Thị Hà Thư","0911111111",null,1,1,1),
  ("NV-0007","Vũng Tàu","1999-04-19", 0,"ainhu@gmail.com","0","197241502","Lê Ái Như","0911111111",null,1,1,1),
  ("NV-0008","Quảng Ngãi","1998-04-01", 0,"thinh@gmail.com","1","197241502","Lê Phước Thịnh","0911111111",null,3,2,1),
  ("NV-0009","Quảng Nam","1998-04-01", 0,"thinh@gmail.com","1","197241502","Lê Phước Thịnh","0911111111",null,3,2,1),
  ("NV-0010","Hà Nội","1998-04-01", 0,"thinh@gmail.com","1","197241502","Đoàn Thị Điểm","0911111111",null,3,2,1),
  ("NV-0011","Quảng Ngãi","1998-04-01", 0,"thinh@gmail.com","1","197241502","Lê Phước Thịnh","0911111111",null,3,2,1);
  
insert into images (id, `url`)
value ( 3 , "https://file4.batdongsan.com.vn/crop/257x147/2021/11/28/20211128220348-1a17_wm.jpg"),
  ( 4 , "https://file4.batdongsan.com.vn/crop/257x147/2022/01/04/20220104095042-13c2_wm.jpg"),
  (5 , "https://file4.batdongsan.com.vn/crop/257x147/2020/03/17/20200317102146-f05d_wm.jpg"),
  ( 6 , "https://file4.batdongsan.com.vn/crop/257x147/2022/01/14/20220114163532-f5e4_wm.jpg"),
  ( 7 , "https://file4.batdongsan.com.vn/crop/257x147/2021/12/22/20211222163505-ecad_wm.jpg"),
  ( 8 , "https://file4.batdongsan.com.vn/crop/257x147/2020/07/18/20200718122425-1bef_wm.jpg"),
  ( 9 , "https://file4.batdongsan.com.vn/crop/260x146/2021/06/13/20210613155351-c517.jpg"),
  ( 10 , "https://file4.batdongsan.com.vn/crop/260x146/2021/12/08/20211208165329-3714.jpg"),
  ( 11 , "https://file4.batdongsan.com.vn/crop/354x200/2022/01/11/wxbwknn6/20220111162607-84e4.jpg");

  insert into real_estate_news_image_list (real_estate_news_id, image_list_id)
  value ('BD-1002', 11),
  ('BD-1003', 3),
  ('BD-1004', 4),
  ('BD-1005', 5),
  ('BD-1006', 6),
  ('BD-1007', 7),
  ('BD-1008', 8),
  ('BD-1009', 9),
  ('BD-1011', 10);
  