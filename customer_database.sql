SELECT * FROM real_estate_news.customers;
use real_estate_news;
insert into customers ( customers.id,customers.address, customers.date_of_birth, customers.deleted, 
customers.email, customers.gender, customers.`name`, customers.phone_number, customers.app_user_id, customers.image_id)
values("KH-0011","Đà Nẵng", "1997-02-12", 0, "quoctung@gmail.com", "0", "Lê Quốc Tùng", "0905123321", null, null),
("KH-0002","Quảng Nam", "2000-02-04", 0, "dat@gmail.com", "0", "Nguyễn Văn Đạt", "0907123456", null, null),
("KH-0003","Hồ Chí Minh", "1990-04-11", 0, "thanhtruc@gmail.com", "1", "Hoàng Thanh Trúc", "0902345263", null, null),
("KH-0004","Hà Nội", "1994-09-16", 0, "ngocnhat@gmail.com", "0", "Võ Ngọc Nhật", "0907123123", null, null),
("KH-0005","Cần Thơ", "1996-12-12", 0, "phuocduc@gmail.com", "0", "Phan Phước Đức", "0902312221", null, null),
("KH-0006","Huế", "1889-05-10", 0, "hoangthien@gmail.com", "0", "Mai Hoàng Thiện", "0909123897", null, null),
("KH-0007","Quảng Trị", "2002-02-28", 0, "thaovi@gmail.com", "1", "Nguyễn Thị Thảo Vi", "0907129873", null, null),
("KH-0008","Quảng Bình", "1987-07-24", 0, "tuanhuynh@gmail.com", "0", "Huỳnh Tuấn", "0934123987", null, null),
("KH-0009","Bình Định", "1995-03-12", 0, "bichtram@gmail.com", "1", "Ngô Thị Bích Trâm", "0923876982", null, null),
("KH-00010","Phú Yên", "1993-09-09", 0, "nhatminh@gmail.com", "0", "Phan Nhật Minh", "0905888999", null, null);