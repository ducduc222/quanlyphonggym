package quanlyphonggym.Models;


public class ThanhToan {
    private int id;
    private int idDangKy;
    private int idHoiVien;
    private int idGoiTap;
    private int soTien;
    private String ngayThanhToan;

    
    public ThanhToan() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdDangKy() {
        return idDangKy;
    }
    public void setIdDangKy(int idDangKy) {
        this.idDangKy = idDangKy;
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
    public int getSoTien() {
        return soTien;
    }
    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }
    public String getNgayThanhToan() {
        return ngayThanhToan;
    }
    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

}
