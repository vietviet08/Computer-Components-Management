package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import color.SetColor;
import dao.SanPhamDAO;
import dao.cpuDAO;
import font.SetFont;
import model.Products;
import model.cpu;
import javax.swing.SwingConstants;
import java.awt.Color;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemCPU frame = new ThemCPU();
					setDefaultIDCPU();
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
		setBounds(100, 100, 554, 409);
		contentPane = new JPanel();
		contentPane.setBackground(SetColor.blueOp);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID sản phẩm");
		lblNewLabel.setForeground(SetColor.whiteFont);
		lblNewLabel.setFont(SetFont.font());
		lblNewLabel.setBounds(21, 57, 81, 30);
		contentPane.add(lblNewLabel);

		JLabel lblSNhn = new JLabel("Số nhân");
		lblSNhn.setForeground(SetColor.whiteFont);
		lblSNhn.setFont(SetFont.font());
		lblSNhn.setBounds(284, 57, 83, 30);
		contentPane.add(lblSNhn);

		JLabel lblNewLabel_1_1 = new JLabel("Số luồng");
		lblNewLabel_1_1.setForeground(SetColor.whiteFont);
		lblNewLabel_1_1.setFont(SetFont.font());
		lblNewLabel_1_1.setBounds(401, 57, 61, 30);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblXungNhp = new JLabel("Xung nhịp");
		lblXungNhp.setFont(SetFont.font());
		lblXungNhp.setForeground(SetColor.whiteFont);
		lblXungNhp.setBounds(284, 122, 71, 30);
		contentPane.add(lblXungNhp);

		JLabel lblNewLabel_1_2 = new JLabel("Tồn kho");
		lblNewLabel_1_2.setForeground(SetColor.whiteFont);
		lblNewLabel_1_2.setFont(SetFont.font());
		lblNewLabel_1_2.setBounds(284, 257, 83, 30);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblinNngTiu = new JLabel("Điện năng tiêu thụ");
		lblinNngTiu.setForeground(SetColor.whiteFont);
		lblinNngTiu.setFont(SetFont.font());
		lblinNngTiu.setBounds(21, 257, 116, 30);
		contentPane.add(lblinNngTiu);

		tfSoNhan = new JTextField();
		tfSoNhan.setColumns(10);
		tfSoNhan.setBounds(351, 57, 45, 30);
		contentPane.add(tfSoNhan);

		tfXungNhip = new JTextField();
		tfXungNhip.setColumns(10);
		tfXungNhip.setBounds(351, 122, 141, 30);
		contentPane.add(tfXungNhip);

		tfTonKho = new JTextField();
		tfTonKho.setColumns(10);
		tfTonKho.setBounds(351, 257, 141, 30);
		contentPane.add(tfTonKho);

		tfDienNang = new JTextField();
		tfDienNang.setColumns(10);
		tfDienNang.setBounds(133, 257, 141, 30);
		contentPane.add(tfDienNang);

		tfSoLuong = new JTextField();
		tfSoLuong.setColumns(10);
		tfSoLuong.setBounds(447, 57, 45, 30);
		contentPane.add(tfSoLuong);

		JButton btnAdd = new JButton("Thêm");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (kiemTraIDCPU()) {
					JOptionPane.showMessageDialog(null, "ID CPU đã tồn tại");
				} else {

					String id = (String) comboBox.getSelectedItem();
					String ten = tfTenCPU.getText();
					String xungNhip = tfXungNhip.getText();
					int soNhan = Integer.parseInt(tfSoNhan.getText());
					int soLuong = Integer.parseInt(tfSoLuong.getText());
					String dienNang = tfDienNang.getText();
					String boNho = tfBoNhoDem.getText();
					double gia = Double.parseDouble(tfTonKho.getText());

					cpu c = new cpu();
					c.setIdSanPham(id);
					c.setIdCpu(tfIDCPU.getText());
					c.setNameCpu(ten);
					c.setXungNhip(xungNhip);
					c.setSoNhan(soNhan);
					c.setSoLuong(soLuong);
					c.setDienNangTieuThu(dienNang);
					c.setBoNhoDem(boNho);
					c.setTonKho(Integer.parseInt(tfTonKho.getText()));
					c.setDonGia(gia);

					cpuDAO.getInstance().insert(c);

					JOptionPane.showMessageDialog(null, "Thêm thành công");

					CPUForm.loadDataToTable(cpuDAO.getInstance().selectAll());

					closeFrame();
				}
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setFont(SetFont.font1_());
		btnAdd.setBounds(299, 319, 97, 30);
		contentPane.add(btnAdd);

		JButton btnCancel = new JButton("Hủy");
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
		btnCancel.setFont(SetFont.font1_());
		btnCancel.setBounds(429, 319, 97, 30);
		contentPane.add(btnCancel);

		JLabel lblNewLabel_1_1_1 = new JLabel("Bộ nhớ đệm");
		lblNewLabel_1_1_1.setForeground(SetColor.whiteFont);
		lblNewLabel_1_1_1.setFont(SetFont.font());
		lblNewLabel_1_1_1.setBounds(284, 192, 71, 30);
		contentPane.add(lblNewLabel_1_1_1);

		tfBoNhoDem = new JTextField();
		tfBoNhoDem.setColumns(10);
		tfBoNhoDem.setBounds(351, 191, 141, 30);
		contentPane.add(tfBoNhoDem);

		ArrayList<Products> list = SanPhamDAO.getIDSanPham("cpu");
		int size = list.size();
		String choose[] = new String[size];
		for (int i = 0; i < size; i++) {
			Products pr = list.get(i);
			choose[i] = pr.getIdSanPham();
		}
		comboBox = new JComboBox<String>();

		comboBox.setModel(new DefaultComboBoxModel<String>(choose));
		comboBox.setBounds(133, 57, 141, 30);
		contentPane.add(comboBox);

		JLabel lblTnCpu = new JLabel("Tên cpu");
		lblTnCpu.setForeground(SetColor.whiteFont);
		lblTnCpu.setFont(SetFont.font());
		lblTnCpu.setBounds(21, 188, 71, 30);
		contentPane.add(lblTnCpu);

		tfTenCPU = new JTextField();
		tfTenCPU.setColumns(10);
		tfTenCPU.setBounds(133, 188, 141, 30);
		contentPane.add(tfTenCPU);

		JLabel lblNewLabel_1 = new JLabel("© Copyright 2023, Bản quyền thuộc về NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_1.setForeground(SetColor.redB);
		lblNewLabel_1.setFont(SetFont.font());
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(101, 381, 389, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("THÊM CPU");
		lblNewLabel_2.setFont(SetFont.fontTitle());
		lblNewLabel_2.setForeground(SetColor.yellow);
		lblNewLabel_2.setBounds(10, 10, 267, 36);
		contentPane.add(lblNewLabel_2);

		JLabel lblIdCpu = new JLabel("ID CPU");
		lblIdCpu.setForeground(new Color(254, 254, 254));
		lblIdCpu.setFont(null);
		lblIdCpu.setBounds(21, 122, 71, 30);
		contentPane.add(lblIdCpu);

		tfIDCPU = new JTextField();
		tfIDCPU.setColumns(10);
		tfIDCPU.setBounds(133, 122, 141, 30);
		contentPane.add(tfIDCPU);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Đơn giá");
		lblNewLabel_1_2_1.setForeground(new Color(254, 254, 254));
		lblNewLabel_1_2_1.setFont(null);
		lblNewLabel_1_2_1.setBounds(19, 319, 83, 30);
		contentPane.add(lblNewLabel_1_2_1);
		
		tfDonGia = new JTextField();
		tfDonGia.setColumns(10);
		tfDonGia.setBounds(133, 319, 141, 30);
		contentPane.add(tfDonGia);
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

	private static void setDefaultIDCPU() {
		String id = "CPU";
		ArrayList<cpu> list = cpuDAO.getInstance().selectAll();
		int code = 1;
		for (cpu cpu : list) {
			if (cpu.getIdCpu().equals(id + code)) {
				code++;
			}else break;
		}
		tfIDCPU.setText(id+code);
	}
}
