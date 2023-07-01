package quanlyphonggym.Controllers;

import quanlyphonggym.MysqlConnection;
import quanlyphonggym.Util.DateForm;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class CheckInNhanVienCtrl {
    public boolean checkIn(int idNhanVien, int idPhongTap) throws SQLException, ClassNotFoundException {
        //code
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String sql = "INSERT INTO nhanviencheckin(idNhanVien, idPhongTap, ngayVaoLam) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idNhanVien);
            preparedStatement.setInt(2, idPhongTap);
            Date date = new Date();
            preparedStatement.setString(3, DateForm.returnDateString(date));

            preparedStatement.execute();
            preparedStatement.close();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            System.out.println(e.getMessage());
            return false;
        }
        connection.close();
        return true;
    }
}
