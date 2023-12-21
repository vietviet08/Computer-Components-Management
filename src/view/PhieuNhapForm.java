package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import color.SetColor;
import dao.NhaPhanPhoiDAO;
import dao.SanPhamDAO;
import font.SetFont;
import model.NhaPhanPhoi;
import model.Products;
import javax.swing.ImageIcon;

public class PhieuNhapForm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	private static DefaultTableModel tableModel;
	private final String columName[] = { "ID sản phẩm", "Tên sản phẩm", "ID nhà phân phối", "Số lượng tồn kho" };

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

	public PhieuNhapForm() {
		setBounds(100, 100, 1200, 530);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 801, 456);
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
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "New column", "New column", "New column", "New column" }));
		scrollPane.setViewportView(table);
		setDefaultTable();

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(811, 0, 381, 397);
		getContentPane().add(scrollPane_1);

		table_1 = new JTable();
		table_1.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "New column", "New column", "New column" }));
		scrollPane_1.setViewportView(table_1);

		JButton btnNewButton = new JButton("-");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton.setFont(SetFont.font1_());
		btnNewButton.setBounds(811, 430, 40, 26);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Xóa");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(SetFont.font1_());
		btnNewButton_1.setBounds(978, 430, 104, 26);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_3 = new JButton("+");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_3.setFont(SetFont.font1_());
		btnNewButton_3.setBounds(904, 430, 40, 26);
		getContentPane().add(btnNewButton_3);

		JButton btnNewButton_1_1 = new JButton("Lưu tạm");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_1_1.setFont(SetFont.font1_());
		btnNewButton_1_1.setBounds(1092, 430, 100, 26);
		getContentPane().add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("Nhập hàng");
		btnNewButton_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_1_2.setFont(SetFont.font1_());
		btnNewButton_1_2.setBounds(978, 467, 104, 26);
		getContentPane().add(btnNewButton_1_2);

		textField = new JTextField();
		textField.setFont(SetFont.font1_());
		textField.setHorizontalAlignment(SwingConstants.CENTER);

		textField.setBorder(null);
		textField.setBounds(849, 431, 57, 24);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnNewButton_1_2_1 = new JButton("Hủy");
		btnNewButton_1_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_1_2_1.setFont(SetFont.font1_());
		btnNewButton_1_2_1.setBounds(1092, 466, 100, 26);
		getContentPane().add(btnNewButton_1_2_1);

		JLabel lblNewLabel = new JLabel("© Copyright 2023, Bản quyền thuộc về NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel.setFont(SetFont.font());
		lblNewLabel.setForeground(SetColor.redB);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 472, 801, 20);
		getContentPane().add(lblNewLabel);

		JLabel lbTongTien = new JLabel("Tổng tiền:");
		lbTongTien.setFont(SetFont.font1());
		lbTongTien.setForeground(SetColor.redB);
		lbTongTien.setBounds(811, 467, 155, 23);
		getContentPane().add(lbTongTien);

		JButton btnNewButton_2 = new JButton("Thêm");
		btnNewButton_2.setIcon(new ImageIcon(PhieuNhapForm.class.getResource("/icon/icons8-add-24.png")));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_2.setFont(SetFont.font1_());
		btnNewButton_2.setBounds(697, 454, 104, 30);
		getContentPane().add(btnNewButton_2);

		ArrayList<NhaPhanPhoi> list = NhaPhanPhoiDAO.getInstance().selectAll();
		String[] combo = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			NhaPhanPhoi npp = list.get(i);
			combo[i] = npp.getIdNPP();
		}

		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<String>(combo));
		comboBox.setBounds(811, 397, 155, 22);
		getContentPane().add(comboBox);

	}
}
