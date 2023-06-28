package quanlyphonggym.Models;

public class DangKyGoiTap {
    private int id;
    private int idHoiVien;
    private int idGoiTap;
    private String ngayDangKy;
    private String ngayBatDau;
    private String ngayKetThuc;
    private Boolean trangThaiThanhToan;
    private Boolean isGoiTapHienTai;
    
    public DangKyGoiTap() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdHoiVien() {
        return idHoiVien;
    }
    public void setIdHoiVien(int idHoiVien) {
        this.idHoiVien = idHoiVien;
    }
    public int getIdGoiTap() {
        return idGoiTap;
    }
    public void setIdGoiTap(int idGoiTap) {
        this.idGoiTap = idGoiTap;
    }
    public String getNgayDangKy() {
        return ngayDangKy;
    }
    public void setNgayDangKy(String ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }
    public String getNgayBatDau() {
        return ngayBatDau;
    }
    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }
    public String getNgayKetThuc() {
        return ngayKetThuc;
    }
    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
    public Boolean getTrangThaiThanhToan() {
        return trangThaiThanhToan;
    }
    public void setTrangThaiThanhToan(Boolean trangThaiThanhToan) {
        this.trangThaiThanhToan = trangThaiThanhToan;
    }
    public Boolean getIsGoiTapHienTai() {
        return isGoiTapHienTai;
    }
    public void setIsGoiTapHienTai(Boolean isGoiTapHienTai) {
        this.isGoiTapHienTai = isGoiTapHienTai;
    }

    
}
