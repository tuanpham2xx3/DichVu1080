package KetnoiSQL;

import Model.DonSDDV;
import Model.KhachHang;
import Model.NguoiDung;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ConnectJDBC_nguoiDung {
    static String url = "jdbc:mySQL://localhost:3306/quanlidichvu1080";
    static String username = "root";
    static String password = "";

    public ConnectJDBC_nguoiDung() {
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

    public static void dangNhap(NguoiDung nguoiDung) {
        String sql = "SELECT * FROM nguoidung WHERE tenDangNhap =? AND matKhau =?";

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareCall(sql);
            preparedStatement.setString(1, nguoiDung.getTenDangNhap());
            preparedStatement.setString(2, nguoiDung.getMatKhau());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (nguoiDung.getTenDangNhap().equals("") || nguoiDung.getMatKhau().equals("")) {
                JOptionPane.showMessageDialog((Component)null, "Chưa nhập tài khoản và mật khẩu");
            }
        } catch (Exception var5) {
        }

    }
    public static void themND(NguoiDung nguoiDung) {
        String sql = "INSERT INTO nguoidung (tenDangNhap, matKhau) VALUES (?, ?)";

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nguoiDung.getTenDangNhap());
            preparedStatement.setString(2, nguoiDung.getMatKhau());
            preparedStatement.execute();
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }
    public static void themWel(NguoiDung nguoiDung) {
        String sql = "INSERT INTO welcome (user) VALUES (?)";

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nguoiDung.getuser());
            preparedStatement.execute();
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }
    public static String layUser() {
        NguoiDung nguoiDung = new NguoiDung();
        String sql = "SELECT * FROM welcome";

        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while(result.next()) {
            	 nguoiDung = new NguoiDung(0,result.getString("user"),"a","a");
                
            }
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return nguoiDung.getuser();
    }
    public static void xoaUser() {
        String sql = "DELETE FROM welcome";

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }
}

