package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import color.SetColor;
import controller.FormatToVND;
import dao.cpuDAO;
import dao.ramDAO;
import dao.vgaDAO;
import font.SetFont;
import model.ChiTietPhieu;
import model.PhieuXuat;
import model.cpu;
import model.ram;
import model.vga;

public class XuatHangForm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private static JTable tableALL;
	private static JTable tableMin;
	private static DefaultTableModel tableModel;
	private static DefaultTableModel tableModelBill;
	private final String columName[] = { "ID mặt hàng", "Tên sản phẩm", "Đơn giá" };
	private final String columNameBill[] = { "ID mặt hàng", "ID sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá" };
	private JTextField textField_1;
	private JComboBox<String> comboBox_chooseProduct;
	private JButton btnNewButton_2;
	private JComboBox<String> comboBox_chonKhachHang;
	private JLabel lbTongTien1;
	private JTextField tfTongTien;
	private static double tien = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhapHangForm frame = new NhapHangForm();
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

//	public static void loadDataToTable(ArrayList<Products> pr) {
//		try {
//			tableModel.setRowCount(0);
//			for (Products i : pr) {
//				tableModel.addRow(new Object[] { i.getIdSanPham(), i.getTenSanPham() });
//			}
//		} catch (Exception e) {
//		}
//	}
	public static void loadDataToTableCPU(ArrayList<cpu> cpu) {

		try {
			tableModel.setRowCount(0);
			for (cpu i : cpu) {
				DefaultTableCellRenderer renderRight = new DefaultTableCellRenderer();
				renderRight.setHorizontalAlignment(JLabel.RIGHT);
				tableALL.getColumnModel().getColumn(2).setCellRenderer(renderRight);
				String gia = FormatToVND.vnd(i.getDonGia());
				tableModel.addRow(new Object[] { i.getIdSanPham(), i.getNameCpu(), gia });
			}
		} catch (Exception e) {
		}
	}

	public static void loadDataToTableRAM(ArrayList<ram> ram) {
		try {

			tableModel.setRowCount(0);
			for (ram i : ram) {
				DefaultTableCellRenderer renderRight = new DefaultTableCellRenderer();
				renderRight.setHorizontalAlignment(JLabel.RIGHT);
				tableALL.getColumnModel().getColumn(2).setCellRenderer(renderRight);
				String gia = FormatToVND.vnd(i.getDonGia());
				tableModel.addRow(new Object[] { i.getIdSanPham(), i.getTenRam(), gia });
			}
		} catch (Exception e) {
		}
	}

	public static void loadDataToTableVGA(ArrayList<vga> vga) {
		try {
			tableModel.setRowCount(0);
			for (vga i : vga) {
				DefaultTableCellRenderer renderRight = new DefaultTableCellRenderer();
				renderRight.setHorizontalAlignment(JLabel.RIGHT);
				tableALL.getColumnModel().getColumn(2).setCellRenderer(renderRight);
				String gia = FormatToVND.vnd(i.getDonGia());
				tableModel.addRow(new Object[] { i.getIdSanPham(), i.getTenVGA(), gia });
			}
		} catch (Exception e) {
		}
	}

	public void setDefaultTable(String isSelect) {
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columName);
		tableALL.setDefaultEditor(Object.class, null);
		tableALL.setModel(tableModel);
		tableALL.getColumnModel().getColumn(0).setPreferredWidth(200);
		tableALL.getColumnModel().getColumn(1).setPreferredWidth(500);
		tableALL.getColumnModel().getColumn(2).setPreferredWidth(200);

		switch (isSelect) {
		case "cpu":
			loadDataToTableCPU(cpuDAO.getInstance().selectAll());
			break;
		case "ram":
			loadDataToTableRAM(ramDAO.getInstance().selectAll());
			break;
		case "vga":
			loadDataToTableVGA(vgaDAO.getInstance().selectAll());
			break;
//		case "mainboard":
//			loadDataToTable(null);
//			break;
//		case "case":
//			loadDataToTable(null);
//			break;
//		case "nguon":
//			loadDataToTable(null);
//			break;
//		case "manhinh":
//			loadDataToTable(null);
//			break;
//		case "chuot":
//			loadDataToTable(null);
//			break;
//		case "banphim":
//			loadDataToTable(null);
//			break;
//		case "tainghe":
//			loadDataToTable(null);
//			break;

		default:
			break;
		}

