package quanlyphonggym.Bean;

import quanlyphonggym.Models.HoiVien;
import quanlyphonggym.Models.NhanVien;
import quanlyphonggym.Models.Role;

import java.util.List;

public class NhanVienBean {
    private NhanVien nhanVien;
    private Role role;
    private boolean isPT;
    private List<HoiVien> danhSachHoiVienChoPT;

    public NhanVienBean() {
    }

    public boolean isPT() {
        return isPT;
    }

    public void setPT(boolean PT) {
        isPT = PT;
    }

    public List<HoiVien> getDanhSachHoiVienChoPT() {
        return danhSachHoiVienChoPT;
    }

    public void setDanhSachHoiVienChoPT(List<HoiVien> danhSachHoiVienChoPT) {
        this.danhSachHoiVienChoPT = danhSachHoiVienChoPT;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
