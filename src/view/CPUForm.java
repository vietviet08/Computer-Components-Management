package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.cpuDAO;
import model.cpu;

public class CPUForm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4185848334864650430L;
	private static JTable table;
	private static DefaultTableModel tableModel;
	private final String columName[] = { "ID sản phẩm", "Tên CPU", "Xung nhịp", "Số nhân", "Số luồng",
			"Điện năng tiêu thụ", "Bộ nhớ đệm" };
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CPUForm frame = new CPUForm();
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

	public static void loadDataToTable(ArrayList<cpu> cpu) {
		try {
			tableModel.setRowCount(0);
			for (cpu i : cpu) {
				tableModel.addRow(new Object[] { i.getIdSanPham(), i.getNameCpu(), i.getXungNhip(), i.getSoNhan(),
						i.getSoLuong(), i.getDienNangTieuThu(), i.getBoNhoDem() });
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
		table.getColumnModel().getColumn(2).setPreferredWidth(500);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(400);
		table.getColumnModel().getColumn(6).setPreferredWidth(200);
		loadDataToTable(cpuDAO.getInstance().selectAll());
	}

	public CPUForm() {
		setBounds(100, 100, 1200, 530);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 630, 49);
		getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.setFont(null);
		btnNewButton_1.setBounds(10, 8, 99, 33);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.setFont(null);
		btnNewButton_2.setBounds(119, 8, 99, 33);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Sửa");
		btnNewButton_3.setFont(null);
		btnNewButton_3.setBounds(228, 8, 87, 33);
		panel.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Nhập Excel");
		btnNewButton_4.setFont(null);
		btnNewButton_4.setBounds(329, 8, 138, 33);
		panel.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Xuất Excel");
		btnNewButton_5.setFont(null);
		btnNewButton_5.setBounds(477, 8, 142, 33);
		panel.add(btnNewButton_5);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 53, 1192, 448);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "New column", "New column", "New column",
				"New column", "New column", "New column", "New column" }));
		scrollPane.setViewportView(table);

		setDefaultTable();

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(635, 0, 557, 49);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(null);
		comboBox.setBounds(10, 8, 99, 33);
		panel_1.add(comboBox);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(119, 8, 302, 33);
		panel_1.add(textField);

		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setFont(null);
		btnNewButton.setBounds(431, 8, 118, 33);
		panel_1.add(btnNewButton);

	}
}
