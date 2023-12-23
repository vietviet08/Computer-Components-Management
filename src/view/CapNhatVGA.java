package view;

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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import color.SetColor;
import dao.SanPhamDAO;
import dao.vgaDAO;
import font.SetFont;
import model.Products;
import model.vga;
import java.awt.Color;
import javax.swing.JComboBox;

public class CapNhatVGA extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField tfTen;
	private static JTextField tfBoNho;
	private static JTextField tfDonGia;
	private static JTextField tfHang;
	private static JTextField tfTonKho;
	private static JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapNhatVGA frame = new CapNhatVGA();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					setDefaultTF();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CapNhatVGA() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 588, 288);
		contentPane = new JPanel();
		contentPane.setBackground(SetColor.blueOp);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CẬP NHẬT VGA");
		lblNewLabel.setFont(SetFont.fontTitle());
		lblNewLabel.setForeground(SetColor.yellow);
		lblNewLabel.setBounds(10, 11, 158, 29);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("© Copyright 2023, Bản quyền thuộc về NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_1.setForeground(SetColor.redB);
		lblNewLabel_1.setFont(SetFont.font());
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(32, 268, 507, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblTnVga = new JLabel("Tên VGA");
		lblTnVga.setForeground(SetColor.whiteFont);
		lblTnVga.setFont(SetFont.font1_());
		lblTnVga.setBounds(293, 57, 78, 25);
		contentPane.add(lblTnVga);

		tfTen = new JTextField();
		tfTen.setFont(SetFont.font());
		tfTen.setBorder(null);
		tfTen.setBounds(381, 57, 158, 25);
		contentPane.add(tfTen);
		tfTen.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Hãng");
		lblNewLabel_2_1.setForeground(SetColor.whiteFont);
		lblNewLabel_2_1.setFont(SetFont.font1_());
		lblNewLabel_2_1.setBounds(20, 117, 78, 25);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Đơn giá");
		lblNewLabel_2_1_1.setForeground(SetColor.whiteFont);
		lblNewLabel_2_1_1.setFont(SetFont.font1_());
		lblNewLabel_2_1_1.setBounds(293, 176, 78, 25);
		contentPane.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_2 = new JLabel("Bộ nhớ");
		lblNewLabel_2_2.setForeground(SetColor.whiteFont);
		lblNewLabel_2_2.setFont(SetFont.font1_());
		lblNewLabel_2_2.setBounds(293, 117, 78, 25);
		contentPane.add(lblNewLabel_2_2);

		JButton btnNewButton = new JButton("Cập nhật");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vga v = VGAForm.getVGASelect();

				vga vvga = new vga(v.getIdVga(), comboBox.getSelectedItem().toString(), tfTen.getText(),
						tfHang.getText(), tfBoNho.getText(), Integer.parseInt(tfTonKho.getText()),
						Double.parseDouble(tfDonGia.getText()));
				vgaDAO.getInstance().update(vvga);
				JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
				VGAForm.loadDataToTable(vgaDAO.getInstance().selectAll());
				closeFrame();
			}
		});
		btnNewButton.setFont(SetFont.font1());
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(170, 227, 89, 30);
		contentPane.add(btnNewButton);

		JButton btnHy = new JButton("Hủy");
		btnHy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeFrame();
			}
		});
		btnHy.setFont(SetFont.font1());
		btnHy.setBorder(null);
		btnHy.setBounds(298, 227, 89, 30);
		contentPane.add(btnHy);

		tfBoNho = new JTextField();
		tfBoNho.setFont(SetFont.font());
		tfBoNho.setColumns(10);
		tfBoNho.setBorder(null);
		tfBoNho.setBounds(381, 117, 158, 25);
		contentPane.add(tfBoNho);

		tfDonGia = new JTextField();
		tfDonGia.setFont(SetFont.font());
		tfDonGia.setColumns(10);
		tfDonGia.setBorder(null);
		tfDonGia.setBounds(381, 176, 158, 25);
		contentPane.add(tfDonGia);

		tfHang = new JTextField();
		tfHang.setFont(SetFont.font());
		tfHang.setColumns(10);
		tfHang.setBorder(null);
		tfHang.setBounds(101, 117, 158, 25);
		contentPane.add(tfHang);

		JLabel lblNewLabel_2_1_2 = new JLabel("ID sản phẩm");
		lblNewLabel_2_1_2.setForeground(new Color(254, 254, 254));
		lblNewLabel_2_1_2.setFont(SetFont.font1_());
		lblNewLabel_2_1_2.setBounds(20, 57, 78, 25);
		contentPane.add(lblNewLabel_2_1_2);

		ArrayList<Products> list = SanPhamDAO.getIDSanPham("vga");
		String[] combo = new String[list.size()];

		for (int i = 0; i < list.size(); i++) {
			Products p = list.get(i);
			combo[i] = p.getIdSanPham();
		}

		comboBox = new JComboBox<>(new DefaultComboBoxModel<String>(combo));
		comboBox.setFont(SetFont.font());
		comboBox.setBounds(101, 57, 158, 25);
		contentPane.add(comboBox);

		JLabel lblNewLabel_2_1_3 = new JLabel("Tồn kho");
		lblNewLabel_2_1_3.setForeground(new Color(254, 254, 254));
		lblNewLabel_2_1_3.setFont(SetFont.font1_());
		lblNewLabel_2_1_3.setBounds(20, 176, 78, 25);
		contentPane.add(lblNewLabel_2_1_3);

		tfTonKho = new JTextField();
		tfTonKho.setFont(SetFont.font());
		tfTonKho.setColumns(10);
		tfTonKho.setBorder(null);
		tfTonKho.setBounds(101, 176, 158, 25);
		contentPane.add(tfTonKho);
	}

	private void closeFrame() {
		this.dispose();
	}

	private static void setDefaultTF() {
		vga v = VGAForm.getVGASelect();
		comboBox.setSelectedItem(v.getIdSanPham());
		tfTen.setText(v.getTenVGA());
		tfBoNho.setText(v.getBoNho());
		tfDonGia.setText(String.valueOf(v.getDonGia()));
		tfTonKho.setText(String.valueOf(v.getTonKho()));
		tfHang.setText(v.getHangVGA());
	}

}
