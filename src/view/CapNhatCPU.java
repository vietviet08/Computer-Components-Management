package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
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
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

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

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 530, 447);
		contentPane = new JPanel();
		contentPane.setBackground(SetColor.blueOp);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSNhn = new JLabel("Số nhân");
		lblSNhn.setForeground(new Color(254, 254, 254));
		lblSNhn.setFont(SetFont.font());
		lblSNhn.setBounds(273, 53, 83, 30);
		contentPane.add(lblSNhn);

		tfSoNhan = new JTextField();
		tfSoNhan.setColumns(10);
		tfSoNhan.setBounds(340, 53, 45, 30);
		contentPane.add(tfSoNhan);

		tfSoluong = new JTextField();
		tfSoluong.setColumns(10);
		tfSoluong.setBounds(436, 53, 45, 30);
		contentPane.add(tfSoluong);

		JLabel lblTnCpu = new JLabel("Tên cpu");
		lblTnCpu.setForeground(new Color(254, 254, 254));
		lblTnCpu.setFont(SetFont.font());
		lblTnCpu.setBounds(10, 117, 71, 30);
		contentPane.add(lblTnCpu);

		tfTen = new JTextField();
		tfTen.setColumns(10);
		tfTen.setBounds(122, 117, 141, 30);
		contentPane.add(tfTen);

		JLabel lblXungNhp = new JLabel("Xung nhịp");
		lblXungNhp.setForeground(new Color(254, 254, 254));
		lblXungNhp.setFont(SetFont.font());
		lblXungNhp.setBounds(273, 118, 71, 30);
		contentPane.add(lblXungNhp);

		tfXungNhip = new JTextField();
		tfXungNhip.setColumns(10);
		tfXungNhip.setBounds(340, 122, 141, 30);
		contentPane.add(tfXungNhip);

		JLabel lblinNngTiu = new JLabel("Điện năng tiêu thụ");
		lblinNngTiu.setForeground(new Color(254, 254, 254));
		lblinNngTiu.setFont(SetFont.font());
		lblinNngTiu.setBounds(10, 186, 116, 30);
		contentPane.add(lblinNngTiu);

		tfDienNang = new JTextField();
		tfDienNang.setColumns(10);
		tfDienNang.setBounds(122, 186, 141, 30);
		contentPane.add(tfDienNang);

		JLabel lblNewLabel_1_1_1 = new JLabel("Bộ nhớ đệm");
		lblNewLabel_1_1_1.setForeground(new Color(254, 254, 254));
		lblNewLabel_1_1_1.setFont(SetFont.font());
		lblNewLabel_1_1_1.setBounds(273, 188, 71, 30);
		contentPane.add(lblNewLabel_1_1_1);

		tfBoNhoDem = new JTextField();
		tfBoNhoDem.setColumns(10);
		tfBoNhoDem.setBounds(340, 193, 141, 30);
		contentPane.add(tfBoNhoDem);

		JLabel lblNewLabel_1_2 = new JLabel("Tồn kho");
		lblNewLabel_1_2.setForeground(new Color(254, 254, 254));
		lblNewLabel_1_2.setFont(SetFont.font());
		lblNewLabel_1_2.setBounds(10, 257, 83, 30);
		contentPane.add(lblNewLabel_1_2);

		tfGia = new JTextField();
		tfGia.setColumns(10);
		tfGia.setBounds(340, 257, 141, 30);
		contentPane.add(tfGia);

		JButton btnCpNht = new JButton("Cập nhật");
		btnCpNht.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String idcpu = CPUForm.getSelectCPU().getIdCpu();
				String ten = tfTen.getText();
				String xn = tfXungNhip.getText();
				int sonhan = Integer.parseInt(tfSoNhan.getText());
				int soluong = Integer.parseInt(tfSoluong.getText());
				String dien = tfDienNang.getText();
				String bonho = tfBoNhoDem.getText();
				int tonkho = Integer.parseInt(tfTonKho.getText());
				double gia = Double.parseDouble(tfGia.getText());

//				Can them kiem tra idcpu de khong bi trung trong database

				String id = comboBox.getSelectedItem().toString();
				cpu cc = new cpu(id, idcpu, ten, xn, sonhan, soluong, dien, bonho, tonkho, gia);
//				System.out.println(c.getIdSanPham());

				cpuDAO.getInstance().update(cc);

				JOptionPane.showMessageDialog(null, "Cập nhật thành công");

				CPUForm.loadDataToTable(cpuDAO.getInstance().selectAll());

				closeFrame();

			}
		});
		btnCpNht.setFont(SetFont.font1_());
		btnCpNht.setBounds(172, 330, 97, 30);
		contentPane.add(btnCpNht);

		JButton btnCancel = new JButton("Hủy");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeFrame();

			}
		});
		btnCancel.setFont(SetFont.font1_());
		btnCancel.setBounds(281, 330, 97, 30);
		contentPane.add(btnCancel);

		JLabel lblSLung = new JLabel("Số luồng");
		lblSLung.setForeground(new Color(254, 254, 254));
		lblSLung.setFont(null);
		lblSLung.setBounds(390, 53, 83, 30);
		contentPane.add(lblSLung);

		JLabel lblIdSnPhm = new JLabel("ID sản phẩm");
		lblIdSnPhm.setForeground(new Color(254, 254, 254));
		lblIdSnPhm.setFont(null);
		lblIdSnPhm.setBounds(10, 53, 71, 30);
		contentPane.add(lblIdSnPhm);

		ArrayList<Products> list = SanPhamDAO.getIDSanPham("cpu");
		int size = list.size();
		String choose[] = new String[size];
		for (int i = 0; i < size; i++) {
			Products pr = list.get(i);
			choose[i] = pr.getIdSanPham();
		}
		comboBox = new JComboBox<>(new DefaultComboBoxModel<String>(choose));
		comboBox.setBounds(122, 57, 141, 26);
		contentPane.add(comboBox);

		JLabel label = new JLabel("Đơn giá");
		label.setForeground(new Color(254, 254, 254));
		label.setFont(null);
		label.setBounds(273, 257, 83, 30);
		contentPane.add(label);

		tfTonKho = new JTextField();
		tfTonKho.setColumns(10);
		tfTonKho.setBounds(122, 257, 141, 30);
		contentPane.add(tfTonKho);

		JLabel lblNewLabel = new JLabel("CẬP NHẬT CPU");
		lblNewLabel.setFont(SetFont.fontTitle());
		lblNewLabel.setForeground(SetColor.yellow);
		lblNewLabel.setBounds(10, 11, 169, 31);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("© Copyright 2023, Bản quyền thuộc về NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_1.setFont(SetFont.font());
		lblNewLabel_1.setForeground(SetColor.redB);
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
}