package View1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import KetnoiSQL.ConnectJDBC;
import KetnoiSQL.ConnectJDBC_donSDDV;
import KetnoiSQL.ConnectJDBC_nguoiDung;
import Model.DonSDDV;
import Model.KhachHang;
import View1.DangNhap;
import java.awt.Panel;
import java.awt.Label;
import java.util.Locale;
import javax.swing.JTextPane;
import javax.swing.JToolBar;

public class QL1080View extends JFrame {

    private JPanel contentPane;
    private JTextField textField_maKhachHang;
    private static JTextField textField_hoVaTen_2;
    private static JTextField textField_loaiDichVu;
    private static JTextField textField_phiDichVu;
    private static JTextField textField_ngayHoaDon;
    private  JTable table_donSDDV;
    private static JTable table_KhachHang;
    private static JTextField textField_hoVaTen;
    private static JTextField textField_ngaySinh;
    private static JTextField textField_soCCCD;
    private static JTextField textField_diaChi;
    private static JTextField textField_soDT;
    private GradientPanel gradientPanel_nutNhan;
    private GradientPanel gradientPanel;
    private JComboBox comboBox;
    private JTable table;
    private JTextField textField_tong;
    private JTextField textField_tongKH;
    private JTextField textField_1;
    private JTextField textField_tongtien;
    private JTextField textField_tongNgay1;
    private JTextField textField_tongNgay2;



	/**
	 * Create the frame.
	 */

	public QL1080View() {
		URL url_icon_file = QL1080View.class.getResource("file.png");
        Image img = Toolkit.getDefaultToolkit().createImage(url_icon_file);
        this.setIconImage(img);
        this.setTitle("QUẢN LÍ DỊCH VỤ 1080");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 804, 566);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        gradientPanel_nutNhan = new GradientPanel(new Color(255,253,228),new Color(0,90,167) );
        gradientPanel_nutNhan.setColor1(new Color(255, 255, 128));
        gradientPanel_nutNhan.setColor2(new Color(0, 128, 255));
        gradientPanel_nutNhan.setBounds(0, -16, 195, 551);



        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setForeground(new Color(255, 0, 0));
        tabbedPane.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        tabbedPane.setToolTipText("");
        tabbedPane.setBounds(192, 0, 611, 535);
        contentPane.add(tabbedPane);

        JPanel panel_nhapThongTin = new JPanel();
        panel_nhapThongTin.setLayout(null);
        panel_nhapThongTin.setFont(new Font("Candara", Font.PLAIN, 15));
        panel_nhapThongTin.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel_nhapThongTin.setBackground(SystemColor.menu);
        tabbedPane.addTab("Thông tin Khách Hàng", null, panel_nhapThongTin, null);

        gradientPanel = new GradientPanel(new Color(238,238,244), new Color(238,238,244), 3);
        gradientPanel.setLayout(null);
        gradientPanel.setBounds(10, 0, 648, 515);
        panel_nhapThongTin.add(gradientPanel);

        JLabel lblHVTn = new JLabel("Họ và tên:");
        lblHVTn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblHVTn.setBounds(48, 64, 111, 24);
        gradientPanel.add(lblHVTn);

        JLabel lblNgySinh = new JLabel("Ngày sinh:");
        lblNgySinh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNgySinh.setBounds(48, 126, 111, 24);
        gradientPanel.add(lblNgySinh);

        JLabel lblSCccd = new JLabel("Số CCCD:");
        lblSCccd.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblSCccd.setBounds(48, 189, 111, 24);
        gradientPanel.add(lblSCccd);

        JLabel lblGiiTnh = new JLabel("Giới tính:");
        lblGiiTnh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblGiiTnh.setBounds(48, 247, 111, 24);
        gradientPanel.add(lblGiiTnh);

        JLabel lblaCh = new JLabel("Địa chỉ:");
        lblaCh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblaCh.setBounds(48, 308, 111, 24);
        gradientPanel.add(lblaCh);

        JLabel lblSinThoi = new JLabel("Số điện thoại:");
        lblSinThoi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblSinThoi.setBounds(48, 374, 111, 24);
        gradientPanel.add(lblSinThoi);

        textField_hoVaTen = new JTextField();
        textField_hoVaTen.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        textField_hoVaTen.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textField_hoVaTen.setColumns(10);
        textField_hoVaTen.setBounds(179, 62, 357, 30);
        gradientPanel.add(textField_hoVaTen);

        textField_ngaySinh = new JTextField();
        textField_ngaySinh.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        textField_ngaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textField_ngaySinh.setColumns(10);
        textField_ngaySinh.setBounds(179, 125, 357, 35);
        gradientPanel.add(textField_ngaySinh);

        textField_soCCCD = new JTextField();
        textField_soCCCD.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        textField_soCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textField_soCCCD.setColumns(10);
        textField_soCCCD.setBounds(179, 183, 357, 30);
        gradientPanel.add(textField_soCCCD);

