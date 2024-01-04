package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

import color.SetColor;
import dao.SanPhamDAO;
import dao.cpuDAO;
import font.SetFont;
import model.Products;
import model.cpu;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ThemCPU extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfSoNhan;
	private JTextField tfXungNhip;
	private JTextField tfTonKho;
	private JTextField tfDienNang;
	private JTextField tfSoLuong;
	private JTextField tfBoNhoDem;
	private JTextField tfTenCPU;
	private JComboBox<String> comboBox;
	private static JTextField tfIDCPU;
	private JTextField tfDonGia;
	private JButton btnUpload;
	private JLabel labelIMG;
	private JTextField tfBaoHanh;

	public static String insert = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemCPU frame = new ThemCPU();
					setDefaultIDCPU(cpuDAO.getInstance().selectAll());
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
	public ThemCPU() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 779, 409);
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

		JLabel lblNewLabel = new JLabel("ID sản phẩm");
		lblNewLabel.setForeground(SetColor.whiteFont);
		lblNewLabel.setFont(SetFont.font1_());
		lblNewLabel.setBounds(21, 57, 81, 30);
		contentPane.add(lblNewLabel);

		JLabel lblSNhn = new JLabel("Số nhân");
		lblSNhn.setForeground(SetColor.whiteFont);
		lblSNhn.setFont(SetFont.font1_());
		lblSNhn.setBounds(284, 57, 83, 30);
		contentPane.add(lblSNhn);

		JLabel lblNewLabel_1_1 = new JLabel("Số luồng");
		lblNewLabel_1_1.setForeground(SetColor.whiteFont);
		lblNewLabel_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_1.setBounds(399, 57, 80, 30);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblXungNhp = new JLabel("Xung nhịp");
		lblXungNhp.setFont(SetFont.font1_());
		lblXungNhp.setForeground(SetColor.whiteFont);
		lblXungNhp.setBounds(299, 122, 71, 30);
		contentPane.add(lblXungNhp);

		JLabel lblNewLabel_1_2 = new JLabel("Tồn kho");
		lblNewLabel_1_2.setForeground(SetColor.whiteFont);
		lblNewLabel_1_2.setFont(SetFont.font1_());
		lblNewLabel_1_2.setBounds(299, 257, 83, 30);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblinNngTiu = new JLabel("Điện năng tiêu thụ");
		lblinNngTiu.setForeground(SetColor.whiteFont);
		lblinNngTiu.setFont(SetFont.font1_());
		lblinNngTiu.setBounds(21, 257, 116, 30);
		contentPane.add(lblinNngTiu);

		tfSoNhan = new JTextField();
		tfSoNhan.setFont(SetFont.fontDetails());
		tfSoNhan.setColumns(10);
		tfSoNhan.setBounds(344, 57, 45, 30);
		contentPane.add(tfSoNhan);

		tfXungNhip = new JTextField();
		tfXungNhip.setColumns(10);
		tfXungNhip.setFont(SetFont.fontDetails());
		tfXungNhip.setBounds(385, 122, 141, 30);
		contentPane.add(tfXungNhip);

		tfTonKho = new JTextField();
		tfTonKho.setFont(SetFont.fontDetails());
		tfTonKho.setColumns(10);
		tfTonKho.setBounds(385, 257, 141, 30);
		contentPane.add(tfTonKho);

		tfDienNang = new JTextField();
		tfDienNang.setColumns(10);
		tfDienNang.setFont(SetFont.fontDetails());
		tfDienNang.setBounds(133, 257, 141, 30);
		contentPane.add(tfDienNang);

		tfSoLuong = new JTextField();
		tfSoLuong.setColumns(10);
		tfSoLuong.setFont(SetFont.fontDetails());
		tfSoLuong.setBounds(481, 57, 45, 30);
		contentPane.add(tfSoLuong);

		JButton btnAdd = new JButton("Thêm");
		btnAdd.setBorder(null);
		btnAdd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					addCPU();
				}
			}
		});
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addCPU();
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setFont(SetFont.font1());
		btnAdd.setBounds(542, 319, 97, 30);
		contentPane.add(btnAdd);

		JButton btnCancel = new JButton("Hủy");
		btnCancel.setBorder(null);
		btnCancel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					closeFrame();
				}
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeFrame();
			}
		});
		btnCancel.setFont(SetFont.font1());
		btnCancel.setBounds(672, 319, 97, 30);
		contentPane.add(btnCancel);

		JLabel lblNewLabel_1_1_1 = new JLabel("Bộ nhớ đệm");
		lblNewLabel_1_1_1.setForeground(SetColor.whiteFont);
		lblNewLabel_1_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_1_1.setBounds(299, 192, 71, 30);
		contentPane.add(lblNewLabel_1_1_1);

		tfBoNhoDem = new JTextField();
		tfBoNhoDem.setFont(SetFont.fontDetails());
		tfBoNhoDem.setColumns(10);
		tfBoNhoDem.setBounds(385, 191, 141, 30);
		contentPane.add(tfBoNhoDem);

		ArrayList<Products> list = SanPhamDAO.getIDSanPham("cpu");
		int size = list.size();
		String choose[] = new String[size];
		for (int i = 0; i < size; i++) {
			Products pr = list.get(i);
			choose[i] = pr.getIdSanPham();
		}
		comboBox = new JComboBox<String>();
		comboBox.setFont(SetFont.fontDetails());
		comboBox.setModel(new DefaultComboBoxModel<String>(choose));
		comboBox.setBounds(133, 57, 141, 30);
		contentPane.add(comboBox);

		JLabel lblTnCpu = new JLabel("Tên cpu");
		lblTnCpu.setForeground(SetColor.whiteFont);
		lblTnCpu.setFont(SetFont.font1_());
		lblTnCpu.setBounds(21, 188, 71, 30);
		contentPane.add(lblTnCpu);

		tfTenCPU = new JTextField();
		tfTenCPU.setColumns(10);
		tfTenCPU.setFont(SetFont.fontDetails());
		tfTenCPU.setBounds(133, 188, 141, 30);
		contentPane.add(tfTenCPU);

		JLabel lblNewLabel_1 = new JLabel("© Copyright 2023, Bản quyền thuộc về NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_1.setForeground(SetColor.copyRight);
		lblNewLabel_1.setFont(SetFont.font());
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 381, 759, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("THÊM CPU");
		lblNewLabel_2.setFont(SetFont.fontTitle());
		lblNewLabel_2.setForeground(SetColor.yellow);
		lblNewLabel_2.setBounds(10, 10, 267, 36);
		contentPane.add(lblNewLabel_2);

		JLabel lblIdCpu = new JLabel("ID CPU");
		lblIdCpu.setForeground(new Color(254, 254, 254));
		lblIdCpu.setFont(SetFont.font1_());
		lblIdCpu.setBounds(21, 122, 71, 30);
		contentPane.add(lblIdCpu);

		tfIDCPU = new JTextField();
		tfIDCPU.setFont(SetFont.fontDetails());
		tfIDCPU.setColumns(10);
		tfIDCPU.setBounds(133, 122, 141, 30);
		contentPane.add(tfIDCPU);

		JLabel lblNewLabel_1_2_1 = new JLabel("Đơn giá");
		lblNewLabel_1_2_1.setForeground(new Color(254, 254, 254));
		lblNewLabel_1_2_1.setFont(SetFont.font1_());
		lblNewLabel_1_2_1.setBounds(19, 319, 83, 30);
		contentPane.add(lblNewLabel_1_2_1);

		tfDonGia = new JTextField();
		tfDonGia.setColumns(10);
		tfDonGia.setFont(SetFont.fontDetails());
		tfDonGia.setBounds(133, 319, 141, 30);
		contentPane.add(tfDonGia);

		labelIMG = new JLabel("Ảnh CPU");
		labelIMG.setHorizontalAlignment(SwingConstants.CENTER);
		labelIMG.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelIMG.setBounds(546, 57, 223, 230);
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
		btnUpload.setBounds(698, 290, 71, 21);
		contentPane.add(btnUpload);

		tfBaoHanh = new JTextField();
		tfBaoHanh.setFont(SetFont.fontDetails());
		tfBaoHanh.setColumns(10);
		tfBaoHanh.setBounds(385, 319, 141, 30);
		contentPane.add(tfBaoHanh);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Bảo hành");
		lblNewLabel_1_2_1_1.setForeground(new Color(254, 254, 254));
		lblNewLabel_1_2_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_2_1_1.setBounds(299, 319, 83, 30);
		contentPane.add(lblNewLabel_1_2_1_1);
	}

	private void closeFrame() {
		this.dispose();
	}

	private boolean kiemTraIDCPU() {
		ArrayList<cpu> listCPU = cpuDAO.getInstance().selectAll();
		for (cpu cpu : listCPU) {
			if (cpu.getIdCpu().equals(tfIDCPU.getText())) {
				JOptionPane.showMessageDialog(null, "ID CPU đã tồn tại!");
				return true;
			}
		}
		return false;
	}

	private static void setDefaultIDCPU(ArrayList<cpu> arr) {
		int id = arr.size() + 1;
		String check = "";
		for (cpu cpu : arr) {
			if (cpu.getIdCpu().equals("cpu" + id)) {
				check = cpu.getIdCpu();
			}
		}
		while (check.length() != 0) {
			String c = check;
			id++;
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i).getIdCpu().equals("cpu" + id)) {
					check = arr.get(i).getIdCpu();
				}
			}
			if (check.equals(c)) {
				check = "";
			}
		}
