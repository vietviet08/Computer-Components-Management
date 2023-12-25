package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import color.SetColor;
import font.SetFont;

public class MainForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Font font;
	public Font font_1;
	public Font font1;
	public Font font2;
	public static JPanel maincontent;
	private JTextField textField;
	private JButton btnNhaCungCap;
	private JButton btnNhapHang;
	private JButton btnPhieuNhap;
	private JButton btnXuatHang;
	private JButton btnPhieuXuat;
	private JButton btnThongKe;
	private JButton btnCpu;
	private JButton btnBnPhm;
	private JButton btnChut;
	private JButton btnMnHnh;
	private JButton btnRam;
	private JButton btnVga;
	private JButton btnMainboard;
	private JButton btnNgun;
	private static JButton btnAllProduct;
	private JButton btnCase;
	private JButton btnTaiNghe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatLightLaf());
//					UIManager.put("Table.showVerticalLines", true);
//					UIManager.put("Table.showHorizontalLines", true);
					MainForm frame = new MainForm();
//					setDateToLable();
					frame.setResizable(false);
					ProductForm pf = new ProductForm();
					maincontent.add(pf).setVisible(true);
					MainForm.btnAllProduct.setForeground(new Color(130, 224, 170));
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public MainForm() {
		Color whiteFont = new Color(254, 254, 254);

		Color green = new Color(130, 224, 170);
//		Color redB = new Color(220, 19, 46);
		Color blue = new Color(64, 143, 221);
		Color blueOp = new Color(98, 181, 244);
//		Color orange = new Color(230, 126, 34);
//
//		Color clickButton = new Color(211, 84, 0);
//		Color defaultColor = new Color(230, 126, 24);

		try {
			File fontStyle = new File("src/font/Roboto-Medium.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(11f);
			font_1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(14f);
			font1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(16f);
			font2 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(22f);

		} catch (Exception e) {
			System.out.println(e);
		}

		this.setTitle("Quản lý linh kiện máy tính");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1408, 802);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel navbar = new JPanel();
		navbar.setBorder(null);
		navbar.setBackground(blue);
		navbar.setForeground(whiteFont);
		navbar.setFont(font_1);
		navbar.setBounds(179, 0, 658, 37);
		contentPane.add(navbar);
		navbar.setLayout(null);

		btnAllProduct = new JButton("Tất cả sản phẩm");
		btnAllProduct.setForeground(whiteFont);
		btnAllProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
				ProductForm pf = new ProductForm();
				maincontent.add(pf).setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnAllProduct.setForeground(green);
				btnCpu.setForeground(whiteFont);
				btnRam.setForeground(whiteFont);
				btnVga.setForeground(whiteFont);
				btnMainboard.setForeground(whiteFont);
				btnCase.setForeground(whiteFont);
				btnNgun.setForeground(whiteFont);
				btnMnHnh.setForeground(whiteFont);
				btnChut.setForeground(whiteFont);
				btnBnPhm.setForeground(whiteFont);
				btnTaiNghe.setForeground(whiteFont);
			}
		});
		btnAllProduct.setBackground(blue);
		btnAllProduct.setFont(font);
		btnAllProduct.setBounds(10, 11, 92, 15);
		navbar.add(btnAllProduct);
		btnAllProduct.setBorder(null);

		btnCpu = new JButton("CPU");
		btnCpu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
				CPUForm cf = new CPUForm();
				maincontent.add(cf).setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnAllProduct.setForeground(whiteFont);
				btnCpu.setForeground(green);
				btnRam.setForeground(whiteFont);
				btnVga.setForeground(whiteFont);
				btnMainboard.setForeground(whiteFont);
				btnCase.setForeground(whiteFont);
				btnNgun.setForeground(whiteFont);
				btnMnHnh.setForeground(whiteFont);
				btnChut.setForeground(whiteFont);
				btnBnPhm.setForeground(whiteFont);
				btnTaiNghe.setForeground(whiteFont);
			}
		});
		btnCpu.setBackground(blue);
		btnCpu.setFont(font);
		btnCpu.setForeground(whiteFont);
		btnCpu.setBorder(null);
		btnCpu.setBounds(99, 7, 49, 22);
		navbar.add(btnCpu);

		btnRam = new JButton("RAM");
		btnRam.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
				RAMForm rf = new RAMForm();
				maincontent.add(rf).setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnAllProduct.setForeground(whiteFont);
				btnCpu.setForeground(whiteFont);
				btnRam.setForeground(green);
				btnVga.setForeground(whiteFont);
				btnMainboard.setForeground(whiteFont);
				btnCase.setForeground(whiteFont);
				btnNgun.setForeground(whiteFont);
				btnMnHnh.setForeground(whiteFont);
				btnChut.setForeground(whiteFont);
				btnBnPhm.setForeground(whiteFont);
				btnTaiNghe.setForeground(whiteFont);
			}
		});
		btnRam.setBackground(blue);
		btnRam.setForeground(whiteFont);
		btnRam.setFont(font);
		btnRam.setBorder(null);
		btnRam.setBounds(146, 7, 49, 22);
		navbar.add(btnRam);

		btnVga = new JButton("VGA");
		btnVga.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
				VGAForm vf = new VGAForm();
				maincontent.add(vf).setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnAllProduct.setForeground(whiteFont);
				btnCpu.setForeground(whiteFont);
				btnRam.setForeground(whiteFont);
				btnVga.setForeground(green);
				btnMainboard.setForeground(whiteFont);
				btnCase.setForeground(whiteFont);
				btnNgun.setForeground(whiteFont);
				btnMnHnh.setForeground(whiteFont);
				btnChut.setForeground(whiteFont);
				btnBnPhm.setForeground(whiteFont);
				btnTaiNghe.setForeground(whiteFont);
			}
		});
		btnVga.setBackground(blue);
		btnVga.setForeground(whiteFont);
		btnVga.setFont(font);
		btnVga.setBorder(null);
		btnVga.setBounds(194, 7, 49, 22);
		navbar.add(btnVga);

		btnMainboard = new JButton("Main Board");
		btnMainboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnAllProduct.setForeground(whiteFont);
				btnCpu.setForeground(whiteFont);
				btnRam.setForeground(whiteFont);
				btnVga.setForeground(whiteFont);
				btnMainboard.setForeground(green);
				btnCase.setForeground(whiteFont);
				btnNgun.setForeground(whiteFont);
				btnMnHnh.setForeground(whiteFont);
				btnChut.setForeground(whiteFont);
				btnBnPhm.setForeground(whiteFont);
				btnTaiNghe.setForeground(whiteFont);
			}
		});
		btnMainboard.setBackground(blue);
		btnMainboard.setForeground(whiteFont);
		btnMainboard.setFont(font);
		btnMainboard.setBorder(null);
		btnMainboard.setBounds(242, 7, 64, 22);
		navbar.add(btnMainboard);

		btnNgun = new JButton("Nguồn");
		btnNgun.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnAllProduct.setForeground(whiteFont);
				btnCpu.setForeground(whiteFont);
				btnRam.setForeground(whiteFont);
				btnVga.setForeground(whiteFont);
				btnMainboard.setForeground(whiteFont);
				btnCase.setForeground(whiteFont);
				btnNgun.setForeground(green);
				btnMnHnh.setForeground(whiteFont);
				btnChut.setForeground(whiteFont);
				btnBnPhm.setForeground(whiteFont);
				btnTaiNghe.setForeground(whiteFont);
			}
		});
		btnNgun.setForeground(whiteFont);
		btnNgun.setFont(font);
		btnNgun.setBackground(blue);
		btnNgun.setBorder(null);
		btnNgun.setBounds(356, 7, 49, 22);
		navbar.add(btnNgun);

		btnMnHnh = new JButton("Màn hình");
		btnMnHnh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnAllProduct.setForeground(whiteFont);
				btnCpu.setForeground(whiteFont);
				btnRam.setForeground(whiteFont);
				btnVga.setForeground(whiteFont);
				btnMainboard.setForeground(whiteFont);
				btnCase.setForeground(whiteFont);
				btnNgun.setForeground(whiteFont);
				btnMnHnh.setForeground(green);
				btnChut.setForeground(whiteFont);
				btnBnPhm.setForeground(whiteFont);
				btnTaiNghe.setForeground(whiteFont);
			}
		});
		btnMnHnh.setForeground(whiteFont);
		btnMnHnh.setFont(font);
		btnMnHnh.setBackground(blue);
		btnMnHnh.setBorder(null);
		btnMnHnh.setBounds(404, 7, 64, 22);
		navbar.add(btnMnHnh);

		btnChut = new JButton("Chuột");
		btnChut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnAllProduct.setForeground(whiteFont);
				btnCpu.setForeground(whiteFont);
				btnRam.setForeground(whiteFont);
				btnVga.setForeground(whiteFont);
				btnMainboard.setForeground(whiteFont);
				btnCase.setForeground(whiteFont);
				btnNgun.setForeground(whiteFont);
				btnMnHnh.setForeground(whiteFont);
				btnChut.setForeground(green);
				btnBnPhm.setForeground(whiteFont);
				btnTaiNghe.setForeground(whiteFont);
			}
		});
		btnChut.setForeground(whiteFont);
		btnChut.setFont(font);
		btnChut.setBackground(blue);
		btnChut.setBorder(null);
		btnChut.setBounds(468, 7, 49, 22);
		navbar.add(btnChut);

		btnBnPhm = new JButton("Bàn phím");
		btnBnPhm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnAllProduct.setForeground(whiteFont);
				btnCpu.setForeground(whiteFont);
				btnRam.setForeground(whiteFont);
				btnVga.setForeground(whiteFont);
				btnMainboard.setForeground(whiteFont);
				btnCase.setForeground(whiteFont);
				btnNgun.setForeground(whiteFont);
				btnMnHnh.setForeground(whiteFont);
				btnChut.setForeground(whiteFont);
				btnBnPhm.setForeground(green);
				btnTaiNghe.setForeground(whiteFont);
			}
		});
		btnBnPhm.setForeground(whiteFont);
		btnBnPhm.setFont(font);
		btnBnPhm.setBackground(blue);
		btnBnPhm.setBorder(null);
		btnBnPhm.setBounds(518, 7, 61, 22);
		navbar.add(btnBnPhm);

		btnCase = new JButton("Case");
		btnCase.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnAllProduct.setForeground(whiteFont);
				btnCpu.setForeground(whiteFont);
				btnRam.setForeground(whiteFont);
				btnVga.setForeground(whiteFont);
				btnMainboard.setForeground(whiteFont);
				btnCase.setForeground(green);
				btnNgun.setForeground(whiteFont);
				btnMnHnh.setForeground(whiteFont);
				btnChut.setForeground(whiteFont);
				btnBnPhm.setForeground(whiteFont);
				btnTaiNghe.setForeground(whiteFont);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
			}
		});
		btnCase.setForeground(whiteFont);
		btnCase.setFont(font);
		btnCase.setBorder(null);
		btnCase.setBackground(blue);
		btnCase.setBounds(305, 7, 52, 22);
		navbar.add(btnCase);

		btnTaiNghe = new JButton("Tai nghe");
		btnTaiNghe.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnAllProduct.setForeground(whiteFont);
				btnCpu.setForeground(whiteFont);
				btnRam.setForeground(whiteFont);
				btnVga.setForeground(whiteFont);
				btnMainboard.setForeground(whiteFont);
				btnCase.setForeground(whiteFont);
				btnNgun.setForeground(whiteFont);
				btnMnHnh.setForeground(whiteFont);
				btnChut.setForeground(whiteFont);
				btnBnPhm.setForeground(whiteFont);
				btnTaiNghe.setForeground(green);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
			}
		});
		btnTaiNghe.setForeground(whiteFont);
		btnTaiNghe.setFont(font);
		btnTaiNghe.setBorder(null);
		btnTaiNghe.setBackground(blue);
		btnTaiNghe.setBounds(574, 7, 64, 22);
		navbar.add(btnTaiNghe);

		maincontent = new JPanel();
		maincontent.setBounds(189, 37, 1200, 730);
		contentPane.add(maincontent);
		maincontent.setLayout(new CardLayout(0, 0));

		JPanel panel_welcome = new JPanel();
		// 40, 180, 99

		panel_welcome.setBackground(SetColor.blue);
		panel_welcome.setLayout(null);
		panel_welcome.setBounds(0, 0, 179, 63);
		contentPane.add(panel_welcome);

		JLabel lblNewLabel = new JLabel("Welcome back, have a good day!!!");
		lblNewLabel.setFont(font);
		lblNewLabel.setForeground(whiteFont);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 179, 14);
		panel_welcome.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(LoginForm.fullN);
		lblNewLabel_1.setForeground(whiteFont);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(font_1);