        textField_diaChi = new JTextField();
        textField_diaChi.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        textField_diaChi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textField_diaChi.setColumns(10);
        textField_diaChi.setBounds(179, 308, 357, 30);
        gradientPanel.add(textField_diaChi);

        textField_soDT = new JTextField();
        textField_soDT.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        textField_soDT.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textField_soDT.setColumns(10);
        textField_soDT.setBounds(179, 373, 357, 29);
        gradientPanel.add(textField_soDT);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nam ", "Nữ"}));
        comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        comboBox.setBounds(179, 250, 111, 27);
        gradientPanel.add(comboBox);


        JButton btn_them = new JButton("Thêm");
        btn_them.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QL1080View.class.getResource("icon_join.png"))));
        btn_them.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                KhachHang khachHang = new KhachHang();
                khachHang.setHoVaTen(textField_hoVaTen.getText());
                khachHang.setNgaySinh(textField_ngaySinh.getText());
                khachHang.setSo_CCCD(textField_soCCCD.getText());
                khachHang.setGioiTinh(comboBox.getSelectedIndex());
                khachHang.setDiaChi(textField_diaChi.getText());
                khachHang.setSoDT((textField_soDT.getText()));

                ConnectJDBC.themKhachHang(khachHang);
                JOptionPane.showMessageDialog(btn_them, "Bạn đã thêm thành công");
                hienThiThongTin(ConnectJDBC.layTatCa());

                refesh_KhachHang();
            }
        });
        btn_them.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btn_them.setBounds(10, 443, 111, 35);
        gradientPanel.add(btn_them);

        JButton btn_capnhat = new JButton("Cập nhật");
        btn_capnhat.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QL1080View.class.getResource("icon_update.png"))));
        btn_capnhat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    KhachHang khachHang = new KhachHang();
                    khachHang.setHoVaTen(textField_hoVaTen.getText());
                    khachHang.setNgaySinh(textField_ngaySinh.getText());
                    khachHang.setSo_CCCD(textField_soCCCD.getText());
                    khachHang.setGioiTinh(comboBox.getSelectedIndex());
                    khachHang.setDiaChi(textField_diaChi.getText());
                    khachHang.setSoDT(textField_soDT.getText());

                    ConnectJDBC con = new ConnectJDBC();
                    con.capNhatKhachHang(khachHang);
                    JOptionPane.showMessageDialog(btn_capnhat, "Cập nhật thành công");
                    refesh_KhachHang();


                } catch (Throwable e2) {
                }
            }
        });
        btn_capnhat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btn_capnhat.setBounds(295, 443, 133, 35);
        gradientPanel.add(btn_capnhat);


        JButton btn_timKiem = new JButton("Tìm kiếm");
        btn_timKiem.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QL1080View.class.getResource("icon_search.png"))));
        btn_timKiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField_hoVaTen.getText().equals("")) {
                    JOptionPane.showMessageDialog(btn_timKiem, "Nhập họ và tên!");
                    textField_hoVaTen.setBackground(new Color(142,209,252));
                    return;
                }
                try {
                    ConnectJDBC con = new ConnectJDBC();
                    KhachHang khachHang = con.timTheoHoVaTen(textField_hoVaTen.getText());

                    if (khachHang != null) {
                        textField_hoVaTen.setText(khachHang.getHoVaTen());
                        textField_ngaySinh.setText(khachHang.getNgaySinh());
                        textField_soCCCD.setText(khachHang.getSo_CCCD());
                        comboBox.setSelectedIndex(khachHang.getGioiTinh());
                        textField_diaChi.setText(khachHang.getDiaChi());
                        textField_soDT.setText(khachHang.getSoDT());
                    }else {
                        JOptionPane.showMessageDialog(btn_timKiem, "Không tìm thấy!");
                    }

                } catch (Throwable e2) {
                    JOptionPane.showMessageDialog(btn_timKiem, "Lỗi");
                    e2.printStackTrace();
                }
            }
        });
        btn_timKiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btn_timKiem.setBounds(139, 443, 133, 35);
        gradientPanel.add(btn_timKiem);

        JButton btn_lamMoi = new JButton("Làm mới");
        btn_lamMoi.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QL1080View.class.getResource("icom_refesh.png"))));
        btn_lamMoi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refesh_KhachHang();
            }
        });
        btn_lamMoi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btn_lamMoi.setBounds(449, 443, 121, 35);
        gradientPanel.add(btn_lamMoi);
                  
                          JLabel Nhapthongtin = new JLabel("Nhập thông tin Khách hàng");
                          Nhapthongtin.setBounds(139, 10, 330, 30);
                          gradientPanel.add(Nhapthongtin);
                          Nhapthongtin.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 25));

        JPanel panel_danhSachKhachHang = new JPanel();
        tabbedPane.addTab("Danh sách Khách Hàng", null, panel_danhSachKhachHang, null);
        panel_danhSachKhachHang.setLayout(null);

        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(10, 50, 563, 402);
        panel_danhSachKhachHang.add(scrollPane_2);

        table_KhachHang = new JTable();
        table_KhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        table_KhachHang.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, "", "", "", "", ""},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                },
                new String[] {
                        "Mã khách hàng", "Họ và tên", "Ngày sinh", "Số CCCD", " Giới tính", "địa chỉ", "Số điện thoại"
                }
        ));
        table_KhachHang.getColumnModel().getColumn(0).setPreferredWidth(53);
        table_KhachHang.getColumnModel().getColumn(1).setPreferredWidth(107);
        table_KhachHang.getColumnModel().getColumn(4).setPreferredWidth(53);
        scrollPane_2.setViewportView(table_KhachHang);

        JButton btn_xoa = new JButton("Xóa");
        btn_xoa.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QL1080View.class.getResource("icon_delete.png"))));
        btn_xoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String luaChon = JOptionPane.showInputDialog("Nhập họ và tên: ");
                KhachHang khachHang = new KhachHang();
                ConnectJDBC.xoaKhachHang(luaChon);
                hienThiThongTin(ConnectJDBC.layTatCa());

            }
        });
        btn_xoa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btn_xoa.setBounds(131, 459, 100, 33);
        panel_danhSachKhachHang.add(btn_xoa);

        JButton btn_tim = new JButton("Tìm");
        btn_tim.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QL1080View.class.getResource("icon_find_2.png"))));
        btn_tim.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String luaChon = JOptionPane.showInputDialog("Nhập họ và tên (hoặc Mã Khách Hàng): ");
                KhachHang khachHang = new KhachHang();
                hienThiThongTin(ConnectJDBC.timKhachHang(luaChon));

            }
        });
        btn_tim.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btn_tim.setBounds(390, 459, 100, 33);
        panel_danhSachKhachHang.add(btn_tim);
        
        JLabel Danhsach = new JLabel("Danh sách Khách hàng");
        Danhsach.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 25));
        Danhsach.setBounds(160, 10, 330, 30);
        panel_danhSachKhachHang.add(Danhsach);
        hienThiThongTin(ConnectJDBC.layTatCa());

        JPanel panel_donSDDV = new JPanel();
        tabbedPane.addTab("Đơn sử dụng dịch vụ", null, panel_donSDDV, null);
        panel_donSDDV.setLayout(null);
        panel_donSDDV.setBackground(new Color(238, 238, 244));

        JLabel lbl_hoVaTen_2 = new JLabel("Họ và tên:");
        lbl_hoVaTen_2.setBounds(10, 51, 111, 24);
        lbl_hoVaTen_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        panel_donSDDV.add(lbl_hoVaTen_2);

        JLabel lbl_loaiDichVu = new JLabel("Loại dịch vụ:");
        lbl_loaiDichVu.setBounds(10, 98, 111, 24);
        lbl_loaiDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        panel_donSDDV.add(lbl_loaiDichVu);

        JLabel lbl_phiDichVu = new JLabel("Phí dịch vụ:");
        lbl_phiDichVu.setBounds(10, 147, 111, 24);
        lbl_phiDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        panel_donSDDV.add(lbl_phiDichVu);

        JLabel lbl_ngayHoaDon = new JLabel("Ngày hoá đơn:");
        lbl_ngayHoaDon.setBounds(10, 199, 111, 24);
        lbl_ngayHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        panel_donSDDV.add(lbl_ngayHoaDon);

        textField_hoVaTen_2 = new JTextField();
        textField_hoVaTen_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        textField_hoVaTen_2.setBounds(108, 51, 333, 24);
        textField_hoVaTen_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textField_hoVaTen_2.setColumns(10);
        panel_donSDDV.add(textField_hoVaTen_2);

        textField_loaiDichVu = new JTextField();
        textField_loaiDichVu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        textField_loaiDichVu.setBounds(108, 98, 333, 24);
        textField_loaiDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textField_loaiDichVu.setColumns(10);
        panel_donSDDV.add(textField_loaiDichVu);

        textField_phiDichVu = new JTextField();
        textField_phiDichVu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        textField_phiDichVu.setBounds(108, 147, 333, 24);
        textField_phiDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textField_phiDichVu.setColumns(10);
        panel_donSDDV.add(textField_phiDichVu);

        textField_ngayHoaDon = new JTextField();
        textField_ngayHoaDon.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        textField_ngayHoaDon.setBounds(108, 199, 333, 24);
        textField_ngayHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textField_ngayHoaDon.setColumns(10);
        panel_donSDDV.add(textField_ngayHoaDon);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(34, 237, 549, 217);
        panel_donSDDV.add(scrollPane_1);

        table_donSDDV = new JTable();
        table_donSDDV.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        table_donSDDV.setModel(new DefaultTableModel(
                new Object[][] {{null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                },
                new String[] {"Mã đơn SDDV ", "Họ và tên", "Loại dịch vụ", " Phí dịch vụ", "Ngày hoá đơn"}
        ));
        table_donSDDV.getColumnModel().getColumn(0).setPreferredWidth(60);
        table_donSDDV.getColumnModel().getColumn(1).setPreferredWidth(135);
        table_donSDDV.getColumnModel().getColumn(2).setPreferredWidth(108);
        table_donSDDV.getColumnModel().getColumn(3).setPreferredWidth(58);
        table_donSDDV.getColumnModel().getColumn(4).setPreferredWidth(107);
        scrollPane_1.setViewportView(table_donSDDV);

        JButton btn_them_DonSDDV = new JButton("Thêm");
        btn_them_DonSDDV.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QL1080View.class.getResource("icon_add.png"))));
        btn_them_DonSDDV.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                DonSDDV donSDDV = new DonSDDV();
                donSDDV.setHoVaTen(textField_hoVaTen_2.getText());
                donSDDV.setLoaiDV(textField_loaiDichVu.getText());
                donSDDV.setPhiDV(textField_phiDichVu.getText());
                donSDDV.setNgayHD(textField_ngayHoaDon.getText());

                JOptionPane.showMessageDialog(btn_them_DonSDDV, "Thêm thành công!");
                ConnectJDBC_donSDDV.themSDDV(donSDDV);
                hienthi_DonSDDV(ConnectJDBC_donSDDV.laydonSDDV());

                refesh_donSDDV();

            }
        });
        btn_them_DonSDDV.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        btn_them_DonSDDV.setBounds(472, 58, 111, 33);
        panel_donSDDV.add(btn_them_DonSDDV);

        JButton btn_xoa_DonSDDV = new JButton("Xóa");
        btn_xoa_DonSDDV.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QL1080View.class.getResource("icon_delete.png"))));
        btn_xoa_DonSDDV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String luaChon = JOptionPane.showInputDialog("Nhập họ và tên (hoặc Mã khách hàng: ");
                ConnectJDBC_donSDDV.xoaDonDDV(luaChon);
                hienthi_DonSDDV(ConnectJDBC_donSDDV.laydonSDDV());
            }
        });
        btn_xoa_DonSDDV.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        btn_xoa_DonSDDV.setBounds(472, 118, 111, 33);
        panel_donSDDV.add(btn_xoa_DonSDDV);

        JButton btn_capnhat_DonSDDV = new JButton("Cập nhật");
        btn_capnhat_DonSDDV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    DonSDDV donSDDV = new DonSDDV();
                    donSDDV.setHoVaTen(textField_hoVaTen_2.getText());
                    donSDDV.setLoaiDV(textField_loaiDichVu.getText());
                    donSDDV.setPhiDV(textField_phiDichVu.getText());
                    donSDDV.setNgayHD(textField_ngayHoaDon.getText());

                    ConnectJDBC_donSDDV con = new ConnectJDBC_donSDDV();
                    con.capNhatDonSDDV(donSDDV);
                    JOptionPane.showMessageDialog(btn_capnhat_DonSDDV, "Cập nhật thành công");

                    refesh_donSDDV();
                    hienthi_DonSDDV(ConnectJDBC_donSDDV.laydonSDDV());

                } catch (Throwable e2) {
                    // TODO: handle exception
                }
            }
        });
        btn_capnhat_DonSDDV.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QL1080View.class.getResource("icon_update2.png"))));
        btn_capnhat_DonSDDV.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        btn_capnhat_DonSDDV.setBounds(472, 173, 111, 33);
        panel_donSDDV.add(btn_capnhat_DonSDDV);

        JButton btn_tim_donSDDV = new JButton("Tìm");
        btn_tim_donSDDV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField_hoVaTen_2.getText().equals("")) {
                    JOptionPane.showMessageDialog(btn_tim_donSDDV, "Nhập họ và tên!");
                    textField_hoVaTen_2.setBackground(new Color(142,209,252));
                    return;
                }
                try {
                    ConnectJDBC_donSDDV con = new ConnectJDBC_donSDDV();
                    DonSDDV donSDDV = con.timTheoHoVaTen(textField_hoVaTen_2.getText());

                    if (donSDDV != null) {
                        textField_hoVaTen_2.setText(donSDDV.getHoVaTen());
                        textField_loaiDichVu.setText(donSDDV.getLoaiDV());
                        textField_phiDichVu.setText(donSDDV.getPhiDV());
                        textField_ngayHoaDon.setText(donSDDV.getNgayHD());
                    }else {
                        JOptionPane.showMessageDialog(btn_tim_donSDDV, "Không tìm thấy!");
                    }

                } catch (Throwable e2) {
                    JOptionPane.showMessageDialog(btn_timKiem, "Lỗi");
                    e2.printStackTrace();
                }
                hienthi_DonSDDV(ConnectJDBC_donSDDV.timDonSDDV(textField_hoVaTen_2.getText()));

            }
        });
        btn_tim_donSDDV.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QL1080View.class.getResource("icon_find_2.png"))));
        btn_tim_donSDDV.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btn_tim_donSDDV.setBounds(137, 465, 100, 33);
        panel_donSDDV.add(btn_tim_donSDDV);

        JButton btn_refesh_DonSDDV = new JButton("Làm mới");
        btn_refesh_DonSDDV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refesh_donSDDV();
                hienthi_DonSDDV(ConnectJDBC_donSDDV.laydonSDDV());
            }
        });
        btn_refesh_DonSDDV.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QL1080View.class.getResource("icom_refesh.png"))));
        btn_refesh_DonSDDV.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btn_refesh_DonSDDV.setBounds(369, 465, 121, 35);
        panel_donSDDV.add(btn_refesh_DonSDDV);
        
        JLabel donsudung = new JLabel("Đơn sử dụng Dịch vụ");
        donsudung.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 25));
        donsudung.setBounds(160, 10, 330, 30);
        panel_donSDDV.add(donsudung);
        
        JPanel panel_thongKe = new JPanel();
        tabbedPane.addTab("Thống kê", null, panel_thongKe, null);
        panel_thongKe.setLayout(null);
                
        JScrollPane scrollPane_1_1 = new JScrollPane();
        scrollPane_1_1.setBounds(0, 47, 596, 274);
        panel_thongKe.add(scrollPane_1_1);
                        
        table = new JTable();
        scrollPane_1_1.setColumnHeaderView(table);
        table.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        table.setModel(new DefaultTableModel(
                new Object[][] {
           {null, null, null, null, null},
           {null, null, null, null, null},
           {null, null, null, null, null},
           {null, null, null, null, null},
           {null, null, null, null, null},
           {null, null, null, null, null},
           {null, null, null, null, null},
           {null, null, null, null, null},
           {null, null, null, null, null},
           {null, null, null, null, null},
           {null, null, null, null, null},
           {null, null, null, null, null},
           {null, null, null, null, null},
           {null, null, null, null, null},
           {null, null, null, null, null},
                                        },
             new String[] {
           "Mã hoá đơn SDDV ", "Họ và tên", "Loại dịch vụ", " Phí dịch vụ", "Ngày hoá đơn"
                                        }
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(60);
        table.getColumnModel().getColumn(1).setPreferredWidth(135);
        table.getColumnModel().getColumn(2).setPreferredWidth(108);
        table.getColumnModel().getColumn(3).setPreferredWidth(58);
        table.getColumnModel().getColumn(4).setPreferredWidth(107);
        scrollPane_1_1.setViewportView(table);
                                
        JButton btn_theoNgay = new JButton("Theo ngày");
        btn_theoNgay.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btn_theoNgay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DonSDDV donSDDV = new DonSDDV();
                String ngay = JOptionPane.showInputDialog(btn_theoNgay,"Nhập ngày");
                textField_tongNgay1.setText(String.valueOf(ConnectJDBC_donSDDV.tongDonSDDV_ngay(ngay)));
                textField_tongNgay2.setText(String.valueOf(ConnectJDBC_donSDDV.tongTien_ngay(ngay)));
            }
        });
        btn_theoNgay.setBounds(403, 348, 106, 27);
        panel_thongKe.add(btn_theoNgay);
                                        
        JButton btn_tong = new JButton("Tổng");
        btn_tong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btn_tong.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DonSDDV donSDDV = new DonSDDV();
                textField_tong.setText(String.valueOf(ConnectJDBC_donSDDV.tongDonSDDV(donSDDV)));
                KhachHang khachhang = new KhachHang();
                textField_tongKH.setText(String.valueOf(ConnectJDBC.tongKhachHang(khachhang)));
                DonSDDV donSDDV1 = new DonSDDV();
                textField_tongtien.setText(String.valueOf(ConnectJDBC_donSDDV.tongTien(donSDDV1)));
            }
        });
        btn_tong.setBounds(228, 348, 106, 26);
        panel_thongKe.add(btn_tong);
                                                
        JLabel lbl_tongDSDDV = new JLabel("Tổng số đơn :");
        lbl_tongDSDDV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbl_tongDSDDV.setBounds(74, 398, 144, 27);
        panel_thongKe.add(lbl_tongDSDDV);
                                                        
        JLabel lbl_tongKH = new JLabel("Tổng số Khách hàng :");
        lbl_tongKH.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbl_tongKH.setBounds(74, 472, 169, 27);
        panel_thongKe.add(lbl_tongKH);
                                                                
        JLabel lbl_tongtien = new JLabel("Tổng số tiền phí:");
        lbl_tongtien.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbl_tongtien.setBounds(74, 435, 133, 27);
        panel_thongKe.add(lbl_tongtien);
                                                                        
        textField_tong =  new JTextField();
        textField_tong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textField_tong.setBounds(228, 399, 106, 23);
        panel_thongKe.add(textField_tong);
        textField_tong.setColumns(10);
                                                                                
        textField_tongKH =  new JTextField();
        textField_tongKH.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textField_tongKH.setBounds(228, 473, 106, 23);
        panel_thongKe.add(textField_tongKH);
        textField_tongKH.setColumns(10);
                                                                                        
        textField_tongtien =  new JTextField();
        textField_tongtien.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textField_tongtien.setBounds(228, 436, 106, 23);
        panel_thongKe.add(textField_tongtien);
        textField_tongtien.setColumns(10);
                                                                                                
        textField_tongNgay1 = new JTextField();
        textField_tongNgay1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textField_tongNgay1.setColumns(10);
        textField_tongNgay1.setBounds(403, 399, 106, 23);
        panel_thongKe.add(textField_tongNgay1);
                                                                                                
        textField_tongNgay2 = new JTextField();
        textField_tongNgay2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textField_tongNgay2.setColumns(10);
        textField_tongNgay2.setBounds(403, 436, 106, 23);
        panel_thongKe.add(textField_tongNgay2);
                                                                                                
        JLabel thongke = new JLabel("Thống kê");
        thongke.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 25));
        thongke.setBounds(226, 10, 330, 30);
        panel_thongKe.add(thongke);
                                                                                                
        JPanel thongTin = new JPanel();
        tabbedPane.addTab("Trợ giúp", null, thongTin, null);
        thongTin.setLayout(null);
                                                                                                
        JLabel troGiup = new JLabel("Trợ giúp");
        troGiup.setBounds(249, 5, 131, 30);
        troGiup.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 25));
        thongTin.add(troGiup);
                                                                                                
        JLabel text1 = new JLabel("Mọi góp ý về lỗi phát sinh vui lòng liên hệ qua :");
        text1.setBounds(20, 77, 469, 30);
        text1.setFont(new Font("Cambria", Font.PLAIN| Font.ITALIC, 20));
        thongTin.add(text1);
                                                                                                
        JLabel lblEmailTuanpqitevkuudn = new JLabel("Email: tuanpq.22ite@vku.udn.vn");
        lblEmailTuanpqitevkuudn.setBounds(53, 117, 469, 30);
        lblEmailTuanpqitevkuudn.setFont(new Font("Cambria", Font.ITALIC, 20));
        thongTin.add(lblEmailTuanpqitevkuudn);
                                                                                                
        JLabel lblFacebookHttpsfacebookcomniipham = new JLabel("Facebook: https://facebook.com/nii.pham.282");
        lblFacebookHttpsfacebookcomniipham.setBounds(53, 157, 469, 30);
        lblFacebookHttpsfacebookcomniipham.setFont(new Font("Cambria", Font.ITALIC, 20));
        thongTin.add(lblFacebookHttpsfacebookcomniipham);
                                                                                                
        JLabel lblMiGp = new JLabel("Mỗi góp ý của bạn là một đóng góp lớn trong việc");
        lblMiGp.setBounds(20, 216, 469, 30);
        lblMiGp.setFont(new Font("Cambria", Font.ITALIC, 20));
        thongTin.add(lblMiGp);
        
        JLabel lblCiThinPhn = new JLabel("cải thiện phần mềm.");
        lblCiThinPhn.setBounds(20, 246, 469, 30);
        lblCiThinPhn.setFont(new Font("Cambria", Font.ITALIC, 20));
        thongTin.add(lblCiThinPhn);
        
        JLabel lblCmn = new JLabel("Cảm ơn đã tin dùng !");
        lblCmn.setBounds(20, 286, 469, 30);
        lblCmn.setFont(new Font("Cambria", Font.ITALIC, 20));
        thongTin.add(lblCmn);
        
        JLabel lblIconarchivecom = new JLabel("© 2023 QL1080 ©");
        lblIconarchivecom.setBounds(206, 469, 469, 30);
        lblIconarchivecom.setFont(new Font("Cambria", Font.ITALIC, 20));
        thongTin.add(lblIconarchivecom);
                                                                                                
        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setBounds(227, 384, 45, 13);
        thongTin.add(lblNewLabel_5);
                                                                                                
        JLabel lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QL1080View.class.getResource("icon_vipro.png"))));
        lblNewLabel_6.setBounds(227, 361, 224, 119);
        thongTin.add(lblNewLabel_6);


        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 195, 535);
        this.setLocationRelativeTo(panel_1);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        panel_1.add(gradientPanel_nutNhan);

        JButton btnDanhSch = new JButton("Danh sách ");
        btnDanhSch.setBounds(0, 245, 157, 51);
        btnDanhSch.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QL1080View.class.getResource("icon_list.png"))));
        btnDanhSch.setForeground(new Color(0, 0, 0));
        btnDanhSch.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
        btnDanhSch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedIndex(1);
                hienThiThongTin(ConnectJDBC.layTatCa());
            }
        });
        gradientPanel_nutNhan.setLayout(null);
        btnDanhSch.setContentAreaFilled(false);
        btnDanhSch.setBorderPainted(false);
        gradientPanel_nutNhan.add(btnDanhSch);

        JButton btnHon = new JButton("Hoá đơn");
        btnHon.setBounds(-10, 300, 158, 41);
        btnHon.setForeground(new Color(0, 0, 0));
        btnHon.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QL1080View.class.getResource("icon_list2.png"))));
        btnHon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedIndex(2);
                hienthi_DonSDDV(ConnectJDBC_donSDDV.laydonSDDV());
            }
        });
        btnHon.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
        btnHon.setContentAreaFilled(false);
        btnHon.setBorderPainted(false);
        gradientPanel_nutNhan.add(btnHon);

        JButton button_thongKe = new JButton("Thống kê");
        button_thongKe.setBounds(-25, 345, 192, 51);
        button_thongKe.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QL1080View.class.getResource("icon_statistics.png"))));
        button_thongKe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedIndex(3);
                hienthi_DonSDDV_Thongke(ConnectJDBC_donSDDV.laydonSDDV());
            }
        });
        button_thongKe.setForeground(Color.BLACK);
        button_thongKe.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
        button_thongKe.setContentAreaFilled(false);
        button_thongKe.setBorderPainted(false);
        gradientPanel_nutNhan.add(button_thongKe);
        
        
        
          JButton btn_nhapThongTin = new JButton("Nhập thông tin");
          btn_nhapThongTin.setBounds(-1, 203, 185, 41);
          gradientPanel_nutNhan.add(btn_nhapThongTin);
          
                  btn_nhapThongTin.setForeground(new Color(0, 0, 0));
                  btn_nhapThongTin.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QL1080View.class.getResource("icon_hand.png"))));
                  btn_nhapThongTin.addActionListener(new ActionListener() {
                      public void actionPerformed(ActionEvent e) {
                          tabbedPane.setSelectedIndex(0);

                      }
                  });
                  btn_nhapThongTin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
                  btn_nhapThongTin.setContentAreaFilled(false);
                  btn_nhapThongTin.setBorderPainted(false);
                  
                  JLabel line_2 = new JLabel("");
                  line_2.setBounds(0, 160, 232, 51);
                  line_2.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QL1080View.class.getResource("line_1.png"))));
                  line_2.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
                  gradientPanel_nutNhan.add(line_2);
                  
                  JButton btnTrGip = new JButton("Trợ giúp");
                  btnTrGip.setBounds(-40, 422, 224, 51);
                  btnTrGip.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QL1080View.class.getResource("icon_infor1.png"))));
                  btnTrGip.addActionListener(new ActionListener() {
                  	public void actionPerformed(ActionEvent e) {
                  		tabbedPane.setSelectedIndex(4);
                  	}
                  });
                  
                  JToolBar toolBar = new JToolBar();
                  toolBar.setBounds(0, 0, 83, 15);
                  gradientPanel_nutNhan.add(toolBar);
                  btnTrGip.setForeground(Color.BLACK);
                  btnTrGip.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
                  btnTrGip.setContentAreaFilled(false);
                  btnTrGip.setBorderPainted(false);
                  gradientPanel_nutNhan.add(btnTrGip);
                  
                  JButton button_dangXuat = new JButton("Đăng xuất");
                  button_dangXuat.setBounds(-18, 479, 192, 51);
                  button_dangXuat.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QL1080View.class.getResource("icon_out1.png"))));
                  button_dangXuat.addActionListener(new ActionListener() {
                  	public void actionPerformed(ActionEvent e) {
                        ConnectJDBC_nguoiDung.xoaUser();
                  		DangNhap DangNhap1 = new DangNhap();
                        DangNhap1.setVisible(true);
                        QL1080View.this.dispose();
                  	}
                  });
                  button_dangXuat.setForeground(Color.BLACK);
                  button_dangXuat.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
                  button_dangXuat.setContentAreaFilled(false);
                  button_dangXuat.setBorderPainted(false);
                  gradientPanel_nutNhan.add(button_dangXuat);
                  
                  JLabel quanLidichvu = new JLabel("");
                  quanLidichvu.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QL1080View.class.getResource("icon_vipro.png"))));
                  quanLidichvu.setBounds(41, 78, 121, 103);
                  gradientPanel_nutNhan.add(quanLidichvu);
                  quanLidichvu.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 28));
                  
                  JLabel line_1 = new JLabel("");
                  line_1.setBounds(-140, 386, 379, 39);
                  gradientPanel_nutNhan.add(line_1);
                  line_1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QL1080View.class.getResource("line_1.png"))));
                  line_1.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
                  
                  JLabel line_1_1 = new JLabel("");
                  line_1_1.setBounds(0, 386, 379, 39);
                  line_1_1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QL1080View.class.getResource("line_1.png"))));
                  line_1_1.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
                  gradientPanel_nutNhan.add(line_1_1);
                  
                  JLabel line_2_1 = new JLabel("");
                  line_2_1.setBounds(-140, 160, 340, 51);
                  line_2_1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QL1080View.class.getResource("line_1.png"))));
                  line_2_1.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
                  gradientPanel_nutNhan.add(line_2_1);
                  
                  JLabel lblNewLabel = new JLabel();
                  lblNewLabel.setBounds(124, 23, 71, 26);
                  lblNewLabel.setText(ConnectJDBC_nguoiDung.layUser());
                  lblNewLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 16));
                  gradientPanel_nutNhan.add(lblNewLabel);
                  
                  JLabel lblNewLabel_1 = new JLabel("Chào mừng ");
                  lblNewLabel_1.setBounds(36, 21, 203, 30);
                  lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 16));
                  gradientPanel_nutNhan.add(lblNewLabel_1);
                  
                  JLabel lblNewLabel_2 = new JLabel("");
                  lblNewLabel_2.setBounds(0, 25, 59, 36);
                  lblNewLabel_2.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QL1080View.class.getResource("icon_1080.png"))));
                  gradientPanel_nutNhan.add(lblNewLabel_2);
                 
                  JLabel lblNewLabel_3 = new JLabel("quay trở lại !");
                  lblNewLabel_3.setBounds(36, 38, 103, 30);
                  lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 16));
                  gradientPanel_nutNhan.add(lblNewLabel_3);
                  
                  JLabel lblNewLabel_4 = new JLabel("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                  lblNewLabel_4.setBounds(30, 72, 204, 13);
                  gradientPanel_nutNhan.add(lblNewLabel_4);
    }
    // Khách Hàng
    public void hienThiThongTin(List<KhachHang> khachHang) {
        List<KhachHang> list_khachHang = new ArrayList<>();
        list_khachHang = khachHang;

        DefaultTableModel tableModel;
        table_KhachHang.getModel();
        tableModel = (DefaultTableModel) table_KhachHang.getModel();
        tableModel.setRowCount(0);
        list_khachHang.forEach((KhachHang) -> {
            String gioiTinh = "";
            if (KhachHang.getGioiTinh() == 0) {
                gioiTinh = "Nam";
            }else if (KhachHang.getGioiTinh() == 1) {
                gioiTinh = "Nữ";
            }
            tableModel.addRow(new Object[] {
                    KhachHang.getMaKhachHang(),
                    KhachHang.getHoVaTen(),
                    KhachHang.getNgaySinh(),
                    KhachHang.getSo_CCCD(),
                    gioiTinh,
                    KhachHang.getDiaChi(),
                    KhachHang.getSoDT()
            });
        });
    }
    public static void refesh_KhachHang() {
        textField_hoVaTen.setText("");
        textField_ngaySinh.setText("");
        textField_soCCCD.setText("");
        textField_diaChi.setText("");
        textField_soDT.setText("");
    }
    // Đơn Sử dụng dịch vụ
    public void hienthi_DonSDDV(List<DonSDDV> donSDDV) {
        List<DonSDDV> list_donSDDV = new ArrayList<>();
        list_donSDDV = donSDDV;

        DefaultTableModel tableModel_donSDDV;
        table_donSDDV.getModel();
        tableModel_donSDDV = (DefaultTableModel) table_donSDDV.getModel();
        tableModel_donSDDV.setRowCount(0);
        list_donSDDV.forEach((donSDDV2) -> {
            tableModel_donSDDV.addRow(new Object[] {
                    donSDDV2.getMaDonSDDV(),
                    donSDDV2.getHoVaTen(),
                    donSDDV2.getLoaiDV(),
                    donSDDV2.getPhiDV(),
                    donSDDV2.getNgayHD()
            });
        });
    }
    public static void refesh_donSDDV() {
        textField_hoVaTen_2.setText("");
        textField_loaiDichVu.setText("");
        textField_phiDichVu.setText("");
        textField_ngayHoaDon.setText("");
    }
    public void hienthi_DonSDDV_Thongke(List<DonSDDV> donSDDV) {
        List<DonSDDV> list_donSDDV = new ArrayList<>();
        list_donSDDV = donSDDV;

        DefaultTableModel tableModel_donSDDV;
        table.getModel();
        tableModel_donSDDV = (DefaultTableModel) table.getModel();
        tableModel_donSDDV.setRowCount(0);
        list_donSDDV.forEach((donSDDV1) -> {
            tableModel_donSDDV.addRow(new Object[] {
                    donSDDV1.getMaDonSDDV(),
                    donSDDV1.getHoVaTen(),
                    donSDDV1.getLoaiDV(),
                    donSDDV1.getPhiDV(),
                    donSDDV1.getNgayHD()
            });
        });
    }
}

