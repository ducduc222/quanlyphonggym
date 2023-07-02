package quanlyphonggym.Controllers.AdminCtrl.QuanLyPhongTapCtrl;

import quanlyphonggym.Bean.PhongTapBean;
import quanlyphonggym.Models.PhongTap;
import quanlyphonggym.MysqlConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CRUDPhongTapCtrl {
    public boolean createPhongTap(PhongTap phongTap) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String sql = "INSERT INTO phongtap(maPhong, tenPhong) VALUES(?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, phongTap.getMaPhong());
            preparedStatement.setString(2, phongTap.getTenPhong());

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
    public boolean updatePhongTap(PhongTap phongTap) throws SQLException, ClassNotFoundException {
        // update dựa vào id phòng tập
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String sql = "UPDATE phongtap SET tenPhong = '"+phongTap.getTenPhong()
                    +"' , maPhong = '"+phongTap.getMaPhong()
                    +"' WHERE id = "+phongTap.getId();
            PreparedStatement p = connection.prepareStatement(sql);
            p.execute();
            p.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            System.out.println(e.getMessage());
            return false;
        }
        connection.close();
        return true;
    }
    public boolean delettePhongTap(int idPhongTap) throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null, "Phòng tập đang đưa vào sử dụng. Không thể xóa");
        return false;
    }
}