//		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
//		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel_1.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-male-user-32-white.png")));
		lblNewLabel_1.setBounds(0, 20, 179, 32);
		panel_welcome.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 58, 179, 2);
		panel_welcome.add(separator);

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
				"© Copyright 2023, Bản quyền thuộc về NGUYỄN QUỐC VIỆT - 23CE.B029", TitledBorder.LEFT,
				TitledBorder.TOP, font, SetColor.redB));
		panel.setBounds(847, 0, 545, 37);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton_1 = new JButton("Đóng góp");
		btnNewButton_1.setFont(font_1);
		btnNewButton_1.setBackground(new Color(74, 176, 63));
		btnNewButton_1.setBounds(435, 12, 100, 20);
		panel.add(btnNewButton_1);

		textField = new JTextField();
		textField.setBounds(103, 13, 322, 18);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Đóng góp ý kiến");
		lblNewLabel_3.setFont(font);
		lblNewLabel_3.setBounds(10, 15, 93, 14);
		panel.add(lblNewLabel_3);

		JPanel panel_1 = new JPanel();
// blue 64,143,221
//orig 230, 126, 34
		panel_1.setBackground(SetColor.blue);
		panel_1.setBounds(0, 61, 179, 706);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		btnNhaCungCap = new JButton("Nhà phân phối");
		btnNhaCungCap.setIconTextGap(8);
		btnNhaCungCap.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhaCungCap.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-flyer-distributor-male-32.png")));
		btnNhaCungCap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				220, 118, 51

