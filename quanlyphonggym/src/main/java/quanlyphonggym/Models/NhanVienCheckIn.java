package quanlyphonggym.Models;

public class NhanVienCheckIn {
    private int id;
    private int idNhanVien;
    private int idPhongTap;
    private String ngayLamViec;
    public NhanVienCheckIn() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdNhanVien() {
        return idNhanVien;
    }
    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }
    public int getIdPhongTap() {
        return idPhongTap;
    }
    public void setIdPhongTap(int idPhongTap) {
        this.idPhongTap = idPhongTap;
    }
    public String getNgayLamViec() {
        return ngayLamViec;
    }
    public void setNgayLamViec(String ngayLamViec) {
        this.ngayLamViec = ngayLamViec;
    }
    
}