//		loadDataToTable(SanPhamDAO.getInstance().selectAll());
	}

	public XuatHangForm() {
		setBounds(100, 100, 1170, 730);
		getContentPane().setLayout(null);

		tfTongTien = new JTextField();
		tfTongTien.setHorizontalAlignment(SwingConstants.TRAILING);
		tfTongTien.setText("0đ");
		tfTongTien.setFont(SetFont.font1_());
		tfTongTien.setForeground(SetColor.redB);

		tfTongTien.setOpaque(false);
		tfTongTien.setBorder(null);
		tfTongTien.setBounds(1016, 594, 136, 26);
		getContentPane().add(tfTongTien);
		tfTongTien.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setIcon(new ImageIcon(NhapHangForm.class.getResource("/icon/icons8-search-24.png")));
		lblNewLabel_1.setBounds(460, 6, 48, 22);
		getContentPane().add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 36, 750, 665);
		getContentPane().add(scrollPane);

		tableALL = new JTable() {
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
		tableALL.getTableHeader().setBackground(SetColor.blueOp);
		tableALL.getTableHeader().setFont(SetFont.fontHeaderTable());
		tableALL.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "New column", "New column", "New column", "New column" }));
		scrollPane.setViewportView(tableALL);
		setDefaultTable("cpu");

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(760, 1, 402, 585);
		getContentPane().add(scrollPane_1);

		tableMin = new JTable() {
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
		tableMin.getTableHeader().setBackground(SetColor.blueOp);
		tableMin.getTableHeader().setFont(SetFont.fontHeaderTable());
		tableMin.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "New column", "New column", "New column" }));
		scrollPane_1.setViewportView(tableMin);

//		list bill
		ArrayList<ChiTietPhieu> listNhap = new ArrayList<ChiTietPhieu>();
//
//		ArrayList<ChiTietPhieu> sanPham = LuuTam.sanPham;
//
//		if (sanPham.size() == 0) {
//			LuuTam.tongTien = 0;
//			tien = LuuTam.tongTien;
//			tfTongTien.setText(FormatToVND.vnd(tien));
//			setDefaultTableBill(listNhap);
//		}
//		else {
//
//			for (ChiTietPhieu ChiTietPhieu : sanPham) {
//				listNhap.add(ChiTietPhieu);
//			}
//			tien = LuuTam.tongTien;
//			tfTongTien.setText(FormatToVND.vnd(tien));
//			setDefaultTableBill(listNhap);
//		}

		JButton btnNewButton = new JButton("-");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton.setFont(SetFont.font1_());
		btnNewButton.setBounds(760, 627, 40, 26);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Xóa");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tableMin.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm để xóa!");
				} else {
					int answ = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn xóa sản phẩm này?", "Cảnh báo",
							JOptionPane.YES_NO_OPTION);
					if (answ == JOptionPane.YES_OPTION) {
						listNhap.remove(tableMin.getSelectedRow());
						JOptionPane.showMessageDialog(null, "Xóa thành công!");
						loadDataToTableBill(listNhap);
					}
				}
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(SetFont.font1_());
		btnNewButton_1.setBounds(916, 625, 104, 26);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_3 = new JButton("+");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_3.setFont(SetFont.font1_());
		btnNewButton_3.setBounds(853, 627, 40, 26);
		getContentPane().add(btnNewButton_3);

		JButton btnNewButton_1_1 = new JButton("Lưu tạm");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

