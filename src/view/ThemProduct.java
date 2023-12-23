package view;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import color.SetColor;
import dao.NhaPhanPhoiDAO;
import dao.SanPhamDAO;
import font.SetFont;
import model.NhaPhanPhoi;
import model.Products;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ThemProduct extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfIDSP;
	private JTextField tfTenSP;
	private JTextField tfTrangThai;
	private JTextArea txtMoTa;

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

		JLabel lblNewLabel_1_1 = new JLabel("Mô tả");
		lblNewLabel_1_1.setForeground(SetColor.whiteFont);
		lblNewLabel_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_1.setBounds(285, 109, 231, 31);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2 = new JLabel("Trạng thái");
		lblNewLabel_2.setForeground(SetColor.whiteFont);
		lblNewLabel_2.setFont(SetFont.font1_());
		lblNewLabel_2.setBounds(10, 109, 231, 31);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("THÊM SẢN PHẨM");
		lblNewLabel_3.setFont(SetFont.fontTitle());
		lblNewLabel_3.setForeground(SetColor.yellow);
		lblNewLabel_3.setBounds(10, 11, 182, 23);
		contentPane.add(lblNewLabel_3);

		JButton btnAdd = new JButton("Thêm");
		btnAdd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					addProduct();
				}
			}
		});
		btnAdd.setFont(SetFont.font1());
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				addProduct();
			}
		});
		btnAdd.setBounds(10, 213, 111, 31);
		contentPane.add(btnAdd);

		JButton btnHuy = new JButton("Hủy");
		btnHuy.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					closeFrame();
				}
			}
		});
		btnHuy.setFont(SetFont.font1());
		btnHuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeFrame();
			}
		});
		btnHuy.setBounds(130, 213, 111, 31);
		contentPane.add(btnHuy);

		ArrayList<NhaPhanPhoi> list = NhaPhanPhoiDAO.getInstance().selectAll();
		String[] comboID = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			NhaPhanPhoi npp = list.get(i);
			comboID[i] = npp.getIdNPP();
		}

		JLabel lblNewLabel = new JLabel("© Copyright 2023, Bản quyền thuộc về NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel.setFont(SetFont.font());
		lblNewLabel.setForeground(SetColor.redB);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(75, 267, 399, 14);
		contentPane.add(lblNewLabel);

		txtMoTa = new JTextArea();
		txtMoTa.setBounds(285, 143, 231, 101);
		contentPane.add(txtMoTa);

		tfTrangThai = new JTextField();
		tfTrangThai.setColumns(10);
		tfTrangThai.setBorder(null);
		tfTrangThai.setBounds(10, 145, 231, 31);
		contentPane.add(tfTrangThai);
	}

	private void closeFrame() {
		this.dispose();
	}

	private boolean kiemTraID() {
		ArrayList<Products> list = SanPhamDAO.getInstance().selectAll();
		for (Products products : list) {
			if (products.getIdSanPham().equals(tfIDSP.getText()))
				return true;
		}
		return false;
	}

	private void addProduct() {
		if (tfIDSP.getText().equals("") || tfTrangThai.equals("") || tfTenSP.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
		} else {
			if (kiemTraID()) {
				JOptionPane.showMessageDialog(null, "ID sản phẩm đã tồn tại!");
			} else {

				String idsp = tfIDSP.getText();
				String ten = tfTenSP.getText();
				int trangthai = Integer.parseInt(tfTrangThai.getText());
				String mota = txtMoTa.getText();

				Products pro = new Products(idsp, ten, trangthai, mota);

				SanPhamDAO.getInstance().insert(pro);

				JOptionPane.showMessageDialog(null, "Thêm thành công");
				ProductForm.loadDataToTable(SanPhamDAO.getInstance().selectAll());
				closeFrame();
			}
		}
	}
}
