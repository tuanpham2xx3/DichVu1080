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

public class DangKy extends JFrame {
    private JPanel contentPane;
    private JTextField textField_taiKhoan;
    private JPasswordField passwordField_matkhau;
    private JPasswordField passwordField_nhaplai;
    private JTextField field_xacminh;
    
    public DangKy() {
        this.setTitle("ĐĂNG KÝ QUẢN LÍ DỊCH VỤ 1080");
        URL url_icon_file = DangKy.class.getResource("sign_up.png");
        Image img = Toolkit.getDefaultToolkit().createImage(url_icon_file);
        this.setIconImage(img);
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
        gradientPanel.setLayout(null);
        gradientPanel.setLayout(null);
        gradientPanel.setLayout(null);
        gradientPanel.setLayout(null);
        gradientPanel.setLayout(null);
        gradientPanel.setLayout(null);
        gradientPanel.setLayout(null);
        gradientPanel.setLayout(null);
        gradientPanel.setLayout(null);
        gradientPanel.setLayout(null);
        JLabel lblNewLabel = new JLabel("ĐĂNG KÝ");
        lblNewLabel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QL1080View.class.getResource("sign_up.png"))));
        lblNewLabel.setBounds(160, 0, 184, 45);
        lblNewLabel.setFont(new Font("Times New Roman", 1, 20));
        gradientPanel.add(lblNewLabel);
        JLabel taikhoan = new JLabel("Tài khoản:");
        taikhoan.setBounds(3, 57, 110, 24);
        taikhoan.setFont(new Font("Times New Roman", 3, 20));
        gradientPanel.add(taikhoan);
        this.textField_taiKhoan = new JTextField();
        textField_taiKhoan.setBounds(141, 55, 290, 30);
        this.textField_taiKhoan.setFont(new Font("Times New Roman", 0, 15));
        gradientPanel.add(this.textField_taiKhoan);
        this.textField_taiKhoan.setColumns(10);
        JLabel matkhau = new JLabel("Mật khẩu:");
        matkhau.setBounds(3, 93, 92, 24);
        matkhau.setFont(new Font("Times New Roman", 3, 20));
        gradientPanel.add(matkhau);
        this.passwordField_matkhau = new JPasswordField();
        passwordField_matkhau.setBounds(141, 91, 290, 30);
        gradientPanel.add(this.passwordField_matkhau);
        
        final JButton btn_DangKy_1 = new JButton("Đăng ký");
        btn_DangKy_1.setBounds(191, 221, 119, 23);
        btn_DangKy_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mySQL://localhost:3306/quanlidichvu1080";
                String username = "root";
                String password = "";

                try {
                	@SuppressWarnings("deprecation")
					String xacminh = field_xacminh.getText();
                	String mk1 = passwordField_matkhau.getText();
                	String mk2 = passwordField_nhaplai.getText();
                    
                if(!DangKy.this.textField_taiKhoan.getText().equals("") && !DangKy.this.passwordField_matkhau.getText().equals("")) {	
                	if (xacminh.equals("W68HP")) {
                    	if(mk1.equals(mk2)) {
                    	NguoiDung nguoiDung = new NguoiDung();
                        nguoiDung.setTenDangNhap(textField_taiKhoan.getText());
                        nguoiDung.setMatKhau(passwordField_matkhau.getText());
                        ConnectJDBC_nguoiDung.themND(nguoiDung);
                        JOptionPane.showMessageDialog(btn_DangKy_1, "Đăng ký thành công, vui lòng đăng nhập!");
                        DangNhap DangNhap = new DangNhap();
                        DangNhap.setVisible(true);
                        DangKy.this.dispose();
                    	} else {
                    		JOptionPane.showMessageDialog(btn_DangKy_1, "Mật khẩu nhập lại không khớp!");
                    	}
                    }else {
                    	JOptionPane.showMessageDialog(btn_DangKy_1, "Nhập lại mã xác nhận!");
                    }
                }else {
                        JOptionPane.showMessageDialog(btn_DangKy_1, "Chưa nhập đủ thông tin đăng ký");
                    }
                } catch (Exception var11) {
                }

            }
        });
        
        JLabel image_xm = new JLabel("");
        image_xm.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QL1080View.class.getResource("xacminh1.png"))));
        image_xm.setBounds(271, 160, 149, 51);
        gradientPanel.add(image_xm);
        
        
                JButton btn_dangki = new JButton("Đăng nhập");
                btn_dangki.setBounds(353, 260, 119, 23);
                btn_dangki.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	DangNhap DangNhap = new DangNhap();
                        DangNhap.setVisible(true);
                        DangKy.this.dispose();
                    }
                });
                btn_dangki.setFont(new Font("Times New Roman", 0, 15));
                gradientPanel.add(btn_dangki);
        btn_DangKy_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        gradientPanel.add(btn_DangKy_1);
        
        JLabel remakhau = new JLabel("Nhập lại MK:");
        remakhau.setBounds(3, 133, 135, 24);
        remakhau.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        gradientPanel.add(remakhau);
        
        passwordField_nhaplai = new JPasswordField();
        passwordField_nhaplai.setBounds(141, 131, 290, 30);
        gradientPanel.add(passwordField_nhaplai);
        
        JLabel xacminh = new JLabel("Xác minh:");
        xacminh.setBounds(3, 171, 135, 24);
        xacminh.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        gradientPanel.add(xacminh);
        
        field_xacminh = new JTextField();
        field_xacminh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        field_xacminh.setColumns(10);
        field_xacminh.setBounds(141, 167, 110, 30);
        gradientPanel.add(field_xacminh);
        
        JLabel text1 = new JLabel("Đã có tài khoản ? Đăng nhập ngay!");
        text1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        text1.setBounds(10, 259, 300, 24);
        gradientPanel.add(text1);


    }
}
