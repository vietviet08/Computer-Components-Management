package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class ThongKeForm extends JInternalFrame {

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
		
		JLabel lblNewLabel = new JLabel("THỐNG KÊ FORM");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 46));
		lblNewLabel.setBounds(10, 11, 479, 124);
		getContentPane().add(lblNewLabel);

	}

}
