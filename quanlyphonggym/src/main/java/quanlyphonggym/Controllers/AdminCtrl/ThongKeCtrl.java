package quanlyphonggym.Controllers.AdminCtrl;

import quanlyphonggym.Bean.DangKyGoiTapBean;
import quanlyphonggym.Models.DangKyGoiTap;
import quanlyphonggym.Models.GoiTap;
import quanlyphonggym.Models.HoiVien;
import quanlyphonggym.Models.ThanhToan;
import quanlyphonggym.MysqlConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThongKeCtrl {

    public List<DangKyGoiTapBean> getAllThanhToan() throws SQLException, ClassNotFoundException {
        // lấy ra thông tin người đki, gói tập, ngày đki, thanh toán chưa?
        List<DangKyGoiTapBean> danhSachThanhToan = new ArrayList<>();

        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String sql = "SELECT hoivien.*, goitap.*, dangkygoitap.*, thanhtoan.*"
                    +" FROM dangkygoitap"
                    +" LEFT JOIN goitap ON dangkygoitap.idGoiap = goitap.id"
                    +" LEFT JOIN hoivien ON dangkygoitap.idHoiVien = hoivien.id"
                    +" LEFT JOIN thanhtoan ON dangkygoitap.id = thanhtoan.idDangKy";


            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                DangKyGoiTapBean dangKyGoiTapBean = new DangKyGoiTapBean();
                HoiVien hoiVien = new HoiVien();
                DangKyGoiTap dangKyGoiTap = new DangKyGoiTap();
                ThanhToan thanhToan = new ThanhToan();
                GoiTap goiTap = new GoiTap();

                //get hoivien
                hoiVien.setId(resultSet.getInt("hoivien.id"));
                hoiVien.setMaHoiVien(resultSet.getString("hoivien.maHoiVien"));
                hoiVien.setHoTen(resultSet.getString("hoivien.hoTen"));
                hoiVien.setNgaySinh(resultSet.getString("hoivien.ngaySinh"));
                hoiVien.setGioiTinh(resultSet.getString("hoivien.gioiTinh"));
                hoiVien.setNgheNghiep(resultSet.getString("hoivien.ngheNghiep"));
                hoiVien.setDiaChi(resultSet.getString("hoivien.diaChi"));
                hoiVien.setSoDienThoai(resultSet.getString("hoivien.soDienThoai"));
                hoiVien.setLoaiThanhVien(resultSet.getString("hoivien.loaiThanhVien"));
                hoiVien.setMaVanTay(resultSet.getString("hoivien.maVanTay"));
                dangKyGoiTapBean.setHoiVien(hoiVien);

                //get dangkygoitap
                dangKyGoiTap.setId(resultSet.getInt("dangkygoitap.id"));
                dangKyGoiTap.setIdHoiVien(resultSet.getInt("dangkygoitap.idHoiVien"));
                dangKyGoiTap.setIdGoiTap(resultSet.getInt("dangkygoitap.idGoiTap"));
                dangKyGoiTap.setNgayDangKy(String.valueOf(resultSet.getDate("dangkygoitap.ngayDangKy")));
                dangKyGoiTap.setNgayBatDau(String.valueOf(resultSet.getDate("dangkygoitap.ngayBatDau")));
                dangKyGoiTap.setNgayKetThuc(String.valueOf(resultSet.getDate("dangkygoitap.ngayKetThuc")));
                dangKyGoiTap.setTrangThaiThanhToan(resultSet.getBoolean("dangkygoitap.trangThaiThanhToan"));
                dangKyGoiTap.setIsGoiTapHienTai(resultSet.getBoolean("dangkygoitap.isGoiTapHienTai"));
                dangKyGoiTapBean.setDangKyGoiTap(dangKyGoiTap);

                //get thông tin gói tập
                goiTap.setId(resultSet.getInt("goitap.id"));
                goiTap.setTenGoiTap(resultSet.getString("goitap.tenGoiTap"));
                goiTap.setNoiDungHinhThuc(resultSet.getString("goitap.noiDungHinhThuc"));
                goiTap.setSoTien(resultSet.getInt("goitap.soTien"));
                dangKyGoiTapBean.setGoiTap(goiTap);

                //get thanhtoan
                //check đã thanh toán chưa
                if (dangKyGoiTap.getTrangThaiThanhToan()) {
                    thanhToan.setId(resultSet.getInt("thanhtoan.id"));
                    thanhToan.setIdDangKy(resultSet.getInt("thanhtoan.idDangKy"));
                    thanhToan.setIdHoiVien(resultSet.getInt("thanhtoan.idHoiVien"));
                    thanhToan.setIdGoiTap(resultSet.getInt("thanhtoan.idGoiTap"));
                    thanhToan.setSoTien(resultSet.getInt("thanhtoan.soTien"));
                    thanhToan.setNgayThanhToan(String.valueOf(resultSet.getTimestamp("thanhtoan.ngayThanhToan")));
                    dangKyGoiTapBean.setThanhToan(thanhToan);
                }

                danhSachThanhToan.add(dangKyGoiTapBean);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            return null;
        }


        return danhSachThanhToan;
    }
}
