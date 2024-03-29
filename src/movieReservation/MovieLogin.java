package movieReservation;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class MovieLogin extends JFrame{
	private JTextField txtMid;
	private JButton btnJoin,btnFind,btnLogin,btnBackbutton;
	private JPasswordField passwordField;
	MovieCustomerInfoDAO dao = new MovieCustomerInfoDAO();
	MovieVO vo = null;
	
	public MovieLogin() {
		super("로그인 창");
		
		setSize(600,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(255, 255, 255));
		pn1.setBounds(0, 0, 584, 190);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblLogo1 = new JLabel("M");
		lblLogo1.setFont(new Font("HY견고딕", Font.BOLD, 52));
		lblLogo1.setBounds(234, 21, 56, 64);
		pn1.add(lblLogo1);
		
		JLabel lblLogo2 = new JLabel("OVIE");
		lblLogo2.setFont(new Font("HY견고딕", Font.BOLD, 20));
		lblLogo2.setBounds(283, 28, 115, 29);
		pn1.add(lblLogo2);
		
		JLabel lblLogo3 = new JLabel("BOOK");
		lblLogo3.setFont(new Font("HY견고딕", Font.BOLD, 20));
		lblLogo3.setBounds(283, 50, 115, 24);
		pn1.add(lblLogo3);
		
		JLabel lblTitle = new JLabel("로그인");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 35));
		lblTitle.setBounds(226, 134, 123, 46);
		pn1.add(lblTitle);
		
		btnBackbutton = new JButton("");
		btnBackbutton.setBackground(new Color(255, 255, 255));
		btnBackbutton.setIcon(new ImageIcon(MovieLogin.class.getResource("/movieReservation/images/backbutton2.png")));
		btnBackbutton.setBorderPainted(false);		
		btnBackbutton.setBounds(23, 27, 30, 30);
		pn1.add(btnBackbutton);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(new Color(255, 255, 255));
		pn2.setBounds(0, 189, 584, 190);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblMid = new JLabel("아이디");
		lblMid.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMid.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 20));
		lblMid.setBounds(101, 56, 108, 26);
		pn2.add(lblMid);
		
		JLabel lblPwd = new JLabel("비밀번호");
		lblPwd.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPwd.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 20));
		lblPwd.setBounds(101, 128, 108, 26);
		pn2.add(lblPwd);
		
		txtMid = new JTextField();
		txtMid.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 18));
		txtMid.setBounds(233, 52, 215, 40);
		pn2.add(txtMid);
		txtMid.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial Black", Font.PLAIN, 18));
		passwordField.setBounds(233, 124, 215, 40);
		pn2.add(passwordField);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(0, 379, 584, 382);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		btnLogin = new JButton("로그인");
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(128, 128, 128));
		btnLogin.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 22));
		btnLogin.setBounds(142, 10, 311, 48);
		panel_2.add(btnLogin);
		
		JLabel lblNewLabel_4 = new JLabel("아이디/비밀번호를 잊어버리셨나요?");
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(88, 119, 238, 33);
		panel_2.add(lblNewLabel_4);
		
		btnFind = new JButton("아이디/비밀번호 찾기");
		btnFind.setForeground(new Color(255, 255, 255));
		btnFind.setBackground(new Color(128, 128, 128));
		btnFind.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 14));
		btnFind.setBounds(339, 114, 160, 28);
		
		panel_2.add(btnFind);
		
		JLabel lblNewLabel_5 = new JLabel("아이디가 없으시다면 회원가입을 해주세요.");
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(88, 155, 276, 33);
		panel_2.add(lblNewLabel_5);
		
		btnJoin = new JButton("회원가입하기");
		btnJoin.setForeground(new Color(255, 255, 255));
		btnJoin.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 14));
		btnJoin.setBackground(new Color(128, 128, 128));
		btnJoin.setBounds(375, 157, 124, 28);
		panel_2.add(btnJoin);
		
		
		//회원가입창으로 넘어가기
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MovieJoin(dao);
			}
		});
		
		//뒤로가기버튼
		btnBackbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MovieMain();
			}
		});
		
		//로그인하기
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mid = txtMid.getText();
				String pwd = new String(passwordField.getPassword());
				vo = new MovieVO();
				vo.setMid(mid);
				vo.setPwd(pwd);
				
				boolean check = dao.loginCheck(vo);
				//아이디와 번호가 맞으면 예매창으로 넘어가기
				if(check) {
					dispose();
					new MovieReservationMain(vo);
				}
				else {
					JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호가 맞지 않습니다. 다시 입력해주세요 ");
				}
			}
		});
		
		// 아이디/비밀번호 찾기
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new customerInfoFind(dao);
			}
		});
		
		
		setVisible(true);

	}
	
	
	
	public static void main(String[] args) {
//		new MovieLogin();
	}
}
