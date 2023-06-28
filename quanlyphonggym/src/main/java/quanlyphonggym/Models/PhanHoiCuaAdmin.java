package quanlyphonggym.Models;

public class PhanHoiCuaAdmin {
    private int id;
    private int idPhanHoiCuaHoiVien;
    private String noiDung;
    private String ngayPhanHoi;
    public PhanHoiCuaAdmin() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdPhanHoiCuaHoiVien() {
        return idPhanHoiCuaHoiVien;
    }
    public void setIdPhanHoiCuaHoiVien(int idPhanHoiCuaHoiVien) {
        this.idPhanHoiCuaHoiVien = idPhanHoiCuaHoiVien;
    }
    public String getNoiDung() {
        return noiDung;
    }
    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
    public String getNgayPhanHoi() {
        return ngayPhanHoi;
    }
    public void setNgayPhanHoi(String ngayPhanHoi) {
        this.ngayPhanHoi = ngayPhanHoi;
    }
    
}
