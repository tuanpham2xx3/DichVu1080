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

public class ConnectJDBC {
    static String url = "jdbc:mySQL://localhost:3306/quanlidichvu1080";
    static String username = "root";
    static String password = "";

    public ConnectJDBC() {
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

    public static void themKhachHang(KhachHang khachHang) {
        String sql = "INSERT INTO khachhang (hoVaTen, ngaySinh, so_CCCD, gioiTinh, diaChi, soDT) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, khachHang.getHoVaTen());
            preparedStatement.setString(2, khachHang.getNgaySinh());
            preparedStatement.setString(3, khachHang.getSo_CCCD());
            preparedStatement.setInt(4, khachHang.getGioiTinh());
            preparedStatement.setString(5, khachHang.getDiaChi());
            preparedStatement.setString(6, khachHang.getSoDT());
            preparedStatement.execute();
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public boolean capNhatKhachHang(KhachHang khachHang) throws Throwable {
        String sql = " UPDATE khachhang SET ngaySinh = ?,so_CCCD = ?,gioiTinh = ?,diaChi = ?,soDT = ? WHERE hoVaTen = ?";
        Throwable var3 = null;
        Object var4 = null;

        try {
            Connection connection = getConnection();

            boolean var10000;
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                try {
                    preparedStatement.setString(6, khachHang.getHoVaTen());
                    preparedStatement.setString(1, khachHang.getNgaySinh());
                    preparedStatement.setString(2, khachHang.getSo_CCCD());
                    preparedStatement.setInt(3, khachHang.getGioiTinh());
                    preparedStatement.setString(4, khachHang.getDiaChi());
                    preparedStatement.setString(5, khachHang.getSoDT());
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

    public static void xoaKhachHang(String khachHang) {
        String sql = "DELETE FROM khachhang WHERE hoVaTen = '" + khachHang + "'" + "OR maKhachHang = '" + khachHang + "'";

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public static List<KhachHang> timKhachHang(String khachHang) {
        List<KhachHang> list_khachHang = new ArrayList();
        String sql = "SELECT * FROM khachhang WHERE maKhachHang ='" + khachHang + "'" + " OR hoVaTen = '" + khachHang + "'";

        try {
            System.out.println(sql);
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while(result.next()) {
                KhachHang khachHang_2 = new KhachHang(result.getInt("maKhachHang"), result.getString("hoVaTen"), result.getString("ngaySinh"), result.getString("so_CCCD"), result.getInt("gioiTinh"), result.getString("diaChi"), result.getString("soDT"));
                list_khachHang.add(khachHang_2);
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        return list_khachHang;
    }

    public static List<KhachHang> layTatCa() {
        List<KhachHang> list_khachHang = new ArrayList();
        String sql = "SELECT * FROM khachhang";

        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while(result.next()) {
                KhachHang khachHang = new KhachHang(result.getInt("maKhachHang"), result.getString("hoVaTen"), result.getString("ngaySinh"), result.getString("so_CCCD"), result.getInt("gioiTinh"), result.getString("diaChi"), result.getString("soDT"));
                list_khachHang.add(khachHang);
            }
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return list_khachHang;
    }

    public static Integer tongKhachHang(KhachHang khachHang) {
        Integer n = 0;
        String sql = "SELECT COUNT(maKhachHang)FROM khachhang";

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

    public KhachHang timTheoHoVaTen(String hoVaTen) throws Throwable {
        String sql = "SELECT hoVaTen, ngaySinh, so_CCCD, gioiTinh, diaChi, soDT from khachhang WHERE hoVaTen = ? ";
        Throwable var3 = null;
        Object var4 = null;

        try {
            Connection connection = getConnection();

            KhachHang var10000;
            label310: {
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);

                    try {
                        preparedStatement.setString(1, hoVaTen);
                        ResultSet rs = preparedStatement.executeQuery();
                        if (rs.next()) {
                            KhachHang khachHang = new KhachHang();
                            khachHang.setHoVaTen(rs.getString("hoVaTen"));
                            khachHang.setNgaySinh(rs.getString("ngaySinh"));
                            khachHang.setSo_CCCD(rs.getString("so_CCCD"));
                            khachHang.setGioiTinh(rs.getInt("gioiTinh"));
                            khachHang.setDiaChi(rs.getString("diaChi"));
                            khachHang.setSoDT(rs.getString("soDT"));
                            var10000 = khachHang;
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
}

