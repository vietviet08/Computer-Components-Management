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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private static JTextField tfIDRAM;
	private JTextField tfTonKho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemRAM frame = new ThemRAM();
					frame.setLocationRelativeTo(null);
					setDefaultIDRAM();
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
		setBounds(100, 100, 520, 315);
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
		lblNewLabel_1.setBounds(257, 92, 83, 23);
		contentPane.add(lblNewLabel_1);

		tfTen = new JTextField();
		tfTen.setBorder(null);
		tfTen.setBounds(350, 90, 142, 26);
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
		lblNewLabel_1_1_1.setBounds(10, 148, 83, 23);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Dung lượng");
		lblNewLabel_1_2.setFont(SetFont.font1_());
		lblNewLabel_1_2.setForeground(SetColor.whiteFont);
		lblNewLabel_1_2.setBounds(257, 148, 83, 23);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Đơn giá");
		lblNewLabel_1_3.setFont(SetFont.font1_());
		lblNewLabel_1_3.setForeground(SetColor.whiteFont);
		lblNewLabel_1_3.setBounds(257, 200, 83, 23);
		contentPane.add(lblNewLabel_1_3);

		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (kiemTraIDRAM())
					JOptionPane.showMessageDialog(null, "ID RAM đã tồn tại!");
				else {

					String id = comboBox.getSelectedItem().toString();
					String idram = tfIDRAM.getText();
					String ten = tfTen.getText();
					String loai = tfLoai.getText();
					String dungluong = tfDungLuong.getText();
					String bus = tfBus.getText();
					int tonkho = Integer.parseInt(tfTonKho.getText());
					double gia = Double.parseDouble(tfGia.getText());

					if (tfTen.getText().equals("") || tfLoai.getText().equals("") || tfDungLuong.getText().equals("")
							|| tfBus.getText().equals("") || tfGia.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
					} else {
						ram r = new ram(id, idram, ten, loai, dungluong, bus, tonkho, gia);
						ramDAO.getInstance().insert(r);
						JOptionPane.showMessageDialog(null, "Thêm thành công");
						RAMForm.loadDataToTable(ramDAO.getInstance().selectAll());
						closeFrame();
					}
				}
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setFont(SetFont.font1());
		btnNewButton.setBounds(142, 243, 89, 35);
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
		btnHy.setBounds(284, 243, 89, 35);
		contentPane.add(btnHy);

		tfLoai = new JTextField();
		tfLoai.setBorder(null);
		tfLoai.setColumns(10);
		tfLoai.setBounds(99, 92, 142, 26);
		contentPane.add(tfLoai);

		tfDungLuong = new JTextField();
		tfDungLuong.setBorder(null);
		tfDungLuong.setColumns(10);
		tfDungLuong.setBounds(350, 146, 142, 26);
		contentPane.add(tfDungLuong);

		tfBus = new JTextField();
		tfBus.setBorder(null);
		tfBus.setColumns(10);
		tfBus.setBounds(99, 145, 142, 26);
		contentPane.add(tfBus);

		tfGia = new JTextField();
		tfGia.setBorder(null);
		tfGia.setColumns(10);
		tfGia.setBounds(350, 198, 142, 26);
		contentPane.add(tfGia);

		JLabel lblNewLabel_2 = new JLabel("© Copyright 2023, Bản quyền thuộc về NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_2.setForeground(SetColor.redB);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 289, 482, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_1_4 = new JLabel("ID sản phẩm");
		lblNewLabel_1_4.setForeground(new Color(254, 254, 254));
		lblNewLabel_1_4.setFont(SetFont.font1_());
		lblNewLabel_1_4.setBounds(10, 41, 83, 23);
		contentPane.add(lblNewLabel_1_4);

		ArrayList<Products> list = SanPhamDAO.getIDSanPham("ram");
		String[] combo = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			Products p = list.get(i);
			combo[i] = p.getIdSanPham();
		}

		comboBox = new JComboBox<>(new DefaultComboBoxModel<String>(combo));
		comboBox.setBounds(99, 36, 142, 26);
		contentPane.add(comboBox);

		JLabel lblNewLabel_1_5 = new JLabel("ID RAM");
		lblNewLabel_1_5.setForeground(new Color(254, 254, 254));
		lblNewLabel_1_5.setFont(SetFont.font1_());
		lblNewLabel_1_5.setBounds(261, 41, 83, 23);
		contentPane.add(lblNewLabel_1_5);

		tfIDRAM = new JTextField();
		tfIDRAM.setColumns(10);
		tfIDRAM.setBorder(null);
		tfIDRAM.setBounds(350, 41, 142, 26);
		contentPane.add(tfIDRAM);

		tfTonKho = new JTextField();
		tfTonKho.setColumns(10);
		tfTonKho.setBorder(null);
		tfTonKho.setBounds(99, 198, 142, 26);
		contentPane.add(tfTonKho);

		JLabel lblNewLabel_1_5_1 = new JLabel("Tồn kho");
		lblNewLabel_1_5_1.setForeground(new Color(254, 254, 254));
		lblNewLabel_1_5_1.setFont(SetFont.font1_());
		lblNewLabel_1_5_1.setBounds(10, 198, 83, 23);
		contentPane.add(lblNewLabel_1_5_1);
	}

	private void closeFrame() {
		this.dispose();
	}

	private boolean kiemTraIDRAM() {
		ArrayList<ram> list = ramDAO.getInstance().selectAll();

		for (ram ram : list) {
			if (ram.getIdRam().equals(tfIDRAM.getText()))
				return true;
		}
		return false;
	}

	private static void setDefaultIDRAM() {
		String id = "r";
		int code = 1;
		ArrayList<ram> list = ramDAO.getInstance().selectAll();
		for (ram ram : list) {
			if (ram.getIdRam().equals(id + code)) {
				code++;
			} else
				break;
		}
		tfIDRAM.setText(id+code);
	}

}
