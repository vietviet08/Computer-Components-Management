package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

public class CapNhatCPU extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField tfSoNhan;
	private static JTextField tfSoluong;
	private static JTextField tfTen;
	private static JTextField tfXungNhip;
	private static JTextField tfDienNang;
	private static JTextField tfBoNhoDem;
	private static JTextField tfGia;
	private static JComboBox<String> comboBox;
	private static JTextField tfTonKho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapNhatCPU frame = new CapNhatCPU();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					setTextToTf();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CapNhatCPU() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 518, 418);
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
				 GradientPaint gp = new GradientPaint(0, 0,new Color(102,125,182), 0, getHeight(), new Color(0,130,200));
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, getWidth(), getHeight());

			}
		};
		
		contentPane.setBackground(SetColor.blueOp);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSNhn = new JLabel("Số nhân");
		lblSNhn.setForeground(new Color(254, 254, 254));
		lblSNhn.setFont(SetFont.font1_());
		lblSNhn.setBounds(289, 53, 83, 30);
		contentPane.add(lblSNhn);

		tfSoNhan = new JTextField();
		tfSoNhan.setFont(SetFont.fontDetails());
		tfSoNhan.setColumns(10);
		tfSoNhan.setBounds(366, 53, 35, 30);
		contentPane.add(tfSoNhan);

		tfSoluong = new JTextField();
		tfSoluong.setColumns(10);
		tfSoluong.setFont(SetFont.fontDetails());
		tfSoluong.setBounds(473, 53, 35, 30);
		contentPane.add(tfSoluong);

		JLabel lblTnCpu = new JLabel("Tên cpu");
		lblTnCpu.setForeground(new Color(254, 254, 254));
		lblTnCpu.setFont(SetFont.font1_());
		lblTnCpu.setBounds(10, 117, 71, 30);
		contentPane.add(lblTnCpu);

		tfTen = new JTextField();
		tfTen.setFont(SetFont.fontDetails());
		tfTen.setColumns(10);
		tfTen.setBounds(128, 117, 141, 30);
		contentPane.add(tfTen);

		JLabel lblXungNhp = new JLabel("Xung nhịp");
		lblXungNhp.setForeground(new Color(254, 254, 254));
		lblXungNhp.setFont(SetFont.font1_());
		lblXungNhp.setBounds(289, 118, 83, 30);
		contentPane.add(lblXungNhp);

		tfXungNhip = new JTextField();
		tfXungNhip.setColumns(10);
		tfXungNhip.setFont(SetFont.fontDetails());
		tfXungNhip.setBounds(367, 117, 141, 30);
		contentPane.add(tfXungNhip);

		JLabel lblinNngTiu = new JLabel("Điện năng tiêu thụ");
		lblinNngTiu.setForeground(new Color(254, 254, 254));
		lblinNngTiu.setFont(SetFont.font1_());
		lblinNngTiu.setBounds(10, 186, 116, 30);
		contentPane.add(lblinNngTiu);

		tfDienNang = new JTextField();
		tfDienNang.setFont(SetFont.fontDetails());
		tfDienNang.setColumns(10);
		tfDienNang.setBounds(128, 186, 141, 30);
		contentPane.add(tfDienNang);

		JLabel lblNewLabel_1_1_1 = new JLabel("Bộ nhớ đệm");
		lblNewLabel_1_1_1.setForeground(new Color(254, 254, 254));
		lblNewLabel_1_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_1_1.setBounds(289, 188, 83, 30);
		contentPane.add(lblNewLabel_1_1_1);

		tfBoNhoDem = new JTextField();
		tfBoNhoDem.setFont(SetFont.fontDetails());
		tfBoNhoDem.setColumns(10);
		tfBoNhoDem.setBounds(367, 186, 141, 30);
		contentPane.add(tfBoNhoDem);

		JLabel lblNewLabel_1_2 = new JLabel("Tồn kho");
		lblNewLabel_1_2.setForeground(new Color(254, 254, 254));
		lblNewLabel_1_2.setFont(SetFont.font1_());
		lblNewLabel_1_2.setBounds(10, 257, 83, 30);
		contentPane.add(lblNewLabel_1_2);

		tfGia = new JTextField();
		tfGia.setFont(SetFont.fontDetails());
		tfGia.setColumns(10);
		tfGia.setBounds(367, 257, 141, 30);
		contentPane.add(tfGia);

		JButton btnCpNht = new JButton("Cập nhật");
		btnCpNht.setBorder(null);
		btnCpNht.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					updateCPU();
				}
			}
		});
		btnCpNht.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateCPU();

			}
		});
		btnCpNht.setFont(SetFont.font1());
		btnCpNht.setBounds(176, 330, 97, 30);
		contentPane.add(btnCpNht);

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
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeFrame();

			}
		});
		btnCancel.setFont(SetFont.font1());
		btnCancel.setBounds(285, 330, 97, 30);
		contentPane.add(btnCancel);

		JLabel lblSLung = new JLabel("Số luồng");
		lblSLung.setForeground(new Color(254, 254, 254));
		lblSLung.setFont(SetFont.font1_());
		lblSLung.setBounds(414, 53, 83, 30);
		contentPane.add(lblSLung);

		JLabel lblIdSnPhm = new JLabel("ID sản phẩm");
		lblIdSnPhm.setForeground(new Color(254, 254, 254));
		lblIdSnPhm.setFont(SetFont.font1_());
		lblIdSnPhm.setBounds(10, 53, 104, 30);
		contentPane.add(lblIdSnPhm);

		ArrayList<Products> list = SanPhamDAO.getIDSanPham("cpu");
		int size = list.size();
		String choose[] = new String[size];
		for (int i = 0; i < size; i++) {
			Products pr = list.get(i);
			choose[i] = pr.getIdSanPham();
		}
		comboBox = new JComboBox<>(new DefaultComboBoxModel<String>(choose));
		comboBox.setFont(SetFont.fontDetails());
		comboBox.setBounds(128, 53, 141, 30);
		contentPane.add(comboBox);

		JLabel label = new JLabel("Đơn giá");
		label.setForeground(new Color(254, 254, 254));
		label.setFont(SetFont.font1_());
		label.setBounds(289, 257, 83, 30);
		contentPane.add(label);

		tfTonKho = new JTextField();
		tfTonKho.setFont(SetFont.fontDetails());
		tfTonKho.setColumns(10);
		tfTonKho.setBounds(128, 257, 141, 30);
		contentPane.add(tfTonKho);

		JLabel lblNewLabel = new JLabel("CẬP NHẬT CPU");
		lblNewLabel.setFont(SetFont.fontTitle());
		lblNewLabel.setForeground(SetColor.yellow);
		lblNewLabel.setBounds(10, 11, 169, 31);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("© Copyright 2023, Bản quyền thuộc về NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_1.setFont(SetFont.font());
		lblNewLabel_1.setForeground(new Color(224, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 387, 498, 14);
		contentPane.add(lblNewLabel_1);
	}

	private void closeFrame() {
		this.dispose();
	}

	private static void setTextToTf() {
		cpu c = CPUForm.getSelectCPU();
		comboBox.setSelectedItem(c.getIdSanPham());
		tfTen.setText(c.getNameCpu());
		tfTonKho.setText(String.valueOf(c.getTonKho()));
		tfXungNhip.setText(c.getXungNhip());
		tfBoNhoDem.setText(c.getBoNhoDem());
		tfGia.setText(String.valueOf(c.getDonGia()));
		tfDienNang.setText(c.getDienNangTieuThu());
		tfSoluong.setText(String.valueOf(c.getSoLuong()));
		tfSoNhan.setText(String.valueOf(c.getSoNhan()));
	}

	private void updateCPU() {
		String idcpu = CPUForm.getSelectCPU().getIdCpu();
		String ten = tfTen.getText();
		String xn = tfXungNhip.getText();
		int sonhan = Integer.parseInt(tfSoNhan.getText());
		int soluong = Integer.parseInt(tfSoluong.getText());
		String dien = tfDienNang.getText();
		String bonho = tfBoNhoDem.getText();
		int tonkho = Integer.parseInt(tfTonKho.getText());
		double gia = Double.parseDouble(tfGia.getText());

//		Can them kiem tra idcpu de khong bi trung trong database

		String id = comboBox.getSelectedItem().toString();
		cpu cc = new cpu(id, idcpu, ten, xn, sonhan, soluong, dien, bonho, tonkho, gia);
//		System.out.println(c.getIdSanPham());

		cpuDAO.getInstance().update(cc);

		JOptionPane.showMessageDialog(null, "Cập nhật thành công");

		CPUForm.loadDataToTable(cpuDAO.getInstance().selectAll());

		closeFrame();
	}
}