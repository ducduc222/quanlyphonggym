package quanlyphonggym.Controllers.AdminCtrl.QuanLyNhanVienCtrl;

import quanlyphonggym.Bean.NhanVienBean;
import quanlyphonggym.Models.HoiVien;
import quanlyphonggym.Models.NhanVien;
import quanlyphonggym.Models.Role;
import quanlyphonggym.MysqlConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienCtrl {
    public List<NhanVienBean> getAllNhanVien() throws SQLException, ClassNotFoundException {
        List<NhanVienBean> nhanVienBeans = new ArrayList<>();
        // code
        Connection connection = MysqlConnection.getMysqlConnection();

        String sql = "SELECT nhanvien.*, role.* FROM nhanvien LEFT JOIN role ON nhanvien.idRole = role.id ";
        PreparedStatement prst = connection.prepareStatement(sql);
        ResultSet resultSet = prst.executeQuery();
        while (resultSet.next()) {
            NhanVienBean nhanVienBean = new NhanVienBean();
            NhanVien nhanVien = new NhanVien();
            Role role = new Role();
            List<HoiVien> danhSachHoiVienPT = new ArrayList<>();

            nhanVien.setId(resultSet.getInt("nhanvien.id"));
            nhanVien.setMaNhanVien(resultSet.getString("nhanvien.maNhanVien"));
            nhanVien.setHoTen(resultSet.getString("nhanvien.hoTen"));
            nhanVien.setNgaySinh(resultSet.getString("nhanvien.ngaySinh"));
            nhanVien.setGioiTinh(resultSet.getString("nhanvien.gioiTinh"));
            nhanVien.setDiaChi(resultSet.getString("nhanvien.diaChi"));
            nhanVien.setSoDienThoai(resultSet.getString("nhanvien.soDienThoai"));
            nhanVien.setNgayVaoLam(resultSet.getString("nhanvien.ngayVaoLam"));
            nhanVien.setIdRole(resultSet.getInt("nhanvien.idRole"));
            nhanVienBean.setNhanVien(nhanVien);

            role.setId(resultSet.getInt("role.id"));
            role.setTenRole(resultSet.getString("role.tenRole"));
            nhanVienBean.setRole(role);
            if (resultSet.getString("role.tenRole").equals("PT")) {
                nhanVienBean.setPT(true);

                String sqlGetHoiVienPT  = "SELECT * FROM hoivien WHERE id IN (SELECT idHoiVien FROM  pt_hoivien WHERE idNhanVien = "+nhanVien.getId()+")";
                PreparedStatement psrt = connection.prepareStatement(sqlGetHoiVienPT);
                ResultSet rss = psrt.executeQuery();
                while (rss.next()) {
                    HoiVien hoiVien = new HoiVien();
                    hoiVien.setId(rss.getInt("id"));
                    hoiVien.setMaHoiVien(rss.getString("maHoiVien"));
                    hoiVien.setHoTen(rss.getString("hoTen"));
                    hoiVien.setNgaySinh(rss.getString("ngaySinh"));
                    hoiVien.setGioiTinh(rss.getString("gioiTinh"));
                    hoiVien.setNgheNghiep(rss.getString("ngheNghiep"));
                    hoiVien.setDiaChi(rss.getString("diaChi"));
                    hoiVien.setSoDienThoai(rss.getString("soDienThoai"));
                    hoiVien.setLoaiThanhVien(rss.getString("loaiThanhVien"));
                    hoiVien.setMaVanTay(rss.getString("maVanTay"));

                    danhSachHoiVienPT.add(hoiVien);
                }
                nhanVienBean.setDanhSachHoiVienChoPT(danhSachHoiVienPT);
            } else {
                nhanVienBean.setPT(false);
                nhanVienBean.setDanhSachHoiVienChoPT(null);
            }

            nhanVienBeans.add(nhanVienBean);
        }
        return nhanVienBeans;
    }

    public NhanVienBean getNhanVienById(int idNhanVien) throws SQLException, ClassNotFoundException {
        NhanVienBean nhanVienBean = new NhanVienBean();
        // code
        Connection connection = MysqlConnection.getMysqlConnection();
        try {


            String sql = "SELECT nhanvien.*, role.* FROM nhanvien LEFT JOIN role ON nhanvien.idRole = role.id WHERE nhanvien.id = " + idNhanVien;
            PreparedStatement prst = connection.prepareStatement(sql);
            ResultSet resultSet = prst.executeQuery();
            if (resultSet.next()) {
                NhanVien nhanVien = new NhanVien();
                Role role = new Role();
                List<HoiVien> danhSachHoiVienPT = new ArrayList<>();

                nhanVien.setId(resultSet.getInt("nhanvien.id"));
                nhanVien.setMaNhanVien(resultSet.getString("nhanvien.maNhanVien"));
                nhanVien.setHoTen(resultSet.getString("nhanvien.hoTen"));
                nhanVien.setNgaySinh(resultSet.getString("nhanvien.ngaySinh"));
                nhanVien.setGioiTinh(resultSet.getString("nhanvien.gioiTinh"));
                nhanVien.setDiaChi(resultSet.getString("nhanvien.diaChi"));
                nhanVien.setSoDienThoai(resultSet.getString("nhanvien.soDienThoai"));
                nhanVien.setNgayVaoLam(resultSet.getString("nhanvien.ngayVaoLam"));
                nhanVien.setIdRole(resultSet.getInt("nhanvien.idRole"));
                nhanVienBean.setNhanVien(nhanVien);

                role.setId(resultSet.getInt("role.id"));
                role.setTenRole(resultSet.getString("role.tenRole"));
                nhanVienBean.setRole(role);
                if (resultSet.getString("role.tenRole").equals("PT")) {
                    nhanVienBean.setPT(true);

                    String sqlGetHoiVienPT = "SELECT * FROM hoivien WHERE id IN (SELECT idHoiVien FROM  pt_hoivien WHERE idNhanVien = " + nhanVien.getId() + ")";
                    PreparedStatement psrt = connection.prepareStatement(sqlGetHoiVienPT);
                    ResultSet rss = psrt.executeQuery();
                    while (rss.next()) {
                        HoiVien hoiVien = new HoiVien();
                        hoiVien.setId(rss.getInt("id"));
                        hoiVien.setMaHoiVien(rss.getString("maHoiVien"));
                        hoiVien.setHoTen(rss.getString("hoTen"));
                        hoiVien.setNgaySinh(rss.getString("ngaySinh"));
                        hoiVien.setGioiTinh(rss.getString("gioiTinh"));
                        hoiVien.setNgheNghiep(rss.getString("ngheNghiep"));
                        hoiVien.setDiaChi(rss.getString("diaChi"));
                        hoiVien.setSoDienThoai(rss.getString("soDienThoai"));
                        hoiVien.setLoaiThanhVien(rss.getString("loaiThanhVien"));
                        hoiVien.setMaVanTay(rss.getString("maVanTay"));

                        danhSachHoiVienPT.add(hoiVien);
                    }
                    nhanVienBean.setDanhSachHoiVienChoPT(danhSachHoiVienPT);
                } else {
                    nhanVienBean.setPT(false);
                    nhanVienBean.setDanhSachHoiVienChoPT(null);
                }

            }
            return nhanVienBean;
        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
