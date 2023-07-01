package quanlyphonggym.Controllers.AdminCtrl.QuanLyPhongTapCtrl;

import quanlyphonggym.Bean.PhongTapBean;
import quanlyphonggym.Models.PhongTap;
import quanlyphonggym.MysqlConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CRUDPhongTapCtrl {
    public boolean createPhongTap(PhongTapBean phongTapBean) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();

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
    public boolean delettePhongTap(int idPhongTap) {
        // xóa phòng tập, thiết bị phòng tập, danh sách nhân viên
        return true;
    }
}
