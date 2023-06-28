package quanlyphonggym.Models;

public class PhanHoiCuaHoiVien {
    private int id;
    private int idHoiVien;
    private int idNhanVien;
    private String noiDung;
    private String ngayPhanHoi;
    private Boolean isDaPhanHoiLai;
    
    public PhanHoiCuaHoiVien() {
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
    public int getIdNhanVien() {
        return idNhanVien;
    }
    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
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
    public Boolean getIsDaPhanHoiLai() {
        return isDaPhanHoiLai;
    }
    public void setIsDaPhanHoiLai(Boolean isDaPhanHoiLai) {
        this.isDaPhanHoiLai = isDaPhanHoiLai;
    }

    
}
