package View1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Model.NguoiDung;
import KetnoiSQL.ConnectJDBC_nguoiDung;

public class DangNhap extends JFrame {
	
    private JPanel contentPane;
    private JTextField textField_taiKhoan;
    private JPasswordField passwordField_matkhau;
    
    public DangNhap() {
    	URL url_icon_file = DangKy.class.getResource("log_in.png");
        Image img = Toolkit.getDefaultToolkit().createImage(url_icon_file);
        this.setIconImage(img);
        this.setTitle("ĐĂNG NHẬP QUẢN LÍ DỊCH VỤ 1080");
        this.setDefaultCloseOperation(3);
        this.setBounds(100, 100, 496, 330);
        this.setLocationRelativeTo(this.contentPane);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout((LayoutManager)null);
        GradientPanel gradientPanel = new GradientPanel(new Color(103, 157, 211), new Color(229, 229, 190), 3);
        gradientPanel.setColor2(new Color(128, 255, 128));
        gradientPanel.setColor1(new Color(128, 255, 255));
        gradientPanel.setBounds(0, 0, 482, 293);
        this.contentPane.add(gradientPanel);
        gradientPanel.setLayout((LayoutManager)null);
        gradientPanel.setLayout(null);
        gradientPanel.setLayout(null);
        gradientPanel.setLayout(null);
        JLabel lblNewLabel = new JLabel("ĐĂNG NHẬP");
        lblNewLabel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QL1080View.class.getResource("log_in.png"))));
        lblNewLabel.setFont(new Font("Times New Roman", 1, 20));
        lblNewLabel.setBounds(152, 0, 171, 42);
        gradientPanel.add(lblNewLabel);
        JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu:");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", 3, 20));
        lblNewLabel_1_1.setBounds(10, 115, 92, 24);
        gradientPanel.add(lblNewLabel_1_1);
        JLabel lblNewLabel_1_2 = new JLabel("Bạn chưa có tài khoản ? Đăng kí ngay !");
        lblNewLabel_1_2.setFont(new Font("Times New Roman", 3, 20));
        lblNewLabel_1_2.setBounds(10, 196, 400, 24);
        gradientPanel.add(lblNewLabel_1_2);
        JLabel lblNewLabel_1 = new JLabel("Tài khoản:");
        lblNewLabel_1.setFont(new Font("Times New Roman", 3, 20));
        lblNewLabel_1.setBounds(10, 55, 110, 24);
        gradientPanel.add(lblNewLabel_1);
        this.textField_taiKhoan = new JTextField();
        this.textField_taiKhoan.setFont(new Font("Times New Roman", 0, 15));
        this.textField_taiKhoan.setBounds(152, 52, 292, 33);
        gradientPanel.add(this.textField_taiKhoan);
        this.textField_taiKhoan.setColumns(10);
        this.passwordField_matkhau = new JPasswordField();
        this.passwordField_matkhau.setBounds(152, 113, 292, 33);
        gradientPanel.add(this.passwordField_matkhau);
        
        
        JButton btn_thoat = new JButton("Thoát");
        btn_thoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DangNhap.this.setVisible(false);
            }
        });
        btn_thoat.setFont(new Font("Times New Roman", 0, 15));
        btn_thoat.setBounds(353, 262, 119, 23);
        gradientPanel.add(btn_thoat);


        JButton btn_dangki = new JButton("Đăng kí");
        btn_dangki.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	DangKy DangKy = new DangKy();
                DangKy.setVisible(true);
                DangNhap.this.dispose();
            }
        });
        btn_dangki.setFont(new Font("Times New Roman", 0, 15));
        btn_dangki.setBounds(191, 230, 119, 23);
        gradientPanel.add(btn_dangki);
        
        final JButton btn_dangNhap_1 = new JButton("Đăng nhập");
        btn_dangNhap_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mySQL://localhost:3306/quanlidichvu1080";
                String username = "root";
                String password = "";

                try {
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String sql = "SELECT * FROM nguoidung WHERE tenDangNhap = ? AND matKhau = ?";
                    PreparedStatement ps = connection.prepareCall(sql);
                    ps.setString(1, DangNhap.this.textField_taiKhoan.getText());
                    ps.setString(2, DangNhap.this.passwordField_matkhau.getText());
                    ResultSet resultSet = ps.executeQuery();
                    if (!DangNhap.this.textField_taiKhoan.getText().equals("") && !DangNhap.this.passwordField_matkhau.getText().equals("")) {
                        if (resultSet.next()) {
                        	NguoiDung nguoiDung = new NguoiDung();
                            nguoiDung.setuser(textField_taiKhoan.getText());
                            ConnectJDBC_nguoiDung.themWel(nguoiDung);
                            QL1080View QL1080View = new QL1080View();
                            QL1080View.setVisible(true);
                            System.out.println("Tài khoản " +ConnectJDBC_nguoiDung.layUser()+ " đã đăng nhập thành công !");
                            DangNhap.this.dispose();
                            
                        } else {
                            JOptionPane.showMessageDialog(btn_dangNhap_1, "Sai thông tin đăng nhập!");
                            DangNhap.this.textField_taiKhoan.setText("");
                            DangNhap.this.passwordField_matkhau.setText("");
                        }
                    } else {
                        JOptionPane.showMessageDialog(btn_dangNhap_1, "Chưa nhập đủ thông tin đăng nhập");
                    }
                } catch (Exception var11) {
                }

            }
        });
        btn_dangNhap_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btn_dangNhap_1.setBounds(191, 156, 119, 23);
        gradientPanel.add(btn_dangNhap_1);


    }
}