//				btnNhaCungCap.setBackground(new Color(211, 84, 0));

				NhaPhanPhoiForm nppf = new NhaPhanPhoiForm();
				maincontent.removeAll();
				maincontent.add(nppf).setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnNhaCungCap.setBackground(blueOp);
				btnNhapHang.setBackground(blue);
				btnXuatHang.setBackground(blue);
				btnPhieuXuat.setBackground(blue);
				btnPhieuNhap.setBackground(blue);
				btnThongKe.setBackground(blue);
			}
		});
		btnNhaCungCap.setFont(font1);
		btnNhaCungCap.setBackground(SetColor.blueOp);
		btnNhaCungCap.setForeground(whiteFont);
		btnNhaCungCap.setBorder(null);
		btnNhaCungCap.setBounds(0, 0, 179, 39);
		panel_1.add(btnNhaCungCap);

		btnNhapHang = new JButton("Nhập Hàng");
		btnNhapHang.setIconTextGap(8);
		btnNhapHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhapHang.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-close-garage-door-32.png")));
		btnNhapHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
				NhapHangForm pnf = new NhapHangForm();
				maincontent.add(pnf).setVisible(true);;
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnNhaCungCap.setBackground(blue);
				btnNhapHang.setBackground(blueOp);
				btnXuatHang.setBackground(blue);
				btnPhieuXuat.setBackground(blue);
				btnPhieuNhap.setBackground(blue);
				btnThongKe.setBackground(blue);

			}
		});
		btnNhapHang.setFont(font1);
		btnNhapHang.setBackground(blue);
		btnNhapHang.setForeground(whiteFont);
		btnNhapHang.setBorder(null);
		btnNhapHang.setBounds(0, 50, 179, 39);
		panel_1.add(btnNhapHang);

		btnXuatHang = new JButton("Xuất Hàng");
		btnXuatHang.setIconTextGap(8);
		btnXuatHang.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-send-package-32.png")));
		btnXuatHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnXuatHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
