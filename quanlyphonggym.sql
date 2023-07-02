CREATE TABLE `user` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `idHoiVien` int,
  `username` varchar(255),
  `password` varchar(255),
  `isAdmin` boolean
);
INSERT INTO user(idHoiVien, username, password, isAdmin) VALUES (-1, 'admin', '[1]', 1);

CREATE TABLE `phongtap` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `maPhong` varchar(13),
  `tenPhong` varchar(255)
);

CREATE TABLE `thietbiphongtap` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `maThietBi` varchar(13),
  `tenThietBi` varchar(255),
  `soLuong` int,
  `ngayNhap` date,
  `ngayBaoHanh` date,
  `xuatXu` varchar(255),
  `tinhTrang` varchar(255),
  `idPhongTap` int
);

CREATE TABLE `role` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `tenRole` varchar(255)
);
INSERT INTO role(tenRole) VALUES ('Nhân viên Sale'), ('Nhân viên phục vụ'), ('PT');

CREATE TABLE `nhanvien` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `maNhanVien` varchar(13),
  `hoTen` varchar(255),
  `ngaySinh` date,
  `gioiTinh` varchar(255),
  `diaChi` varchar(255),
  `soDienThoai` varchar(13),
  `ngayVaoLam` date,
  `idRole` int
);

CREATE TABLE `pt_hoivien` (
  `id` int  PRIMARY KEY  AUTO_INCREMENT,
  `idNhanVien` int,
  `idHoiVien` int
);

CREATE TABLE `nhanvien_phongtap` (
  `id` int PRIMARY KEY AUTO_INCREMENT ,
  `idPhongTap` int,
  `idNhanVien` int
);

CREATE TABLE `nhanviencheckin` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `idNhanVien` int,
  `idPhongTap` int,
  `ngayVaoLam` date
);

CREATE TABLE `hoivien` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `maHoiVien` varchar(13),
  `hoTen` varchar(255),
  `ngaySinh` date,
  `gioiTinh` varchar(255),
  `ngheNghiep` varchar(255),
  `diaChi` varchar(255),
  `soDienThoai` varchar(13),
  `loaiThanhVien` varchar(255),
  `maVanTay` varchar(255)
);

CREATE TABLE `goitap` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `tenGoiTap` varchar(255),
  `noiDungHinhThuc` varchar(255),
  `soTien` int
);

CREATE TABLE `dangkygoitap` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `idHoiVien` int,
  `idGoiTap` int,
  `ngayDangKy` date,
  `ngayBatDau` date,
  `ngayKetThuc` date,
  `trangThaiThanhToan` boolean,
  `isGoiTapHienTai` boolean
);

CREATE TABLE `thanhtoan` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `idDangKy` int,
  `idHoiVien` int,
  `idGoiTap` int,
  `soTien` int,
  `ngayThanhToan` timestamp
);

CREATE TABLE `lichsu` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `idHoiVien` int,
  `gioVao` timestamp DEFAULT CURRENT_TIMESTAMP,
  `gioRa` timestamp DEFAULT CURRENT_TIMESTAMP,
  `ngaySuDung` date
);

CREATE TABLE `phanhoicuahoivien` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `idHoiVien` int,
  `idNhanVien` int,
  `noiDung` varchar(255),
  `ngayPhanHoi` timestamp,
  `isDaPhanHoiLai` boolean
);

CREATE TABLE `phanhoicuaadmin` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `idPhanHoiCuaHoiVien` int,
  `noiDung` varchar(255),
  `ngayPhanHoi` timestamp
);
