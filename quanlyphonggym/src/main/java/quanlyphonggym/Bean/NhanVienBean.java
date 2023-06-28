package quanlyphonggym.Bean;

import quanlyphonggym.Models.NhanVien;
import quanlyphonggym.Models.Role;

public class NhanVienBean {
    private NhanVien nhanVien;
    private Role role;

    public NhanVienBean() {
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
