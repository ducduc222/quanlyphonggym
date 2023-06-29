package quanlyphonggym.Controllers.AdminCtrl.QuanLyNhanVienCtrl;

import quanlyphonggym.MysqlConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CDHoiVienChoPTCtrl {
    public boolean addNewHoiVienChoPT(int idPT, int idHoiVien) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();

        try {
            //check đã tồn tại chưa
            String sql2 = "SELECT * FROM pt_hoivien WHERE idHoiVien = "+idHoiVien;
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
            ResultSet resultSet = preparedStatement2.executeQuery();
            if (resultSet.next()) {
                JOptionPane.showMessageDialog(null, "Học viên đang được dạy");
                return false;
            }


            //insert
            String sql = "INSERT INTO pt_hoivien (idNhanVien,idHoiVien)"
                    + " values (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idPT);
            preparedStatement.setInt(2, idHoiVien);

            preparedStatement.execute();
            preparedStatement.close();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            System.out.println(e.getMessage());
        }

        return true;
    }
    public boolean deleteHoiVienChoPT(int idPT, int idHoiVien) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();

        try {
            //insert
            String sql = "DELETE FROM pt_hoivien WHERE idNhanVien = "+idPT+" and idHoiVien = "+idHoiVien;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.execute();
            preparedStatement.close();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            System.out.println(e.getMessage());
        }

        return true;
    }
}
