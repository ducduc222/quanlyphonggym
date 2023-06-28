package quanlyphonggym.Controllers.AdminCtrl.QuanLyNhanVienCtrl;

import quanlyphonggym.Bean.NhanVienBean;
import quanlyphonggym.Models.NhanVien;
import quanlyphonggym.MysqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class CRUDNhanVienCtrl {
    public boolean createNhanVien(NhanVien nhanVien) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        
        try {
            String sql = "INSERT INTO nhanvien (maNhanVien,hoTen,ngaySinh,gioiTinh,diaChi,soDienThoai,ngayVaoLam,idRole)"
            + " values (?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nhanVien.getMaNhanVien());
            preparedStatement.setString(2, nhanVien.getHoTen());
            preparedStatement.setString(3, nhanVien.getNgaySinh());
            preparedStatement.setString(4, nhanVien.getGioiTinh());
            preparedStatement.setString(5, nhanVien.getDiaChi());
            preparedStatement.setString(6, nhanVien.getSoDienThoai());
            preparedStatement.setString(7, nhanVien.getNgayVaoLam());
            preparedStatement.setInt(8, nhanVien.getIdRole());

            preparedStatement.execute();
            preparedStatement.close();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            System.out.println(e.getMessage());
        }
        
        return true;
    }

    public boolean updateNhanVien(NhanVienBean nhanVienBean) throws SQLException, ClassNotFoundException {
        //code
        Connection connection = MysqlConnection.getMysqlConnection();

        try {
            String sql = "UPDATE nhanvien SET " +
                    "maNhanVien = ?,"+
                    "hoTen = ?,"+
                    "ngaySinh = ?,"+
                    "gioiTinh = ?,"+
                    "diaChi = ?,"+
                    "soDienThoai = ?,"+
                    "ngayVaoLam = ?,"+
                    "idRole = ?"+
                    " WHERE id = "+nhanVienBean.getNhanVien().getId();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nhanVienBean.getNhanVien().getMaNhanVien());
            preparedStatement.setString(2, nhanVienBean.getNhanVien().getHoTen());
            preparedStatement.setString(3, nhanVienBean.getNhanVien().getNgaySinh());
            preparedStatement.setString(4, nhanVienBean.getNhanVien().getGioiTinh());
            preparedStatement.setString(5, nhanVienBean.getNhanVien().getDiaChi());
            preparedStatement.setString(6, nhanVienBean.getNhanVien().getSoDienThoai());
            preparedStatement.setString(7, nhanVienBean.getNhanVien().getNgayVaoLam());
            preparedStatement.setInt(8, nhanVienBean.getRole().getId());

            preparedStatement.execute();
            preparedStatement.close();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            System.out.println(e.getMessage());
        }
        connection.close();
        return true;
    }

    public boolean deleteNhanVien(int idNhanVien) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        String sql = "DELETE FROM nhanvien WHERE id = " +idNhanVien;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();
        preparedStatement.close();
        return true;
    }
}
