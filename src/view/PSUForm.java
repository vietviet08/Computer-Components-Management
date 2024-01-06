package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import color.SetColor;
import controller.FormatToVND;
import dao.SanPhamDAO;
import dao.psuDAO;
import font.SetFont;
import model.psu;

public class PSUForm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JLabel labelTen;
	private JLabel labelIMG;
	private JLabel labelTien;
	private JLabel labelBaoHanh;
	private JTextArea txtrAbc;
	private static JTable table;
	private static DefaultTableModel tableModel;
//	idsanpham, idnguon, tennguon, hang, congsuat, chuannguon, kieuday, kichthuoc, tonkho, gia, baohanh
	private static final String[] columnName = { "ID sản phẩm", "ID nguồn", "Tên nguồn", "Hãng", "Công suất",
			"Chuẩn nguồn", "Kiểu dây", "Kích thước", "Tồn kho", "Giá" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PSUForm frame = new PSUForm();
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
	public static void loadDataToTable(ArrayList<psu> psu) {
		try {
			tableModel.setRowCount(0);
			for (psu i : psu) {
				DefaultTableCellRenderer renderRight = new DefaultTableCellRenderer();
				renderRight.setHorizontalAlignment(JLabel.RIGHT);

				DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
				renderCenter.setHorizontalAlignment(JLabel.CENTER);

				table.getColumnModel().getColumn(4).setCellRenderer(renderCenter);
				table.getColumnModel().getColumn(5).setCellRenderer(renderCenter);
				table.getColumnModel().getColumn(7).setCellRenderer(renderCenter);
				table.getColumnModel().getColumn(8).setCellRenderer(renderCenter);
				table.getColumnModel().getColumn(9).setCellRenderer(renderRight);
				String gia = FormatToVND.vnd(i.getDonGia());
				tableModel.addRow(new Object[] { i.getIdSanPham(), i.getIdNguon(), i.getTenNguon(), i.getHang(),
						i.getCongSuat(), i.getChuanNguon(), i.getKieuDay(), i.getKichThuoc(), i.getTonKho(), gia });
			}
		} catch (Exception e) {
		}
	}

	public void setDefaultTable() {
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columnName);
		table.setDefaultEditor(Object.class, null);
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(500);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(5).setPreferredWidth(250);
		table.getColumnModel().getColumn(6).setPreferredWidth(250);
		table.getColumnModel().getColumn(7).setPreferredWidth(150);
		table.getColumnModel().getColumn(8).setPreferredWidth(100);
		table.getColumnModel().getColumn(9).setPreferredWidth(200);
		loadDataToTable(psuDAO.getInstance().selectAll());
	}

	public PSUForm() {
		setBounds(100, 100, 1170, 730);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 630, 49);
		getContentPane().add(panel);

		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ThemPSU.main(null);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(PSUForm.class.getResource("/icon/icons8-add-24.png")));
		btnNewButton_1.setFont(SetFont.font());
		btnNewButton_1.setBounds(10, 8, 99, 33);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRow() == -1)
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm để xóa!");
				else {
					int check = JOptionPane.showConfirmDialog(null, "Bạn chắn chắn xóa sản phẩm này?", "Cảnh báo",
							JOptionPane.YES_NO_OPTION);
					if (check == JOptionPane.YES_OPTION)
						psuDAO.getInstance().delete(getPSUSelect());
				}
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(PSUForm.class.getResource("/icon/icons8-delete-24.png")));
		btnNewButton_2.setFont(SetFont.font());
		btnNewButton_2.setBounds(119, 8, 99, 33);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Sửa");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(PSUForm.class.getResource("/icon/icons8-edit-24.png")));
		btnNewButton_3.setFont(SetFont.font());
		btnNewButton_3.setBounds(228, 8, 87, 33);
		panel.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Nhập Excel");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(PSUForm.class.getResource("/icon/icons8-import-csv-24.png")));
		btnNewButton_4.setFont(SetFont.font());
		btnNewButton_4.setBounds(329, 8, 138, 33);
		panel.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Xuất Excel");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_5.setIcon(new ImageIcon(PSUForm.class.getResource("/icon/icons8-export-excel-24.png")));
		btnNewButton_5.setFont(SetFont.font());
		btnNewButton_5.setBounds(477, 8, 142, 33);
		panel.add(btnNewButton_5);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 53, 780, 648);
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
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				psu psu = getPSUSelect();
				labelTen.setText(psu.getTenNguon());
				labelTien.setText(FormatToVND.vnd(psu.getDonGia()));
				labelBaoHanh.setText("Bảo hành: " + psu.getBaoHanh());
				txtrAbc.setText(SanPhamDAO.getInstance().selectById(psu.getIdSanPham()).getMoTa());

				if (psu.getImg() == null) {
					labelIMG.setIcon(new ImageIcon(PSUForm.class.getResource("/icon/icons8-no-image-14.png")));
					labelIMG.setText("Sản phẩm hiện chưa có ảnh mẫu!");
				} else {
					Blob blob = psu.getImg();
					try {
						byte[] by = blob.getBytes(1, (int) blob.length());
						ImageIcon ii = new ImageIcon(by);
						Image i = ii.getImage().getScaledInstance(labelIMG.getWidth(), labelIMG.getHeight(),
								Image.SCALE_SMOOTH);
						ii = new ImageIcon(i);
						labelIMG.setIcon(ii);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		table.getTableHeader().setFont(SetFont.font());
		table.getTableHeader().setBackground(SetColor.blueOp);
		scrollPane.setViewportView(table);
		setDefaultTable();

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(635, 0, 527, 49);
		getContentPane().add(panel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(PSUForm.class.getResource("/icon/search-24.png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBorder(null);
		lblNewLabel_2.setBounds(471, 15, 48, 22);
		panel_1.add(lblNewLabel_2);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(SetFont.font());
		comboBox.setBounds(146, 8, 89, 33);
		panel_1.add(comboBox);

		textField = new JTextField();
		textField.setFont(SetFont.font());
		textField.setColumns(10);
		textField.setBounds(248, 8, 277, 33);
		panel_1.add(textField);

		JComboBox<String> comboBoxSort = new JComboBox<String>();
		comboBoxSort.setFont(SetFont.font());
		comboBoxSort.setBounds(0, 8, 125, 33);
		panel_1.add(comboBoxSort);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(790, 53, 372, 648);
		getContentPane().add(panel_2);

		labelIMG = new JLabel("Ảnh sản phẩm");
		labelIMG.setIcon(new ImageIcon(PSUForm.class.getResource("/icon/icons8-no-image-14.png")));
		labelIMG.setHorizontalAlignment(SwingConstants.CENTER);
		labelIMG.setFont(SetFont.font());
		labelIMG.setBorder(null);
		labelIMG.setBounds(12, 50, 350, 350);
		panel_2.add(labelIMG);

		labelTien = new JLabel("0 đ");
		labelTien.setForeground(new Color(190, 14, 30));
		labelTien.setFont(SetFont.font1());
		labelTien.setBounds(41, 402, 131, 23);
		panel_2.add(labelTien);

		labelBaoHanh = new JLabel("Bảo hành");
		labelBaoHanh.setFont(SetFont.font1());
		labelBaoHanh.setBounds(41, 436, 143, 23);
		panel_2.add(labelBaoHanh);

		labelTen = new JLabel("Tên PSU");
		labelTen.setFont(SetFont.fontCategory());
		labelTen.setBounds(30, 11, 341, 31);
		panel_2.add(labelTen);

		txtrAbc = new JTextArea();
		txtrAbc.setWrapStyleWord(true);
		txtrAbc.setOpaque(false);
		txtrAbc.setLineWrap(true);
		txtrAbc.setFont(SetFont.fontDetails_1());
		txtrAbc.setEditable(false);
		txtrAbc.setBounds(33, 470, 310, 167);
		panel_2.add(txtrAbc);
	}

	public static psu getPSUSelect() {
		return psuDAO.getInstance().selectById(table.getValueAt(table.getSelectedRow(), 1).toString());

	}
}
