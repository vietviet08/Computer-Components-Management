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
import javax.swing.border.EmptyBorder;

import color.SetColor;
import dao.NhaPhanPhoiDAO;
import dao.SanPhamDAO;
import font.SetFont;
import model.NhaPhanPhoi;
import model.Products;

public class ThemProduct extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfIDSP;
	private JTextField tfTenSP;
	private JTextField tfSL;
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemProduct frame = new ThemProduct();
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
	public ThemProduct() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 539, 292);
		contentPane = new JPanel();
		contentPane.setBackground(SetColor.blueOp);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfIDSP = new JTextField();
		tfIDSP.setColumns(10);
		tfIDSP.setBorder(null);
		tfIDSP.setBounds(10, 67, 231, 31);
		contentPane.add(tfIDSP);

		JLabel lblIdSnPhm = new JLabel("ID sản phẩm");
		lblIdSnPhm.setForeground(SetColor.whiteFont);
		lblIdSnPhm.setFont(SetFont.font1_());
		lblIdSnPhm.setBounds(10, 36, 231, 31);
		contentPane.add(lblIdSnPhm);

		JLabel lblTnSnPhm = new JLabel("Tên sản phẩm");
		lblTnSnPhm.setForeground(SetColor.whiteFont);
		lblTnSnPhm.setFont(SetFont.font1_());
		lblTnSnPhm.setBounds(285, 36, 231, 31);
		contentPane.add(lblTnSnPhm);

		tfTenSP = new JTextField();
		tfTenSP.setColumns(10);
		tfTenSP.setBorder(null);
		tfTenSP.setBounds(285, 67, 231, 31);
		contentPane.add(tfTenSP);

		JLabel lblNewLabel_1_1 = new JLabel("Số lượng tồn kho");
		lblNewLabel_1_1.setForeground(SetColor.whiteFont);
		lblNewLabel_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_1.setBounds(285, 109, 231, 31);
		contentPane.add(lblNewLabel_1_1);

		tfSL = new JTextField();
		tfSL.setColumns(10);
		tfSL.setBorder(null);
		tfSL.setBounds(285, 140, 231, 31);
		contentPane.add(tfSL);

		JLabel lblNewLabel_2 = new JLabel("ID Nhà phân phối");
		lblNewLabel_2.setForeground(SetColor.whiteFont);
		lblNewLabel_2.setFont(SetFont.font1_());
		lblNewLabel_2.setBounds(10, 109, 231, 31);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("THÊM SẢN PHẨM");
		lblNewLabel_3.setFont(SetFont.fontTitle());
		lblNewLabel_3.setForeground(SetColor.yellow);
		lblNewLabel_3.setBounds(10, 11, 182, 23);
		contentPane.add(lblNewLabel_3);

		JButton btnAdd = new JButton("Thêm ");
		btnAdd.setFont(SetFont.font1());
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (tfIDSP.getText().equals("") || tfSL.equals("") || tfTenSP.equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
				} else {
					String idsp = tfIDSP.getText();
					String ten = tfTenSP.getText();
					int soluongtonkho = Integer.parseInt(tfSL.getText());
					String idnpp = comboBox.getSelectedItem().toString();

					Products pro = new Products(idsp, ten, idnpp, soluongtonkho);

					SanPhamDAO.getInstance().insert(pro);

					JOptionPane.showMessageDialog(null, "Thêm thành công");
					ProductForm.loadDataToTable(SanPhamDAO.getInstance().selectAll());
					closeFrame();
				}
			}
		});
		btnAdd.setBounds(130, 215, 111, 31);
		contentPane.add(btnAdd);

		JButton btnHuy = new JButton("Hủy");
		btnHuy.setFont(SetFont.font1());
		btnHuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeFrame();
			}
		});
		btnHuy.setBounds(285, 215, 111, 31);
		contentPane.add(btnHuy);

		ArrayList<NhaPhanPhoi> list = NhaPhanPhoiDAO.getInstance().selectAll();
		String[] comboID = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			NhaPhanPhoi npp = list.get(i);
			comboID[i] = npp.getIdNPP();
		}

		comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<String>(comboID));
		comboBox.setBounds(10, 140, 231, 31);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("© Copyright 2023, Bản quyền thuộc về NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel.setFont(SetFont.font());
		lblNewLabel.setForeground(SetColor.redB);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(75, 267, 399, 14);
		contentPane.add(lblNewLabel);
	}

	private void closeFrame() {
		this.dispose();
	}
}
