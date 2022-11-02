create database ontap
create table LoaiNGK
(
	Maloai char(30),
	Tenloai nvarchar(30)
	constraint PK_Maloai primary key(maloai),
	unique(tenloai)
)

create table NGK
(
	MaNGK char(30),
	TenNGK nvarchar(30) unique,
	DVT nvarchar(30) 
	check (dvt='chai' or dvt='lon' or dvt=N'thùng' or dvt=N'kết'),
	Soluong int check (Soluong>0),
	Dongia int check (dongia>0),
	MaloaiNGK char(30),
	constraint FK_MaloaiNGK foreign key(MaloaiNGK) references loaingk(maloai),
	constraint PK_MaNGK primary key(MaNGK)
)

create table Khachhang
(
	MsKH char(30),
	hoten nvarchar(30),
	diachi nvarchar(30),
	Dienthoai char(30) default 'chuaco',
	constraint PK_MsKH primary key(MsKH)
)

create table Hoadon
(
	Sohd int,
	MsKH char(30),
	nhanvien nvarchar(30),
	ngaylap date default getDate(),
	constraint PK_Sohd primary key(Sohd),
	constraint FK_MsKH foreign key(MsKH) references khachhang(mskh)
)

create table CTHD
(
	Sohd int,
	MaNGK char(30),
	Soluong int check(soluong>0),
	dongia int,
	constraint FK_Sohd foreign key(Sohd) references Hoadon(Sohd),
	constraint FK_MaNGK foreign key(MaNGK) references NGK(MaNGK)
)

alter table cthd
add thanhtien int

alter table cthd
add check (dongia>1000)
--g. xoa rang buoc khoa ngoai tham chieu den bang NGK va bang Hoadon
alter table CTHD
drop FK_MaNGK
alter table CTHD
drop FK_Sohd
--h
alter table CTHD
add constraint UD_tt check(thanhtien>0)


--2a
insert into LoaiNGK values('001','nuocloc')
insert into LoaiNGK values('002','nuockhoang')
insert into LoaiNGK values('003','nuocngot')
insert into LoaiNGK values('004','nuocla')

insert into NGK values('n1','cocacola','lon',10,10000,'003')
insert into NGK values('n2','lavi','chai',10,5000,'001')
insert into NGK values('n3','dangthach','chai',10,20000,'002')
insert into NGK values('n4','nuocgieng','thung',10,200000,'004')

insert into Khachhang values('kh1','Dinh Thuy Linh','BMT','0333123123')
insert into Khachhang values('kh2','Ngoc Anh','Saigon','0333123124')
insert into Khachhang values('kh3','Hung Dung','Hanoi','0333123125')
insert into Khachhang values('kh3','Anh','Hanoi','0333123126')

insert into hoadon values(10,'kh1','Tra Ngan','2022-10-22')
insert into hoadon values(20,'kh2','To Linh','2022-10-23')
insert into hoadon values(30,'kh3','Kim Dung','2022-10-24')
insert into hoadon values(30,'kh4','Phuong','2009-10-24')

insert into cthd values(10,'n1',10,10000,100000)
insert into cthd values(20,'n2',20,20000,100000)
insert into cthd values(30,'n3',30,30000,100000)

update cthd
set dongia = dongia + 10000 where MaNGK = 'lon'

delete a
from hoadon a
join khachhang b on a.mskh = b.mskh
where (year(ngaylap)<2023)

delete from NGK
where NGK.Soluong = 0


select * from NGK

update NGK set dongia = case 
when dongia + 100000 > 500000 then 500000 else dongia + 100000 end where dvt = 'thùng'

