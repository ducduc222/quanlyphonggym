package quanlyphonggym.Controllers.AdminCtrl.QuanLyPhongTapCtrl;

import quanlyphonggym.Bean.PhanHoiBean;
import quanlyphonggym.Bean.PhongTapBean;
import quanlyphonggym.Models.*;
import quanlyphonggym.MysqlConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhongTapCtrl {
    public List<PhongTap> getAllPhongTap() throws SQLException, ClassNotFoundException {
        List<PhongTap> phongTaps = new ArrayList<>();
        // code
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String sql = "SELECT * FROM phongtap";
            PreparedStatement prst = connection.prepareStatement(sql);
            ResultSet rs = prst.executeQuery();

            while (rs.next()) {
                PhongTap phongTap = new PhongTap();
                phongTap.setId(rs.getInt("id"));
                phongTap.setMaPhong(rs.getString("maPhong"));
                phongTap.setTenPhong(rs.getString("tenPhong"));

                phongTaps.add(phongTap);
            }

        } catch (SQLException e)  {
            JOptionPane.showMessageDialog(null,"Có lỗi xảy ra");
            System.out.println(e.getMessage());
            return null;
        }
        connection.close();
        return phongTaps;
    }

    public PhongTapBean getPhongTapById(int idPhongTap) throws SQLException, ClassNotFoundException {
        PhongTapBean phongTapBean = new PhongTapBean();
        Connection connection = MysqlConnection.getMysqlConnection();

        PhongTap phongTap = new PhongTap();
        List<ThietBiPhongTap> danhSachThietBiPhongTap = new ArrayList<>();
        List<NhanVien> danhSachNhanVien = new ArrayList<>();
        List<PhanHoiBean> danhSachPhanHoiVeNhanVienCuaPhong = new ArrayList<>();

        try {
            //get PhongTap
            String sql1 = "SELECT * FROM phongtap WHERE id = "+idPhongTap;
            PreparedStatement prst1 = connection.prepareStatement(sql1);
            ResultSet rs1 = prst1.executeQuery();

            if (rs1.next()) {
                phongTap.setId(rs1.getInt("id"));
                phongTap.setTenPhong(rs1.getString("tenPhong"));
                phongTap.setMaPhong(rs1.getString("maPhong"));
                phongTapBean.setPhongTap(phongTap);
            }
            prst1.close();

            // get danhSachThietBiPhongTap
            String sql2 = "SELECT * FROM thietbiphongtap where idPhongTap = "+ idPhongTap;
            PreparedStatement prst2 = connection.prepareStatement(sql2);
            ResultSet rs2 = prst2.executeQuery();
            while (rs2.next()) {
                ThietBiPhongTap thietBiPhongTap = new ThietBiPhongTap();
                thietBiPhongTap.setId(rs2.getInt("id"));
                thietBiPhongTap.setMaThietBi(rs2.getString("maThietBi"));
                thietBiPhongTap.setTenThietBi(rs2.getString("tenThietBi"));
                thietBiPhongTap.setSoLuong(rs2.getInt("soLuong"));
                thietBiPhongTap.setNgayNhap(rs2.getString("ngayNhap"));
                thietBiPhongTap.setNgayBaoHanh(rs2.getString("ngayBaoHanh"));
                thietBiPhongTap.setXuatXu(rs2.getString("xuatXu"));
                thietBiPhongTap.setTinhTrang(rs2.getString("tinhTrang"));
                thietBiPhongTap.setIdPhongTap(rs2.getInt("idPhongTap"));

                danhSachThietBiPhongTap.add(thietBiPhongTap);
            }
            phongTapBean.setDanhSachThietBiPhongTap(danhSachThietBiPhongTap);
            prst2.close();

            //danhSachNhanVien
            String sql3 = "SELECT * FROM nhanvien WHERE id IN (SELECT idNhanVien FROM nhanvien_phongtap WHERE idPhongTap = "+idPhongTap+")";
            PreparedStatement prst3 = connection.prepareStatement(sql3);
            ResultSet rs3 = prst3.executeQuery();
            while(rs3.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(rs3.getInt("id"));
                nhanVien.setMaNhanVien(rs3.getString("maNhanVien"));
                nhanVien.setHoTen(rs3.getString("hoTen"));
                nhanVien.setNgaySinh(rs3.getString("ngaySinh"));
                nhanVien.setGioiTinh(rs3.getString("gioiTinh"));
                nhanVien.setDiaChi(rs3.getString("diaChi"));
                nhanVien.setSoDienThoai(rs3.getString("soDienThoai"));
                nhanVien.setNgayVaoLam(rs3.getString("ngayVaoLam"));
                nhanVien.setIdRole(rs3.getInt("idRole"));
                danhSachNhanVien.add(nhanVien);
            }
            prst3.close();
            phongTapBean.setDanhSachNhanVien(danhSachNhanVien);

            //getAll phanhoi phongtap
            String sql4 = "SELECT phanhoicuahoivien.*,phanhoicuaadmin.*  FROM phanhoicuahoivien LEFT JOIN phanhoicuaadmin ON phanhoicuahoivien.id = phanhoicuaadmin.idPhanHoiCuaHoiVien WHERE phanhoicuahoivien.idNhanVien IN (SELECT idNhanVien FROM nhanvien_phongtap WHERE idPhongTap = "+idPhongTap+")";
            PreparedStatement prst4 = connection.prepareStatement(sql4);
            ResultSet rs4 = prst4.executeQuery();
            while (rs4.next()) {
                PhanHoiBean phanHoiBean = new PhanHoiBean();
                PhanHoiCuaHoiVien phanHoiCuaHoiVien = new PhanHoiCuaHoiVien();
                PhanHoiCuaAdmin phanHoiCuaAdmin = new PhanHoiCuaAdmin();
                phanHoiCuaHoiVien.setId(rs4.getInt("phanhoicuahoivien.id"));
                phanHoiCuaHoiVien.setIdHoiVien(rs4.getInt("phanhoicuahoivien.idHoiVien"));
                phanHoiCuaHoiVien.setIdNhanVien(rs4.getInt("phanhoicuahoivien.idNhanVien"));
                phanHoiCuaHoiVien.setNoiDung(rs4.getString("phanhoicuahoivien.noiDung"));
                phanHoiCuaHoiVien.setNgayPhanHoi(String.valueOf(rs4.getTimestamp("phanhoicuahoivien.ngayPhanHoi")));
                phanHoiCuaHoiVien.setIsDaPhanHoiLai(rs4.getBoolean("phanhoicuahoivien.isDaPhanHoiLai"));
                phanHoiBean.setPhanHoiCuaHoiVien(phanHoiCuaHoiVien);

                //get phanhoiAdmin
                if (phanHoiCuaHoiVien.getIsDaPhanHoiLai()) {
                    phanHoiCuaAdmin.setId(rs4.getInt("phanhoicuaadmin.id"));
                    phanHoiCuaAdmin.setIdPhanHoiCuaHoiVien(rs4.getInt("phanhoicuaadmin.idPhanHoiCuaHoiVien"));
                    phanHoiCuaAdmin.setNoiDung(rs4.getString("phanhoicuaadmin.noiDung"));
                    phanHoiCuaAdmin.setNgayPhanHoi(String.valueOf(rs4.getTimestamp("phanhoicuaadmin.ngayPhanHoi")));
                    phanHoiBean.setPhanHoiCuaAdmin(phanHoiCuaAdmin);
                }

                danhSachPhanHoiVeNhanVienCuaPhong.add(phanHoiBean);
            }
            prst4.close();
            phongTapBean.setDanhSachPhanHoiVeNhanVienCuaPhong(danhSachPhanHoiVeNhanVienCuaPhong);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            System.out.println(e.getMessage());
            return null;
        }
        connection.close();
        return phongTapBean;
    }

//    public List<PhanHoiBean> getAllPhanHoiNhanVienPhongTap(int idPhongTap) throws SQLException, ClassNotFoundException {
//        List<PhanHoiBean> phanHoiBeanList = new ArrayList<>();
//        Connection connection = MysqlConnection.getMysqlConnection();
//        //code
//
//
//        return phanHoiBeanList;
//    }
}