//				ArrayList<ChiTietPhieu> list = LuuTam.sanPham;
//				for (ChiTietPhieu ChiTietPhieu : listNhap) {
//					list.add(ChiTietPhieu);
//				}
//
//				LuuTam.tongTien = tien;

			}
		});
		btnNewButton_1_1.setFont(SetFont.font1_());
		btnNewButton_1_1.setBounds(1052, 625, 100, 26);
		getContentPane().add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("Xuất hàng");
		btnNewButton_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (listNhap.size() == 0) {
					JOptionPane.showMessageDialog(null, "Không có sản phẩm nào để xuất hàng!");
				} else {

					int check = cpuDAO.getInstance().updateTonKho(listNhap);
					check += ramDAO.getInstance().updateTonKho(listNhap);
					check += vgaDAO.getInstance().updateTonKho(listNhap);
					if (check > 0) {

						JOptionPane.showMessageDialog(null, "Đã nhập hàng thành công!");
						System.out.println(tien);

//						String idPhieu = createIDPhieuNhap();

						Timestamp timestamp = new Timestamp(System.currentTimeMillis());

//						PhieuXuat px = new PhieuXuat(createIDPhieuNhap(PhieuXuatDAO.getInstance().selectAll()),
//								comboBox_chonKhachHang.getSelectedItem().toString(), timestamp, LoginForm.fullN, tien, 1);
//						PhieuXuatDAO.getInstance().insert(px);

//						for (int i = 0; i < tableMin.getRowCount(); i++) {
//							String money = (String) tableMin.getValueAt(i, 4);
//							double money1 = Double.parseDouble(money.substring(0, money.length()).trim());
//							ChiTietPhieu ctp = new ChiTietPhieu(px.getIdPhieu(), (String) tableMin.getValueAt(i, 0),
//									(int) tableMin.getValueAt(i, 3), (double) tableMin.getValueAt(i, 4));
//							(double)tableMin.getValueAt(i, 4)
//							ChiTietPhieuXuatDAO.getInstance().insert(ctp);
//						}

					}
					listNhap.removeAll(listNhap);
//					LuuTam.sanPham.clear();
//					LuuTam.tongTien = 0;
					tien = 0;
					tfTongTien.setText(FormatToVND.vnd(tien));
					loadDataToTableBill(listNhap);

//				tạo phiếu nhập có datetime 
				}
			}
		});
		btnNewButton_1_2.setFont(SetFont.font1_());
		btnNewButton_1_2.setBounds(916, 662, 104, 26);
		getContentPane().add(btnNewButton_1_2);

		textField = new JTextField();
		textField.setFont(SetFont.font1_());
		textField.setHorizontalAlignment(SwingConstants.CENTER);

		textField.setBorder(null);
		textField.setBounds(798, 628, 57, 24);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnNewButton_1_2_1 = new JButton("Hủy");
		btnNewButton_1_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int answ = JOptionPane.showConfirmDialog(null, "Xác nhận hủy đơn hàng?", "Cảnh báo!",
						JOptionPane.YES_NO_OPTION);
				if (answ == JOptionPane.YES_OPTION) {
					listNhap.clear();
//					LuuTam.sanPham.clear();
//					LuuTam.tongTien = 0;
					tien = 0;
					tfTongTien.setText("0đ");
					JOptionPane.showMessageDialog(null, "Đã hủy đơn hàng!");
					loadDataToTableBill(listNhap);
				}
			}
		});
		btnNewButton_1_2_1.setFont(SetFont.font1_());
		btnNewButton_1_2_1.setBounds(1052, 662, 100, 26);
		getContentPane().add(btnNewButton_1_2_1);

		lbTongTien1 = new JLabel("Tổng tiền:");
		lbTongTien1.setFont(SetFont.font1_());
		lbTongTien1.setForeground(SetColor.redB);
		lbTongTien1.setBounds(916, 596, 78, 23);
		getContentPane().add(lbTongTien1);

		btnNewButton_2 = new JButton("Thêm");
		btnNewButton_2.setIcon(new ImageIcon(NhapHangForm.class.getResource("/icon/icons8-add-24.png")));

		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tableALL.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Chọn sản phẩm để thêm!");
				} else {
					if (comboBox_chooseProduct.getSelectedItem().toString().equals("CPU")) {
						cpu cpu = cpuDAO.getInstance().selectNhapHang().get(tableALL.getSelectedRow());

////						kiểm tra số lượng
//						if (kiemTraSoLuongNhap(cpu.getIdCpu(), listNhap) == false) {
//							ChiTietPhieu pn = new ChiTietPhieu(cpu.getIdSanPham(), cpu.getIdCpu(), cpu.getNameCpu(), 1,
//									cpu.getDonGia());
//							listNhap.add(pn);
//						}
						tien += cpu.getDonGia();
						if (listNhap.size() == 0)
							tien = 0;
						tfTongTien.setText(FormatToVND.vnd(tien));

						loadDataToTableBill(listNhap);
						for (ChiTietPhieu ChiTietPhieu : listNhap) {
							System.out.println(ChiTietPhieu.getSoLuong());
						}
//						tạo constructor gồm 4 thông số idsp, idcpu, tencpu, dongia -> done
//						thêm vào arraylist kiểu ChiTietPhieuHang -> done
//						sd loadDataToTable vào bảng tableMin -> done
					} else if (comboBox_chooseProduct.getSelectedItem().toString().equals("RAM")) {
						ram ram = ramDAO.getInstance().selectNhapHang().get(tableALL.getSelectedRow());

//						if (kiemTraSoLuongNhap(ram.getIdRam(), listNhap) == false) {
//							ChiTietPhieu pn = new ChiTietPhieu(ram.getIdSanPham(), ram.getIdRam(), ram.getTenRam(), 1,
//									ram.getDonGia());
//							listNhap.add(pn);
//						}
						tien += ram.getDonGia();
						if (listNhap.size() == 0)
							tien = 0;
						tfTongTien.setText(FormatToVND.vnd(tien));

						loadDataToTableBill(listNhap);
					} else if (comboBox_chooseProduct.getSelectedItem().toString().equals("VGA")) {
						vga vga = vgaDAO.getInstance().selectNhapHang().get(tableALL.getSelectedRow());

//						if (kiemTraSoLuongNhap(vga.getIdVga(), listNhap) == false) {
//							ChiTietPhieu pn = new ChiTietPhieu(vga.getIdSanPham(), vga.getIdVga(), vga.getTenVGA(), 1,
//									vga.getDonGia());
//							listNhap.add(pn);
//						}
						tien += vga.getDonGia();
						if (listNhap.size() == 0)
							tien = 0;
						tfTongTien.setText(FormatToVND.vnd(tien));

						loadDataToTableBill(listNhap);
					}

				}
			}
		});
		btnNewButton_2.setFont(SetFont.font1_());
		btnNewButton_2.setBounds(648, 3, 104, 30);
		getContentPane().add(btnNewButton_2);

