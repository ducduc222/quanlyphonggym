package quanlyphonggym.Bean;

import quanlyphonggym.Models.PhanHoiCuaAdmin;
import quanlyphonggym.Models.PhanHoiCuaHoiVien;

public class PhanHoiBean {
    private PhanHoiCuaHoiVien phanHoiCuaHoiVien;
    private PhanHoiCuaAdmin phanHoiCuaAdmin;

    public PhanHoiBean() {
    }

    public PhanHoiCuaHoiVien getPhanHoiCuaHoiVien() {
        return phanHoiCuaHoiVien;
    }

    public void setPhanHoiCuaHoiVien(PhanHoiCuaHoiVien phanHoiCuaHoiVien) {
        this.phanHoiCuaHoiVien = phanHoiCuaHoiVien;
    }

    public PhanHoiCuaAdmin getPhanHoiCuaAdmin() {
        return phanHoiCuaAdmin;
    }

    public void setPhanHoiCuaAdmin(PhanHoiCuaAdmin phanHoiCuaAdmin) {
        this.phanHoiCuaAdmin = phanHoiCuaAdmin;
    }
}
