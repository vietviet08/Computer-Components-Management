package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import color.SetColor;
import dao.SanPhamDAO;
import dao.ramDAO;
import font.SetFont;
import model.Products;
import model.ram;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JComboBox;

public class ThemRAM extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfTen;
	private JTextField tfLoai;
	private JTextField tfDungLuong;
	private JTextField tfBus;
	private JTextField tfGia;
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemRAM frame = new ThemRAM();
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
	public ThemRAM() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 520, 295);
		contentPane = new JPanel();
		contentPane.setBackground(SetColor.blueOp);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("THÊM RAM");
		lblNewLabel.setFont(SetFont.fontTitle());
		lblNewLabel.setForeground(SetColor.yellow);
		lblNewLabel.setBounds(10, 0, 212, 35);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tên RAM");
		lblNewLabel_1.setFont(SetFont.font1_());
		lblNewLabel_1.setForeground(SetColor.whiteFont);
		lblNewLabel_1.setBounds(261, 38, 83, 23);
		contentPane.add(lblNewLabel_1);

		tfTen = new JTextField();
		tfTen.setBorder(null);
		tfTen.setBounds(350, 38, 142, 26);
		contentPane.add(tfTen);
		tfTen.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Loại RAM");
		lblNewLabel_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_1.setForeground(SetColor.whiteFont);
		lblNewLabel_1_1.setBounds(10, 90, 83, 23);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("BUS");
		lblNewLabel_1_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_1_1.setForeground(SetColor.whiteFont);
		lblNewLabel_1_1_1.setBounds(10, 162, 83, 23);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Dung lượng");
		lblNewLabel_1_2.setFont(SetFont.font1_());
		lblNewLabel_1_2.setForeground(SetColor.whiteFont);
		lblNewLabel_1_2.setBounds(261, 94, 83, 23);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Đơn giá");
		lblNewLabel_1_3.setFont(SetFont.font1_());
		lblNewLabel_1_3.setForeground(SetColor.whiteFont);
		lblNewLabel_1_3.setBounds(261, 161, 83, 23);
		contentPane.add(lblNewLabel_1_3);

		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = comboBox.getSelectedItem().toString();
				String ten = tfTen.getText();
				String loai = tfLoai.getText();
				String dungluong = tfDungLuong.getText();
				String bus = tfBus.getText();
				double gia = Double.parseDouble(tfGia.getText());

				if (tfTen.getText().equals("") || tfLoai.getText().equals("") || tfDungLuong.getText().equals("")
						|| tfBus.getText().equals("") || tfGia.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
				} else {
					ram r = new ram(id, ten, loai, dungluong, bus, gia);
					ramDAO.getInstance().insert(r);
					JOptionPane.showMessageDialog(null, "Thêm thành công");
					RAMForm.loadDataToTable(ramDAO.getInstance().selectAll());
					closeFrame();
				}
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setFont(SetFont.font1());
		btnNewButton.setBounds(141, 218, 89, 35);
		contentPane.add(btnNewButton);

		JButton btnHy = new JButton("Hủy");
		btnHy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeFrame();
			}
		});
		btnHy.setBorder(null);
		btnHy.setFont(SetFont.font1());
		btnHy.setBounds(283, 218, 89, 35);
		contentPane.add(btnHy);

		tfLoai = new JTextField();
		tfLoai.setBorder(null);
		tfLoai.setColumns(10);
		tfLoai.setBounds(99, 92, 142, 26);
		contentPane.add(tfLoai);

		tfDungLuong = new JTextField();
		tfDungLuong.setBorder(null);
		tfDungLuong.setColumns(10);
		tfDungLuong.setBounds(350, 91, 142, 26);
		contentPane.add(tfDungLuong);

		tfBus = new JTextField();
		tfBus.setBorder(null);
		tfBus.setColumns(10);
		tfBus.setBounds(99, 159, 142, 26);
		contentPane.add(tfBus);

		tfGia = new JTextField();
		tfGia.setBorder(null);
		tfGia.setColumns(10);
		tfGia.setBounds(350, 159, 142, 26);
		contentPane.add(tfGia);

		JLabel lblNewLabel_2 = new JLabel("© Copyright 2023, Bản quyền thuộc về NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_2.setForeground(SetColor.redB);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 264, 482, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_1_4 = new JLabel("ID sản phẩm");
		lblNewLabel_1_4.setForeground(new Color(254, 254, 254));
		lblNewLabel_1_4.setFont(null);
		lblNewLabel_1_4.setBounds(10, 41, 83, 23);
		contentPane.add(lblNewLabel_1_4);

		ArrayList<Products> list = SanPhamDAO.getIDSanPham("ram");
		String[] combo = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			Products p = list.get(i);
			combo[i] = p.getIdNPP();
		}

		comboBox = new JComboBox<>(new DefaultComboBoxModel<String>(combo));
		comboBox.setBounds(99, 36, 142, 26);
		contentPane.add(comboBox);
	}

	private void closeFrame() {
		this.dispose();
	}

}
