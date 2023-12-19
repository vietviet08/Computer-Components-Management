package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import color.SetColor;
import controller.FormatToVND;
import dao.cpuDAO;
import model.cpu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CPUForm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4185848334864650430L;
	private static JTable table;
	private static DefaultTableModel tableModel;
	private final String columName[] = { "ID sản phẩm", "Tên CPU", "Xung nhịp", "Số nhân", "Số luồng",
			"Điện năng tiêu thụ", "Bộ nhớ đệm", "Đơn giá" };
	private JTextField textField;
	public Font font;
	public Font font_1;
	public Font font1;
	public Font font2;

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
				// set text column don gia ben phai
				DefaultTableCellRenderer renderRight = new DefaultTableCellRenderer();

				renderRight.setHorizontalAlignment(JLabel.RIGHT);
				table.getColumnModel().getColumn(7).setCellRenderer(renderRight);

				String gia = FormatToVND.vnd(i.getDonGia());
				tableModel.addRow(new Object[] { i.getIdSanPham(), i.getNameCpu(), i.getXungNhip(), i.getSoNhan(),
						i.getSoLuong(), i.getDienNangTieuThu(), i.getBoNhoDem(), gia });
			}
		} catch (Exception e) {
		}
	}

	public void setDefaultTable() {
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columName);
		table.setDefaultEditor(Object.class, null);
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(500);
		table.getColumnModel().getColumn(2).setPreferredWidth(500);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(400);
		table.getColumnModel().getColumn(6).setPreferredWidth(150);
		table.getColumnModel().getColumn(7).setPreferredWidth(200);
		loadDataToTable(cpuDAO.getInstance().selectAll());
	}

	public CPUForm() {

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

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

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 630, 49);
		getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ThemCPU.main(null);
			}
		});
		btnNewButton_1.setFont(font);
		btnNewButton_1.setIcon(new ImageIcon(CPUForm.class.getResource("/icon/icons8-add-24.png")));
		btnNewButton_1.setBounds(10, 8, 99, 33);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(CPUForm.class.getResource("/icon/icons8-delete-24.png")));
		btnNewButton_2.setFont(font);
		btnNewButton_2.setBounds(119, 8, 99, 33);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Sửa");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn cpu muốn sửa!");
				} else {
					CapNhatCPU.main(null);
				}
				
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(CPUForm.class.getResource("/icon/icons8-edit-24.png")));
		btnNewButton_3.setFont(font);
		btnNewButton_3.setBounds(228, 8, 87, 33);
		panel.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Nhập Excel");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(CPUForm.class.getResource("/icon/icons8-import-csv-24.png")));
		btnNewButton_4.setFont(font);
		btnNewButton_4.setBounds(329, 8, 138, 33);
		panel.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Xuất Excel");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_5.setIcon(new ImageIcon(CPUForm.class.getResource("/icon/icons8-export-excel-24.png")));
		btnNewButton_5.setFont(font);
		btnNewButton_5.setBounds(477, 8, 142, 33);
		panel.add(btnNewButton_5);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 53, 1192, 448);
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
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "New column", "New column", "New column",
				"New column", "New column", "New column", "New column" }));
		scrollPane.setViewportView(table);

		setDefaultTable();

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(635, 0, 557, 49);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(font);
		comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID sản phẩm", "Tên CPU", "Xung nhịp",
				"Số nhân", "Số luồng", "Điện năng tiêu thụ", "Bộ nhớ đệm", "Đơn giá" }));
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
	
	public static cpu getSelectCPU() {
		cpu c = cpuDAO.getInstance().selectAll().get(table.getSelectedRow());
		return c;
	}
}
