package quanlyphonggym.Controllers.HoiVienCtrl;

import com.sun.security.auth.NTNumericCredential;
import quanlyphonggym.Bean.HoiVienBean;
import quanlyphonggym.Models.HoiVien;
import quanlyphonggym.Models.LichSu;
import quanlyphonggym.Models.Role;
import quanlyphonggym.MysqlConnection;
import quanlyphonggym.Util.CheckSoDienThoai;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoiVienCtrl {
    public List<HoiVien> getAllHoiVien() throws SQLException, ClassNotFoundException {
        List<HoiVien> hoiViens = new ArrayList<>();
        //code
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String sql = "SELECT* FROM hoivien";
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                HoiVien hoiVien = new HoiVien();
                hoiVien.setId(rs.getInt(1));

                hoiViens.add(hoiVien);
            }
            p.close();
        } catch (SQLException E) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            System.out.println(E.getMessage());
            connection.close();
            return null;
        }

        return hoiViens;
    }
    public HoiVienBean getThongTinHoiVien(int idHoiVien) {
        HoiVienBean hoiVienBean = new HoiVienBean();
        //code

        return hoiVienBean;
    }

    public boolean updateThongTinCaNhan(HoiVien hoiVien) throws SQLException, ClassNotFoundException {
        //code
        if (!CheckSoDienThoai.checkSoDienThoai(hoiVien.getSoDienThoai())) {
            JOptionPane.showMessageDialog(null, "Số điện thoại phải có 10 chữ số và không chứa kí tự khác ngoài 0-9");
            return false;
        }
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String sql = "UPDATE hoivien SET "
            +" maHoiVien = '" +hoiVien.getMaHoiVien()
            +"', hoTen =  '"+hoiVien.getHoTen()
            +"', ngaySinh = '"+hoiVien.getNgaySinh()
            +"', gioiTinh = '"+hoiVien.getGioiTinh()
            +"', ngheNghiep = '"+hoiVien.getNgheNghiep()
            +"', diaChi = '"+hoiVien.getDiaChi()
            +"', soDienThoai = '"+hoiVien.getSoDienThoai()
            +"' WHERE id = "+hoiVien.getId();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            System.out.println(e.getMessage());
            connection.close();
            return false;
        }
        connection.close();
        return true;
    }
    public List<LichSu> getLichSuPhongTap(int idHoiVien) {
        List<LichSu> lichSus = new ArrayList<>();
        //code
        return lichSus;
    }

}