//				btnXuatHang.setBackground(new Color(211, 84, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnNhaCungCap.setBackground(blue);
				btnNhapHang.setBackground(blue);
				btnXuatHang.setBackground(blueOp);
				btnPhieuXuat.setBackground(blue);
				btnPhieuNhap.setBackground(blue);
				btnThongKe.setBackground(blue);
			}
		});
		btnXuatHang.setFont(font1);
		btnXuatHang.setBackground(blue);
		btnXuatHang.setForeground(whiteFont);
		btnXuatHang.setBorder(null);
		btnXuatHang.setBounds(0, 150, 179, 39);
		panel_1.add(btnXuatHang);

		btnPhieuNhap = new JButton("Phiếu Nhập");
		btnPhieuNhap.setIconTextGap(8);
		btnPhieuNhap.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-bill-32 (2).png")));
		btnPhieuNhap.setHorizontalAlignment(SwingConstants.LEFT);
		btnPhieuNhap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
//				btnPhieuNhap.setBackground(new Color(211, 84, 0));
				PhieuNhapForm pnf = new PhieuNhapForm();
				maincontent.add(pnf).setVisible(true);;
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnNhaCungCap.setBackground(blue);
				btnNhapHang.setBackground(blue);
				btnXuatHang.setBackground(blue);
				btnPhieuXuat.setBackground(blue);
				btnPhieuNhap.setBackground(blueOp);
				btnThongKe.setBackground(blue);
			}
		});
		btnPhieuNhap.setFont(font1);
		btnPhieuNhap.setBackground(blue);
		btnPhieuNhap.setForeground(whiteFont);
		btnPhieuNhap.setBorder(null);
		btnPhieuNhap.setBounds(0, 100, 179, 39);
		panel_1.add(btnPhieuNhap);

		JButton btnDangXuat = new JButton("Đăng Xuất");
		btnDangXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDangXuat.setBackground(new Color(231, 76, 60));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnDangXuat.setBackground(new Color(251, 252, 252));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int answ = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn đăng xuất?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
				if(answ == JOptionPane.YES_OPTION) {
					closeFrame();
				}
			}
		});
		btnDangXuat.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-shutdown-16.png")));
		btnDangXuat.setBorder(null);
		btnDangXuat.setFont(font1);
		btnDangXuat.setBounds(0, 678, 179, 28);
		panel_1.add(btnDangXuat);

		JButton btnThayDoiTT = new JButton("Thông Tin Tài Khoản");
		btnThayDoiTT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnThayDoiTT.setBackground(new Color(46, 134, 193));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnThayDoiTT.setBackground(new Color(251, 252, 252));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ThongTinTaiKhoan.main(null);
			}
		});
		btnThayDoiTT.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-info-16.png")));
		btnThayDoiTT.setBorder(null);
		btnThayDoiTT.setFont(font1);
		btnThayDoiTT.setBounds(0, 652, 179, 28);
		panel_1.add(btnThayDoiTT);

		btnThongKe = new JButton("Thống Kê");
		btnThongKe.setIconTextGap(8);
		btnThongKe.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-stocks-32.png")));
		btnThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		btnThongKe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
