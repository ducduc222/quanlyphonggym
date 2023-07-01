package quanlyphonggym.Controllers.AuthCtrl;

import quanlyphonggym.Models.User;
import quanlyphonggym.MysqlConnection;
import quanlyphonggym.Session;

import javax.swing.*;
import java.lang.module.ResolutionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginCtrl {
    public boolean checkLogin(User user) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        User user1 = new User();

        try {
            String sql = "SELECT * FROM user WHERE username = '"+user.getUsername()+"' and password = '"+user.getPassword()+"'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user1.setId(resultSet.getInt("id"));
                user1.setIdHoiVien(resultSet.getInt("idHoiVien"));
                user1.setIsAdmin(resultSet.getBoolean("isAdmin"));

                Session.setIdHoiVien(resultSet.getInt("idHoiVien"));
                Session.setIsAdmin(resultSet.getBoolean("isAdmin"));
            } else {
                return false;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            System.out.println(e.getMessage());
            return false;
        }
        connection.close();
        return true;
    }
}
