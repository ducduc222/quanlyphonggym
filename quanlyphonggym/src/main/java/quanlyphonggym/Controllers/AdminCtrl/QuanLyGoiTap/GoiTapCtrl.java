package quanlyphonggym.Controllers.AdminCtrl.QuanLyGoiTap;

import quanlyphonggym.Bean.DangKyGoiTapBean;
import quanlyphonggym.Models.DangKyGoiTap;
import quanlyphonggym.Models.GoiTap;
import quanlyphonggym.Models.HoiVien;
import quanlyphonggym.Models.ThanhToan;
import quanlyphonggym.MysqlConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoiTapCtrl {
    public List<GoiTap> getAllGoiTap() throws SQLException, ClassNotFoundException {
        List<GoiTap> goiTaps = new ArrayList<>();
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String sql = "SELECT * FROM goitap";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                GoiTap goiTap = new GoiTap();
                goiTap.setId(resultSet.getInt("id"));
                goiTap.setTenGoiTap(resultSet.getString("tenGoiTap"));
                goiTap.setNoiDungHinhThuc(resultSet.getString("noiDungHinhThuc"));
                goiTap.setSoTien(resultSet.getInt("soTien"));

                goiTaps.add(goiTap);
            }
            preparedStatement.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            System.out.println(e.getMessage());
            return null;
        }
        connection.close();
        return goiTaps;
    }
    public GoiTap getGoiTapById(int idGoiTap) throws SQLException, ClassNotFoundException {
        GoiTap goiTap = new GoiTap();
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String sql = "SELECT * FROM goitap WHERE id = "+idGoiTap;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                goiTap.setId(resultSet.getInt("id"));
                goiTap.setTenGoiTap(resultSet.getString("tenGoiTap"));
                goiTap.setNoiDungHinhThuc(resultSet.getString("noiDungHinhThuc"));
                goiTap.setSoTien(resultSet.getInt("soTien"));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            System.out.println(e.getMessage());
            return null;
        }
        connection.close();
        return goiTap;
    }
    public List<HoiVien> getAllNguoiDangKyGoiTap(int idGoiTap) throws SQLException, ClassNotFoundException {
        List<HoiVien> hoiViens = new ArrayList<>();

        Connection connection = MysqlConnection.getMysqlConnection();

        String sql = "SELECT * FROM hoivien WHERE id IN (SELECT idHoiVien FROM dangkygoitap WHERE idGoiTap = "+idGoiTap+")";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            HoiVien hoiVien = new HoiVien();
            hoiVien.setId(resultSet.getInt("id"));
            hoiVien.setMaHoiVien(resultSet.getString("maHoiVien"));
            hoiVien.setHoTen(resultSet.getString("hoTen"));
            hoiVien.setNgaySinh(resultSet.getString("ngaySinh"));
            hoiVien.setGioiTinh(resultSet.getString("gioiTinh"));
            hoiVien.setNgheNghiep(resultSet.getString("ngheNghiep"));
            hoiVien.setDiaChi(resultSet.getString("diaChi"));
            hoiVien.setSoDienThoai(resultSet.getString("soDienThoai"));
            hoiVien.setLoaiThanhVien(resultSet.getString("loaiThanhVien"));
            hoiVien.setMaVanTay(resultSet.getString("maVanTay"));

            hoiViens.add(hoiVien);
        }
        return hoiViens;
    }


}
