package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class MainForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Font font;
	public Font font_1;
	public Font font1;
	public Font font2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
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
	public MainForm() {
		try {
			File fontStyle = new File("src/font/Roboto-Medium.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(11f);
			font_1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(14f);
			font1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(16f);
			font2 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(22f);

		} catch (Exception e) {
			System.out.println(e);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 598);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel navbar = new JPanel();
		navbar.setBounds(0, 0, 191, 563);
		contentPane.add(navbar);
		navbar.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hello Admin");
		lblNewLabel.setFont(font1);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 171, 26);
		navbar.add(lblNewLabel);
		
		JLabel lblHaveAGood = new JLabel("Have a good day!!!");
		lblHaveAGood.setFont(font1);
		lblHaveAGood.setHorizontalAlignment(SwingConstants.CENTER);
		lblHaveAGood.setFont(null);
		lblHaveAGood.setBounds(10, 34, 171, 20);
		navbar.add(lblHaveAGood);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-show-password-16.png")));
		btnNewButton.setBounds(0, 64, 191, 37);
		navbar.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBounds(0, 102, 191, 37);
		navbar.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("New button");
		btnNewButton_2_1.setBorder(null);
		btnNewButton_2_1.setBounds(0, 177, 191, 37);
		navbar.add(btnNewButton_2_1);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBounds(0, 139, 191, 37);
		navbar.add(btnNewButton_1);
		
		JButton btnNewButton_2_2 = new JButton("New button");
		btnNewButton_2_2.setBorder(null);
		btnNewButton_2_2.setBounds(0, 263, 191, 37);
		navbar.add(btnNewButton_2_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setBounds(0, 225, 191, 37);
		navbar.add(btnNewButton_3);
		
		JButton btnNewButton_2_3 = new JButton("New button");
		btnNewButton_2_3.setBorder(null);
		btnNewButton_2_3.setBounds(0, 526, 191, 37);
		navbar.add(btnNewButton_2_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBorder(null);
		btnNewButton_4.setBounds(0, 488, 191, 37);
		navbar.add(btnNewButton_4);
		
		JPanel maincontent = new JPanel();
		maincontent.setBounds(193, 0, 605, 563);
		contentPane.add(maincontent);
	}
}
