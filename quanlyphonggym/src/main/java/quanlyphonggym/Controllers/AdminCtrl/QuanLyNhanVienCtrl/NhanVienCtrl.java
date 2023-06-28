package quanlyphonggym.Controllers.AdminCtrl.QuanLyNhanVienCtrl;

import quanlyphonggym.Models.NhanVien;
import quanlyphonggym.MysqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienCtrl {
    public List<NhanVien> getAllNhanVien() throws SQLException, ClassNotFoundException {
        List<NhanVien> nhanViens = new ArrayList<>();
        // code
        Connection connection = MysqlConnection.getMysqlConnection();

        String sql = "SELECT * FROM nhanvien ";
        PreparedStatement prst = connection.prepareStatement(sql);
        ResultSet resultSet = prst.executeQuery();
        while (resultSet.next()) {
            NhanVien nhanVien = new NhanVien();
            nhanVien.setId(resultSet.getInt("id"));
            nhanVien.setMaNhanVien(resultSet.getString("maNhanVien"));
            nhanVien.setHoTen(resultSet.getString("hoTen"));
            nhanVien.setNgaySinh(resultSet.getString("ngaySinh"));
            nhanVien.setGioiTinh(resultSet.getString("gioiTinh"));
            nhanVien.setDiaChi(resultSet.getString("diaChi"));
            nhanVien.setSoDienThoai(resultSet.getString("soDienThoai"));
            nhanVien.setNgayVaoLam(resultSet.getString("ngayVaoLam"));
            nhanVien.setIdRole(resultSet.getInt("idRole"));
            nhanViens.add(nhanVien);
        }
        return nhanViens;
    }
}