//		int code = 1;
//		for (cpu cpu : arr) {
//			int id = Integer.parseInt(cpu.getIdCpu().substring(3, cpu.getIdCpu().length()));
//			if (code != id) {
//				tfIDCPU.setText("cpu" + code);
//				return;
//			}
//			code++;
//		}
//		tfIDCPU.setText("cpu" + Math.addExact(arr.size(), 1));
		tfIDCPU.setText("cpu" + id);
	}

	private void addCPU() {
		if (kiemTraIDCPU()) {
			JOptionPane.showMessageDialog(null, "ID CPU đã tồn tại");
		} else {

			String id = (String) comboBox.getSelectedItem();
			String idcpu = tfIDCPU.getText();
			String ten = tfTenCPU.getText();
			String xungNhip = tfXungNhip.getText();
			int soNhan = Integer.parseInt(tfSoNhan.getText());
			int soLuong = Integer.parseInt(tfSoLuong.getText());
			String dienNang = tfDienNang.getText();
			String boNho = tfBoNhoDem.getText();
			double gia = Double.parseDouble(tfDonGia.getText());
			String baoHanh = tfBaoHanh.getText();

			cpu cc = new cpu(id, idcpu, ten, xungNhip, soNhan, soLuong, dienNang, boNho, soLuong, gia, baoHanh, null);
			if (insert.equals("")) {
				int check = cpuDAO.getInstance().insertNotIMG(cc);
				if (check > 0)
					JOptionPane.showMessageDialog(null, "Thêm thành công");
				else
					JOptionPane.showMessageDialog(null, "Thêm Thất bại!");
			} else {
				int check = cpuDAO.getInstance().insert(cc);
				if (check > 0)
					JOptionPane.showMessageDialog(null, "Thêm thành công");
				else
					JOptionPane.showMessageDialog(null, "Thêm Thất bại!!!");
			}
			CPUForm.loadDataToTable(cpuDAO.getInstance().selectAll());
			closeFrame();
		}
	}

	public static String getInsert() {
		return insert;
	}

	public static void setInsert(String insert) {
		ThemCPU.insert = insert;
	}

}
