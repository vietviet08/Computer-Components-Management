package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
import dao.mainDAO;
import font.SetFont;
import model.mainboard;

public class MainboardForm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private static JTable table;
	private static DefaultTableModel tableModel;
	private final String columName[] = { "ID sản phẩm", "ID Mainboard", "Tên mainboard", "Hãng", "Hỗ trợ CPU",
			"Hỗ trợ RAM", "Kích thước", "Tồn kho", "Đơn giá" };
	private JLabel labelIMG;
	private JLabel labelTen;
	private JLabel labelTien;
	private JLabel labelBaoHanh;
	private JTextArea txtrAbc;
	private JLabel labelHoTroRAM;
	private JLabel labelHoTroCPU;
	private JLabel labelKichThuoc;
	private JComboBox<String> comboBoxSort;
	private JComboBox<String> comboBox;

	private final String[] comboSort = { "Sắp xếp", "Giá tăng dần", "Giá giảm dần", "Tồn kho tăng", "Tồn kho giảm" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainboardForm frame = new MainboardForm();
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

	public static void loadDataToTable(ArrayList<mainboard> mainboard) {
		try {
			tableModel.setRowCount(0);
			for (mainboard i : mainboard) {
				DefaultTableCellRenderer renderRight = new DefaultTableCellRenderer();
				renderRight.setHorizontalAlignment(JLabel.RIGHT);

				DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
				renderCenter.setHorizontalAlignment(JLabel.CENTER);

				table.getColumnModel().getColumn(7).setCellRenderer(renderCenter);
				table.getColumnModel().getColumn(8).setCellRenderer(renderRight);

				String gia = FormatToVND.vnd(i.getDonGia());
				tableModel.addRow(new Object[] { i.getIdSanPham(), i.getIdMainboard(), i.getTenMain(), i.getTenHang(),
						i.getHoTroCPU(), i.getHoTroRAM(), i.getKichThuoc(), i.getTonKho(), gia });
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
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(500);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(300);
		table.getColumnModel().getColumn(5).setPreferredWidth(300);
		table.getColumnModel().getColumn(6).setPreferredWidth(200);
		table.getColumnModel().getColumn(7).setPreferredWidth(100);
		table.getColumnModel().getColumn(8).setPreferredWidth(250);
		loadDataToTable(mainDAO.getInstance().selectAll());
	}

	public MainboardForm() {
		setBounds(100, 100, 1170, 730);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 630, 49);
		getContentPane().add(panel);

		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemMainboard.main(null);
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(MainboardForm.class.getResource("/icon/icons8-add-24.png")));
		btnNewButton_1.setFont(SetFont.font());
		btnNewButton_1.setBounds(10, 8, 99, 33);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRow() == -1)
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm để xóa!");
				else {
					int answ = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn xóa sản phẩm này!", "Cảnh báo",
							JOptionPane.YES_NO_OPTION);
					if (answ == JOptionPane.YES_OPTION) {
						mainDAO.getInstance().delete(getMainboardSellect());
						JOptionPane.showMessageDialog(null, "Xóa thành công");
						loadDataToTable(mainDAO.getInstance().selectAll());
					}
				}
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(MainboardForm.class.getResource("/icon/icons8-delete-24.png")));
		btnNewButton_2.setFont(SetFont.font());
		btnNewButton_2.setBounds(119, 8, 99, 33);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Sửa");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRow() == -1)
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm để cập nhật!");
				else
					CapNhatMainboard.main(null);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(MainboardForm.class.getResource("/icon/icons8-edit-24.png")));
		btnNewButton_3.setFont(SetFont.font());
		btnNewButton_3.setBounds(228, 8, 87, 33);
		panel.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Nhập Excel");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(MainboardForm.class.getResource("/icon/icons8-import-csv-24.png")));
		btnNewButton_4.setFont(SetFont.font());
		btnNewButton_4.setBounds(329, 8, 138, 33);
		panel.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Xuất Excel");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_5.setIcon(new ImageIcon(MainboardForm.class.getResource("/icon/icons8-export-excel-24.png")));
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
		table.getTableHeader().setFont(SetFont.font());
		table.getTableHeader().setBackground(SetColor.blueOp);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				mainboard mb = getMainboardSellect();

				mainboard mb = mainDAO.getInstance()
						.selectById(String.valueOf(table.getValueAt(table.getSelectedRow(), 1)));

				labelTen.setText(mb.getTenMain());
				labelTien.setText(FormatToVND.vnd(mb.getDonGia()));
				labelBaoHanh.setText("Bảo hành: " + mb.getBaoHanh());
				txtrAbc.setText(SanPhamDAO.getInstance().selectById(mb.getIdSanPham()).getMoTa());
				labelHoTroCPU.setText(mb.getHoTroCPU());
				labelHoTroRAM.setText(mb.getHoTroRAM());
				labelKichThuoc.setText(mb.getKichThuoc());
				if (mb.getImg() == null) {
					labelIMG.setIcon(null);
					labelIMG.setIcon(new ImageIcon(MainboardForm.class.getResource("/icon/icons8-no-image-14.png")));
					labelIMG.setText("Hiện sản phẩm chưa có ảnh mẫu");
				} else {
					Blob blob = mb.getImg();
					try {
						byte[] by = blob.getBytes(1, (int) blob.length());

						ImageIcon ii = new ImageIcon(by);
						Image i = ii.getImage().getScaledInstance(labelIMG.getWidth(), labelIMG.getHeight(),
								Image.SCALE_SMOOTH);
						ii = new ImageIcon(i);

						labelIMG.setBorder(null);
						labelIMG.setText("");
						labelIMG.setIcon(ii);

					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}

			}
		});
		scrollPane.setViewportView(table);
		setDefaultTable();

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(635, 0, 527, 49);
		getContentPane().add(panel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MainboardForm.class.getResource("/icon/search-24.png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBorder(null);
		lblNewLabel_2.setBounds(471, 15, 48, 22);
		panel_1.add(lblNewLabel_2);

		comboBox = new JComboBox<String>();
		comboBox.setFont(SetFont.font());
		comboBox.setBounds(146, 8, 89, 33);
		panel_1.add(comboBox);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(248, 8, 277, 33);
		panel_1.add(textField);

		comboBoxSort = new JComboBox<String>(comboSort);
		comboBoxSort.setFont(SetFont.font());
		comboBoxSort.setBounds(0, 8, 125, 32);
		comboBoxSort.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String src = comboBoxSort.getSelectedItem().toString();
				if (src.equals("Giá tăng dần"))
					loadDataToTable(sortByGiaTangDan());
				else if (src.equals("Giá giảm dần"))
					loadDataToTable(sortByGiaGiamDan());
				else if (src.equals("Tồn kho tăng"))
					loadDataToTable(sortByTonKhoTang());
				else if (src.equals("Tồn kho giảm"))
					loadDataToTable(sortByTonKhoGiam());
			}
		});
		panel_1.add(comboBoxSort);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(790, 53, 372, 648);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);

		labelIMG = new JLabel("Ảnh sản phẩm");
		labelIMG.setFont(SetFont.font());
		labelIMG.setIcon(new ImageIcon(MainboardForm.class.getResource("/icon/icons8-no-image-14.png")));
		labelIMG.setHorizontalAlignment(SwingConstants.CENTER);
		labelIMG.setBorder(null);
		labelIMG.setBounds(12, 50, 350, 350);
		panel_2.add(labelIMG);

		labelTien = new JLabel("0 đ");
		labelTien.setForeground(new Color(190, 14, 30));
		labelTien.setFont(SetFont.font1());
		labelTien.setBounds(41, 402, 153, 23);
		panel_2.add(labelTien);

		labelBaoHanh = new JLabel("Bảo hành");
		labelBaoHanh.setFont(SetFont.font1());
		labelBaoHanh.setBounds(41, 436, 153, 23);
		panel_2.add(labelBaoHanh);

		labelTen = new JLabel("Tên mainboard");
		labelTen.setFont(SetFont.fontCategory());
		labelTen.setBounds(30, 8, 342, 31);
		panel_2.add(labelTen);

		txtrAbc = new JTextArea();
		txtrAbc.setBounds(33, 470, 329, 167);
		panel_2.add(txtrAbc);
		txtrAbc.setWrapStyleWord(true);
		txtrAbc.setOpaque(false);
		txtrAbc.setLineWrap(true);
		txtrAbc.setFont(SetFont.fontDetails_1());
		txtrAbc.setEditable(false);

		labelHoTroCPU = new JLabel("");
		labelHoTroCPU.setFont(SetFont.fontDetails());
		labelHoTroCPU.setBounds(202, 406, 160, 14);
		panel_2.add(labelHoTroCPU);

		labelHoTroRAM = new JLabel("");
		labelHoTroRAM.setFont(SetFont.fontDetails());
		labelHoTroRAM.setBounds(202, 423, 160, 14);
		panel_2.add(labelHoTroRAM);

		labelKichThuoc = new JLabel("");
		labelKichThuoc.setFont(SetFont.fontDetails());
		labelKichThuoc.setBounds(202, 440, 160, 14);
		panel_2.add(labelKichThuoc);
	}

	private void openFile(String file) {
		try {
			File path = new File(file);
			Desktop.getDesktop().open(path);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static mainboard getMainboardSellect() {
		return mainDAO.getInstance().selectAll().get(table.getSelectedRow());
	}

	private ArrayList<mainboard> sortByGiaTangDan() {
		ArrayList<mainboard> mb = mainDAO.getInstance().selectAll();
		ArrayList<mainboard> list = new ArrayList<mainboard>();
		for (mainboard mainboard : mb) {
			list.add(mainboard);
		}
		Collections.sort(list, new Comparator<mainboard>() {

			@Override
			public int compare(mainboard o1, mainboard o2) {
				if (o1.getDonGia() > o2.getDonGia())
					return 1;
				else if (o1.getDonGia() < o2.getDonGia())
					return -1;
				return 0;
			}
		});
		return list;
	}

	private ArrayList<mainboard> sortByGiaGiamDan() {
		ArrayList<mainboard> mb = mainDAO.getInstance().selectAll();
		ArrayList<mainboard> list = new ArrayList<mainboard>();
		for (mainboard mainboard : mb) {
			list.add(mainboard);
		}
		Collections.sort(list, new Comparator<mainboard>() {

			@Override
			public int compare(mainboard o1, mainboard o2) {
				if (o1.getDonGia() > o2.getDonGia())
					return -1;
				else if (o1.getDonGia() < o2.getDonGia())
					return 1;
				return 0;
			}
		});
		return list;
	}

	private ArrayList<mainboard> sortByTonKhoTang() {
		ArrayList<mainboard> mb = mainDAO.getInstance().selectAll();
		ArrayList<mainboard> list = new ArrayList<mainboard>();
		for (mainboard mainboard : mb) {
			list.add(mainboard);
		}
		Collections.sort(list, new Comparator<mainboard>() {

			@Override
			public int compare(mainboard o1, mainboard o2) {
				if (o1.getTonKho() > o2.getTonKho())
					return 1;
				else if (o1.getTonKho() < o2.getTonKho())
					return -1;
				return 0;
			}
		});
		return list;
	}

	private ArrayList<mainboard> sortByTonKhoGiam() {
		ArrayList<mainboard> mb = mainDAO.getInstance().selectAll();
		ArrayList<mainboard> list = new ArrayList<mainboard>();
		for (mainboard mainboard : mb) {
			list.add(mainboard);
		}
		Collections.sort(list, new Comparator<mainboard>() {

			@Override
			public int compare(mainboard o1, mainboard o2) {
				if (o1.getTonKho() > o2.getTonKho())
					return -1;
				else if (o1.getTonKho() < o2.getTonKho())
					return 1;
				return 0;
			}
		});
		return list;
	}
}
