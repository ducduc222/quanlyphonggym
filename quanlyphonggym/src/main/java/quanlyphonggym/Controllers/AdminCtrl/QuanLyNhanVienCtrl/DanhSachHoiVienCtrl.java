package quanlyphonggym.Controllers.AdminCtrl.QuanLyNhanVienCtrl;

import quanlyphonggym.Models.HoiVien;
import quanlyphonggym.MysqlConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DanhSachHoiVienCtrl {
    public List<HoiVien> getAllHoiVien() throws SQLException, ClassNotFoundException {
        List<HoiVien> hoiViens = new ArrayList<>();
        Connection connection = MysqlConnection.getMysqlConnection();

        //code
        try {
            String sql = "SELECT * FROM hoivien ORDER BY id DESC";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rss = preparedStatement.executeQuery();
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

                hoiViens.add(hoiVien);
            }
            preparedStatement.close();
            return hoiViens;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "có lỗi xảy ra");
            System.out.println(e.getMessage());
            connection.close();
            return null;
        }
    }
}
