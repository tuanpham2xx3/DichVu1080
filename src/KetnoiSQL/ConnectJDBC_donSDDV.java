package KetnoiSQL;

import Model.DonSDDV;
import Model.KhachHang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectJDBC_donSDDV {
    static String url = "jdbc:mySQL://localhost:3306/quanlidichvu1080";
    static String username = "root";
    static String password = "";

    public ConnectJDBC_donSDDV() {
    }

    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

        return connection;
    }

    public static void themSDDV(DonSDDV donSDDV) {
        String sql = "INSERT INTO hoadon (hoVaTen, loaiDichVu, phiDichVu, ngayHoaDon) VALUES (?, ?, ?, ?)";

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, donSDDV.getHoVaTen());
            preparedStatement.setString(2, donSDDV.getLoaiDV());
            preparedStatement.setString(3, donSDDV.getPhiDV());
            preparedStatement.setString(4, donSDDV.getNgayHD());
            preparedStatement.execute();
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public static List<DonSDDV> laydonSDDV() {
        List<DonSDDV> list_donSDDV = new ArrayList();
        String sql = "SELECT * FROM hoadon";

        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while(result.next()) {
                DonSDDV donSDDV = new DonSDDV(result.getInt("maHoaDon"), result.getString("hoVaTen"), result.getString("loaiDichVu"), result.getString("phiDichVu"), result.getString("ngayHoaDon"));
                list_donSDDV.add(donSDDV);
            }
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return list_donSDDV;
    }

    public static void xoaDonDDV(String donSDDV) {
        String sql = "DELETE FROM hoadon WHERE hoVaTen = '" + donSDDV + "'" + " OR maHoaDon = '" + donSDDV + "'";

        try {
            System.out.println(sql);
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public DonSDDV timTheoHoVaTen(String hoVaTen) throws Throwable {
        String sql = "SELECT hoVaTen, loaiDichVu, phiDichVu, ngayHoaDon from hoadon WHERE hoVaTen = ? ";
        Throwable var3 = null;
        Object var4 = null;

        try {
            Connection connection = getConnection();

            DonSDDV var10000;
            label310: {
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);

                    try {
                        preparedStatement.setString(1, hoVaTen);
                        ResultSet rs = preparedStatement.executeQuery();
                        if (rs.next()) {
                            DonSDDV donSDDV = new DonSDDV();
                            donSDDV.setHoVaTen(rs.getString("hoVaTen"));
                            donSDDV.setLoaiDV(rs.getString("loaiDichVu"));
                            donSDDV.setPhiDV(rs.getString("phiDichVu"));
                            donSDDV.setNgayHD(rs.getString("ngayHoaDon"));
                            var10000 = donSDDV;
                            break label310;
                        }
                    } finally {
                        if (preparedStatement != null) {
                            preparedStatement.close();
                        }

                    }
                } catch (Throwable var19) {
                    if (var3 == null) {
                        var3 = var19;
                    } else if (var3 != var19) {
                        var3.addSuppressed(var19);
                    }

                    if (connection != null) {
                        connection.close();
                    }

                    throw var3;
                }

                if (connection != null) {
                    connection.close();
                }

                return null;
            }

            if (connection != null) {
                connection.close();
            }

            return var10000;
        } catch (Throwable var20) {
            if (var3 == null) {
                var3 = var20;
            } else if (var3 != var20) {
                var3.addSuppressed(var20);
            }

            throw var3;
        }
    }

    public static List<DonSDDV> timDonSDDV(String donSDDV1) {
        List<DonSDDV> list_donSDDV = new ArrayList();
        String sql = "SELECT * FROM hoadon WHERE maHoaDon ='" + donSDDV1 + "'" + " OR hoVaTen = '" + donSDDV1 + "'";

        try {
            System.out.println(sql);
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while(result.next()) {
                DonSDDV donSDDV = new DonSDDV(result.getInt("maHoaDon"), result.getString("hoVaTen"), result.getString("loaiDichVu"), result.getString("phiDichVu"), result.getString("ngayHoaDon"));
                list_donSDDV.add(donSDDV);
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        return list_donSDDV;
    }

    public boolean capNhatDonSDDV(DonSDDV donSDDV) throws Throwable {
        String sql = " UPDATE hoadon SET loaiDichVu = ?,phiDichVu = ?,ngayHoaDon = ? WHERE hoVaTen = ?";
        Throwable var3 = null;
        Object var4 = null;

        try {
            Connection connection = getConnection();

            boolean var10000;
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                try {
                    preparedStatement.setString(4, donSDDV.getHoVaTen());
                    preparedStatement.setString(1, donSDDV.getLoaiDV());
                    preparedStatement.setString(2, donSDDV.getPhiDV());
                    preparedStatement.setString(3, donSDDV.getNgayHD());
                    var10000 = preparedStatement.executeUpdate() > 0;
                } finally {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }

                }
            } catch (Throwable var17) {
                if (var3 == null) {
                    var3 = var17;
                } else if (var3 != var17) {
                    var3.addSuppressed(var17);
                }

                if (connection != null) {
                    connection.close();
                }

                throw var3;
            }

            if (connection != null) {
                connection.close();
            }

            return var10000;
        } catch (Throwable var18) {
            if (var3 == null) {
                var3 = var18;
            } else if (var3 != var18) {
                var3.addSuppressed(var18);
            }

            throw var3;
        }
    }

    public static Integer tongDonSDDV(DonSDDV donSDDV) {
        Integer n = 0;
        String sql = "SELECT COUNT(maHoaDon)FROM hoadon";

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            n = resultSet.getInt(1);
            System.out.println(sql);
            System.out.println(n);
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return n;
    }

    public static Integer tongTien(DonSDDV donSDDV) {
        Integer n = 0;
        String sql = "SELECT SUM(phiDichVu)FROM hoadon";

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            n = resultSet.getInt(1);
            System.out.println(sql);
            System.out.println(n);
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return n;
    }
    public static Integer tongDonSDDV_ngay(String donSDDV) {
        Integer n = 0;
        String sql = "SELECT COUNT(maHoaDon) FROM hoadon Where ngayHoaDon = ?";

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, donSDDV);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            n = resultSet.getInt(1);
            System.out.println(sql);
            System.out.println(n);
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return n;
    }
    public static Integer tongTien_ngay(String donSDDV) {
        Integer n = 0;
        String sql = "SELECT SUM(phiDichVu) FROM hoadon Where ng78= ?";

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, donSDDV);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            n = resultSet.getInt(1);
            System.out.println(sql);
            System.out.println(n);
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return n;
    }

}


