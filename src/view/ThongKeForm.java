package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import color.SetColor;
import dao.KhachHangDAO;
import dao.PhieuNhapDAO;
import dao.PhieuXuatDAO;
import dao.SanPhamDAO;
import decor.PanelRoundThongKe;
import font.SetFont;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ThongKeForm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKeForm frame = new ThongKeForm();
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
	public ThongKeForm() {
		setBounds(100, 100, 1170, 730);
		getContentPane().setLayout(null);

		PanelRoundThongKe panel = new PanelRoundThongKe();
		panel.setColorTo(new Color(42, 8, 69));
		panel.setColorFrom(new Color(100, 65, 165));
		panel.setRoundTopRight(40);
		panel.setRoundTopLeft(40);
		panel.setRoundBottomRight(40);
		panel.setRoundBottomLeft(40);
		panel.setBounds(22, 26, 260, 140);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel tfLoaiSP = new JLabel("Tổng sản phẩm");
		tfLoaiSP.setHorizontalAlignment(SwingConstants.CENTER);
		tfLoaiSP.setForeground(SetColor.whiteFont);
		tfLoaiSP.setFont(SetFont.fontThongKe());
		tfLoaiSP.setBounds(0, 0, 172, 68);
		panel.add(tfLoaiSP);

		JLabel tfLoaiSP_1 = new JLabel("");
		tfLoaiSP_1.setIcon(new ImageIcon(ThongKeForm.class.getResource("/icon/icons8-product-75.png")));
		tfLoaiSP_1.setHorizontalAlignment(SwingConstants.CENTER);
		tfLoaiSP_1.setForeground(new Color(254, 254, 254));
		tfLoaiSP_1.setFont(null);
		tfLoaiSP_1.setBounds(156, 26, 94, 68);
		panel.add(tfLoaiSP_1);

		JLabel tfLoaiSP_1_1 = new JLabel(String.valueOf(SanPhamDAO.getInstance().selectAll().size()));
		tfLoaiSP_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		tfLoaiSP_1_1.setForeground(new Color(254, 254, 254));
		tfLoaiSP_1_1.setFont(SetFont.fontThongKe1());
		tfLoaiSP_1_1.setBounds(32, 68, 94, 34);

		panel.add(tfLoaiSP_1_1);

		PanelRoundThongKe panel_1 = new PanelRoundThongKe();
		panel_1.setRoundTopRight(40);
		panel_1.setRoundTopLeft(40);
		panel_1.setRoundBottomRight(40);
		panel_1.setRoundBottomLeft(40);
		panel_1.setColorTo(new Color(248, 54, 0));
		panel_1.setColorFrom(new Color(254, 140, 0));
		panel_1.setBounds(305, 26, 260, 140);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel tfLoaiSP_1_1_1 = new JLabel(String.valueOf(KhachHangDAO.getInstance().selectAll().size()));
		tfLoaiSP_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		tfLoaiSP_1_1_1.setForeground(new Color(254, 254, 254));
		tfLoaiSP_1_1_1.setFont(SetFont.fontThongKe1());
		tfLoaiSP_1_1_1.setBounds(32, 79, 94, 34);
		panel_1.add(tfLoaiSP_1_1_1);

		JLabel lblKhchHng = new JLabel("Khách hàng");
		lblKhchHng.setHorizontalAlignment(SwingConstants.CENTER);
		lblKhchHng.setForeground(new Color(254, 254, 254));
		lblKhchHng.setFont(SetFont.fontThongKe());
		lblKhchHng.setBounds(0, 11, 172, 43);
		panel_1.add(lblKhchHng);

		JLabel tfLoaiSP_1_2 = new JLabel("");
		tfLoaiSP_1_2.setIcon(new ImageIcon(ThongKeForm.class.getResource("/icon/icons8-group-75.png")));
		tfLoaiSP_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		tfLoaiSP_1_2.setForeground(new Color(254, 254, 254));
		tfLoaiSP_1_2.setFont(null);
		tfLoaiSP_1_2.setBounds(156, 37, 94, 68);
		panel_1.add(tfLoaiSP_1_2);

		JLabel lblThamGia = new JLabel("đã tham gia");
		lblThamGia.setHorizontalAlignment(SwingConstants.CENTER);
		lblThamGia.setForeground(new Color(254, 254, 254));
		lblThamGia.setFont(SetFont.fontThongKe());
		lblThamGia.setBounds(0, 37, 172, 43);
		panel_1.add(lblThamGia);

		PanelRoundThongKe panel_1_1 = new PanelRoundThongKe();
		panel_1_1.setRoundTopRight(40);
		panel_1_1.setRoundTopLeft(40);
		panel_1_1.setRoundBottomRight(40);
		panel_1_1.setRoundBottomLeft(40);
		panel_1_1.setColorTo(new Color(0, 114, 225));
		panel_1_1.setColorFrom(new Color(0, 198, 225));
		panel_1_1.setBounds(880, 26, 260, 140);
		getContentPane().add(panel_1_1);
		panel_1_1.setLayout(null);

		JLabel tfLoaiSP_1_1_3 = new JLabel(String.valueOf(PhieuXuatDAO.getInstance().selectAll().size()));
		tfLoaiSP_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		tfLoaiSP_1_1_3.setForeground(new Color(254, 254, 254));
		tfLoaiSP_1_1_3.setFont(SetFont.fontThongKe1());
		tfLoaiSP_1_1_3.setBounds(32, 79, 94, 34);
		panel_1_1.add(tfLoaiSP_1_1_3);

		JLabel lblTngnXut = new JLabel("Tổng đơn xuất");
		lblTngnXut.setHorizontalAlignment(SwingConstants.CENTER);
		lblTngnXut.setForeground(new Color(254, 254, 254));
		lblTngnXut.setFont(SetFont.fontThongKe());
		lblTngnXut.setBounds(0, 11, 172, 68);
		panel_1_1.add(lblTngnXut);

		JLabel tfLoaiSP_1_4 = new JLabel("");
		tfLoaiSP_1_4.setIcon(new ImageIcon(ThongKeForm.class.getResource("/icon/icons8-detail-75 (1).png")));
		tfLoaiSP_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		tfLoaiSP_1_4.setForeground(new Color(254, 254, 254));
		tfLoaiSP_1_4.setFont(null);
		tfLoaiSP_1_4.setBounds(156, 30, 94, 75);
		panel_1_1.add(tfLoaiSP_1_4);

		PanelRoundThongKe panel_2 = new PanelRoundThongKe();
		panel_2.setRoundTopRight(40);
		panel_2.setRoundTopLeft(40);
		panel_2.setRoundBottomRight(40);
		panel_2.setRoundBottomLeft(40);
		panel_2.setColorTo(new Color(154, 132, 120));
		panel_2.setColorFrom(new Color(30, 19, 12));
		panel_2.setBounds(592, 26, 260, 140);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel tfLoaiSP_1_1_2 = new JLabel(String.valueOf(PhieuNhapDAO.getInstance().selectAll().size()));
		tfLoaiSP_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		tfLoaiSP_1_1_2.setForeground(new Color(254, 254, 254));
		tfLoaiSP_1_1_2.setFont(SetFont.fontThongKe1());
		tfLoaiSP_1_1_2.setBounds(32, 79, 94, 34);
		panel_2.add(tfLoaiSP_1_1_2);

		JLabel lblTngnNhp = new JLabel("Tổng đơn nhập");
		lblTngnNhp.setHorizontalAlignment(SwingConstants.CENTER);
		lblTngnNhp.setForeground(new Color(254, 254, 254));
		lblTngnNhp.setFont(SetFont.fontThongKe());
		lblTngnNhp.setBounds(0, 11, 172, 68);
		panel_2.add(lblTngnNhp);

		JLabel tfLoaiSP_1_3 = new JLabel("");
		tfLoaiSP_1_3.setIcon(new ImageIcon(ThongKeForm.class.getResource("/icon/icons8-detail-75.png")));
		tfLoaiSP_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		tfLoaiSP_1_3.setForeground(new Color(254, 254, 254));
		tfLoaiSP_1_3.setFont(null);
		tfLoaiSP_1_3.setBounds(156, 37, 94, 68);
		panel_2.add(tfLoaiSP_1_3);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(22, 197, 1118, 493);
		getContentPane().add(tabbedPane);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Sản phẩm nổi bật", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel labelIMG = new JLabel("Ảnh sản phẩm");
		labelIMG.setHorizontalAlignment(SwingConstants.CENTER);
		labelIMG.setBounds(43, 34, 380, 380);
		panel_3.add(labelIMG);
		
		JLabel labelTenSP = new JLabel("Tên sản phẩm");
		labelTenSP.setBounds(477, 36, 626, 29);
		panel_3.add(labelTenSP);
		
		JLabel labelGia = new JLabel("1999999vnd");
		labelGia.setBounds(477, 274, 626, 29);
		panel_3.add(labelGia);
		
		JLabel labelBaoHanh = new JLabel("12 Tháng");
		labelBaoHanh.setBounds(477, 323, 626, 29);
		panel_3.add(labelBaoHanh);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(240, 240, 240));
		textArea.setBounds(477, 74, 449, 189);
		panel_3.add(textArea);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Khách hàng thân quen", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Thống kê sản phẩm", null, panel_5, null);

	}
}
