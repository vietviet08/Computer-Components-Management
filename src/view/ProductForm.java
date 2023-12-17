package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ProductForm extends JInternalFrame {

	public Font font;
	public Font font_1;
	public Font font1;
	public Font font2;
	private JTable table;
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
		panel_1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Bộ công cụ",
				TitledBorder.LEFT, TitledBorder.TOP, font));
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 629, 75);
		getContentPane().add(panel_1);

		JButton btnNewButton_1 =  new JButton("Thêm");
		btnNewButton_1.setFont(font);
		btnNewButton_1.setIcon(new ImageIcon(ProductForm.class.getResource("/icon/icons8-add-24.png")));
		btnNewButton_1.setBounds(10, 11, 99, 52);
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.setFont(font);
		btnNewButton_2.setIcon(new ImageIcon(ProductForm.class.getResource("/icon/icons8-delete-24.png")));
		btnNewButton_2.setBounds(119, 11, 99, 52);
		panel_1.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Sửa");
		btnNewButton_3.setFont(font);
		btnNewButton_3.setIcon(new ImageIcon(ProductForm.class.getResource("/icon/icons8-edit-24.png")));
		btnNewButton_3.setBounds(228, 11, 87, 52);
		panel_1.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Nhập Excel");
		btnNewButton_4.setFont(font);
		btnNewButton_4.setIcon(new ImageIcon(ProductForm.class.getResource("/icon/icons8-import-csv-24.png")));
		btnNewButton_4.setBounds(329, 11, 138, 52);
		panel_1.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Xuât Excel");
		btnNewButton_5.setFont(font);
		btnNewButton_5.setIcon(new ImageIcon(ProductForm.class.getResource("/icon/icons8-export-excel-24.png")));
		btnNewButton_5.setBounds(477, 11, 142, 52);
		panel_1.add(btnNewButton_5);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Tìm kiếm",
				TitledBorder.LEFT, TitledBorder.TOP, font));
		panel_2.setLayout(null);
		panel_2.setBounds(639, 0, 549, 74);
		getContentPane().add(panel_2);

		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setFont(font);
		btnNewButton.setIcon(new ImageIcon(ProductForm.class.getResource("/icon/icons8-search-24.png")));
		btnNewButton.setBounds(421, 11, 118, 52);
		panel_2.add(btnNewButton);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(109, 11, 302, 52);
		panel_2.add(textField);

		String select[] = { "ID Sản phẩm", "Tên sản phẩm", "Loại sản phẩm" };
		JComboBox comboBox = new JComboBox(select);
		comboBox.setFont(font);
		comboBox.setBounds(10, 11, 89, 52);
		panel_2.add(comboBox);

		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(0, 75, 1188, 430);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID Sản phẩm", "Tên sản phẩm", "ID loại sản phẩm",
				"ID Nhà phân phối", "Số lượng tồn kho"}));
		scrollPane.setViewportView(table);

	}
}
