package view;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.NhaPhanPhoiDAO;
import model.NhaPhanPhoi;

public class ThemNhaPhanPhoi extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfDiaChi;
	private JTextField tfSDT;
	private JTextField tfTen;
	private JTextField tfEmail;
	private JTextField tfID;
	private NhaPhanPhoiForm nppf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemNhaPhanPhoi frame = new ThemNhaPhanPhoi();
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
	public ThemNhaPhanPhoi() {
		setUndecorated(true);
		this.nppf = (NhaPhanPhoiForm) nppf;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setTitle("Thêm nhà phân phối");
		
		setBounds(100, 100, 779, 373);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID Nhà phân phối");
		lblNewLabel.setBounds(55, 25, 321, 39);
		getContentPane().add(lblNewLabel);
		
		tfID = new JTextField();
		tfID.setBounds(55, 64, 321, 49);
		getContentPane().add(tfID);
		tfID.setColumns(10);
		
		tfDiaChi = new JTextField();
		tfDiaChi.setColumns(10);
		tfDiaChi.setBounds(55, 163, 321, 49);
		getContentPane().add(tfDiaChi);
		
		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setBounds(55, 124, 321, 39);
		getContentPane().add(lblaCh);
		
		tfSDT = new JTextField();
		tfSDT.setColumns(10);
		tfSDT.setBounds(55, 262, 321, 49);
		getContentPane().add(tfSDT);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setBounds(55, 223, 321, 39);
		getContentPane().add(lblSinThoi);
		
		tfTen = new JTextField();
		tfTen.setColumns(10);
		tfTen.setBounds(404, 64, 321, 49);
		getContentPane().add(tfTen);
		
		JLabel lblTnNhPhn = new JLabel("Tên nhà phân phối");
		lblTnNhPhn.setBounds(404, 25, 321, 39);
		getContentPane().add(lblTnNhPhn);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(404, 163, 321, 49);
		getContentPane().add(tfEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(404, 124, 321, 39);
		getContentPane().add(lblEmail);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = tfID.getText().trim();
				String ten = tfTen.getText().trim();
				String diaChi = tfDiaChi.getText().trim();
				String email = tfEmail.getText().trim();
				int sdt = Integer.parseInt(tfSDT.getText().trim());
				
				if(id.equals("") || ten.equals("")) {
					JOptionPane.showMessageDialog(null, "ID và tên không được bỏ trống!");
				}else {
					if(NhaPhanPhoiDAO.getInstance().selectById(id)==null) {
						NhaPhanPhoi npp = new NhaPhanPhoi();
						npp.setIdNPP(id);
						npp.setTenNPP(ten);
						npp.setDiaChi(diaChi);
						npp.setEmail(email);
						npp.setSdt(sdt);
						NhaPhanPhoiDAO.getInstance().insert(npp);
						JOptionPane.showMessageDialog(null, "Thêm thành công!");
						
//						nppf.loadDataToTable(NhaPhanPhoiDAO.getInstance().selectAll());	
						thoatCuaSo();
					}else JOptionPane.showMessageDialog(null, "ID nhà phân phối đã tồn tại!");
				}
				
			}
		});
		btnThem.setBounds(404, 262, 150, 49);
		getContentPane().add(btnThem);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				thoatCuaSo();
			}
		});
		btnHuy.setBounds(575, 262, 150, 49);
		getContentPane().add(btnHuy);

	}
	
	private void thoatCuaSo() {
		this.dispose();
	}
}
