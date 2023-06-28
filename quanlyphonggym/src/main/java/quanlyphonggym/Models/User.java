package quanlyphonggym.Models;

public class User {
    private int id;
    private int idHoiVien;
    private String username;
    private String password;
    private Boolean isAdmin;
    public User() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdHoiVien() {
        return idHoiVien;
    }
    public void setIdHoiVien(int idHoiVien) {
        this.idHoiVien = idHoiVien;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Boolean getIsAdmin() {
        return isAdmin;
    }
    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    
}
