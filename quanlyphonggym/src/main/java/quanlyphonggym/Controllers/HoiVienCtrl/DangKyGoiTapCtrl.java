package quanlyphonggym.Controllers.HoiVienCtrl;

import quanlyphonggym.Models.DangKyGoiTap;
import quanlyphonggym.MysqlConnection;

import javax.swing.*;
import java.sql.*;

public class DangKyGoiTapCtrl {
    public boolean dangKyGoiTap(DangKyGoiTap dangKyGoiTap) throws SQLException, ClassNotFoundException {
        //code
        Connection connection = MysqlConnection.getMysqlConnection();
        connection.setAutoCommit(false);
        try {
            //check thanhtoan
            String sql1 = "SELECT * FROM dangkygoitap WHERE idHoiVien = "+dangKyGoiTap.getIdHoiVien()
                    +" and trangThaiThanhToan = 0";
            PreparedStatement prst1 = connection.prepareStatement(sql1);
            ResultSet rs1 = prst1.executeQuery();
            if (rs1.next()) {
                JOptionPane.showMessageDialog(null, "Hãy thanh toán gói tập hiện tại trước khi đăng kí gói mới");
                return false;
            }

            //update isGoiTapHienTai
            String sql2 = "UPDATE dangkygoitap SET isGoiTapHienTai = 0 WHERE idHoiVien = "+ dangKyGoiTap.getIdHoiVien()
                    + " and isGoiTapHienTai = 1";
            PreparedStatement prst2 = connection.prepareStatement(sql2);
            prst2.execute();

            //insert goimoi
            String sql3 = "INSERT INTO dangkygoitap (idHoiVien, idGoiTap,ngayDangKy,ngayBatDau,ngayKetThuc,trangThaiThanhToan, isGoiTapHienTai)"
                    +" values(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement prst3 = connection.prepareStatement(sql3);
            prst3.setInt(1, dangKyGoiTap.getIdHoiVien());
            prst3.setInt(2, dangKyGoiTap.getIdGoiTap());
            prst3.setDate(3, Date.valueOf(dangKyGoiTap.getNgayDangKy()));
            prst3.setDate(4, Date.valueOf(dangKyGoiTap.getNgayBatDau()));
            prst3.setDate(5, Date.valueOf(dangKyGoiTap.getNgayKetThuc()));
            prst3.setBoolean(6, false);
            prst3.setBoolean(7, true);

            prst3.execute();
            prst3.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            System.out.println(e.getMessage());
            connection.close();
            return false;
        }
        connection.commit();
        connection.close();
        return true;
    }
}