//		ArrayList<KhachHang> list = KhachHangDAO.getInstance().selectAll();
//		String[] combo = new String[list.size()];
//		for (int i = 0; i < list.size(); i++) {
//			KhachHang kh = list.get(i);
//			combo[i] = kh.getIdKhachHang();
//		}
		

		comboBox_chonKhachHang = new JComboBox<>();
		comboBox_chonKhachHang.setModel(new DefaultComboBoxModel<String>(new String[] {"test", "new"}));
		comboBox_chonKhachHang.setBounds(760, 594, 133, 22);
		getContentPane().add(comboBox_chonKhachHang);

		String[] allProduct = { "CPU", "RAM", "VGA", "Mainboard", "Case", "Nguồn", "Màn hình", "Chuột", "Bàn phím",
				"Tai nghe" };
		comboBox_chooseProduct = new JComboBox<>(allProduct);
		comboBox_chooseProduct.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBox_chooseProduct.getSelectedItem().toString().equals("CPU")) {
					setDefaultTable("cpu");
				} else if (comboBox_chooseProduct.getSelectedItem().toString().equals("RAM")) {
					setDefaultTable("ram");
				} else if (comboBox_chooseProduct.getSelectedItem().toString().equals("VGA")) {
					setDefaultTable("vga");
				}

			}
		});
		comboBox_chooseProduct.setBounds(522, 3, 116, 30);
		getContentPane().add(comboBox_chooseProduct);

		textField_1 = new JTextField();
		textField_1.setName("");
		textField_1.setToolTipText("");
		textField_1.setBounds(241, 3, 271, 30);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("XUẤT HÀNG");
		lblNewLabel.setFont(SetFont.fontTitle());
		lblNewLabel.setBounds(10, 6, 219, 26);
		getContentPane().add(lblNewLabel);

	}

	public static void loadDataToTableBill(ArrayList<ChiTietPhieu> pn) {
		try {
			tableModelBill.setRowCount(0);
			for (ChiTietPhieu i : pn) {
				DefaultTableCellRenderer renderRight = new DefaultTableCellRenderer();
				renderRight.setHorizontalAlignment(JLabel.RIGHT);
				tableMin.getColumnModel().getColumn(4).setCellRenderer(renderRight);
//				String gia = FormatToVND.vnd(i.getGia());
				tableModelBill.addRow(
						new Object[] { i.getIdSanPham(), i.getIdRieng(), i.getTenSanPham(), i.getSoLuong(), i.getDonGia() });
			}
		} catch (Exception e) {
		}
	}

	public void setDefaultTableBill(ArrayList<ChiTietPhieu> pn) {
		tableModelBill = new DefaultTableModel();
		tableModelBill.setColumnIdentifiers(columNameBill);
		tableMin.setDefaultEditor(Object.class, null);
		tableMin.setModel(tableModelBill);
		tableMin.getColumnModel().getColumn(0).setPreferredWidth(200);
		tableMin.getColumnModel().getColumn(1).setPreferredWidth(150);
		tableMin.getColumnModel().getColumn(2).setPreferredWidth(300);
		tableMin.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableMin.getColumnModel().getColumn(4).setPreferredWidth(200);

		loadDataToTableBill(pn);
	}

