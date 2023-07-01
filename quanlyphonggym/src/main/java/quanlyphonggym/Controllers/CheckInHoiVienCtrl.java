package quanlyphonggym.Controllers;

import quanlyphonggym.MysqlConnection;
import quanlyphonggym.Session;
import quanlyphonggym.Util.DateForm;
import quanlyphonggym.Util.TimeStampForm;

import javax.swing.*;
import java.sql.*;
import java.time.Instant;
import java.util.Date;

public class CheckInHoiVienCtrl {
    public boolean checkIn(int idHoiVien) throws SQLException, ClassNotFoundException {
        //code
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String  sql = "INSERT INTO lichsu(idHoiVien, gioVao, ngaySuDung) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idHoiVien);
            Instant time = Instant.now();
            long timee = time.toEpochMilli();
            preparedStatement.setString(2, TimeStampForm.returnTimeStampString(timee));
            Date date = new Date();
            preparedStatement.setString(3, DateForm.returnDateString(date));

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean checkOut(int idHoiVien) throws SQLException, ClassNotFoundException {
        //code
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            //checkin
            String sqlCheckIn = "SELECT * FROM lichsu WHERE idHoiVien = "+idHoiVien
                    +" and gioRa = '0000-00-00 00:00:00'";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCheckIn, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSe2 = preparedStatement.executeQuery();
            if (resultSe2.next()) {
                preparedStatement.close();


                int idLichSu = resultSe2.getInt(1);
                Instant time = Instant.now();
                long timee = time.toEpochMilli();
                String timeStamp =  TimeStampForm.returnTimeStampString(timee);
                String SqlcheckOut = "UPDATE lichsu SET gioRa = '"+timeStamp+"' WHERE id = "+idLichSu;
                PreparedStatement preparedStatement3 = connection.prepareStatement(SqlcheckOut);

                preparedStatement3.execute();
                preparedStatement3.close();
            } else {
                JOptionPane.showMessageDialog(null, "Chưa Checkin");
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            System.out.println(e.getMessage());
            return false;
        }
        connection.close();
        return true;
    }
}
