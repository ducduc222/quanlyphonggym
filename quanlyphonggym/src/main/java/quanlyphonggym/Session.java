package quanlyphonggym;

public class Session {
    private static int idHoiVien;
    private static boolean isAdmin;


    public static int getIdHoiVien() {
        return idHoiVien;
    }

    public static void setIdHoiVien(int idHoiVien) {
        Session.idHoiVien = idHoiVien;
    }

    public static boolean isIsAdmin() {
        return isAdmin;
    }

    public static void setIsAdmin(boolean isAdmin) {
        Session.isAdmin = isAdmin;
    }
}
