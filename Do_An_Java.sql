-- --------------------------------------------------------------------TẠO DATABASE---------------------------------------------------------------------
-- use master
-- go
-- if exists(select *from sysdatabases where name='QUAN_LY_QUAN_CAFE')
-- drop database QUAN_LY_QUAN_CAFE
-- go
create DATABASE QUAN_LY_QUAN_CAFE;
-- GO
USE QUAN_LY_QUAN_CAFE;
-- GO
-- ---------------------------------------------------------------TẠO BẢNG,KHOÁ CHÍNH,KHOÁ NGOẠI--------------------------------------------------------
-- ------ TẠO BẢNG TAIKHOAN
CREATE TABLE QUANTRI
(
	TENTK VARCHAR(20) NOT NULL PRIMARY KEY,
	MATKHAU VARCHAR(200) not null
);
CREATE TABLE BAN
(
	MABAN CHAR(10) NOT NULL PRIMARY KEY,
	TENBAN NVARCHAR(30) NOT NULL,
	TINHTRANG BIT DEFAULT 0
);

-- ------ TẠO BẢNG NHANVIEN
CREATE TABLE NHANVIEN
(
	MANV CHAR(10) NOT NULL PRIMARY KEY,
	MATKHAU VARCHAR(200) NOT NULL,
    TENNV NVARCHAR(30) NOT NULL,
	GIOITINH NCHAR(5),
	DIACHI NVARCHAR(50),
	NAMSINH DATE,
	NGAYVL DATE NOT NULL,
	SODT CHAR(11),
	LUONG FLOAT
);
-- ------ TẠO BẢNG LOAIKH
CREATE TABLE LOAIKH
(
	MALOAIKH CHAR(10) NOT NULL PRIMARY KEY,
	TENLOAIKH NVARCHAR(50) NOT NULL,
	GIAMGIA FLOAT
);
-- ------ TẠO BẢNG KHACHHANG
CREATE TABLE KHACHHANG
(
	MAKH CHAR(10) NOT NULL PRIMARY KEY,
	TENKH NVARCHAR(30) NOT NULL,
	GIOITINH NCHAR(5),
	DIACHI NVARCHAR(50),
	SDT CHAR(11),
	MALOAIKH CHAR(10),
	CONSTRAINT FK_KHACHHANG_LOAIKH FOREIGN KEY(MALOAIKH) REFERENCES LOAIKH(MALOAIKH)
);

-- ------ TẠO BẢNG LOAINUOC
CREATE TABLE LOAINUOC
(
	MALOAINUOC CHAR(10) NOT NULL PRIMARY KEY,
	TENLOAINUOC NVARCHAR(30)
);
-- ------ TẠO BẢNG MONAN
CREATE TABLE NUOCUONG
(
	MANUOCUONG CHAR(10) NOT NULL PRIMARY KEY,
	TENNUOCUONG NVARCHAR(30),
	MALOAINUOC CHAR(10),
	DONGIA FLOAT,
	CONSTRAINT FK_MONAN_LOAINUOC FOREIGN KEY(MALOAINUOC) REFERENCES LOAINUOC(MALOAINUOC)
);

-- ------ TẠO BẢNG NHAPKHO
CREATE TABLE NHAPKHO
(
	MANHAP CHAR(10) NOT NULL PRIMARY KEY,
	NGAYNHAP DATE,
	MANV CHAR(10),
	THANHTIEN FLOAT,
	CONSTRAINT FK_NHAPKHO_NHANVIEN FOREIGN KEY(MANV) REFERENCES NHANVIEN(MANV)
);
-- ------ TẠO BẢNG CHITIETNK
CREATE TABLE CHITIETNK
(
	MANHAP CHAR(10) NOT NULL,
	MANUOCUONG CHAR(10) NOT NULL,
	SOLUONG INT,
	GIANHAP FLOAT,
	THANHTIEN FLOAT,
	CONSTRAINT PK_CHITIETNK PRIMARY KEY(MANHAP,MANUOCUONG),
	CONSTRAINT FK_CHITIETNK_NHAPKHO FOREIGN KEY(MANHAP) REFERENCES NHAPKHO(MANHAP),
	CONSTRAINT FK_CHITIETNK_NUOCUONG FOREIGN KEY(MANUOCUONG) REFERENCES NUOCUONG(MANUOCUONG) 
);
-- ------ TẠO BẢNG HOADON
CREATE TABLE HOADON
(
	MAHD CHAR(10) NOT NULL PRIMARY KEY,
	NGAYRAHD DATE,
	THANHTOAN FLOAT,
	MANV CHAR(10),
	GIAMGIA FLOAT,
	MABAN CHAR(10),
	CONSTRAINT FK_HOADON_NHANVIEN FOREIGN KEY(MANV) REFERENCES NHANVIEN(MANV),
	CONSTRAINT FK_HOADON_BAN FOREIGN KEY(MABAN) REFERENCES BAN(MABAN)
);

