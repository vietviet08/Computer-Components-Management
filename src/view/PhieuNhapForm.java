package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.toedter.calendar.JDateChooser;

import color.SetColor;
import controller.ConvertDate;
import controller.FormatToVND;
import dao.ChiTietPhieuNhapDAO;
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
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBoxSort;
	private JDateChooser chooseFrom;
	private JDateChooser chooseTo;

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
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm");

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

				tableModel.addRow(new Object[] { i.getIdPhieu(), i.getIdNPP(), formatDate.format(i.getThoiGianTao()),
						i.getNguoiTao(), gia, i.getTrangThai() });
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
		lblNewLabel_2.setBounds(1104, 12, 48, 22);
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
		table.getTableHeader().setBackground(SetColor.blueOp);
		table.getTableHeader().setFont(SetFont.fontHeaderTable());
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "New column", "New column", "New column",
				"New column", "New column", "New column", "New column" }));
		scrollPane.setViewportView(table);
		setDefaultTable();

		JButton btnNewButton_1 = new JButton("Chi tiết");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRow() == -1)
					JOptionPane.showMessageDialog(null, "Vui lòng chọn đơn để xem chi tiết!");
				else
					DetailPhieuNhap.main(null);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(PhieuNhapForm.class.getResource("/icon/icons8-details-24.png")));
		btnNewButton_1.setFont(SetFont.font());
		btnNewButton_1.setBounds(0, 5, 99, 33);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn đơn để xóa!");
				} else {
					int answ = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn xóa đơn hàng này?", "Cảnh báo!",
							JOptionPane.YES_NO_OPTION);
					if (answ == JOptionPane.YES_OPTION) {
						ChiTietPhieuNhapDAO.getInstance().deleteByID(
								PhieuNhapDAO.getInstance().selectAll().get(table.getSelectedRow()).getIdPhieu());
						PhieuNhapDAO.getInstance()
								.delete(PhieuNhapDAO.getInstance().selectAll().get(table.getSelectedRow()));
						loadDataToTable(PhieuNhapDAO.getInstance().selectAll());
					}
				}
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(PhieuNhapForm.class.getResource("/icon/icons8-delete-24.png")));
		btnNewButton_2.setFont(SetFont.font());
		btnNewButton_2.setBounds(106, 5, 99, 33);
		getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Sửa");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(PhieuNhapForm.class.getResource("/icon/icons8-edit-24.png")));
		btnNewButton_3.setFont(SetFont.font());
		btnNewButton_3.setBounds(213, 5, 87, 33);
		getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Nhập Excel");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();

				int rowBanDau = model.getRowCount();

				File excelFile;
				FileInputStream excelFIS = null;
				BufferedInputStream excelBIS = null;
				XSSFWorkbook excelImportToJTable = null;
				String defaultCurrentDirectoryPath = "C:\\Users\\DELL\\Desktop";
				JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
				excelFileChooser.setDialogTitle("Select Excel File");
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
				excelFileChooser.setFileFilter(fnef);
				int excelChooser = excelFileChooser.showOpenDialog(null);
				if (excelChooser == JFileChooser.APPROVE_OPTION) {
					try {
						excelFile = excelFileChooser.getSelectedFile();
//		                jExcelFilePath.setText(excelFile.toString());
						excelFIS = new FileInputStream(excelFile);
						excelBIS = new BufferedInputStream(excelFIS);
						excelImportToJTable = new XSSFWorkbook(excelBIS);
						XSSFSheet excelSheet = excelImportToJTable.getSheetAt(0);

						for (int row = 1; row <= excelSheet.getLastRowNum(); row++) {
							XSSFRow excelRow = excelSheet.getRow(row);
							XSSFCell iddonnhap = excelRow.getCell(0);
							XSSFCell idnpp = excelRow.getCell(1);
							XSSFCell tgnhap = excelRow.getCell(2);
							XSSFCell nguoitao = excelRow.getCell(3);
							XSSFCell tongtien = excelRow.getCell(4);
							XSSFCell trangthai = excelRow.getCell(5);

							model.addRow(new Object[] { iddonnhap, idnpp, tgnhap, nguoitao, tongtien, trangthai });
						}
						JOptionPane.showMessageDialog(null, "Thêm thành công!");
						int answ = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm vào csdl không", "Thông báo",
								JOptionPane.YES_NO_OPTION);
						if (answ == JOptionPane.YES_OPTION) {
							for (int i = rowBanDau; i <= model.getRowCount(); i++) {

								String iddonnhap = model.getValueAt(i, 0).toString();
								String idnpp = model.getValueAt(i, 1).toString();
								java.sql.Timestamp tgnhap = (java.sql.Timestamp) model.getValueAt(i, 2);
								String nguoitao = model.getValueAt(i, 3).toString();
								double tongtien = (double) model.getValueAt(i, 4);
								int trangthai = (int) model.getValueAt(i, 5);

								PhieuNhap pn = new PhieuNhap(iddonnhap, idnpp, tgnhap, nguoitao, tongtien, trangthai);

								PhieuNhapDAO.getInstance().insert(pn);
							}
						}
					} catch (IOException iOException) {
						JOptionPane.showMessageDialog(null, iOException.getMessage());
					} finally {
						try {
							if (excelFIS != null) {
								excelFIS.close();
							}
							if (excelBIS != null) {
								excelBIS.close();
							}
							if (excelImportToJTable != null) {
								excelImportToJTable.close();
							}
						} catch (IOException iOException) {
							JOptionPane.showMessageDialog(null, iOException.getMessage());
						}
					}
				}

			}
		});
		btnNewButton_4.setIcon(new ImageIcon(PhieuNhapForm.class.getResource("/icon/icons8-import-csv-24.png")));
		btnNewButton_4.setFont(SetFont.font());
		btnNewButton_4.setBounds(308, 5, 123, 33);
		getContentPane().add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Xuất Excel");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					JFileChooser jFileChooser = new JFileChooser();
					jFileChooser.showSaveDialog(null);
					File saveFile = jFileChooser.getSelectedFile();
					if (saveFile != null) {
						saveFile = new File(saveFile.toString() + ".xlsx");
						Workbook wb = new XSSFWorkbook();
						Sheet sheet = wb.createSheet("Phiếu nhập");

						Row rowCol = sheet.createRow(0);
						for (int i = 0; i < table.getColumnCount(); i++) {
							org.apache.poi.ss.usermodel.Cell cell = rowCol.createCell(i);
							cell.setCellValue(table.getColumnName(i));
						}

						for (int j = 0; j < table.getRowCount(); j++) {
							Row row = sheet.createRow(j + 1);
							for (int k = 0; k < table.getColumnCount(); k++) {
								org.apache.poi.ss.usermodel.Cell ce = row.createCell(k);
								if (table.getValueAt(j, k) != null) {
									ce.setCellValue(table.getValueAt(j, k).toString());
								}

							}
						}
						FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
						wb.write(out);
						wb.close();
						out.close();
						openFile(saveFile.toString());
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}

			}
		});
		btnNewButton_5.setIcon(new ImageIcon(PhieuNhapForm.class.getResource("/icon/icons8-export-excel-24.png")));
		btnNewButton_5.setFont(SetFont.font());
		btnNewButton_5.setBounds(440, 5, 123, 33);
		getContentPane().add(btnNewButton_5);

		comboBoxSort = new JComboBox<String>(new DefaultComboBoxModel<String>(new String[] { "Sắp xếp", "Đã thanh toán",
				"Chưa thanh toán", "Tổng tiền tăng dần", "Tổng tiền giảm dần" }));
		comboBoxSort.setFont(SetFont.font());
		comboBoxSort.setBounds(848, 5, 77, 32);
		getContentPane().add(comboBoxSort);

		comboBox = new JComboBox<String>(new DefaultComboBoxModel<String>(new String[] { "ID đơn nhập",
				"ID nhà phân phối", "Thời gian nhập", "Người tạo", "Tổng tiền", "Trạng thái" }));
		comboBox.setFont(SetFont.font());
		comboBox.setBounds(932, 5, 99, 33);
		getContentPane().add(comboBox);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		textField.setColumns(10);
		textField.setBounds(1037, 5, 123, 33);
		getContentPane().add(textField);

		chooseFrom = new JDateChooser();
		chooseFrom.setDateFormatString("dd/MM/yyyy");

		chooseFrom.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (chooseFrom.getDate() != null || chooseTo.getDate() != null)
					loadDataToTable(timKiemTheoLich());
			}
		});
		chooseFrom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				loadDataToTable(timKiemTheoLich());
			}
		});
		chooseFrom.setBounds(570, 5, 105, 33);
		getContentPane().add(chooseFrom);

		chooseTo = new JDateChooser();
		chooseTo.setDateFormatString("dd/MM/yyyy");
		chooseTo.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (chooseFrom.getDate() != null || chooseTo.getDate() != null)
					loadDataToTable(timKiemTheoLich());
			}
		});
		chooseTo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				loadDataToTable(timKiemTheoLich());
			}
		});

		chooseTo.setBounds(685, 5, 105, 33);
		getContentPane().add(chooseTo);

		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chooseFrom.setCalendar(null);
				chooseTo.setCalendar(null);
				loadDataToTable(PhieuNhapDAO.getInstance().selectAll());
			}
		});
		btnNewButton.setIcon(new ImageIcon(PhieuNhapForm.class.getResource("/icon/icons8-reset-24.png")));
		btnNewButton.setBounds(800, 5, 40, 33);
		getContentPane().add(btnNewButton);

	}

	private void openFile(String file) {
		try {
			File path = new File(file);
			Desktop.getDesktop().open(path);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private boolean check(Date date, Date from, Date to) {
		return date.getTime() >= from.getTime() && date.getTime() <= to.getTime();
	}

	private ArrayList<PhieuNhap> timKiemTheoLich() {
		ArrayList<PhieuNhap> list = PhieuNhapDAO.getInstance().selectAll();
		ArrayList<PhieuNhap> newlist = new ArrayList<PhieuNhap>();
		if (chooseFrom.getDate() != null || chooseTo.getDate() != null) {
			java.util.Date from;
			java.util.Date to;
			if (chooseFrom.getDate() != null && chooseTo.getDate() == null) {
				try {
					from = ConvertDate.ChangeFrom(chooseFrom.getDate());
					to = new Date();
					for (PhieuNhap phieuNhap : list) {
						if (check(phieuNhap.getThoiGianTao(), from, to))
							newlist.add(phieuNhap);
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} else if (chooseFrom.getDate() == null && chooseTo.getDate() != null) {
				try {
					from = ConvertDate.ChangeFrom(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1990"));
					to = ConvertDate.ChangeTo(chooseTo.getDate());
					for (PhieuNhap phieuNhap : list) {
						if (check(phieuNhap.getThoiGianTao(), from, to))
							newlist.add(phieuNhap);
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} else {
				try {
					from = ConvertDate.ChangeTo(chooseFrom.getDate());
					to = ConvertDate.ChangeTo(chooseTo.getDate());
					if (from.getTime() > to.getTime()) {
						JOptionPane.showMessageDialog(null, "Lỗi chọn thời gian!");
						chooseFrom.setCalendar(null);
						chooseTo.setCalendar(null);
					} else
						for (PhieuNhap phieuNhap : list)
							if (check(phieuNhap.getThoiGianTao(), from, to))
								newlist.add(phieuNhap);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(newlist.size());
		return newlist;
	}

	public static PhieuNhap getPhieuNhapSelect() {
		PhieuNhap pn = PhieuNhapDAO.getInstance().selectAll().get(table.getSelectedRow());
		return pn;
	}
}
