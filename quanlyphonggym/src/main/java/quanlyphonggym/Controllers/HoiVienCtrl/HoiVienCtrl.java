package quanlyphonggym.Controllers.HoiVienCtrl;

import quanlyphonggym.Bean.HoiVienBean;
import quanlyphonggym.Models.HoiVien;
import quanlyphonggym.Models.LichSu;

import java.util.ArrayList;
import java.util.List;

public class HoiVienCtrl {
    public List<HoiVienBean> getAllHoiVien() {
        List<HoiVienBean> hoiVienBeans = new ArrayList<>();
        //code

        return hoiVienBeans;
    }
    public HoiVienBean getThongTinHoiVien(int idHoiVien) {
        HoiVienBean hoiVienBean = new HoiVienBean();
        //code

        return hoiVienBean;
    }

    public boolean updateThongTinCaNhan(HoiVien hoiVien) {
        //code
        return true;
    }
    public List<LichSu> getLichSuPhongTap(int idHoiVien) {
        List<LichSu> lichSus = new ArrayList<>();
        //code
        return lichSus;
    }
}