-- ------ TẠO BẢNG CHITIETHD
CREATE TABLE CHITIETHD
(
	MAHD CHAR(10) NOT NULL,
	MANUOCUONG CHAR(10) NOT NULL,
	SOLUONG INT,
	DONGIA FLOAT,
	THANHTIEN FLOAT,
	CONSTRAINT PK_CHITIETHD PRIMARY KEY(MAHD,MANUOCUONG),
	CONSTRAINT FK_CHITIETHD_HOADON FOREIGN KEY(MAHD) REFERENCES HOADON(MAHD),
	CONSTRAINT FK_CHITIETHD_NUOCUONG FOREIGN KEY(MANUOCUONG) REFERENCES NUOCUONG(MANUOCUONG)
);

-- -------------------------------------------------------------Tạo ràng buộc toàn vẹn------------------------------------------------------------------
-- -----------------Bảng NHANVIEN
-- ----LƯƠNG PHẢI LỚN HƠN 0
ALTER TABLE NHANVIEN ADD CONSTRAINT CHK_LUONG CHECK(LUONG>0);
-- ----GIỚI TÍNH THUỘC NAM HOẶC NỮ
ALTER TABLE NHANVIEN ADD CONSTRAINT CHK_GIOITINH_NV CHECK(GIOITINH IN('NAM',N'NỮ'));
-- -----------------Bảng LOAIKH
-- ----TÊN LOẠI KHÁCH HÀNG LÀ DUY NHẤT
ALTER TABLE LOAIKH ADD CONSTRAINT UNI_TENLOAIKH UNIQUE(TENLOAIKH);
-- ----GIẢM GIÁ PHẢI LỚN HƠN HOẶC BẰNG 0
ALTER TABLE LOAIKH ADD CONSTRAINT CHK_GIAMGIA_LOAIKH CHECK(GIAMGIA>=0);
-- -----------------Bảng KHACHHANG
-- ----GIỚI TÍNH THUỘC NAM HOẶC NỮ
ALTER TABLE KHACHHANG ADD CONSTRAINT CHK_GIOITINH_KH CHECK(GIOITINH IN('NAM',N'NỮ'));
-- -----------------Bảng LOAINUOCUONG
-- ------TÊN LOẠI MÓN PHẢI DUY NHẤT
ALTER TABLE LOAINUOC ADD CONSTRAINT UNI_TENLOAINUOC UNIQUE(TENLOAINUOC);
-- -----------------Bảng NUOCUONG
-- ------TÊN MÓN PHẢI DUY NHẤT
ALTER TABLE NUOCUONG ADD CONSTRAINT UNI_TENNUOCUONG UNIQUE(TENNUOCUONG);
-- ------ĐƠN GIÁ PHẢI LỚN HƠN 0
ALTER TABLE NUOCUONG ADD CONSTRAINT CHK_DONGIA_NUOCUONG CHECK(DONGIA>0);
-- -----------------Bảng BAN
-- ----TÊN BÀN LÀ DUY NHẤT
ALTER TABLE BAN ADD CONSTRAINT UNI_TENBAN UNIQUE(TENBAN);
-- -----------------Bảng HOADON
-- ------THANH TOÁN PHẢI LỚN HƠN 0
ALTER TABLE HOADON ADD CONSTRAINT CHK_THANHTOAN CHECK(THANHTOAN>0);
-- -----------------Bảng CHITIETHD
-- ------SỐ LƯỢNG PHẢI LỚN HƠN 0
ALTER TABLE CHITIETHD ADD CONSTRAINT CHK_SOLUONG_CTHD CHECK(SOLUONG>0);
-- ------THÀNH TIỀN PHẢI LỚN HƠN 0
ALTER TABLE CHITIETHD ADD CONSTRAINT CHK_THANHTIEN_CTHD CHECK(THANHTIEN>0);
-- ------ĐƠN GIÁ PHẢI LỚN HƠN 0
ALTER TABLE CHITIETHD ADD CONSTRAINT CHK_DONGIA_CTHD CHECK(DONGIA>0);
-- ------------------BẢNG CHITIETNK
-- ------SỐ LƯỢNG PHẢI LỚN HƠN 0
ALTER TABLE CHITIETNK ADD CONSTRAINT CHK_SOLUONG_CTNK CHECK(SOLUONG>0);
-- ------GIÁ NHẬP PHẢI LỚN HƠN 0
ALTER TABLE CHITIETNK ADD CONSTRAINT CHK_GIANHAP_CTNK CHECK(GIANHAP>0);
-- ------THÀNH TIỀN PHẢI LỚN HƠN 0
ALTER TABLE CHITIETNK ADD CONSTRAINT CHK_THANHTIEN_CTNK CHECK(THANHTIEN>0);

