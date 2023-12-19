package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import color.SetColor;
import dao.cpuDAO;
import font.SetFont;
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
		setBounds(100, 100, 530, 318);
		contentPane = new JPanel();
		contentPane.setBackground(SetColor.blueOp);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSNhn = new JLabel("Số nhân");
		lblSNhn.setForeground(new Color(254, 254, 254));
		lblSNhn.setFont(SetFont.font());
		lblSNhn.setBounds(273, 11, 83, 30);
		contentPane.add(lblSNhn);

		tfSoNhan = new JTextField();
		tfSoNhan.setColumns(10);
		tfSoNhan.setBounds(340, 11, 45, 30);
		contentPane.add(tfSoNhan);

		tfSoluong = new JTextField();
		tfSoluong.setColumns(10);
		tfSoluong.setBounds(436, 11, 45, 30);
		contentPane.add(tfSoluong);

		JLabel lblTnCpu = new JLabel("Tên cpu");
		lblTnCpu.setForeground(new Color(254, 254, 254));
		lblTnCpu.setFont(SetFont.font());
		lblTnCpu.setBounds(10, 11, 71, 30);
		contentPane.add(lblTnCpu);

		tfTen = new JTextField();
		tfTen.setColumns(10);
		tfTen.setBounds(122, 11, 141, 30);
		contentPane.add(tfTen);

		JLabel lblXungNhp = new JLabel("Xung nhịp");
		lblXungNhp.setForeground(new Color(254, 254, 254));
		lblXungNhp.setFont(SetFont.font());
		lblXungNhp.setBounds(273, 76, 71, 30);
		contentPane.add(lblXungNhp);

		tfXungNhip = new JTextField();
		tfXungNhip.setColumns(10);
		tfXungNhip.setBounds(340, 76, 141, 30);
		contentPane.add(tfXungNhip);

		JLabel lblinNngTiu = new JLabel("Điện năng tiêu thụ");
		lblinNngTiu.setForeground(new Color(254, 254, 254));
		lblinNngTiu.setFont(SetFont.font());
		lblinNngTiu.setBounds(10, 80, 116, 30);
		contentPane.add(lblinNngTiu);

		tfDienNang = new JTextField();
		tfDienNang.setColumns(10);
		tfDienNang.setBounds(122, 80, 141, 30);
		contentPane.add(tfDienNang);

		JLabel lblNewLabel_1_1_1 = new JLabel("Bộ nhớ đệm");
		lblNewLabel_1_1_1.setForeground(new Color(254, 254, 254));
		lblNewLabel_1_1_1.setFont(SetFont.font());
		lblNewLabel_1_1_1.setBounds(273, 146, 71, 30);
		contentPane.add(lblNewLabel_1_1_1);

		tfBoNhoDem = new JTextField();
		tfBoNhoDem.setColumns(10);
		tfBoNhoDem.setBounds(340, 145, 141, 30);
		contentPane.add(tfBoNhoDem);

		JLabel lblNewLabel_1_2 = new JLabel("Đơn giá");
		lblNewLabel_1_2.setForeground(new Color(254, 254, 254));
		lblNewLabel_1_2.setFont(SetFont.font());
		lblNewLabel_1_2.setBounds(10, 151, 83, 30);
		contentPane.add(lblNewLabel_1_2);

		tfGia = new JTextField();
		tfGia.setColumns(10);
		tfGia.setBounds(122, 151, 141, 30);
		contentPane.add(tfGia);

		JButton btnCpNht = new JButton("Cập nhật");
		btnCpNht.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String ten = tfTen.getText();
				String xn = tfXungNhip.getText();
				int sonhan = Integer.parseInt(tfSoNhan.getText());
				int soluong = Integer.parseInt(tfSoluong.getText());
				String dien = tfDienNang.getText();
				String bonho = tfBoNhoDem.getText();
				double gia = Double.parseDouble(tfGia.getText());

				cpu c = CPUForm.getSelectCPU();
				String id = c.getIdSanPham();
				cpu cc = new cpu(id, ten, xn, sonhan, soluong, dien, bonho, gia);
				System.out.println(c.getIdSanPham());

				cpuDAO.getInstance().update(cc);

				JOptionPane.showMessageDialog(null, "Cập nhật thành công");

				CPUForm.loadDataToTable(cpuDAO.getInstance().selectAll());

				closeFrame();

			}
		});
		btnCpNht.setFont(SetFont.font1_());
		btnCpNht.setBounds(164, 216, 97, 30);
		contentPane.add(btnCpNht);

		JButton btnCancel = new JButton("Hủy");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeFrame();

			}
		});
		btnCancel.setFont(SetFont.font1_());
		btnCancel.setBounds(273, 216, 97, 30);
		contentPane.add(btnCancel);

		JLabel lblSLung = new JLabel("Số luồng");
		lblSLung.setForeground(new Color(254, 254, 254));
		lblSLung.setFont(null);
		lblSLung.setBounds(390, 11, 83, 30);
		contentPane.add(lblSLung);
	}

	private void closeFrame() {
		this.dispose();
	}

	private static void setTextToTf() {
		cpu c = CPUForm.getSelectCPU();

		tfTen.setText(c.getNameCpu());
		tfXungNhip.setText(c.getXungNhip());
		tfBoNhoDem.setText(c.getBoNhoDem());
		tfGia.setText(String.valueOf(c.getDonGia()));
		tfDienNang.setText(c.getDienNangTieuThu());
		tfSoluong.setText(String.valueOf(c.getSoLuong()));
		tfSoNhan.setText(String.valueOf(c.getSoNhan()));
	}
}