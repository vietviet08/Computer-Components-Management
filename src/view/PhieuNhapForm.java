package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import color.SetColor;
import controller.FormatToVND;
import dao.PhieuNhapDAO;
import font.SetFont;
import model.PhieuNhap;

public class PhieuNhapForm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTable table;
	private static DefaultTableModel tableModel;
	private static String[] columName = { "ID đơn nhập", "ID nhà phân phối", "Thời gian nhập hàng", "Người tạo đơn",
			"Tổng tiền", "Trạng thái" };
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhieuNhapForm frame = new PhieuNhapForm();
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

	public static void loadDataToTable(ArrayList<PhieuNhap> phieu) {
		try {
			tableModel.setRowCount(0);
			for (PhieuNhap i : phieu) {
				// set text column don gia ben phai
				DefaultTableCellRenderer renderRight = new DefaultTableCellRenderer();
				renderRight.setHorizontalAlignment(JLabel.RIGHT);

				DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
				renderCenter.setHorizontalAlignment(JLabel.CENTER);

				table.getColumnModel().getColumn(2).setCellRenderer(renderCenter);
				table.getColumnModel().getColumn(5).setCellRenderer(renderCenter);
				table.getColumnModel().getColumn(4).setCellRenderer(renderRight);

				String gia = FormatToVND.vnd(i.getTongTien());
				tableModel.addRow(new Object[] { i.getIdPhieu(), i.getIdNPP(), i.getThoiGianTao(), i.getNguoiTao(), gia,
						i.getTrangThai() });
			}
		} catch (Exception e) {
		}
	}

	public void setDefaultTable() {
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columName);
		table.setDefaultEditor(Object.class, null);
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(500);
		table.getColumnModel().getColumn(3).setPreferredWidth(500);
		table.getColumnModel().getColumn(4).setPreferredWidth(200);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		loadDataToTable(PhieuNhapDAO.getInstance().selectAll());
	}

	public PhieuNhapForm() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1170, 730);
		getContentPane().setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(PhieuNhapForm.class.getResource("/icon/icons8-search-24.png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBorder(null);
		lblNewLabel_2.setBounds(1105, 10, 48, 22);
		getContentPane().add(lblNewLabel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 41, 1160, 660);
		getContentPane().add(scrollPane);

		table = new JTable() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component returnComp = super.prepareRenderer(renderer, row, column);
				if (!returnComp.getBackground().equals(getSelectionBackground())) {
					Color bg = (row % 2 == 0 ? SetColor.blueBaby : Color.WHITE);
					returnComp.setBackground(bg);
					bg = null;
				}
				return returnComp;
			}
		};
		table.getTableHeader().setFont(SetFont.fontHeaderTable());
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "New column", "New column", "New column",
				"New column", "New column", "New column", "New column" }));
		scrollPane.setViewportView(table);
		setDefaultTable();

		JButton btnNewButton_1 = new JButton("Chi tiết");
		btnNewButton_1.setIcon(new ImageIcon(PhieuNhapForm.class.getResource("/icon/icons8-details-24.png")));
		btnNewButton_1.setFont(null);
		btnNewButton_1.setBounds(10, 5, 99, 33);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.setIcon(new ImageIcon(PhieuNhapForm.class.getResource("/icon/icons8-delete-24.png")));
		btnNewButton_2.setFont(null);
		btnNewButton_2.setBounds(121, 5, 99, 33);
		getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Sửa");
		btnNewButton_3.setIcon(new ImageIcon(PhieuNhapForm.class.getResource("/icon/icons8-edit-24.png")));
		btnNewButton_3.setFont(null);
		btnNewButton_3.setBounds(235, 5, 87, 33);
		getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Nhập Excel");
		btnNewButton_4.setIcon(new ImageIcon(PhieuNhapForm.class.getResource("/icon/icons8-import-csv-24.png")));
		btnNewButton_4.setFont(null);
		btnNewButton_4.setBounds(336, 5, 138, 33);
		getContentPane().add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Xuất Excel");
		btnNewButton_5.setIcon(new ImageIcon(PhieuNhapForm.class.getResource("/icon/icons8-export-excel-24.png")));
		btnNewButton_5.setFont(null);
		btnNewButton_5.setBounds(487, 5, 142, 33);
		getContentPane().add(btnNewButton_5);

		JComboBox<String> comboBoxSort = new JComboBox<String>();
		comboBoxSort.setFont(null);
		comboBoxSort.setBounds(636, 5, 125, 32);
		getContentPane().add(comboBoxSort);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(null);
		comboBox.setBounds(771, 5, 99, 33);
		getContentPane().add(comboBox);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(880, 5, 277, 33);
		getContentPane().add(textField);

	}
}
