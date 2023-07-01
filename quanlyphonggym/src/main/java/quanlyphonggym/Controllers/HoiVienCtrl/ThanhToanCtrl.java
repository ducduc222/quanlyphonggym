package quanlyphonggym.Controllers.HoiVienCtrl;

import quanlyphonggym.Bean.DangKyGoiTapBean;
import quanlyphonggym.Models.DangKyGoiTap;
import quanlyphonggym.MysqlConnection;
import quanlyphonggym.Util.DateForm;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class ThanhToanCtrl {
    public boolean thanhToan(DangKyGoiTapBean goiTapDaDangKy) throws SQLException, ClassNotFoundException {
        //code
        Connection connection = MysqlConnection.getMysqlConnection();
        connection.setAutoCommit(false);
        try {
            String sql1 = "INSERT INTO thanhtoan (idDangKy, idHoiVien, idGoiTap, soTien, ngayThanhToan)"
                    +" values(?, ?, ?, ?, ?)";
            PreparedStatement prst1 = connection.prepareStatement(sql1);
            prst1.setInt(1, goiTapDaDangKy.getDangKyGoiTap().getId());
            prst1.setInt(2, goiTapDaDangKy.getDangKyGoiTap().getIdHoiVien());
            prst1.setInt(3, goiTapDaDangKy.getDangKyGoiTap().getIdGoiTap());
            prst1.setInt(4, goiTapDaDangKy.getGoiTap().getSoTien());
            Date date = new Date();
            prst1.setString(5, DateForm.returnDateString(date));

            prst1.execute();
            prst1.close();

            //update dangkygoitap trangThaiThanhToan
            String sql2 = "UPDATE dangkygoitap SET trangThaiThanhToan = 1 WHERE trangThaiThanhToan = 0 AND idHoiVien = "+goiTapDaDangKy.getDangKyGoiTap().getIdHoiVien();
            PreparedStatement prst2 = connection.prepareStatement(sql2);
            prst2.execute();
            prst2.close();
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
