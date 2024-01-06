package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import color.SetColor;
import dao.SanPhamDAO;
import dao.vgaDAO;
import font.SetFont;
import model.Products;
import model.vga;

public class ThemVGA extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfTen;
	private JTextField tfBoNho;
	private JTextField tfHang;
	private JTextField tfDonGia;
	private JComboBox<String> comboBox;
	private static JTextField tfIDVGA;
	public static String insert = "";
	private JTextField tfBaoHanh;
	private JButton btnUpload;
	private JLabel labelIMG;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemVGA frame = new ThemVGA();
					setDefaultIDVGA(vgaDAO.getInstance().selectAll());
					frame.setLocationRelativeTo(null);
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
	public ThemVGA() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 783, 349);
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 25, 25));
		contentPane = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics grphcs) {
				super.paintComponent(grphcs);
				Graphics2D g2d = (Graphics2D) grphcs;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				GradientPaint gp = new GradientPaint(0, 0, new Color(102, 125, 182), 0, getHeight(),
						new Color(0, 130, 200));
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, getWidth(), getHeight());

			}
		};
		contentPane.setBackground(SetColor.blueOp);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("THÊM VGA");
		lblNewLabel.setFont(SetFont.fontTitle());
		lblNewLabel.setForeground(SetColor.yellow);
		lblNewLabel.setBounds(10, 11, 138, 24);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("© Copyright 2023, Bản quyền thuộc về NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_1.setForeground(SetColor.copyRight);
		lblNewLabel_1.setFont(SetFont.font());
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 320, 763, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("ID Sản phẩm");
		lblNewLabel_2.setFont(SetFont.font1_());
		lblNewLabel_2.setForeground(SetColor.whiteFont);
		lblNewLabel_2.setBounds(30, 63, 87, 25);
		contentPane.add(lblNewLabel_2);

		tfTen = new JTextField();
		tfTen.setFont(SetFont.fontDetails());
		tfTen.setColumns(10);
		tfTen.setBorder(null);
		tfTen.setBounds(116, 123, 149, 25);
		contentPane.add(tfTen);

		JLabel lblNewLabel_2_1 = new JLabel("Tên VGA");
		lblNewLabel_2_1.setFont(SetFont.font1_());
		lblNewLabel_2_1.setForeground(SetColor.whiteFont);
		lblNewLabel_2_1.setBounds(30, 123, 87, 25);
		contentPane.add(lblNewLabel_2_1);

		tfBoNho = new JTextField();
		tfBoNho.setFont(SetFont.fontDetails());
		tfBoNho.setColumns(10);
		tfBoNho.setBorder(null);
		tfBoNho.setBounds(116, 183, 149, 25);
		contentPane.add(tfBoNho);

		JLabel lblNewLabel_2_1_1 = new JLabel("Bộ nhớ");
		lblNewLabel_2_1_1.setFont(SetFont.font1_());
		lblNewLabel_2_1_1.setForeground(SetColor.whiteFont);
		lblNewLabel_2_1_1.setBounds(30, 183, 87, 25);
		contentPane.add(lblNewLabel_2_1_1);

		tfHang = new JTextField();
		tfHang.setFont(SetFont.fontDetails());
		tfHang.setColumns(10);
		tfHang.setBorder(null);
		tfHang.setBounds(378, 123, 149, 25);
		contentPane.add(tfHang);

		JLabel lblNewLabel_2_2 = new JLabel("Hãng VGA");
		lblNewLabel_2_2.setFont(SetFont.font1_());
		lblNewLabel_2_2.setForeground(SetColor.whiteFont);
		lblNewLabel_2_2.setBounds(292, 123, 87, 25);
		contentPane.add(lblNewLabel_2_2);

		tfDonGia = new JTextField();
		tfDonGia.setFont(SetFont.fontDetails());
		tfDonGia.setColumns(10);
		tfDonGia.setBorder(null);
		tfDonGia.setBounds(378, 183, 149, 25);
		contentPane.add(tfDonGia);

		JLabel lblNewLabel_2_3 = new JLabel("Đơn giá");
		lblNewLabel_2_3.setFont(SetFont.font1_());
		lblNewLabel_2_3.setForeground(SetColor.whiteFont);
		lblNewLabel_2_3.setBounds(292, 183, 87, 25);
		contentPane.add(lblNewLabel_2_3);

		ArrayList<Products> list = SanPhamDAO.getIDSanPham("vga");
		String[] combo = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			Products p = list.get(i);
			combo[i] = p.getIdSanPham();
		}
		comboBox = new JComboBox<>(new DefaultComboBoxModel<String>(combo));
		comboBox.setFont(SetFont.fontDetails());
		comboBox.setBounds(116, 64, 149, 25);
		contentPane.add(comboBox);

		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String idsp = comboBox.getSelectedItem().toString();
				String idvga = tfIDVGA.getText();
				String ten = tfTen.getText();
				String hang = tfHang.getText();
				String bonho = tfBoNho.getText();
				double gia = Double.parseDouble(tfDonGia.getText());
				String baohanh = tfBaoHanh.getText();

				if (ten.equals("") || hang.equals("") || bonho.equals("") || tfDonGia.equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
				} else {
					vga v = new vga(idsp, idvga, ten, hang, bonho, 0, gia, baohanh, null);

					if (insert.equals("")) {
						int check = vgaDAO.getInstance().insertNotIMG(v);
						if (check > 0) {
							JOptionPane.showMessageDialog(null, "Thêm thành công!");
							setInsert("");
						} else {
							JOptionPane.showMessageDialog(null, "Thêm không thành công!");
							setInsert("");
						}
					} else {
						int check = vgaDAO.getInstance().insert(v);
						if (check > 0) {
							JOptionPane.showMessageDialog(null, "Thêm thành công!");
							setInsert("");
						} else {
							JOptionPane.showMessageDialog(null, "Thêm không thành công!");
							setInsert("");
						}

					}
					VGAForm.loadDataToTable(vgaDAO.getInstance().selectAll());
					closeFrame();
				}
			}
		});
		btnNewButton.setFont(SetFont.font1());
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(314, 240, 89, 30);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Hủy");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeFrame();
			}
		});
		btnNewButton_1.setFont(SetFont.font1());
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBounds(438, 240, 89, 30);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_2_1_2 = new JLabel("ID VGA");
		lblNewLabel_2_1_2.setForeground(new Color(254, 254, 254));
		lblNewLabel_2_1_2.setFont(SetFont.font1_());
		lblNewLabel_2_1_2.setBounds(292, 63, 87, 25);
		contentPane.add(lblNewLabel_2_1_2);

		tfIDVGA = new JTextField();
		tfIDVGA.setFont(SetFont.fontDetails());
		tfIDVGA.setColumns(10);
		tfIDVGA.setBorder(null);
		tfIDVGA.setBounds(378, 63, 149, 25);
		contentPane.add(tfIDVGA);

		tfBaoHanh = new JTextField();
		tfBaoHanh.setFont(SetFont.fontDetails());
		tfBaoHanh.setColumns(10);
		tfBaoHanh.setBorder(null);
		tfBaoHanh.setBounds(116, 240, 149, 25);
		contentPane.add(tfBaoHanh);

		JLabel lblNewLabel_2_1_3_1 = new JLabel("Bảo hành");
		lblNewLabel_2_1_3_1.setForeground(new Color(254, 254, 254));
		lblNewLabel_2_1_3_1.setFont(SetFont.font1_());
		lblNewLabel_2_1_3_1.setBounds(30, 240, 87, 25);
		contentPane.add(lblNewLabel_2_1_3_1);

		labelIMG = new JLabel("Ảnh CPU");
		labelIMG.setHorizontalAlignment(SwingConstants.CENTER);
		labelIMG.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelIMG.setBounds(550, 53, 223, 230);
		contentPane.add(labelIMG);

		btnUpload = new JButton("Upload");
		btnUpload.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				fileChooser.addChoosableFileFilter(
						new FileNameExtensionFilter("*.IMAGE", "webp", "jpg", "jpeg", "gif", "png"));
				int result = fileChooser.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectFile = fileChooser.getSelectedFile();
					ImageIcon ii = new ImageIcon(selectFile.getAbsolutePath());
					Image i = ii.getImage();
					i = i.getScaledInstance(labelIMG.getWidth(), labelIMG.getHeight(), Image.SCALE_SMOOTH);
					labelIMG.setText("");
					labelIMG.setIcon(new ImageIcon(i));
					insert = selectFile.getAbsolutePath();
				} else
					JOptionPane.showMessageDialog(null, "Lỗi file!");
			}
		});
		btnUpload.setFont(SetFont.font());
		btnUpload.setBorder(null);
		btnUpload.setBounds(702, 291, 71, 21);
		contentPane.add(btnUpload);
	}

	private void closeFrame() {
		this.dispose();
	}

	private static void setDefaultIDVGA(ArrayList<vga> arr) {
		int id = arr.size() + 1;
		String check = "";
		for (vga vga : arr) {
			if (vga.getIdVga().equals("vga" + id)) {
				check = vga.getIdVga();
			}
		}
		while (check.length() != 0) {
			String c = check;
			id++;
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i).getIdVga().equals("vga" + id)) {
					check = arr.get(i).getIdVga();
				}
			}
			if (check.equals(c)) {
				check = "";
			}
		}
		tfIDVGA.setText("vga" + id);
	}

	public static String getInsert() {
		return insert;
	}

	public static void setInsert(String insert) {
		ThemVGA.insert = insert;
	}

}