//				btnThongKe.setBackground(new Color(211, 84, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnNhaCungCap.setBackground(blue);
				btnNhapHang.setBackground(blue);
				btnXuatHang.setBackground(blue);
				btnPhieuXuat.setBackground(blue);
				btnPhieuNhap.setBackground(blue);
				btnThongKe.setBackground(blueOp);
			}
		});
		btnThongKe.setFont(font1);
		btnThongKe.setBackground(blue);
		btnThongKe.setForeground(whiteFont);
		btnThongKe.setBorder(null);
		btnThongKe.setBounds(0, 300, 179, 39);
		panel_1.add(btnThongKe);

		btnPhieuXuat = new JButton("Phiếu Xuất");
		btnPhieuXuat.setIconTextGap(8);
		btnPhieuXuat.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-payment-check-32.png")));
		btnPhieuXuat.setHorizontalAlignment(SwingConstants.LEFT);
		btnPhieuXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
//				btnPhieuXuat.setBackground(new Color(211, 84, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnNhaCungCap.setBackground(blue);
				btnNhapHang.setBackground(blue);
				btnXuatHang.setBackground(blue);
				btnPhieuXuat.setBackground(blueOp);
				btnPhieuNhap.setBackground(blue);
				btnThongKe.setBackground(blue);
			}
		});
		btnPhieuXuat.setFont(font1);
		btnPhieuXuat.setBackground(blue);
		btnPhieuXuat.setForeground(whiteFont);
		btnPhieuXuat.setBorder(null);
		btnPhieuXuat.setBounds(0, 200, 179, 39);
		panel_1.add(btnPhieuXuat);
		
		JPanel panelDateTime = new JPanel();
		panelDateTime.setBackground(blue);
		ClockPane cp = new ClockPane();
		cp.setBackground(blue);
		panelDateTime.add(cp);