-- ------------------------------------------------------------INSERT DỮ LIỆU---------------------------------------------------------------------------
-- ----BẢNG QUẢN TRỊ
-- ---mật khẩu: admin
insert into QUANTRI values
('admin','21232f297a57a5a743894a0e4a801fc3');
-- ----BẢNG BÀN
-- SET @i := 1;
-- WHILE (@i <= 20) DO
--     INSERT INTO BAN (MABAN, TENBAN)
--     VALUES (CONCAT('B', CAST(@i AS CHAR(10))), CONCAT('Bàn ', CAST(@i AS CHAR(10))));
--     SET @i := @i + 1;
-- END WHILE;
-- ----BẢNG NHÂN VIÊN
-- SET DATEFORMAT DMY
-- --mật khẩu:12345
INSERT INTO NHANVIEN VALUES
('NV01','827ccb0eea8a706c4c34a16891f84e7b',N'Nguyễn Ngọc Tú Anh',N'Nữ',N'TP.HCM','23/04/1999','14/03/2019','0234327865',2000000),
('NV02','827ccb0eea8a706c4c34a16891f84e7b',N'Dương ĐÔng Duy',N'Nam',N'Tiền Giang','06/12/2001','14/06/2020','0382762835',2300000),
('NV03','827ccb0eea8a706c4c34a16891f84e7b',N'Điêu Ngọc Trinh',N'Nữ',N'TP.HCM','17/10/2001','20/03/2020','05097362749',2300000),
('NV04','827ccb0eea8a706c4c34a16891f84e7b',N'Lê Xuân Bắc',N'Nam',N'Đắk Lắk','05/06/2001','15/03/2019','0234327865',2000000),
('NV05','827ccb0eea8a706c4c34a16891f84e7b',N'Nguyễn Thị Thảo Vy',N'Nữ',N'Tiền Giang','03/02/2001','03/03/2019','0353676482',2000000),
('NV06','827ccb0eea8a706c4c34a16891f84e7b',N'Ngô Thanh Huyền',N'Nữ',N'Quảng Bình','10/03/2001','03/12/2018','0583527543',2000000),
('NV07','827ccb0eea8a706c4c34a16891f84e7b',N'Võ Thị Thu Hà',N'Nữ',N'Bình Định','10/03/2001','30/3/2019','0738456281',5000000),
('NV08','827ccb0eea8a706c4c34a16891f84e7b',N'Trần Tuấn Anh',N'Nam',N'Long An','07/12/2000','08/03/2020','0487362873',2000000),
('NV09','827ccb0eea8a706c4c34a16891f84e7b',N'Lưu Thanh Bình',N'Nam',N'Phú Yên','28/02/1999','23/09/2020','0387529267',2000000),
('NV10','827ccb0eea8a706c4c34a16891f84e7b',N'Vũ Thị Thanh Danh',N'Nữ',N'TP.HCM','04/05/1999','23/03/2020','0473526483',2000000);
-- ---BẢNG LOAIKH
INSERT INTO LOAIKH VALUES
('MLK01',N'KHÁCH HÀNG VIP',10),
('MLK02',N'KHÁCH HÀNG TIỀM NĂNG',8),
('MLK03',N'KHÁCH HÀNG THÂN THIẾT',5);
-- ---BẢNG KHACHHANG

