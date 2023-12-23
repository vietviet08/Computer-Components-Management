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
import dao.NhaPhanPhoiDAO;
import dao.SanPhamDAO;
import dao.cpuDAO;
import dao.ramDAO;
import dao.vgaDAO;
import font.SetFont;
import model.NhaPhanPhoi;
import model.ProductNhap;
import model.Products;
import model.cpu;
import model.ram;
import model.vga;

public class PhieuNhapForm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private static JTable tableALL;
	private static JTable tableMin;
	private static DefaultTableModel tableModel;
	private final String columName[] = { "ID sản phẩm", "Tên sản phẩm", "Đơn giá" };
	private JTextField textField_1;
	private JComboBox<String> comboBox_chooseProduct;
	private JButton btnNewButton_2;
	private JComboBox<String> comboBox_chooseNPP;
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

	public PhieuNhapForm() {
		setBounds(100, 100, 1200, 530);
		getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setIcon(new ImageIcon(PhieuNhapForm.class.getResource("/icon/icons8-search-24.png")));
		lblNewLabel_1.setBounds(508, 7, 48, 22);
		getContentPane().add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 36, 801, 420);
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
		tableALL.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "New column", "New column", "New column", "New column" }));
		scrollPane.setViewportView(tableALL);
		setDefaultTable("cpu");

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(811, 0, 381, 397);
		getContentPane().add(scrollPane_1);

		tableMin = new JTable();
		tableMin.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "New column", "New column", "New column" }));
		scrollPane_1.setViewportView(tableMin);

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

		lbTongTien1 = new JLabel("Tổng tiền:");
		lbTongTien1.setFont(SetFont.font1());
		lbTongTien1.setForeground(SetColor.redB);
		lbTongTien1.setBounds(746, 469, 94, 23);
		getContentPane().add(lbTongTien1);

		btnNewButton_2 = new JButton("Thêm");
		btnNewButton_2.setIcon(new ImageIcon(PhieuNhapForm.class.getResource("/icon/icons8-add-24.png")));
		
		ArrayList<ProductNhap> listNhap = new ArrayList<ProductNhap>();
		
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tableALL.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Chọn sản phẩm để thêm!");
				} else {
//					new arraylist
					ArrayList<cpu> listCPU = new ArrayList<>();
//					Products p = getProductSelect();
					cpu cpu = new cpu();
					if (comboBox_chooseProduct.getSelectedItem().toString().equals("CPU")) {
						cpu = cpuDAO.getInstance().selectNhapHang().get(tableALL.getSelectedRow());
//						setTotalPrice(cpu.getDonGia());
						tien += cpu.getDonGia();
//						tfTongTien.setText(FormatToVND.vnd(Double.parseDouble(tfTongTien.getText())+cpu.getDonGia()));
						tfTongTien.setText(FormatToVND.vnd(tien));
						
						System.out.println(cpu.toString());
//						kiểm tra số lượng

						if (kiemTraSoLuongNhap(cpu, listNhap) == false) {

							ProductNhap pn = new ProductNhap(cpu.getIdSanPham(), cpu.getIdCpu(), cpu.getTenSanPham(), 1,
									cpu.getDonGia());
							listNhap.add(pn);
						} else {
							for (ProductNhap productNhap : listNhap) {
								if (productNhap.getPrivateId().equals(cpu.getIdCpu())) {
									productNhap.setSoLuong(productNhap.getSoLuong() + 1);
								}
							}
						}

						for (ProductNhap productNhap : listNhap) {
							System.out.println(productNhap.getSoLuong());
						}

//						listCPU.add(cpu);
//						tạo constructor gồm 4 thông số idsp, idcpu, tencpu, dongia -> done
//						thêm vào arraylist kiểu productNhapHang -> sẽ tạo

//						sd loadDataToTable vào bảng tableMin

					}

				}
			}
		});
		btnNewButton_2.setFont(SetFont.font1_());
		btnNewButton_2.setBounds(697, 2, 104, 30);
		getContentPane().add(btnNewButton_2);

		ArrayList<NhaPhanPhoi> list = NhaPhanPhoiDAO.getInstance().selectAll();
		String[] combo = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			NhaPhanPhoi npp = list.get(i);
			combo[i] = npp.getIdNPP();
		}

		comboBox_chooseNPP = new JComboBox<>();
		comboBox_chooseNPP.setModel(new DefaultComboBoxModel<String>(combo));
		comboBox_chooseNPP.setBounds(811, 397, 155, 22);
		getContentPane().add(comboBox_chooseNPP);

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
		comboBox_chooseProduct.setBounds(571, 3, 116, 27);
		getContentPane().add(comboBox_chooseProduct);

		textField_1 = new JTextField();
		textField_1.setBounds(290, 3, 271, 28);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		tfTongTien = new JTextField();
		tfTongTien.setText("0");
		tfTongTien.setOpaque(false);
		tfTongTien.setBorder(null);
		tfTongTien.setBounds(821, 467, 147, 26);
		getContentPane().add(tfTongTien);
		tfTongTien.setColumns(10);

	}

	private void loadDataToTableBill() {

	}

	private Products getProductSelect() {
		return SanPhamDAO.getInstance().selectAll().get(tableALL.getSelectedRow());
	}


	private boolean kiemTraSoLuongNhap(cpu cpu, ArrayList<ProductNhap> list) {
		for (ProductNhap productNhap : list) {
			if (productNhap.getPrivateId().equals(cpu.getIdCpu())) {
				return true;
			}
		}
		return false;
	}
}
