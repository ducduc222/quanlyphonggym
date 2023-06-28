package quanlyphonggym.Bean;

import quanlyphonggym.Models.NhanVien;
import quanlyphonggym.Models.PhongTap;
import quanlyphonggym.Models.ThietBiPhongTap;

import java.util.List;

public class PhongTapBean {
    private PhongTap phongTap;
    private List<ThietBiPhongTap> danhSachThietBiPhongTap;
    private List<NhanVien> danhSachNhanVien;
    private List<PhanHoiBean> danhSachPhanHoiVeNhanVienCuaPhong;

    public PhongTapBean() {
    }

    public PhongTap getPhongTap() {
        return phongTap;
    }

    public void setPhongTap(PhongTap phongTap) {
        this.phongTap = phongTap;
    }

    public List<ThietBiPhongTap> getDanhSachThietBiPhongTap() {
        return danhSachThietBiPhongTap;
    }

    public void setDanhSachThietBiPhongTap(List<ThietBiPhongTap> danhSachThietBiPhongTap) {
        this.danhSachThietBiPhongTap = danhSachThietBiPhongTap;
    }

    public List<NhanVien> getDanhSachNhanVien() {
        return danhSachNhanVien;
    }

    public void setDanhSachNhanVien(List<NhanVien> danhSachNhanVien) {
        this.danhSachNhanVien = danhSachNhanVien;
    }

    public List<PhanHoiBean> getDanhSachPhanHoiVeNhanVienCuaPhong() {
        return danhSachPhanHoiVeNhanVienCuaPhong;
    }

    public void setDanhSachPhanHoiVeNhanVienCuaPhong(List<PhanHoiBean> danhSachPhanHoiVeNhanVienCuaPhong) {
        this.danhSachPhanHoiVeNhanVienCuaPhong = danhSachPhanHoiVeNhanVienCuaPhong;
    }
}
