package quanlyphonggym;

public class Session {
    private static int idUser;

    public static int getIdAdmin() {
        return idUser;
    }

    public static void setIdAdmin(int idUser) {
        Session.idUser = idUser;
    }
}
