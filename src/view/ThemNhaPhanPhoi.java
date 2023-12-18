package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import color.SetColor;
import dao.NhaPhanPhoiDAO;
import model.NhaPhanPhoi;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class ThemNhaPhanPhoi extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfDiaChi;
	private JTextField tfSDT;
	private JTextField tfTen;
	private JTextField tfEmail;
	private JTextField tfID;
	private NhaPhanPhoiForm nppf;
	public Font font;
	public Font font_1;
	public Font font1;
	public Font font2;
	public Font font3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemNhaPhanPhoi frame = new ThemNhaPhanPhoi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ThemNhaPhanPhoi() {

		try {
			File fontStyle = new File("src/font/Roboto-Medium.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(11f);
			font_1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(14f);
			font1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(16f);
			font2 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(22f);
			File fontStyle1 = new File("src/font/Oswald-Medium.ttf");
			font3 = Font.createFont(Font.TRUETYPE_FONT, fontStyle1).deriveFont(18f);

		} catch (Exception e) {
			System.out.println(e);
		}

		setUndecorated(true);
		this.nppf = (NhaPhanPhoiForm) nppf;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setTitle("Thêm nhà phân phối");

		setBounds(100, 100, 779, 373);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("ID Nhà phân phối");
		lblNewLabel.setForeground(SetColor.whiteFont);
		lblNewLabel.setFont(font_1);
		lblNewLabel.setBounds(55, 25, 321, 39);
		getContentPane().add(lblNewLabel);

		tfID = new JTextField();
		tfID.setBorder(null);
		tfID.setBounds(55, 64, 321, 49);
		getContentPane().add(tfID);
		tfID.setColumns(10);

		tfDiaChi = new JTextField();
		tfDiaChi.setBorder(null);
		tfDiaChi.setColumns(10);
		tfDiaChi.setBounds(55, 163, 321, 49);
		getContentPane().add(tfDiaChi);

		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setForeground(SetColor.whiteFont);
		lblaCh.setFont(font_1);
		lblaCh.setBounds(55, 124, 321, 39);
		getContentPane().add(lblaCh);

		tfSDT = new JTextField();
		tfSDT.setBorder(null);
		tfSDT.setColumns(10);
		tfSDT.setBounds(55, 262, 321, 49);
		getContentPane().add(tfSDT);

		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setFont(font_1);
		lblSinThoi.setForeground(SetColor.whiteFont);
		lblSinThoi.setBounds(55, 223, 321, 39);
		getContentPane().add(lblSinThoi);

		tfTen = new JTextField();
		tfTen.setBorder(null);
		tfTen.setColumns(10);
		tfTen.setBounds(404, 64, 321, 49);
		getContentPane().add(tfTen);

		JLabel lblTnNhPhn = new JLabel("Tên nhà phân phối");
		lblTnNhPhn.setForeground(SetColor.whiteFont);
		lblTnNhPhn.setFont(font_1);
		lblTnNhPhn.setBounds(404, 25, 321, 39);
		getContentPane().add(lblTnNhPhn);

		tfEmail = new JTextField();
		tfEmail.setBorder(null);
		tfEmail.setColumns(10);
		tfEmail.setBounds(404, 163, 321, 49);
		getContentPane().add(tfEmail);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(SetColor.whiteFont);
		lblEmail.setFont(font_1);
		lblEmail.setBounds(404, 124, 321, 39);
		getContentPane().add(lblEmail);

		JButton btnThem = new JButton("Thêm");
		btnThem.setBorder(null);
		btnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = tfID.getText().trim();
				String ten = tfTen.getText().trim();
				String diaChi = tfDiaChi.getText().trim();
				String email = tfEmail.getText().trim();
				int sdt = Integer.parseInt(tfSDT.getText().trim());

				if (id.equals("") || ten.equals("")) {
					JOptionPane.showMessageDialog(null, "ID và tên không được bỏ trống!");
				} else {
					if (NhaPhanPhoiDAO.getInstance().selectById(id) == null) {
						NhaPhanPhoi npp = new NhaPhanPhoi();
						npp.setIdNPP(id);
						npp.setTenNPP(ten);
						npp.setDiaChi(diaChi);
						npp.setEmail(email);
						npp.setSdt(sdt);
						NhaPhanPhoiDAO.getInstance().insert(npp);
						JOptionPane.showMessageDialog(null, "Thêm thành công!");
						NhaPhanPhoiForm.loadDataToTable(NhaPhanPhoiDAO.getInstance().selectAll());
//						nppf.loadDataToTable(NhaPhanPhoiDAO.getInstance().selectAll());	
						thoatCuaSo();
					} else
						JOptionPane.showMessageDialog(null, "ID nhà phân phối đã tồn tại!");
				}

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnThem.setBackground(SetColor.green);
				btnThem.setForeground(SetColor.whiteFont);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnThem.setBackground(SetColor.whiteFont);
				btnThem.setForeground(Color.BLACK);
			}
		});
		btnThem.setFont(font1);
		btnThem.setBounds(404, 262, 150, 49);
		getContentPane().add(btnThem);

		JButton btnHuy = new JButton("Hủy");
		btnHuy.setBorder(null);
		btnHuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				thoatCuaSo();
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnHuy.setBackground(SetColor.redB);
				btnHuy.setForeground(SetColor.whiteFont);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnHuy.setBackground(SetColor.whiteFont);
				btnHuy.setForeground(Color.BLACK);
			}
		});
		btnHuy.setFont(font1);
		btnHuy.setBounds(575, 262, 150, 49);
		getContentPane().add(btnHuy);

		JPanel panel = new JPanel();
		panel.setBackground(SetColor.blueOp);
		panel.setBounds(0, 0, 779, 373);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("© Copyright 2023, Bản quyền thuộc về NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_1.setFont(font);
		lblNewLabel_1.setForeground(SetColor.whiteFont);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(58, 348, 668, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("THÊM NHÀ PHÂN PHỐI");
		lblNewLabel_2.setFont(font3);
		lblNewLabel_2.setForeground(SetColor.green1);
		lblNewLabel_2.setBounds(0, 0, 379, 37);
		panel.add(lblNewLabel_2);

	}

	private void thoatCuaSo() {
		this.dispose();
	}
}
