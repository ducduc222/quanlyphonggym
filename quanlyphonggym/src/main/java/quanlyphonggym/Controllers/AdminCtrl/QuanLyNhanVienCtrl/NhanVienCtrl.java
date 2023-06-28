package quanlyphonggym.Controllers.AdminCtrl.QuanLyNhanVienCtrl;

import quanlyphonggym.Bean.NhanVienBean;
import quanlyphonggym.Models.NhanVien;
import quanlyphonggym.Models.Role;
import quanlyphonggym.MysqlConnection;

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

            nhanVienBeans.add(nhanVienBean);
        }
        return nhanVienBeans;
    }
}
