package quanlyphonggym.Controllers.AdminCtrl.QuanLyPhongTapCtrl;

import quanlyphonggym.Models.NhanVien;
import quanlyphonggym.MysqlConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CDNhanVienPhongTapCtrl {
    public boolean addNewNhanVienPhongTap(int idPhongTap, int idNhanVien) throws SQLException, ClassNotFoundException {
        //code
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String sql = "INSERT INTO nhanvien_phongtap(idPhongTap, idNhanVien) VALUES(?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idPhongTap);
            preparedStatement.setInt(2, idNhanVien);

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            System.out.println(e.getMessage());
            return false;
        }
        connection.close();
        return true;
    }
    public boolean deleteNhanVienPhongTap(int idPhongTap, int idNhanVien) throws SQLException, ClassNotFoundException {
        //code
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            //check
            String sql = "DELETE FROM nhanvien_phongtap WHERE idNhanVien = "+idNhanVien+" and idPhongTap = "+idPhongTap;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            System.out.println(e.getMessage());
            return false;
        }
        connection.close();

        return true;
    }

    public List<NhanVien> getAllNhanVien() throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        List<NhanVien> nhanViens = new ArrayList<>();
        try {
            //check
            String sql = "SELECT * FROM nhanvien";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet =  preparedStatement.executeQuery();

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
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            System.out.println(e.getMessage());
            connection.close();
            return null;
        }
        connection.close();
        return nhanViens;
    }
}
