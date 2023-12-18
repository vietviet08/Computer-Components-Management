package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.SanPhamDAO;
import dao.cpuDAO;
import model.Products;
import model.cpu;

public class ProductForm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Font font;
	public Font font_1;
	public Font font1;
	public Font font2;
	private static JTable table;
	private static DefaultTableModel tableModel;
	private final String columName[] = { "ID sản phẩm", "Tên sản phẩm", "ID nhà phân phối", "Số lượng tồn kho" };
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductForm frame = new ProductForm();
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

	public static void loadDataToTable(ArrayList<Products> pr) {
		try {
			tableModel.setRowCount(0);
			for (Products i : pr) {
				tableModel.addRow(
						new Object[] { i.getIdSanPham(), i.getTenSanPham(), i.getIdNPP(), i.getSoLuongTonKho() });
			}
		} catch (Exception e) {
		}
	}

	public void setDefaultTable() {
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columName);
		table.setDefaultEditor(Object.class, null);
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(500);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		loadDataToTable(SanPhamDAO.getInstance().selectAll());
	}

	public ProductForm() {

		try {
			File fontStyle = new File("src/font/Roboto-Medium.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(11f);
			font_1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(14f);
			font1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(16f);
			font2 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(22f);

		} catch (Exception e) {
			System.out.println(e);
		}

		setBounds(100, 100, 1200, 530);
		getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 629, 49);
		getContentPane().add(panel_1);

		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.setFont(font);
		btnNewButton_1.setIcon(new ImageIcon(ProductForm.class.getResource("/icon/icons8-add-24.png")));
		btnNewButton_1.setBounds(10, 8, 99, 33);
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.setFont(font);
		btnNewButton_2.setIcon(new ImageIcon(ProductForm.class.getResource("/icon/icons8-delete-24.png")));
		btnNewButton_2.setBounds(119, 8, 99, 33);
		panel_1.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Sửa");
		btnNewButton_3.setFont(font);
		btnNewButton_3.setIcon(new ImageIcon(ProductForm.class.getResource("/icon/icons8-edit-24.png")));
		btnNewButton_3.setBounds(228, 8, 87, 33);
		panel_1.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Nhập Excel");
		btnNewButton_4.setFont(font);
		btnNewButton_4.setIcon(new ImageIcon(ProductForm.class.getResource("/icon/icons8-import-csv-24.png")));
		btnNewButton_4.setBounds(329, 8, 138, 33);
		panel_1.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Xuât Excel");
		btnNewButton_5.setFont(font);
		btnNewButton_5.setIcon(new ImageIcon(ProductForm.class.getResource("/icon/icons8-export-excel-24.png")));
		btnNewButton_5.setBounds(477, 8, 142, 33);
		panel_1.add(btnNewButton_5);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setLayout(null);
		panel_2.setBounds(639, 1, 549, 49);
		getContentPane().add(panel_2);

		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setFont(font);
		btnNewButton.setIcon(new ImageIcon(ProductForm.class.getResource("/icon/icons8-search-24.png")));
		btnNewButton.setBounds(421, 8, 118, 33);
		panel_2.add(btnNewButton);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(109, 8, 302, 33);
		panel_2.add(textField);

		String select[] = { "ID Sản phẩm", "Tên sản phẩm", "Loại sản phẩm" };
		JComboBox comboBox = new JComboBox(select);
		comboBox.setFont(font);
		comboBox.setBounds(10, 8, 89, 33);
		panel_2.add(comboBox);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(0, 53, 1188, 452);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID Sản phẩm", "Tên sản phẩm",
				"ID loại sản phẩm", "ID Nhà phân phối", "Số lượng tồn kho" }));
		scrollPane.setViewportView(table);
		setDefaultTable();

	}
}
