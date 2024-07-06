package Model;

public class NguoiDung {
    private int maNguoiDung;
    private String tenDangNhap;
    private String matKhau;
    private String user;
    private String Hovaten;

    public NguoiDung() {
    }

    public NguoiDung(int maNguoiDung, String tenDangNhap, String matKhau, String user) {
        this.maNguoiDung = maNguoiDung;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.user = user;
    }
    
    public int getMaNguoiDung() {
        return this.maNguoiDung;
    }

    public void setMaNguoiDung(int maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public String getTenDangNhap() {
        return this.tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return this.matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    public String getuser() {
        return this.tenDangNhap;
    }

    public void setuser(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }
    public String getHovaten() {
        return this.Hovaten;
    }
    public void setHovaten(String Hovaten) {
        this.Hovaten = Hovaten;
    }
}
