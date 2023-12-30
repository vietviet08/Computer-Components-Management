package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class KhachHangForm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachHangForm frame = new KhachHangForm();
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
	public KhachHangForm() {
		setBounds(100, 100, 1170, 730);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("KHÁCH HÀNG FORM");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 44));
		lblNewLabel.setBounds(28, 24, 485, 199);
		getContentPane().add(lblNewLabel);

	}

}
