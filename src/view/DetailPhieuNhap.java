package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import color.SetColor;
import controller.FormatToVND;
import dao.ChiTietPhieuNhapDAO;
import font.SetFont;
import model.ChiTietPhieu;

public class DetailPhieuNhap extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String[] columName = { "ID đơn nhập", "ID sản phẩm", "Số lượng ", "Đơn giá" };
	private static JTable table;
	private static DefaultTableModel tableModel;
	private JTextField textField;
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailPhieuNhap frame = new DetailPhieuNhap();
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setTitle("Chi tiết đơn hàng " + PhieuNhapForm.getPhieuNhapSelect().getIdPhieu());
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

	public static void loadDataToTable(ArrayList<ChiTietPhieu> phieu) {
		try {
			tableModel.setRowCount(0);
			for (ChiTietPhieu i : phieu) {
				// set text column don gia ben phai
				DefaultTableCellRenderer renderRight = new DefaultTableCellRenderer();
				renderRight.setHorizontalAlignment(JLabel.RIGHT);

				DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
				renderCenter.setHorizontalAlignment(JLabel.CENTER);

//				table.getColumnModel().getColumn(2).setCellRenderer(renderCenter);
				table.getColumnModel().getColumn(2).setCellRenderer(renderCenter);
				table.getColumnModel().getColumn(3).setCellRenderer(renderRight);

				String gia = FormatToVND.vnd(i.getDonGia());

				tableModel.addRow(new Object[] { i.getIdPhieu(), i.getIdSanPham(), i.getSoLuong(), gia });
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
		table.getColumnModel().getColumn(1).setPreferredWidth(500);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		loadDataToTable(
				ChiTietPhieuNhapDAO.getInstance().selectAllById(PhieuNhapForm.getPhieuNhapSelect().getIdPhieu()));
	}

	public DetailPhieuNhap() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 683, 710);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Chi tiết phiếu nhập",
				new ImageIcon(DetailPhieuNhap.class.getResource("/icon/icons8-about-12.png")), panel, null);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setIcon(new ImageIcon(DetailPhieuNhap.class.getResource("/icon/icons8-search-24.png")));
		lblNewLabel_1.setBounds(626, 16, 37, 24);
		panel.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 50, 678, 632);
		panel.add(scrollPane);

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
		table.getTableHeader().setBackground(SetColor.blueOp);
		table.getTableHeader().setFont(SetFont.fontHeaderTable());
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "New column", "New column", "New column", "New column" }));
		scrollPane.setViewportView(table);
		setDefaultTable();

		JButton btnNewButton = new JButton("Chi tiết sản phẩm");
		btnNewButton.setIcon(new ImageIcon(DetailPhieuNhap.class.getResource("/icon/icons8-details-24.png")));
		btnNewButton.setBounds(10, 11, 180, 33);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Xuất excel");
		btnNewButton_1.setIcon(new ImageIcon(DetailPhieuNhap.class.getResource("/icon/icons8-export-excel-24.png")));
		btnNewButton_1.setBounds(200, 11, 124, 33);
		panel.add(btnNewButton_1);

		comboBox = new JComboBox<>(new DefaultComboBoxModel<String>(
				new String[] { "Sắp xếp", "Số lượng tăng", "Số lượng giảm", "Đơn giá tăng", "Đơn giá giảm" }));
		comboBox.setBounds(334, 11, 145, 33);
		panel.add(comboBox);

		textField = new JTextField();
		textField.setBounds(489, 11, 179, 33);
		panel.add(textField);
		textField.setColumns(10);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Hóa đơn", new ImageIcon(DetailPhieuNhap.class.getResource("/icon/icons8-bill-12.png")),
				panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Hóa đơn file PNG hoặc JPG");
		lblNewLabel.setBackground(SystemColor.controlHighlight);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(22, 47, 631, 635);
		panel_1.add(lblNewLabel);

		JButton btnNewButton_3 = new JButton("In PDF");
		btnNewButton_3.setBounds(22, 11, 89, 23);
		panel_1.add(btnNewButton_3);
	}
}
