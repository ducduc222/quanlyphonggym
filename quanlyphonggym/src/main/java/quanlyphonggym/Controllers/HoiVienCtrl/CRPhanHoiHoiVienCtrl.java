package quanlyphonggym.Controllers.HoiVienCtrl;

import quanlyphonggym.Bean.PhanHoiBean;
import quanlyphonggym.Models.PhanHoiCuaAdmin;
import quanlyphonggym.Models.PhanHoiCuaHoiVien;
import quanlyphonggym.MysqlConnection;
import quanlyphonggym.Util.TimeStampForm;

import javax.swing.*;
import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CRPhanHoiHoiVienCtrl {
    public boolean guiPhanHoi(PhanHoiCuaHoiVien phanHoiCuaHoiVien) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();

        try {
            String sql = "INSERT INTO phanhoicuahoivien(idHoiVien, idNhanVien, noiDung, ngayPhanHoi, isDaPhanHoiLai) "
                    +" values(?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setInt(1, phanHoiCuaHoiVien.getIdHoiVien());
            preparedStatement.setInt(2, phanHoiCuaHoiVien.getIdNhanVien());
            preparedStatement.setString(3, phanHoiCuaHoiVien.getNoiDung());
            Instant instant = Instant.now();
            long timestamp = instant.getEpochSecond();
            preparedStatement.setString(4, TimeStampForm.returnTimeStampString(timestamp));
            preparedStatement.setBoolean(5, false);

            preparedStatement.execute();
            preparedStatement.close();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            System.out.println(e.getMessage());
            connection.close();
            return false;
        }
        return true;
    }

    public List<PhanHoiBean> getAllPhanHoiCuaHoiVienById(int idHoiVien) throws SQLException, ClassNotFoundException {
        List<PhanHoiBean> phanHoiBeanList = new ArrayList<>();

        //code
        Connection connection = MysqlConnection.getMysqlConnection();

        try {

            String sql = "SELECT phanhoicuahoivien.*,phanhoicuaadmin.*  FROM phanhoicuahoivien LEFT JOIN phanhoicuaadmin ON phanhoicuahoivien.id = phanhoicuaadmin.idPhanHoiCuaHoiVien WHERE phanhoicuahoivien.idHoiVien = "+idHoiVien;
            PreparedStatement prst = connection.prepareStatement(sql);
            ResultSet resultSet5 = prst.executeQuery();
            while (resultSet5.next()) {
                PhanHoiBean phanHoiBean = new PhanHoiBean();
                PhanHoiCuaHoiVien phanHoiCuaHoiVien = new PhanHoiCuaHoiVien();
                PhanHoiCuaAdmin phanHoiCuaAdmin = new PhanHoiCuaAdmin();

                //get phanhoihoivien
                phanHoiCuaHoiVien.setId(resultSet5.getInt("phanhoicuahoivien.id"));
                phanHoiCuaHoiVien.setIdHoiVien(resultSet5.getInt("phanhoicuahoivien.idHoiVien"));
                phanHoiCuaHoiVien.setIdNhanVien(resultSet5.getInt("phanhoicuahoivien.idNhanVien"));
                phanHoiCuaHoiVien.setNoiDung(resultSet5.getString("phanhoicuahoivien.noiDung"));
                phanHoiCuaHoiVien.setNgayPhanHoi(String.valueOf(resultSet5.getTimestamp("phanhoicuahoivien.ngayPhanHoi")));
                phanHoiCuaHoiVien.setIsDaPhanHoiLai(resultSet5.getBoolean("phanhoicuahoivien.isDaPhanHoiLai"));
                phanHoiBean.setPhanHoiCuaHoiVien(phanHoiCuaHoiVien);

                //get phanhoiAdmin
                if (phanHoiCuaHoiVien.getIsDaPhanHoiLai()) {
                    phanHoiCuaAdmin.setId(resultSet5.getInt("phanhoicuaadmin.id"));
                    phanHoiCuaAdmin.setIdPhanHoiCuaHoiVien(resultSet5.getInt("phanhoicuaadmin.idPhanHoiCuaHoiVien"));
                    phanHoiCuaAdmin.setNoiDung(resultSet5.getString("phanhoicuaadmin.noiDung"));
                    phanHoiCuaAdmin.setNgayPhanHoi(String.valueOf(resultSet5.getTimestamp("phanhoicuaadmin.ngayPhanHoi")));
                    phanHoiBean.setPhanHoiCuaAdmin(phanHoiCuaAdmin);
                }

                phanHoiBeanList.add(phanHoiBean);
            }
            prst.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            System.out.println(e.getMessage());
            return null;
        }

        connection.close();
        return phanHoiBeanList;
    }
}