INSERT INTO KHACHHANG VALUES
('KH01',N'Nguyễn Hải Đăng',N'Nam',N'TP.HCM','0364767243','MLK01'),
('KH02',N'Hoàng Tiến Đạt',N'Nam',N'Cần Thơ','0463745625','MLK02'),
('KH03',N'Trịnh Đông Duy',N'Nam',N'An Giang','0975645370','MLK03'),
('KH04',N'Võ Thùy Dương',N'Nữ',N'Long An','0976352638','MLK02'),
('KH05',N'Nguyễn Thị Hạnh Duyên',N'Nữ',N'TP.HCM','0945324538','MLK02'),
('KH06',N'Nguyễn Nhật Hào',N'Nam',N'TP.HCM','0463725379','MLK03'),
('KH07',N'Trương Thị Hoa',N'Nữ',N'TP.HCM','0403647365','MLK02'),
('KH08',N'Trần Thị Thúy Hòa',N'Nữ',N'TP.HCM','0402045342','MLK01'),
('KH09',N'Trần Thị Kiều Oanh',N'Nữ',N'TP.HCM','0286534271','MLK03'),
('KH10',N'Trần Thị Thu Hồng',N'Nữ',N'TP.HCM','04837523527','MLK02'),
('KH11',N'Nguyễn Thị Hồng',N'Nữ',N'TP.HCM','0354828423','MLK02'),
('KH12',N'Dỗ Thị Ngọc Hương',N'Nữ',N'TP.HCM','0835427287','MLK03'),
('KH13',N'Lê Thanh Tuấn Kiệt',N'Nam',N'TP.HCM','09876543212','MLK01'),
('KH14',N'Mai Đức Kiều',N'NAM',N'TP.HCM','0925362438','MLK02'),
('KH15',N'Huỳnh Trọng Hiển',N'Nam',N'Tiền Giang','0987678678','MLK02'),
('KH16',N'Nguyễn Minh Nhựt',N'Nam',N'Vĩnh Long','0876563211','MLK01'),
('KH17',N'Nguyễn Thảo Hương Quỳnh',N'Nữ',N'Kiên Giang','0376880903','MLK03'),
('KH18',N'Nguyễn Trần Hòa Hợp',N'Nữ',N'Bến Tre','0988322241','MLK02'),
('KH19',N'Lê Hiếu Nghĩa',N'Nam',N'Bến Tre','0878493212','MLK02'),
('KH20',N'Nguyễn Minh Đức',N'Nam',N'Cà Mau','0987771232','MLK03');
-- -----BẢNG LOAINUOC

INSERT INTO LOAINUOC VALUES
('LN01',N'COFFEE'),
('LN02',N'MILK TEA'),
('LN03',N'YAOURT'),
('LN04',N'SINH TỐ'),
('LN05',N'MATCHA'),
('LN06',N'ICE BLENDED'),
('LN07',N'SODA'),
('LN08',N'FLAVORRED'),
('LN09',N'NƯỚC ÉP'),
('LN10',N'FRESH FRUIT TEA');

-- ------ INSERT BẢNG NUOCUONG

