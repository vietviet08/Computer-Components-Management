package view;

import java.awt.EventQueue;
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
import javax.swing.SwingConstants;

import color.SetColor;
import dao.SanPhamDAO;
import font.SetFont;
import model.Products;

public class CapNhatProduct extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField tfTen;
	private static JTextField tfSoLuongTonKho;
	private JComboBox<String> comboBox;
//	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapNhatProduct frame = new CapNhatProduct();
					frame.setVisible(true);
					setTextToTF();
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
	public CapNhatProduct() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 533, 286);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 533, 286);
		panel.setBackground(SetColor.blueOp);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tên sản phẩm");
		lblNewLabel.setFont(SetFont.font1_());
		lblNewLabel.setForeground(SetColor.whiteFont);
		lblNewLabel.setBounds(66, 56, 173, 28);
		panel.add(lblNewLabel);

		tfTen = new JTextField();
		tfTen.setBorder(null);
		tfTen.setBounds(66, 91, 172, 28);
		panel.add(tfTen);
		tfTen.setColumns(10);

		JLabel lblIdNhPhn = new JLabel("ID nhà phân phối");
		lblIdNhPhn.setFont(SetFont.font1_());
		lblIdNhPhn.setBounds(275, 56, 173, 28);
		lblIdNhPhn.setForeground(SetColor.whiteFont);
		panel.add(lblIdNhPhn);

		JLabel lblNewLabel_1_1 = new JLabel("Số lượng tồn kho");
		lblNewLabel_1_1.setForeground(SetColor.whiteFont);
		lblNewLabel_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_1.setBounds(66, 150, 173, 28);
		panel.add(lblNewLabel_1_1);

		tfSoLuongTonKho = new JTextField();
		tfSoLuongTonKho.setBorder(null);
		tfSoLuongTonKho.setColumns(10);
		tfSoLuongTonKho.setBounds(66, 185, 172, 28);
		panel.add(tfSoLuongTonKho);

		JButton btnNewButton = new JButton("Cập nhật");
		btnNewButton.setBorder(null);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tfSoLuongTonKho.getText().equals("") || tfTen.equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!");

				} else {
					Products old = ProductForm.getProSelect();

					String idsp = old.getIdSanPham();
					String tensp = tfTen.getText();
					String idnpp = comboBox.getSelectedItem().toString();
					int soluontonkho = Integer.parseInt(tfSoLuongTonKho.getText());

					Products p = new Products(idsp, tensp, idnpp, soluontonkho);

					SanPhamDAO.getInstance().update(p);

					JOptionPane.showInternalMessageDialog(null, "Cập nhật thành công!");
					closeFrame();
				}
			}
		});
		btnNewButton.setFont(SetFont.font1());
		btnNewButton.setBounds(275, 182, 89, 34);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Hủy");
		btnNewButton_1.setBorder(null);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeFrame();
			}
		});
		btnNewButton_1.setFont(SetFont.font1());
		btnNewButton_1.setBounds(374, 182, 89, 34);
		panel.add(btnNewButton_1);

		ArrayList<Products> list = SanPhamDAO.getInstance().selectAll();
		String[] combo = new String[list.size()];
		for(int i = 0; i< list.size(); i++) {
			Products p = list.get(i);
			combo[i] = p.getIdNPP();
		}
		comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<String>(combo));
		comboBox.setBorder(null);
		comboBox.setBounds(274, 91, 189, 28);
		panel.add(comboBox);

		JLabel lblNewLabel_1 = new JLabel("CẬP NHẬT SẢN PHẨM");
		lblNewLabel_1.setFont(SetFont.fontTitle());
		lblNewLabel_1.setForeground(SetColor.yellow);
		lblNewLabel_1.setBounds(10, 11, 253, 28);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("© Copyright 2023, Bản quyền thuộc về NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_2.setFont(SetFont.font());
		lblNewLabel_2.setForeground(SetColor.redB);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(66, 260, 397, 19);
		panel.add(lblNewLabel_2);
		contentPane.setLayout(null);
	}

	private void closeFrame() {
		this.dispose();
	}
	
	private static  void setTextToTF() {
		Products pr = ProductForm.getProSelect();
		tfTen.setText(pr.getTenSanPham());
		tfSoLuongTonKho.setText(String.valueOf(pr.getSoLuongTonKho()));
	}
}
