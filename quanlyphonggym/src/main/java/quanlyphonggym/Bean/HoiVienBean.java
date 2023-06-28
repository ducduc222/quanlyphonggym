package quanlyphonggym.Bean;

import quanlyphonggym.Models.*;

import java.util.List;

public class HoiVienBean {
    private HoiVien hoiVien;
    private DangKyGoiTapBean goiTapHienTai;
    private List<DangKyGoiTapBean> danhSachGoiTapDaDangKy;
    private List<LichSu> lichSuSuDungDichVu;
    private List<PhanHoiBean> danhSachPhanHoi;
    private NhanVien PT; //người hướng dẫn

    public HoiVienBean() {
    }

    public HoiVien getHoiVien() {
        return hoiVien;
    }

    public void setHoiVien(HoiVien hoiVien) {
        this.hoiVien = hoiVien;
    }

    public DangKyGoiTapBean getGoiTapHienTai() {
        return goiTapHienTai;
    }

    public void setGoiTapHienTai(DangKyGoiTapBean goiTapHienTai) {
        this.goiTapHienTai = goiTapHienTai;
    }

    public List<DangKyGoiTapBean> getDanhSachGoiTapDaDangKy() {
        return danhSachGoiTapDaDangKy;
    }

    public void setDanhSachGoiTapDaDangKy(List<DangKyGoiTapBean> danhSachGoiTapDaDangKy) {
        this.danhSachGoiTapDaDangKy = danhSachGoiTapDaDangKy;
    }

    public List<LichSu> getLichSuSuDungDichVu() {
        return lichSuSuDungDichVu;
    }

    public void setLichSuSuDungDichVu(List<LichSu> lichSuSuDungDichVu) {
        this.lichSuSuDungDichVu = lichSuSuDungDichVu;
    }

    public List<PhanHoiBean> getDanhSachPhanHoi() {
        return danhSachPhanHoi;
    }

    public void setDanhSachPhanHoi(List<PhanHoiBean> danhSachPhanHoi) {
        this.danhSachPhanHoi = danhSachPhanHoi;
    }

    public NhanVien getPT() {
        return PT;
    }

    public void setPT(NhanVien PT) {
        this.PT = PT;
    }
}
