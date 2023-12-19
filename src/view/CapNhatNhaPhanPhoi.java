package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import color.SetColor;
import dao.NhaPhanPhoiDAO;
import model.NhaPhanPhoi;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class CapNhatNhaPhanPhoi extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Font font;
	public Font font_1;
	public Font font1;
	public Font font2;
	public Font font3;
	private static JTextField tfTen;
	private static JTextField tfDiaChi;
	private static JTextField tfSDT;
	private static JTextField tfEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapNhatNhaPhanPhoi frame = new CapNhatNhaPhanPhoi();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					setDefaultJtextFiel();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CapNhatNhaPhanPhoi() {

		setUndecorated(true);
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

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 780, 370);
		contentPane = new JPanel();
		contentPane.setBackground(SetColor.blueOp);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CẬP NHẬT NHÀ PHÂN PHỐI");
		lblNewLabel.setFont(font3);
		lblNewLabel.setForeground(SetColor.yellow);
		lblNewLabel.setBounds(0, 0, 339, 63);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tên nhà phân phối");
		lblNewLabel_1.setFont(font_1);
		lblNewLabel_1.setForeground(SetColor.whiteFont);
		lblNewLabel_1.setBounds(80, 40, 264, 37);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Địa chỉ");
		lblNewLabel_1_1.setFont(font_1);
		lblNewLabel_1_1.setForeground(SetColor.whiteFont);
		lblNewLabel_1_1.setBounds(412, 40, 264, 37);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Email");
		lblNewLabel_1_2.setFont(font_1);
		lblNewLabel_1_2.setForeground(SetColor.whiteFont);
		lblNewLabel_1_2.setBounds(80, 135, 264, 37);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_1_1.setFont(font_1);
		lblNewLabel_1_1_1.setForeground(SetColor.whiteFont);
		lblNewLabel_1_1_1.setBounds(412, 135, 264, 37);
		contentPane.add(lblNewLabel_1_1_1);

		JButton btnNewButton = new JButton("Cập nhật");
		btnNewButton.setBorder(null);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NhaPhanPhoi n = NhaPhanPhoiForm.getNppSelect();
				String id = n.getIdNPP();
				String ten = tfTen.getText();
				String diaChi = tfDiaChi.getText();
				String email = tfEmail.getText();
				int sdt = Integer.parseInt(tfSDT.getText());

				NhaPhanPhoi npp = new NhaPhanPhoi(id, ten, diaChi, email, sdt);
				NhaPhanPhoiDAO.getInstance().update(npp);
				NhaPhanPhoiForm.loadDataToTable(NhaPhanPhoiDAO.getInstance().selectAll());

				JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
				closeFrame();
			}
		});
		btnNewButton.setFont(font1);
		btnNewButton.setBounds(220, 263, 143, 46);
		contentPane.add(btnNewButton);

		JButton btnHy = new JButton("Hủy");
		btnHy.setBorder(null);
		btnHy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeFrame();
			}
		});
		btnHy.setFont(font1);
		btnHy.setBounds(388, 263, 143, 46);
		contentPane.add(btnHy);

		tfTen = new JTextField();
		tfTen.setBorder(null);
		tfTen.setBounds(80, 75, 257, 49);
		contentPane.add(tfTen);
		tfTen.setColumns(10);

		tfDiaChi = new JTextField();
		tfDiaChi.setBorder(null);
		tfDiaChi.setColumns(10);
		tfDiaChi.setBounds(412, 75, 257, 49);
		contentPane.add(tfDiaChi);

		tfSDT = new JTextField();
		tfSDT.setBorder(null);
		tfSDT.setColumns(10);
		tfSDT.setBounds(412, 166, 257, 49);
		contentPane.add(tfSDT);

		tfEmail = new JTextField();
		tfEmail.setBorder(null);
		tfEmail.setColumns(10);
		tfEmail.setBounds(80, 166, 257, 49);
		contentPane.add(tfEmail);

		JLabel lblNewLabel_2 = new JLabel("© Copyright 2023, Bản quyền thuộc về NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_2.setForeground(SetColor.whiteFont);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(80, 345, 589, 14);
		contentPane.add(lblNewLabel_2);
	}

	public void closeFrame() {
		this.dispose();
	}

	private static void setDefaultJtextFiel() {
		NhaPhanPhoi npp = NhaPhanPhoiForm.getNppSelect();
		tfTen.setText(npp.getTenNPP());
		tfDiaChi.setText(npp.getDiaChi());
		tfEmail.setText(npp.getEmail());
		tfSDT.setText(String.valueOf(npp.getSdt()));
	}

}
