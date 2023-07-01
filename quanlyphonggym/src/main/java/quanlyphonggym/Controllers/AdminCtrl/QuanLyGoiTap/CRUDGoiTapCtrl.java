package quanlyphonggym.Controllers.AdminCtrl.QuanLyGoiTap;

import quanlyphonggym.Models.GoiTap;
import quanlyphonggym.MysqlConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDGoiTapCtrl {
    public boolean createGoiTap(GoiTap goiTap) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();

        try {
            String sql = "INSERT INTO goitap (tenGoiTap, noiDungHinhThuc, soTien) "
                    + "values (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, goiTap.getTenGoiTap());
            preparedStatement.setString(2, goiTap.getNoiDungHinhThuc());
            preparedStatement.setInt(3, goiTap.getSoTien());

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Có lỗi xảy ra");
            System.out.println(e.getMessage());
        }
        return true;
    }

    public boolean updateGoiTap(GoiTap goiTap) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();

        try {
            String sql = "UPDATE goitap SET " +
                    "tenGoiTap = ?,"+
                    "noiDungHinhThuc = ?,"+
                    "soTien = ?"+
                    " WHERE id = "+goiTap.getId();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, goiTap.getTenGoiTap());
            preparedStatement.setString(2, goiTap.getNoiDungHinhThuc());
            preparedStatement.setInt(3, goiTap.getSoTien());

            preparedStatement.execute();
            preparedStatement.close();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            System.out.println(e.getMessage());
        }
        connection.close();
        return true;
    }

    public boolean deleteGoiTap(int idGoiTap) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();

        //check đã có học viên nào đăng kí gói chưa
        try {
            String sqlCheckHV = "SELECT * FROM dangkygoitap WHERE idGoiTap = " + idGoiTap;
            PreparedStatement prds = connection.prepareStatement(sqlCheckHV);
            ResultSet ertr = prds.executeQuery();
            if (ertr.next()) {
                JOptionPane.showMessageDialog(null, "Đã có học viên đăng kí gói tập này. Hãy hủy các đăng kí trước khi xóa");
                prds.close();
                return false;
            }

            String sql = "DELETE FROM goitap WHERE id = " + idGoiTap;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra");
            System.out.println(e.getMessage());
            connection.close();
            return false;
        }
        connection.close();
        return true;
    }
}
