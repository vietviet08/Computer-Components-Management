package view;

import java.awt.Color;
import java.awt.Desktop.Action;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.formdev.flatlaf.FlatIntelliJLaf;

import color.SetColor;
import controller.BCrypt;
import dao.AccountDAO;
import model.Account;
import java.awt.event.KeyAdapter;

public class LoginForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfuser;
	private JPasswordField jtfpassword;
	public Font font;
	public Font font1;
	public Font font2;
	public Font font_1;
	public static String fullN;
	/**
	 * Launch the application.
	 */
//	static LoginForm frame = new LoginForm();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
					UIManager.setLookAndFeel(new FlatIntelliJLaf());
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
	public LoginForm() {
		
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
		setBounds(100, 100, 438, 574);
		contentPane = new JPanel();
		contentPane.setBackground(SetColor.blueOp);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Stencil", Font.BOLD, 66));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(86, 23, 199, 77);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(font1);
		lblNewLabel_1.setForeground(SetColor.whiteFont);
//		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(86, 125, 260, 23);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_2 = new JLabel("Password");
		lblNewLabel_1_2.setFont(font1);
		lblNewLabel_1_2.setForeground(SetColor.whiteFont);
//		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_2.setBounds(86, 226, 260, 23);
		contentPane.add(lblNewLabel_1_2);

		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					checkLogin();
				}
			}
		});
		
		btnNewButton.setBorder(null);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				checkLogin();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(SetColor.green);
				btnNewButton.setForeground(SetColor.whiteFont);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(Color.WHITE);
				btnNewButton.setForeground(Color.BLACK);
			}
		});
		btnNewButton.setFont(font2);
//		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(86, 353, 262, 38);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("Forgot password?");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				ForgotPassword fp = new ForgotPassword();
//				fp.setVisible(true);
				ForgotPassword.main(null);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_2.setForeground(Color.BLUE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2.setForeground(Color.BLACK);
			}
		});
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(font_1);
//		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(219, 402, 127, 17);
		contentPane.add(lblNewLabel_2);

		jtfuser = new JTextField();
		jtfuser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					checkLogin();
				}
			}
		});
		jtfuser.setBackground(SetColor.blueOp);
		jtfuser.setBorder(null);
		jtfuser.setFont(font_1);
		jtfuser.setBounds(86, 168, 260, 23);
		contentPane.add(jtfuser);
		jtfuser.setColumns(10);

		jtfpassword = new JPasswordField();
		jtfpassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					checkLogin();
				}
			}
		});
		jtfpassword.setBackground(SetColor.blueOp);
		jtfpassword.setEchoChar('*');
		jtfpassword.setBorder(null);
		jtfpassword.setFont(font_1);
		jtfpassword.setBounds(86, 268, 260, 23);
		contentPane.add(jtfpassword);

		JLabel lblNewLabel_2_1 = new JLabel("Create account");
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				CreateAccount ca = new CreateAccount();
				CreateAccount.main(null);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_2_1.setForeground(Color.BLUE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2_1.setForeground(Color.BLACK);
			}
		});
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setFont(font_1);
//		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(86, 402, 114, 17);
		contentPane.add(lblNewLabel_2_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Hiển thị mật khẩu");
		chckbxNewCheckBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					jtfpassword.setEchoChar((char)0);
				}else jtfpassword.setEchoChar('*');
			}
		});
		chckbxNewCheckBox.setFont(font);
		chckbxNewCheckBox.setForeground(SetColor.whiteFont);
		chckbxNewCheckBox.setBackground(SetColor.blueOp);
		chckbxNewCheckBox.setBorder(null);
		chckbxNewCheckBox.setBounds(86, 302, 147, 15);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_3 = new JLabel("© Copyright 2023, Bản quyền thuộc về NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_3.setFont(font);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 485, 406, 31);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBorder(new LineBorder(SetColor.whiteFont));
		lblNewLabel_4.setBounds(86, 195, 260, 2);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setBorder(new LineBorder(SetColor.whiteFont));
		lblNewLabel_4_1.setBounds(86, 294, 260, 2);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(LoginForm.class.getResource("/icon/icons8-admin-64.png")));
		lblNewLabel_5.setBounds(284, 24, 73, 59);
		contentPane.add(lblNewLabel_5);
	}

	public void checkLogin() {
		String usercheck = jtfuser.getText();
		String passwordcheck = jtfpassword.getText();
		if (usercheck.equals("") || passwordcheck.equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ username và passoword!", "Cảnh báo!",
					JOptionPane.WARNING_MESSAGE);
		} else {
			try {
				Account acc = AccountDAO.getInstance().selectById(usercheck);
				if (acc == null) {
					JOptionPane.showMessageDialog(this, "Username không tồn tại trên hệ thống!", "Cảnh báo!",
							JOptionPane.WARNING_MESSAGE);
				} else {
					if (BCrypt.checkpw(passwordcheck, acc.getPassword())) {
						if (acc.getStatus() == 1) {
							try {
								fullN = checkFullName(acc);
								JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
								this.dispose();
								// setvisible main;
								MainForm.main(null);
							} catch (Exception e) {
								System.out.println(e);
							}
						} else {
							JOptionPane.showMessageDialog(this, "Tài khoản của bạn đã bị khóa!", "Cảnh báo!",
									JOptionPane.WARNING_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(this, "Sai mật khẩu!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
					}
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	public String checkFullName(Account ac) {
		String name = ac.getFullName();
		
		
		return name;
		
	}
}
