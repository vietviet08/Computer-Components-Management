package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.NhaPhanPhoiDAO;
import model.NhaPhanPhoi;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;

public class NhaPhanPhoiForm extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable tableNpp;
	private DefaultTableModel tableModel;
	private final String columName[] = {"Mã nhà phân phối", "Tên nhà phân phối", "Địa chỉ", "Email", "Số điện thoại"};
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

					NhaPhanPhoiForm frame = new NhaPhanPhoiForm();
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

	// method load data
	public  void loadDataToTable(ArrayList<NhaPhanPhoi> npp) {
		try {
			tableModel.setRowCount(0);
			for (NhaPhanPhoi i : npp) {
				tableModel.addRow(new Object[] { i.getIdNPP(), i.getTenNPP(),i.getDiaChi(), i.getEmail(), i.getSdt() });
			}
		} catch (Exception e) {
		}
	}

	public void setDefaultTable() {
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columName);
		tableNpp.setDefaultEditor(Object.class, null);
		tableNpp.setModel(tableModel);
		tableNpp.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableNpp.getColumnModel().getColumn(1).setPreferredWidth(300);
		tableNpp.getColumnModel().getColumn(2).setPreferredWidth(350);
		tableNpp.getColumnModel().getColumn(3).setPreferredWidth(200);
		loadDataToTable(NhaPhanPhoiDAO.getInstance().selectAll());
	}

	public NhaPhanPhoiForm() {
		
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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 71, 1188, 430);
		getContentPane().add(scrollPane);

		tableNpp = new JTable();
		tableNpp.setModel(
				new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"new", "new", "new", "new", "new"
			}
		));
		scrollPane.setViewportView(tableNpp);
		
		setDefaultTable();

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 631, 70);
		getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.setIcon(new ImageIcon(NhaPhanPhoiForm.class.getResource("/icon/icons8-add-24.png")));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ThemNhaPhanPhoi tnpp = new ThemNhaPhanPhoi();
				tnpp.setVisible(true);
				tnpp.setLocationRelativeTo(null);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		btnNewButton_1.setFont(font);
		btnNewButton_1.setBounds(10, 11, 99, 52);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.setIcon(new ImageIcon(NhaPhanPhoiForm.class.getResource("/icon/icons8-delete-24.png")));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tableNpp.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà phân phối muốn xóa!");
				}else {
					int answ = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa không", "Thông báo", JOptionPane.YES_NO_OPTION);
					if(answ == JOptionPane.YES_OPTION) {
						NhaPhanPhoi npp = NhaPhanPhoiDAO.getInstance().selectAll().get(tableNpp.getSelectedRow());
						NhaPhanPhoiDAO.getInstance().delete(npp);
						loadDataToTable(NhaPhanPhoiDAO.getInstance().selectAll());
						JOptionPane.showMessageDialog(null, "Xóa thành công");
					}
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		btnNewButton_2.setFont(font);
		btnNewButton_2.setBounds(119, 11, 99, 52);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Sửa");
		btnNewButton_3.setIcon(new ImageIcon(NhaPhanPhoiForm.class.getResource("/icon/icons8-edit-24.png")));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		btnNewButton_3.setFont(font);
		btnNewButton_3.setBounds(228, 11, 87, 52);
		panel.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Nhập Excel");
		btnNewButton_4.setIcon(new ImageIcon(NhaPhanPhoiForm.class.getResource("/icon/icons8-import-csv-24.png")));
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		btnNewButton_4.setFont(font);
		btnNewButton_4.setBounds(329, 11, 138, 52);
		panel.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Xuât Excel");
		btnNewButton_5.setFont(font);
		btnNewButton_5.setIcon(new ImageIcon(NhaPhanPhoiForm.class.getResource("/icon/icons8-export-excel-24.png")));
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		btnNewButton_5.setBounds(477, 11, 142, 52);
		panel.add(btnNewButton_5);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(632, 0, 556, 70);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		
		String[] item = {"ID Nhà phân phối", "Tên nhà phân phối", "Email", "SDT"};
		
		JComboBox comboBox = new JComboBox(item);
		comboBox.setFont(font);
		comboBox.setBounds(0, 11, 99, 52);
		panel_1.add(comboBox);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(109, 11, 302, 52);
		panel_1.add(textField);

		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setFont(font);
		btnNewButton.setIcon(new ImageIcon(NhaPhanPhoiForm.class.getResource("/icon/icons8-search-24.png")));
		btnNewButton.setBounds(421, 11, 118, 52);
		panel_1.add(btnNewButton);

	}
}
