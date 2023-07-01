package quanlyphonggym.Controllers.AuthCtrl;

import quanlyphonggym.Models.HoiVien;
import quanlyphonggym.Models.User;
import quanlyphonggym.MysqlConnection;

import javax.swing.*;
import java.sql.*;

public class RegisterCtrl {
    public boolean register(HoiVien hoiVien, User user) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();

        try {
            String sql = "INSERT INTO hoivien(maHoiVien, hoTen, ngaySinh, gioiTinh, ngheNghiep, diaChi, soDienThoai, maVanTay)"
                    +" values(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement prst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prst.setString(1, hoiVien.getMaHoiVien());
            prst.setString(2, hoiVien.getHoTen());
            prst.setString(3, hoiVien.getNgaySinh());
            prst.setString(4, hoiVien.getGioiTinh());
            prst.setString(5, hoiVien.getNgheNghiep());
            prst.setString(6, hoiVien.getDiaChi());
            prst.setString(7, hoiVien.getSoDienThoai());
            prst.setString(8, "LKISADJH732$%!#$%@DSF");
            prst.execute();

            ResultSet resultSet = prst.getGeneratedKeys();
            if (resultSet.next()) {
                int idHoiVien = resultSet.getInt(1);
                String sqlUser = "INSERT INTO user(idHoiVien, username, password, isAdmin) values(?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sqlUser);
                preparedStatement.setInt(1, idHoiVien);
                preparedStatement.setString(2, user.getUsername());
                preparedStatement.setString(3, user.getPassword());
                preparedStatement.setBoolean(4, false);

                preparedStatement.execute();
                preparedStatement.close();
            }
            prst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"");
            System.out.println(e.getMessage());
            return false;
        }
        connection.close();
        return true;
    }
}
