package quanlyphonggym.Bean;

import quanlyphonggym.Models.DangKyGoiTap;
import quanlyphonggym.Models.GoiTap;
import quanlyphonggym.Models.HoiVien;
import quanlyphonggym.Models.ThanhToan;

public class DangKyGoiTapBean {
    private HoiVien hoiVien;
    private DangKyGoiTap dangKyGoiTap;
    private ThanhToan thanhToan;
    private GoiTap goiTap;

    public DangKyGoiTapBean() {
    }

    public HoiVien getHoiVien() {
        return hoiVien;
    }

    public void setHoiVien(HoiVien hoiVien) {
        this.hoiVien = hoiVien;
    }

    public DangKyGoiTap getDangKyGoiTap() {
        return dangKyGoiTap;
    }

    public void setDangKyGoiTap(DangKyGoiTap dangKyGoiTap) {
        this.dangKyGoiTap = dangKyGoiTap;
    }

    public ThanhToan getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(ThanhToan thanhToan) {
        this.thanhToan = thanhToan;
    }

    public GoiTap getGoiTap() {
        return goiTap;
    }

    public void setGoiTap(GoiTap goiTap) {
        this.goiTap = goiTap;
    }
}