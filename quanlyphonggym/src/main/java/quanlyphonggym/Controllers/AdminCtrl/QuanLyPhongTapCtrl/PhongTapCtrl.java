package quanlyphonggym.Controllers.AdminCtrl.QuanLyPhongTapCtrl;

import quanlyphonggym.Bean.PhanHoiBean;
import quanlyphonggym.Bean.PhongTapBean;

import java.util.ArrayList;
import java.util.List;

public class PhongTapCtrl {
    public List<PhongTapBean> getAllPhongTap() {
        List<PhongTapBean> phongTapBeans = new ArrayList<>();
        // code

        return phongTapBeans;
    }

    public PhongTapBean getPhongTapById(int idPhongTap) {
        PhongTapBean phongTapBean = new PhongTapBean();
        return phongTapBean;
    }

    public List<PhanHoiBean> getAllPhanHoiNhanVienPhongTap(int idPhongTap) {
        List<PhanHoiBean> phanHoiBeanList = new ArrayList<>();
        //code

        return phanHoiBeanList;
    }
}
