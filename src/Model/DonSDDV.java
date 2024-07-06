package Model;

public class DonSDDV {
    private int maDonSDDV;
    private String hoVaTen;
    private String loaiDV;
    private String phiDV;
    private String ngayHD;

    public DonSDDV() {
    }

    public DonSDDV(int maDonSDDV, String hoVaTen, String loaiDV, String phiDV, String ngayHD) {
        this.maDonSDDV = maDonSDDV;
        this.hoVaTen = hoVaTen;
        this.loaiDV = loaiDV;
        this.phiDV = phiDV;
        this.ngayHD = ngayHD;
    }

    public int getMaDonSDDV() {
        return this.maDonSDDV;
    }

    public void setMaDonSDDV(int maDonSDDV) {
        this.maDonSDDV = maDonSDDV;
    }

    public String getHoVaTen() {
        return this.hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getLoaiDV() {
        return this.loaiDV;
    }

    public void setLoaiDV(String loaiDV) {
        this.loaiDV = loaiDV;
    }

    public String getPhiDV() {
        return this.phiDV;
    }

    public void setPhiDV(String phiDV) {
        this.phiDV = phiDV;
    }

    public String getNgayHD() {
        return this.ngayHD;
    }

    public void setNgayHD(String ngayHD) {
        this.ngayHD = ngayHD;
    }
}
