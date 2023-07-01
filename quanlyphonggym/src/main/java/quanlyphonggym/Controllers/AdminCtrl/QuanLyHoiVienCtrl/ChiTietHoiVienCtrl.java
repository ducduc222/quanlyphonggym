package quanlyphonggym.Controllers.AdminCtrl.QuanLyHoiVienCtrl;

import quanlyphonggym.Bean.DangKyGoiTapBean;
import quanlyphonggym.Bean.HoiVienBean;
import quanlyphonggym.Bean.PhanHoiBean;
import quanlyphonggym.Models.*;
import quanlyphonggym.MysqlConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChiTietHoiVienCtrl {
    public HoiVienBean getChiTietHoiVienById(int idHoiVien) throws SQLException, ClassNotFoundException {
        HoiVienBean hoiVienBean = new HoiVienBean();
        //code
        HoiVien hoiVien = new HoiVien();
        DangKyGoiTapBean goiTapHienTai = new DangKyGoiTapBean();
        List<DangKyGoiTapBean> danhSachGoiTapDaDangKy = new ArrayList<>();
        List<LichSu> lichSuSuDungDichVu = new ArrayList<>();
        List<PhanHoiBean> danhSachPhanHoi = new ArrayList<>();
        NhanVien PT = new NhanVien(); //người hướng dẫn

        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            // get hoivien
            String sql1 = "SELECT * FROM hoivien WHERE id = "+idHoiVien;
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
            ResultSet rss = preparedStatement1.executeQuery();
            if (rss.next()) {
                hoiVien.setId(rss.getInt("id"));
                hoiVien.setMaHoiVien(rss.getString("maHoiVien"));
                hoiVien.setHoTen(rss.getString("hoTen"));
                hoiVien.setNgaySinh(rss.getString("ngaySinh"));
                hoiVien.setGioiTinh(rss.getString("gioiTinh"));
                hoiVien.setNgheNghiep(rss.getString("ngheNghiep"));
                hoiVien.setDiaChi(rss.getString("diaChi"));
                hoiVien.setSoDienThoai(rss.getString("soDienThoai"));
                hoiVien.setLoaiThanhVien(rss.getString("loaiThanhVien"));
                hoiVien.setMaVanTay(rss.getString("maVanTay"));

            }
            hoiVienBean.setHoiVien(hoiVien);
            preparedStatement1.close();

            // get goiTapHIenTai
            String sql2 = "SELECT dangkygoitap.*, goitap.* FROM dangkygoitap"+
                    " LEFT JOIN goitap ON goitap.id = dangkygoitap.idGoiTap "+
                    " WHERE idHoiVien = "+idHoiVien+
                    " and isGoiTapHienTai = 1";
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
            ResultSet resultSet2 = preparedStatement2.executeQuery();
            if (resultSet2.next()) {
                GoiTap goiTap = new GoiTap();
                goiTap.setId(resultSet2.getInt("goitap.id"));
                goiTap.setTenGoiTap(resultSet2.getString("goitap.tenGoiTap"));
                goiTap.setNoiDungHinhThuc(resultSet2.getString("goitap.noiDungHinhThuc"));
                goiTapHienTai.setGoiTap(goiTap);

                DangKyGoiTap dangKyGoiTap = new DangKyGoiTap();
                dangKyGoiTap.setId(resultSet2.getInt("dangkygoitap.id"));
                dangKyGoiTap.setIdHoiVien(resultSet2.getInt("dangkygoitap.idHoiVien"));
                dangKyGoiTap.setIdGoiTap(resultSet2.getInt("dangkygoitap.idGoiTap"));
                dangKyGoiTap.setNgayDangKy(String.valueOf(resultSet2.getDate("dangkygoitap.ngayDangKy")));
                dangKyGoiTap.setNgayBatDau(String.valueOf(resultSet2.getDate("dangkygoitap.ngayBatDau")));
                dangKyGoiTap.setNgayKetThuc(String.valueOf(resultSet2.getDate("dangkygoitap.ngayKetThuc")));
                dangKyGoiTap.setTrangThaiThanhToan(resultSet2.getBoolean("dangkygoitap.trangThaiThanhToan"));
                dangKyGoiTap.setIsGoiTapHienTai(true);
                goiTapHienTai.setDangKyGoiTap(dangKyGoiTap);

            }
            hoiVienBean.setGoiTapHienTai(goiTapHienTai);
            preparedStatement2.close();

//          get  List<DangKyGoiTapBean> danhSachGoiTapDaDangKy = new ArrayList<>();
            String sql3 = "SELECT dangkygoitap.*, goitap.* FROM dangkygoitap"+
                    " LEFT JOIN goitap ON goitap.id = dangkygoitap.idGoiTap ";
            PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
            ResultSet resultSet3 = preparedStatement3.executeQuery();
            while (resultSet3.next()) {
                DangKyGoiTapBean goiTapBean = new DangKyGoiTapBean();
                GoiTap goiTap = new GoiTap();
                goiTap.setId(resultSet3.getInt("goitap.id"));
                goiTap.setTenGoiTap(resultSet3.getString("goitap.tenGoiTap"));
                goiTap.setNoiDungHinhThuc(resultSet3.getString("goitap.noiDungHinhThuc"));
                goiTapBean.setGoiTap(goiTap);

                DangKyGoiTap dangKyGoiTap = new DangKyGoiTap();
                dangKyGoiTap.setId(resultSet3.getInt("dangkygoitap.id"));
                dangKyGoiTap.setIdHoiVien(resultSet3.getInt("dangkygoitap.idHoiVien"));
                dangKyGoiTap.setIdGoiTap(resultSet3.getInt("dangkygoitap.idGoiTap"));
                dangKyGoiTap.setNgayDangKy(String.valueOf(resultSet3.getDate("dangkygoitap.ngayDangKy")));
                dangKyGoiTap.setNgayBatDau(String.valueOf(resultSet3.getDate("dangkygoitap.ngayBatDau")));
                dangKyGoiTap.setNgayKetThuc(String.valueOf(resultSet3.getDate("dangkygoitap.ngayKetThuc")));
                dangKyGoiTap.setTrangThaiThanhToan(resultSet3.getBoolean("dangkygoitap.trangThaiThanhToan"));
                dangKyGoiTap.setIsGoiTapHienTai(resultSet3.getBoolean("dangkygoitap.isGoiTapHienTai"));
                goiTapBean.setDangKyGoiTap(dangKyGoiTap);
                danhSachGoiTapDaDangKy.add(goiTapBean);
            }
            hoiVienBean.setDanhSachGoiTapDaDangKy(danhSachGoiTapDaDangKy);
            preparedStatement3.close();

//          get  List<LichSu> lichSuSuDungDichVu = new ArrayList<>();
            String sql4 = "SELECT * FROM lichsu WHERE idHoiVien = "+idHoiVien+" ORDER BY ngaySuDung DESC";
            PreparedStatement preparedStatement4 = connection.prepareStatement(sql4);
            ResultSet resultSet4 = preparedStatement4.executeQuery();
            while (resultSet4.next()) {
                LichSu lichSu = new LichSu();
                lichSu.setId(resultSet4.getInt("id"));
                lichSu.setIdHoiVien(resultSet4.getInt("idHoiVien"));
                lichSu.setGioVao(String.valueOf(resultSet4.getTimestamp("gioVao")));
                lichSu.setGioRa(String.valueOf(resultSet4.getTimestamp("gioRa")));
                lichSu.setNgaySuDung(String.valueOf(resultSet4.getDate("ngaySuDung")));

                lichSuSuDungDichVu.add(lichSu);

            }
            hoiVienBean.setLichSuSuDungDichVu(lichSuSuDungDichVu);
            preparedStatement4.close();

//          get  List<PhanHoiBean> danhSachPhanHoi = new ArrayList<>();
            String sql5 = "SELECT * FROM phanhoicuahoivien "
            +"LEFT JOIN phanhoicuaadmin ON phanhoicuaadmin.idPhanHoiCuaHoiVien = phanhoicuahoivien.id "
            +"WHERE idHoiVien = "+idHoiVien;
            PreparedStatement preparedStatement5 = connection.prepareStatement(sql5);
            ResultSet resultSet5 = preparedStatement5.executeQuery();
            while (resultSet5.next()) {
                PhanHoiBean phanHoiBean = new PhanHoiBean();
                PhanHoiCuaHoiVien phanHoiCuaHoiVien = new PhanHoiCuaHoiVien();
                PhanHoiCuaAdmin phanHoiCuaAdmin = new PhanHoiCuaAdmin();

                //get phanhoiHoiVien
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

                danhSachPhanHoi.add(phanHoiBean);

            }
            hoiVienBean.setDanhSachPhanHoi(danhSachPhanHoi);
            preparedStatement5.close();

//          get  NhanVien PT = new NhanVien(); //người hướng dẫn
            String sql6 = "SELECT * FROM nhanvien WHERE id = (SELECT idNhanVien FROM pt_hoivien WHERE idHoiVien = "+idHoiVien+")";
            PreparedStatement preparedStatement6 = connection.prepareStatement(sql6);
            ResultSet resultSet6 = preparedStatement6.executeQuery();
            if (resultSet6.next()) {
                PT.setId(resultSet6.getInt("id"));
                PT.setMaNhanVien(resultSet6.getString("maNhanVien"));
                PT.setHoTen(resultSet6.getString("hoTen"));
                PT.setNgaySinh(resultSet6.getString("ngaySinh"));
                PT.setGioiTinh(resultSet6.getString("gioiTinh"));
                PT.setDiaChi(resultSet6.getString("diaChi"));
                PT.setSoDienThoai(resultSet6.getString("soDienThoai"));
                PT.setNgayVaoLam(resultSet6.getString("ngayVaoLam"));
                PT.setIdRole(resultSet6.getInt("idRole"));
            }
            preparedStatement6.close();
            hoiVienBean.setPT(PT);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Có lỗi xảy ra");
            System.out.println(e.getMessage());
        }

        return hoiVienBean;
    }
}
