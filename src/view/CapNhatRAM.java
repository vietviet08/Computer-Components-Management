package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import color.SetColor;
import dao.ramDAO;
import font.SetFont;
import model.ram;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CapNhatRAM extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField tfTen;
	private static JTextField tfLoai;
	private static JTextField tfBus;
	private static JTextField tfDungLuong;
	private static JTextField tfGia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapNhatRAM frame = new CapNhatRAM();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
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
	public CapNhatRAM() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 582, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setBackground(SetColor.blueOp);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CẬP NHẬT RAM");
		lblNewLabel.setForeground(SetColor.yellow);
		lblNewLabel.setFont(SetFont.fontTitle());
		lblNewLabel.setBounds(10, 11, 155, 39);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("© Copyright 2023, Bản quyền thuộc về NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_1.setFont(SetFont.font());
		lblNewLabel_1.setForeground(SetColor.redB);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(35, 292, 511, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Tên RAM");
		lblNewLabel_2.setFont(SetFont.font1_());
		lblNewLabel_2.setForeground(SetColor.whiteFont);
		lblNewLabel_2.setBounds(35, 70, 84, 28);
		contentPane.add(lblNewLabel_2);

		tfTen = new JTextField();
		tfTen.setBorder(null);
		tfTen.setBounds(115, 70, 164, 28);
		contentPane.add(tfTen);
		tfTen.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Loại RAM");
		lblNewLabel_2_1.setFont(SetFont.font1_());
		lblNewLabel_2_1.setForeground(SetColor.whiteFont);
		lblNewLabel_2_1.setBounds(302, 70, 84, 28);
		contentPane.add(lblNewLabel_2_1);

		tfLoai = new JTextField();
		tfLoai.setBorder(null);
		tfLoai.setColumns(10);
		tfLoai.setBounds(382, 70, 164, 28);
		contentPane.add(tfLoai);

		JLabel lblNewLabel_2_1_1 = new JLabel("BUS");
		lblNewLabel_2_1_1.setFont(SetFont.font1_());
		lblNewLabel_2_1_1.setForeground(SetColor.whiteFont);
		lblNewLabel_2_1_1.setBounds(302, 150, 84, 28);
		contentPane.add(lblNewLabel_2_1_1);

		tfBus = new JTextField();
		tfBus.setBorder(null);
		tfBus.setColumns(10);
		tfBus.setBounds(382, 150, 164, 28);
		contentPane.add(tfBus);

		tfDungLuong = new JTextField();
		tfDungLuong.setBorder(null);
		tfDungLuong.setColumns(10);
		tfDungLuong.setBounds(115, 150, 164, 28);
		contentPane.add(tfDungLuong);

		JLabel lblNewLabel_2_2 = new JLabel("Dung lượng");
		lblNewLabel_2_2.setFont(SetFont.font1_());
		lblNewLabel_2_2.setForeground(SetColor.whiteFont);
		lblNewLabel_2_2.setBounds(35, 150, 84, 28);
		contentPane.add(lblNewLabel_2_2);

		tfGia = new JTextField();
		tfGia.setBorder(null);
		tfGia.setColumns(10);
		tfGia.setBounds(115, 232, 164, 28);
		contentPane.add(tfGia);

		JLabel lblNewLabel_2_3 = new JLabel("Đơn giá");
		lblNewLabel_2_3.setFont(SetFont.font1_());
		lblNewLabel_2_3.setForeground(SetColor.whiteFont);
		lblNewLabel_2_3.setBounds(35, 232, 84, 28);
		contentPane.add(lblNewLabel_2_3);

		JButton btnNewButton = new JButton("Cập nhật");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				ram old = RAMForm.getSelectRAM();

				String id = old.getIdSanPham();

				ram r = new ram(id, tfTen.getText(), tfLoai.getText(), tfDungLuong.getText(), tfBus.getText(),
						Double.parseDouble(tfGia.getText()));

				ramDAO.getInstance().update(r);
				JOptionPane.showMessageDialog(null, "Cập nhật thành công");
				closeFrame();
			}
		});
		btnNewButton.setFont(SetFont.font1());
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(302, 230, 112, 35);
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
		btnNewButton_1.setBounds(435, 230, 112, 35);
		contentPane.add(btnNewButton_1);
	}

	private void closeFrame() {
		this.dispose();
	}

	private static void setDefaultTF() {
		ram r = RAMForm.getSelectRAM();
		tfTen.setText(r.getTenRam());
		tfLoai.setText(r.getLoai());
		tfBus.setText(r.getBus());
		tfGia.setText(String.valueOf(r.getDonGia()));
		tfDungLuong.setText(r.getDungLuong());
	}

}
