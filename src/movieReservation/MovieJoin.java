package movieReservation;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class MovieJoin extends JFrame{
	private JButton btnBackbutton, btnDuplMid,btnJoin;
	private JPasswordField pwdField,pwdFieldCheck,pwdFieldSocialNum;
	private JTextField txtMid, txtName,txtSocialNum,txtMiddleNum, txtLastNum;
	private JLabel lblCheckMsgMid, lblCheckMsgPwd;
	private JComboBox comboFirstNum;
	MovieVO vo = null;
	int res = 0;
	
	
	public MovieJoin(MovieCustomerInfoDAO dao) {
		super("회원가입하기");
		
		setSize(600,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(255, 255, 255));
		pn1.setBounds(0, 0, 584, 157);
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
		
		JLabel lblTitle = new JLabel("회원가입");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 35));
		lblTitle.setBounds(222, 95, 123, 46);
		pn1.add(lblTitle);
		
		btnBackbutton = new JButton("");
		btnBackbutton.setBackground(new Color(255, 255, 255));
		btnBackbutton.setIcon(new ImageIcon(MovieLogin.class.getResource("/movieReservation/images/backbutton2.png")));
		btnBackbutton.setBorderPainted(false);		
		btnBackbutton.setBounds(23, 27, 30, 30);
		pn1.add(btnBackbutton);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(new Color(255, 255, 255));
		pn2.setBounds(0, 157, 584, 468);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 20));
		lblNewLabel.setBounds(79, 34, 102, 36);
		pn2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(52, 150, 130, 36);
		pn2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("비밀번호 확인");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_1.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(52, 196, 130, 36);
		pn2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("성명");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_1_1.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(52, 274, 130, 36);
		pn2.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("주민번호");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_1_1_1.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(52, 331, 130, 36);
		pn2.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("전화번호");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_1_1_1_1.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1.setBounds(52, 396, 130, 36);
		pn2.add(lblNewLabel_1_1_1_1_1);
		
		txtMid = new JTextField();
		txtMid.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 18));
		txtMid.setBounds(218, 34, 181, 36);
		pn2.add(txtMid);
		txtMid.setColumns(10);
		
		pwdField = new JPasswordField();
		pwdField.setEditable(false);
		pwdField.setFont(new Font("Arial Black", Font.PLAIN, 18));
		pwdField.setBounds(219, 150, 253, 36);
		pn2.add(pwdField);
		
		pwdFieldCheck = new JPasswordField();
		pwdFieldCheck.setEditable(false);
		pwdFieldCheck.setFont(new Font("Arial Black", Font.PLAIN, 18));
		pwdFieldCheck.setBounds(219, 196, 253, 36);
		pn2.add(pwdFieldCheck);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 18));
		txtName.setColumns(10);
		txtName.setBounds(219, 274, 253, 36);
		pn2.add(txtName);
		
		txtSocialNum = new JTextField();
		txtSocialNum.setEditable(false);
		txtSocialNum.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 18));
		txtSocialNum.setColumns(10);
		txtSocialNum.setBounds(219, 331, 116, 36);
		pn2.add(txtSocialNum);
		
		pwdFieldSocialNum = new JPasswordField();
		pwdFieldSocialNum.setEditable(false);
		pwdFieldSocialNum.setFont(new Font("Arial Black", Font.PLAIN, 18));
		pwdFieldSocialNum.setBounds(355, 331, 111, 36);
		pn2.add(pwdFieldSocialNum);
		
		comboFirstNum = new JComboBox();
		comboFirstNum.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 18));
		comboFirstNum.setModel(new DefaultComboBoxModel(new String[] {"010", "011"}));
		comboFirstNum.setBounds(219, 400, 67, 32);
		pn2.add(comboFirstNum);
		
		txtMiddleNum = new JTextField();
		txtMiddleNum.setEditable(false);
		txtMiddleNum.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 18));
		txtMiddleNum.setColumns(10);
		txtMiddleNum.setBounds(315, 401, 60, 32);
		pn2.add(txtMiddleNum);
		
		txtLastNum = new JTextField();
		txtLastNum.setEditable(false);
		txtLastNum.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 18));
		txtLastNum.setColumns(10);
		txtLastNum.setBounds(399, 401, 67, 32);
		pn2.add(txtLastNum);
		
		JLabel lblNewLabel_2 = new JLabel("-");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(286, 400, 27, 36);
		pn2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("-");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(373, 400, 27, 36);
		pn2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("-");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(332, 331, 27, 36);
		pn2.add(lblNewLabel_2_1_1);
		
		btnDuplMid = new JButton("중복체크");
		btnDuplMid.setForeground(new Color(255, 255, 255));
		btnDuplMid.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 16));
		btnDuplMid.setBackground(new Color(128, 128, 128));
		btnDuplMid.setBounds(411, 34, 97, 36);
		pn2.add(btnDuplMid);
		
		JLabel lblNewLabel_3 = new JLabel("<html>비밀번호는 최소 8자에서 16자까지, 영문자(대/소문자), <br>숫자 및 특수 문자를 포함해야 합니다.</html>");
		lblNewLabel_3.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 10));
		lblNewLabel_3.setBounds(218, 110, 253, 30);
		pn2.add(lblNewLabel_3);
		
		lblCheckMsgMid = new JLabel();
		lblCheckMsgMid.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 10));
		lblCheckMsgMid.setBounds(218, 72, 328, 30);
		pn2.add(lblCheckMsgMid);
		
		lblCheckMsgPwd = new JLabel();
		lblCheckMsgPwd.setForeground(new Color(198, 0, 0));
		lblCheckMsgPwd.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 10));
		lblCheckMsgPwd.setBounds(218, 234, 254, 30);
		pn2.add(lblCheckMsgPwd);
		
		JLabel lblNewLabel_3_1 = new JLabel("<html>아이디는 최소 4자에서 12자까지 영문자(대/소문자),<br> 숫자만 포함해야 합니다.</html>\r\n");
		lblNewLabel_3_1.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 10));
		lblNewLabel_3_1.setBounds(218, 0, 290, 36);
		pn2.add(lblNewLabel_3_1);
		
		JPanel pn3 = new JPanel();
		pn3.setBackground(new Color(255, 255, 255));
		pn3.setBounds(0, 624, 584, 137);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btnJoin = new JButton("회원가입하기");
		btnJoin.setForeground(new Color(255, 255, 255));
		btnJoin.setBackground(new Color(128, 128, 128));
		btnJoin.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 22));
		btnJoin.setBounds(113, 10, 354, 54);
		btnJoin.setEnabled(false);
		pn3.add(btnJoin);
		
		
		btnBackbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MovieLogin();
			}
		});
		
		
		//중복체크
		btnDuplMid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String duplMid = txtMid.getText();
				
				boolean regex = Pattern.matches("^[a-zA-z0-9]{4,12}$", duplMid);
				
				if(regex) {
					boolean ok = dao.duplCheck(duplMid);
					if(ok) {
						lblCheckMsgMid.setText("아이디를 사용하실 수 있습니다.");
						lblCheckMsgMid.setForeground(new Color(0, 128, 0));
						pwdField.setEditable(true);
						pwdFieldCheck.setEditable(true);
						txtName.setEditable(true);
						txtSocialNum.setEditable(true);
						pwdFieldSocialNum.setEditable(true);
						txtMiddleNum.setEditable(true);
						txtLastNum.setEditable(true);
						btnJoin.setEnabled(true);
					} else {
						lblCheckMsgMid.setText("같은 아이디가 존재합니다. 다시 입력해 주세요.");
						lblCheckMsgMid.setForeground(new Color(193, 0, 0));
					}
				}else {
					lblCheckMsgMid.setText("아이디의 형식이 맞지 않습니다.(아이디형식:영문 대소문자와 숫자 4~12자리)");
					lblCheckMsgMid.setForeground(new Color(193, 0, 0));
				}
			}
		});
		
		
		//회원가입하기
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pwd = new String(pwdField.getPassword());
				String pwdCheck =  new String(pwdFieldCheck.getPassword());
				String name = txtName.getText();
				String socialNum = txtSocialNum.getText() +"-"+new String(pwdFieldSocialNum.getPassword());
				String phonNum = comboFirstNum.getSelectedItem() +"-"+txtMiddleNum.getText()+"-"+txtLastNum.getText();
				String gender ="";
				String birthDate ="";
				
				boolean regexPwd = Pattern.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*?_]).{8,16}$", pwd);
				boolean regexName = Pattern.matches("^[가-힣]*$", name);
				boolean regexSocialNum = Pattern.matches("^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))-[1-4][0-9]{6}$", socialNum);
				boolean regexphoneNum = Pattern.matches("^\\d{2,3}-\\d{3,4}-\\d{4}$", phonNum);
				
				if(regexPwd) {
					if(!pwd.equals(pwdCheck)) {
						lblCheckMsgPwd.setText("두 비밀번호가 맞지 않습니다. 다시입력해주세요.");
					}
					else {
						if(regexName) {
							if(regexSocialNum) {
								if(regexphoneNum) {
									birthDate = socialNum.substring(0,2)+"-"+socialNum.substring(2,4)+"-"+socialNum.substring(4,6);
									if(Integer.parseInt(socialNum.substring(7,8)) == 2 || Integer.parseInt(socialNum.substring(7,8)) ==  4) gender = "여자";
									else if (Integer.parseInt(socialNum.substring(7,8)) == 1 || Integer.parseInt(socialNum.substring(7,8)) ==  3) gender = "남자";
									
									vo = new MovieVO();
									vo.setMid(txtMid.getText());
									vo.setPwd(pwd);
									vo.setName(name);
									vo.setGender(gender);
									vo.setBirthDate(birthDate);
									vo.setSocialNum(socialNum);
									vo.setPhoneNum(phonNum);
									res = dao.CustomerInfoInput(vo);
									
									if(res != 0) {
										JOptionPane.showMessageDialog(null, "회원가입 완료!");
										dispose();
										new MovieLogin();
									}
									else JOptionPane.showMessageDialog(null, "회원가입 실패!");
									
								}else {
									JOptionPane.showMessageDialog(null, "전화번호가 형식에 맞지 않습니다. 다시 입력해주세요.");
									txtMiddleNum.requestFocus();
								}
							} else {
								JOptionPane.showMessageDialog(null, "주민번호가 형식에 맞지 않습니다. 다시 입력해주세요.");
								txtSocialNum.requestFocus();
							}
						}else {
							JOptionPane.showMessageDialog(null, "이름이 형식에 맞지 않습니다. 다시 입력해주세요.");
							txtName.requestFocus();
						}
					}	
				} else {
					JOptionPane.showMessageDialog(null, "비밀번호가 형식과 맞지않습니다. 다시 입력해주세요.");
					pwdField.requestFocus();
				}
		
			}
		});
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
	}
}