INSERT INTO NUOCUONG VALUES
('N01',N'COFFEE ĐEN','LN01',14000),
('N02',N'SỮA TƯƠI COFFEE','LN01',18000),
('N03',N'TRÀ SỮA BÁ TƯỚC','LN02',220000),
('N04',N' TRÀ SỮA SOCOLA','LN02',20000),
('N05',N'YAOURT ĐÁ','LN03 ',250000),
('N06',N'YAOURT DÂU','LN03 ',25000),
('N07',N'YAOURT TRÁI CÂY','LN03 ',25000),
('N08',N'SINH TỐ DƯA HẤU','LN04',28000),
('N09',N'SINH TỐ DỪA','LN04',28000),
('N10',N'SINH TỐ CAM','LN04',28000),
('N11',N'MATCHA MẬT ONG','LN05',30000),
('N12',N'MATCHA MANGO','LN05',30000),
('N13',N'MATCHA OREO','LN05',30000),
('N14',N'MATCHA ĐẬU ĐỎ','LN05',30000),
('N15',N'ĐÁ XAY VỊ DÂU','LN06',30000),
('N16',N'ĐÁ XAY VỊ PHÚC BỒN TỬ','LN06',30000),
('N17',N'SODA BẠC HÀ','LN07',20000),
('N18',N'SODA CHANH','LN07',20000),
('N19',N'HỒNG TRÀ','LN08',15000),
('N20',N'TRÀ HOA ĐẬU BIẾC','LN08',22000),
('N21',N'TRÀ BÁ TƯỚC','LN08',25000),
('N22',N'TRÀ OLONG','LN08',25000),
('N23',N'NƯỚC ÉP CAM','LN09',26000),
('N24',N'NƯỚC ÉP TÁO','LN09',23000),
('N25',N'NƯỚC ÉP DƯA HẤU','LN09',19000),
('N26',N'NƯỚC ÉP DÂU','LN09',20000),
('N27',N'NƯỚC ÉP THƠM','LN09',20000),
('N28',N'TRÀ DÂU HOA HỒNG','LN10',30000),
('N29',N'TRÀ ĐÀO CAM SẢ','LN10',30000),
('N30',N'TRÀ DÂU CAM VÀNG','LN10',30000);
-- go
-- -----Trigger xoá loại nước các bảng liên quan cũng xoá theo
-- create trigger xoaLoaiNuoc on loaiNuoc
-- instead of delete
-- as
-- begin
-- declare mycursor cursor for
-- 	select maloaiNuoc from deleted
-- 	open mycursor
-- 	declare @maloainuoc char(10)
-- 	fetch next from mycursor into @maloainuoc
-- 	while(@@FETCH_STATUS=0)
-- 	begin	
-- 		delete NUOCUONG where MALOAINUOC=@maloainuoc
-- 		delete LOAINUOC where MALOAINUOC=@maloainuoc
-- 	fetch next from mycursor into @maloainuoc
-- 	end
-- 	close mycursor
-- 	deallocate mycursor
-- end
-- go
-- ---Trigger xoá nước uống các bảng liên quan cũng xoá theo
-- --create trigger xoaNuocUong on nuocUOng
-- --instead of delete 
-- --as
-- --begin
-- --	declare mycursor1 cursor 
-- --	for select manuocuong from deleted
-- --	open mycursor1
-- --	declare @manuocuong char(10)
-- --	fetch next from mycursor1 into @manuocuong
-- --	while(@@FETCH_STATUS=0)
-- --	begin
-- --		delete chitietnk where MANUOCUONG=@manuocuong
-- --		delete chitiethd where MANUOCUONG=@manuocuong
-- --		delete nuocuong where MANUOCUONG=@manuocuong
-- --		fetch next from mycursor1 into @manuocuong
-- --	end
-- --	close mycursor1
-- --	deallocate mycursor1
-- 	
-- --end
-- --go

