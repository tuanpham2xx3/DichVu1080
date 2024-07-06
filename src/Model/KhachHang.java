package Model;

public class KhachHang {
    private int maKhachHang;
    private String hoVaTen;
    private String ngaySinh;
    private String so_CCCD;
    private int gioiTinh;
    private String diaChi;
    private String soDT;

    public KhachHang() {
    }

    public KhachHang(int maKhachHang, String hoVaTen, String ngaySinh, String so_CCCD, int gioiTinh, String diaChi, String soDT) {
        this.maKhachHang = maKhachHang;
        this.hoVaTen = hoVaTen;
        this.ngaySinh = ngaySinh;
        this.so_CCCD = so_CCCD;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soDT = soDT;
    }

    public int getMaKhachHang() {
        return this.maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getHoVaTen() {
        return this.hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getNgaySinh() {
        return this.ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSo_CCCD() {
        return this.so_CCCD;
    }

    public void setSo_CCCD(String so_CCCD) {
        this.so_CCCD = so_CCCD;
    }

    public int getGioiTinh() {
        return this.gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return this.diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDT() {
        return this.soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }
}