//	private boolean kiemTraSoLuongNhap(String id, ArrayList<ChiTietPhieu> list) {
//		for (ChiTietPhieu ChiTietPhieu : list) {
//			if (ChiTietPhieu.getPrivateId().equals(id)) {
//				ChiTietPhieu.setSoLuong(ChiTietPhieu.getSoLuong() + 1);
//				return true;
//			}
//		}
//		return false;
//	}

	private String createIDPhieuNhap(ArrayList<PhieuXuat> arr) {
//		String id = "pn";
//		int code = 0;
//
//		ArrayList<PhieuNhap> list = PhieuNhapDAO.getInstance().selectAll();
//
////		Collections.sort(list, new Comparator<PhieuNhap>() {
////
////			@Override
////			public int compare(PhieuNhap o1, PhieuNhap o2) {
////
////				if (Double.parseDouble((String) o1.getIdPhieu().substring(2, o1.getIdPhieu().length())) > Double
////						.parseDouble((String) o2.getIdPhieu().substring(2, o2.getIdPhieu().length()))) {
////					return 1;
////				}else if(Double.parseDouble((String) o1.getIdPhieu().substring(2, o1.getIdPhieu().length())) > Double
////						.parseDouble((String) o2.getIdPhieu().substring(2, o2.getIdPhieu().length()))) return -1;
////
////				return 0;
////			}
////		});
//		for (PhieuNhap phieuNhap : list) {
//			if (phieuNhap.getIdPhieu().equals(id + code))
//				code++;
//			else
//				break;
//		}
//
//		return id + code;

		int id = arr.size() + 1;
		String check = "";
		for (PhieuXuat phieuXuat : arr) {
			if (phieuXuat.getIdPhieu().equals("px" + id)) {
				check = phieuXuat.getIdPhieu();
			}
		}
		while (check.length() != 0) {
			String c = check;
			id++;
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i).getIdPhieu().equals("px" + id)) {
					check = arr.get(i).getIdPhieu();
				}
			}
			if (check.equals(c)) {
				check = "";
			}
		}
		return "px" + id;
	}
}