//		 cp.BOTTOM_ALIGNMENT
		panelDateTime.setBounds(0, 619, 179, 29);
		panel_1.add(panelDateTime);
		panelDateTime.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnKhchHng = new JButton("Khách Hàng");
		btnKhchHng.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-group-32.png")));
		btnKhchHng.setIconTextGap(8);
		btnKhchHng.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhchHng.setForeground(new Color(254, 254, 254));
		btnKhchHng.setFont(SetFont.font1());
		btnKhchHng.setBorder(null);
		btnKhchHng.setBackground(new Color(64, 143, 221));
		btnKhchHng.setBounds(0, 250, 179, 39);
		panel_1.add(btnKhchHng);
		
		

//		btnNewButton = new JButton("Light");
//		btnNewButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				toLight();
//			}
//		});
//		btnNewButton.setBorder(null);
//		btnNewButton.setBounds(0, 390, 95, 23);
//		panel_1.add(btnNewButton);
//		
//		btnDark = new JButton("Dark");
//		btnDark.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				toDark();
//			}
//		});
//		btnDark.setForeground(new Color(243, 243, 243));
//		btnDark.setBackground(Color.DARK_GRAY);
//		btnDark.setBorder(null);
//		btnDark.setBounds(90, 390, 89, 23);
//		panel_1.add(btnDark);

//		JScrollPane panelPane = new JScrollPane(panel);
//		panelPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//		panelPane.setBounds(0, 197, 183, 175);
//		contentPane.add(panelPane);

//		javax.swing.GroupLayout MainContentLayout = new javax.swing.GroupLayout(maincontent);
//		maincontent.setLayout(MainContentLayout);
//        MainContentLayout.setHorizontalGroup(
//            MainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 1180, Short.MAX_VALUE)
//        );
//        MainContentLayout.setVerticalGroup(
//            MainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 750, Short.MAX_VALUE)
//        );
//
//        getContentPane().add(maincontent, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1180, 750));
	}

	public void toLight() {
		try {
			UIManager.setLookAndFeel(new FlatLightLaf());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void toDark() {
		try {
			UIManager.setLookAndFeel(new FlatDarkLaf());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	private static void setDateToLable() {
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//		LocalDateTime now = LocalDateTime.now();
//		lbDateTime.setText(dtf.format(now));
//	}
	
	
	
	class ClockPane extends JPanel {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JLabel clock = new JLabel();
		

		public ClockPane() {
			
			setLayout(new BorderLayout());
			tickTock();
			clock.setForeground(SetColor.whiteFont);
			clock.setBackground(SetColor.blue);
			clock.setFont(font_1);
			add(clock);
			Timer timer = new Timer(500, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tickTock();
				}
			});
			timer.setRepeats(true);
			timer.setCoalesce(true);
			timer.setInitialDelay(0);
			timer.start();
		}

		public void tickTock() {
			clock.setText(DateFormat.getDateTimeInstance().format(new Date()));
		}
	}
	
	
	@SuppressWarnings("deprecation")
	private void closeFrame() {
		this.disable();
		this.dispose();
	}
}
