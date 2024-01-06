package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import color.SetColor;
import dao.cpuDAO;
import dao.mainDAO;
import dao.ramDAO;
import dao.vgaDAO;
import font.SetFont;
import model.cpu;
import model.mainboard;
import model.ram;
import model.vga;

public class ChiTietSP extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextArea textArea;
	private static String id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					setId(key);
					ChiTietSP frame = new ChiTietSP();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					if (id.contains("cpu"))
						setDetailToCPU();
					else if (id.contains("r"))
						setDetailToRAM();
					else if (id.contains("vga"))
						setDetailToVGA();
					else if (id.contains("mba"))
						setDetailToMainboard();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChiTietSP() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 410, 473);
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 25, 25));
		contentPane = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics grphcs) {
				super.paintComponent(grphcs);
				Graphics2D g2d = (Graphics2D) grphcs;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				GradientPaint gp = new GradientPaint(0, 0, new Color(102, 125, 182), 0, getHeight(),
						new Color(0, 130, 200));
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, getWidth(), getHeight());

			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textArea = new JTextArea();
		textArea.setFont(SetFont.fontDetails1());
		textArea.setWrapStyleWord(true);
		textArea.setWrapStyleWord(true);
		textArea.setBounds(10, 39, 390, 375);
		contentPane.add(textArea);

		JButton btnNewButton = new JButton("Đóng");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeFrame();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(SetColor.redB);
				btnNewButton.setForeground(SetColor.whiteFont);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(SetColor.whiteFont);
				btnNewButton.setForeground(Color.black);

			}
		});
		btnNewButton.setFont(SetFont.font());
		btnNewButton.setBounds(154, 425, 107, 34);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("CHI TIẾT");
		lblNewLabel.setFont(SetFont.fontTitle());
		lblNewLabel.setForeground(SetColor.yellow);
		lblNewLabel.setBounds(10, 11, 378, 26);
		contentPane.add(lblNewLabel);
	}

	private void closeFrame() {
		this.dispose();
	}

	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		ChiTietSP.id = id;
	}

	private static void setDetailToCPU() {
		cpu cpu = cpuDAO.getInstance().selectById(id);
		textArea.setText("-- ID sản phẩm: " + cpu.getIdSanPham() + "\n-- ID CPU: " + cpu.getIdCpu() + "\n-- Tên CPU: "
				+ cpu.getNameCpu() + "\n-- Xung nhịp: " + cpu.getXungNhip() + "\n-- Số nhân: " + cpu.getSoNhan()
				+ "\n-- Số luồng: " + cpu.getSoLuong() + "\n-- Điện năng tiêu thụ: " + cpu.getDienNangTieuThu()
				+ "\n-- Bộ nhớ đệm: " + cpu.getBoNhoDem());
	}

	private static void setDetailToRAM() {
		ram ram = ramDAO.getInstance().selectById(id);
		System.out.println(id);
		textArea.setText("-- ID sản phẩm: " + ram.getIdSanPham() + "\n-- ID RAM: " + ram.getIdRam() + "\n-- Tên RAM: "
				+ ram.getTenRam() + "\n-- Loại RAM: " + ram.getLoai() + "\n-- Dung Lượng: " + ram.getDungLuong()
				+ "\n-- BUS: " + ram.getBus());
	}

	private static void setDetailToVGA() {
		vga vga = vgaDAO.getInstance().selectById(id);
		textArea.setText("-- ID sản phẩm: " + vga.getIdSanPham() + "\n-- ID VGA: " + vga.getIdVga() + "\n-- Tên VGA: "
				+ vga.getTenVGA() + "\n-- Hãng VGA: " + vga.getHangVGA() + "\n-- Bộ nhớ: " + vga.getBoNho());
	}
	
	private static void setDetailToMainboard() {
		mainboard mb = mainDAO.getInstance().selectById(id);
		textArea.setText("ok mainboard!!!!!! \nquocviet");
	}
}
