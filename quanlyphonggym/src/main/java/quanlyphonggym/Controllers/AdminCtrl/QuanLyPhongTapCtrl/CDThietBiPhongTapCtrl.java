package quanlyphonggym.Controllers.AdminCtrl.QuanLyPhongTapCtrl;

import quanlyphonggym.Models.ThietBiPhongTap;
import quanlyphonggym.MysqlConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CDThietBiPhongTapCtrl {
    public boolean addNewThietBiPhongTap (ThietBiPhongTap thietBiPhongTap) throws SQLException, ClassNotFoundException {
        //code
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String sql = "INSERT INTO thietbiphongtap(maThietBi, tenThietBi, xuatXu, tinhTrang, ngayNhap, idPhongTap) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, thietBiPhongTap.getMaThietBi());
            preparedStatement.setString(2, thietBiPhongTap.getTenThietBi());
            preparedStatement.setString(3, thietBiPhongTap.getXuatXu());
            preparedStatement.setString(4, thietBiPhongTap.getTinhTrang());
            preparedStatement.setString(5, thietBiPhongTap.getNgayNhap());
            preparedStatement.setInt(6, thietBiPhongTap.getIdPhongTap());

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

    public boolean deleteThietBiPhongTap (int idThietBiPhongTap) throws SQLException, ClassNotFoundException {
        //code
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String sql = "DELETE FROM thietbiphongtap where id = "+idThietBiPhongTap;
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
}