-- ---trigger xoá hoadon các bảng liên quan xoá theo
-- create trigger xoaHD on hoadon
-- instead of delete
-- as
-- begin
-- 	declare @mahd char(10)
-- 	select @mahd=mahd from deleted
-- 	delete CHITIETHD where MAHD=@mahd
-- 	delete hoadon where mahd=@mahd
-- end
-- -- go
-- -- ---trigger xoá nhapkho các bảng liên quan xoá theo
-- create trigger xoaNK on nhapkho
-- instead of delete
-- as
-- begin
-- 	declare @manhap char(10)
-- 	select @manhap=manhap from deleted
-- 	delete CHITIETnk where MANHAP=@manhap
-- 	delete NHAPKHO where manhap=@manhap
-- end
-- -- go
-- ---Trigger xoá nhân viên các bảng liên quan cũng xoá theo
-- create trigger xoaNV on nhanvien
-- instead of delete
-- as
-- begin
-- 	declare @manv char(10),@count int
-- 	select @manv=manv from deleted
-- 	select @count=count(*) from hoadon where MANV=@manv
-- 	while(@count!=0)
-- 	begin
-- 	delete HOADON where MANV=@manv	
-- 	set @count=@count-1
-- 	end
-- 	select @count=count(*) from NHAPKHO where MANV=@manv
-- 	while(@count!=0)
-- 	begin
-- 	delete NHAPKHO where MANV=@manv
-- 	set @count=@count-1
-- 	end
-- 	delete nhanvien where manv=@manv
-- end
-- go

-- ---trigger cập nhật thanhToan cho hoadon
-- --create trigger updateThanhToan on chitiethd
-- --after delete
-- --as
-- --begin
-- --	declare cs  cursor	
-- --	for select mahd from deleted
-- --	open cs
-- --	declare @mahd char(10)
-- --	fetch next from cs into @mahd
-- --	while(@@FETCH_STATUS=0)
-- --	begin
-- --		declare @thanhtien float		
-- --		select @thanhtien=sum(thanhtien) from CHITIETHD where MAHD=@mahd
-- --		if(@thanhtien>0)
-- --		update HOADON
-- --		set thanhtoan=@thanhtien - @thanhtien*(giamgia/100.0)
-- --		where MAHD=@mahd
-- --		else
-- --		delete hoadon where mahd=@mahd
-- --		fetch next from cs into @mahd
-- --	end
-- --	close cs
-- --	deallocate cs
-- --end

-- go
-- ---trigger cập nhật lại thành tiền cho nhapkho
-- --create trigger updateThanhTien on chitietnk
-- --after delete 
-- --as
-- --begin
-- --	declare cs  cursor	
-- --	for select MANHAP from deleted
-- --	open cs
-- --	declare @mank char(10)
-- --	fetch next from cs into @mank
-- --	while(@@FETCH_STATUS=0)
-- --	begin
-- --		declare @thanhtien float		
-- --		select @thanhtien=sum(thanhtien) from CHITIETNK where MANHAP=@mank
-- --		if(@thanhtien>0)
-- --		update nhapkho
-- --		set THANHTIEN=@thanhtien
-- --		where manhap=@mank
-- --		else
-- --		delete NHAPKHO where manhap=@mank
-- --		fetch next from cs into @mank
-- --	end
-- --	close cs
-- --	deallocate cs
-- --end
-- -- go
-- -- ------Thủ tục tìm ra nước uống bán ra nhiều nhất
-- create proc nuocUongBanNhieuNhat
-- as
-- select CHITIETHD.MANUOCUONG,TENNUOCUONG,SUM(soluong) 'TSL',SUM(THANHTIEN) 'TTT',CHITIETHD.DONGIA from CHITIETHD,NuocUong where CHITIETHD.MANUOCUONG=NUOCUONG.MANUOCUONG 
-- group by CHITIETHD.MANUOCUONG,TENNUOCUONG,CHITIETHD.DONGIA
-- having sum(soluong)=(select distinct SUM(soluong) from CHITIETHD 
-- group by MANUOCUONG
-- having sum(soluong)>=all(select sum(soluong) from CHITIETHD group by MANUOCUONG))
-- -- go
-- -- ---Trigger xoá loaikh các bảng liên quan cũng xoá theo
-- create trigger xoaloaiKH on loaikh
-- instead of delete 
-- as
-- begin
-- 	declare mycursor cursor for
-- 	select maloaikh from deleted
-- 	open mycursor
-- 	declare @maloaikh char(10)
-- 	fetch next from mycursor into @maloaikh
-- 	while(@@FETCH_STATUS=0)
-- 	begin
-- 	delete KHACHHANG where MALOAIKH=@maloaikh
-- 	delete LOAIKH where MALOAIKH=@maloaikh
-- 	fetch next from mycursor into @maloaikh
-- 	end
-- 	close mycursor
-- 	deallocate mycursor
-- end
