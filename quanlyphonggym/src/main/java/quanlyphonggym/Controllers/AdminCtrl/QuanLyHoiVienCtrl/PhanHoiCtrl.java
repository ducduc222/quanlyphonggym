package quanlyphonggym.Controllers.AdminCtrl.QuanLyHoiVienCtrl;

import quanlyphonggym.Bean.PhanHoiBean;
import quanlyphonggym.Models.PhanHoiCuaAdmin;
import quanlyphonggym.Models.PhanHoiCuaHoiVien;
import quanlyphonggym.MysqlConnection;
import quanlyphonggym.Util.DateForm;
import quanlyphonggym.Util.TimeStampForm;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhanHoiCtrl {
    public PhanHoiBean getPhanHoiHoiVienById(int idPhanHoi) throws SQLException, ClassNotFoundException {
        PhanHoiBean phanHoiBean = new PhanHoiBean();
        //code
        Connection connection = MysqlConnection.getMysqlConnection();

        try {
            PhanHoiCuaHoiVien phanHoiCuaHoiVien = new PhanHoiCuaHoiVien();
            PhanHoiCuaAdmin phanHoiCuaAdmin = new PhanHoiCuaAdmin();
            String sql = "SELECT phanhoicuahoivien.*,phanhoicuaadmin.*  FROM phanhoicuahoivien LEFT JOIN phanhoicuaadmin ON phanhoicuahoivien.id = phanhoicuaadmin.idPhanHoiCuaHoiVien WHERE phanhoicuahoivien.id = "+idPhanHoi;
            PreparedStatement prst = connection.prepareStatement(sql);
            ResultSet resultSet5 = prst.executeQuery();
            if (resultSet5.next()) {
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
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            System.out.println(e.getMessage());
        }

        return phanHoiBean;
    }

    public boolean traLoiPhanHoi(PhanHoiBean phanHoiBean) throws SQLException, ClassNotFoundException {
        //code
        Connection connection = MysqlConnection.getMysqlConnection();

        try {
            String sqlHV = "UPDATE phanhoicuahoivien SET isDaPhanHoiLai = 1 WHERE id = "+ phanHoiBean.getPhanHoiCuaHoiVien().getId();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlHV);
            preparedStatement.execute();
            preparedStatement.close();

            Date date = new Date();
            String sqlAD = "";
            if (phanHoiBean.getPhanHoiCuaHoiVien().getIsDaPhanHoiLai()) {

                String ngayPhanHoi = TimeStampForm.returnTimeStampString(date.getTime());
                sqlAD = "UPDATE phanhoicuaadmin SET noiDung = '"+phanHoiBean.getPhanHoiCuaAdmin().getNoiDung()+
                        "',ngayPhanHoi = '"+ngayPhanHoi
                        +"'  WHERE idPhanHoiCuaHoiVien = "+phanHoiBean.getPhanHoiCuaHoiVien().getId();
            } else {

                String ngayPhanHoi = TimeStampForm.returnTimeStampString(date.getTime());
                sqlAD = "INSERT INTO phanhoicuaadmin(idPhanHoiCuaHoiVien, noiDung, ngayPhanHoi) "+
                        "VALUES ("
                        +phanHoiBean.getPhanHoiCuaHoiVien().getId() +", '"
                        +phanHoiBean.getPhanHoiCuaAdmin().getNoiDung() +"', '"
                        +ngayPhanHoi
                        +"')";
             }

            PreparedStatement preparedStatement1 = connection.prepareStatement(sqlAD);
            preparedStatement1.execute();
            preparedStatement1.close();

        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            System.out.println(e.getMessage());
        }
        connection.close();
        return true;
    }
}
