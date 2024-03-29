package movieReservation;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class customerInfoFind extends JFrame {
	private JButton btnBackbutton, btnMidFind, btnMidPwdFind, btnFind;
	private JTextField txtMid, txtName, txtSocialNum, txtMiddleNum, txtLastNum, txtmsg;
	private JPasswordField pwdFieldSocialNum;
	private MovieVO vo = null;
	boolean check = false;

	public customerInfoFind(MovieCustomerInfoDAO dao) {
		super("아이디/비밀번호 찾기");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(255, 255, 255));
		pn1.setBounds(0, 0, 584, 166);
		getContentPane().add(pn1);
		pn1.setLayout(null);

		btnBackbutton = new JButton("");
		btnBackbutton.setBackground(new Color(255, 255, 255));
		btnBackbutton.setIcon(new ImageIcon(MovieLogin.class.getResource("/movieReservation/images/backbutton2.png")));
		btnBackbutton.setBorderPainted(false);
		btnBackbutton.setBounds(23, 27, 30, 30);
		pn1.add(btnBackbutton);

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

		JLabel lblTitle = new JLabel("아이디/비밀번호 찾기");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 25));
		lblTitle.setBounds(114, 110, 361, 46);
		pn1.add(lblTitle);

		JPanel pn2 = new JPanel();
		pn2.setBackground(new Color(255, 255, 255));
		pn2.setBounds(0, 164, 584, 461);
		getContentPane().add(pn2);
		pn2.setLayout(null);

		btnMidFind = new JButton("아이디찾기");

		btnMidFind.setForeground(new Color(255, 255, 255));
		btnMidFind.setFont(new Font("경기천년제목 Light", Font.PLAIN, 16));
		btnMidFind.setBackground(new Color(128, 128, 128));
		btnMidFind.setBounds(0, 10, 298, 44);
		pn2.add(btnMidFind);

		btnMidPwdFind = new JButton("비밀번호 찾기");

		btnMidPwdFind.setForeground(new Color(255, 255, 255));
		btnMidPwdFind.setFont(new Font("경기천년제목 Light", Font.PLAIN, 16));
		btnMidPwdFind.setBackground(new Color(128, 128, 128));
		btnMidPwdFind.setBounds(300, 10, 284, 44);
		pn2.add(btnMidPwdFind);

		JLabel lblNewLabel = new JLabel("성명");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 20));
		lblNewLabel.setBounds(79, 162, 115, 44);
		pn2.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("주민번호");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(79, 229, 115, 44);
		pn2.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("전화번호");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_1.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(79, 295, 115, 44);
		pn2.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("아이디");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_1_1.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(79, 94, 115, 44);
		pn2.add(lblNewLabel_1_1_1);

		txtMid = new JTextField();
		txtMid.setEditable(false);
		txtMid.setFont(new Font("경기천년제목 Light", Font.PLAIN, 16));
		txtMid.setBounds(217, 101, 229, 35);
		pn2.add(txtMid);
		txtMid.setColumns(10);

		txtName = new JTextField();
		txtName.setFont(new Font("경기천년제목 Light", Font.PLAIN, 16));
		txtName.setColumns(10);
		txtName.setBounds(217, 169, 229, 35);
		pn2.add(txtName);

		txtSocialNum = new JTextField();
		txtSocialNum.setFont(new Font("경기천년제목 Light", Font.PLAIN, 16));
		txtSocialNum.setBounds(216, 229, 104, 35);
		pn2.add(txtSocialNum);
		txtSocialNum.setColumns(10);

		pwdFieldSocialNum = new JPasswordField();
		pwdFieldSocialNum.setFont(new Font("Arial Black", Font.PLAIN, 16));
		pwdFieldSocialNum.setBounds(344, 229, 104, 35);
		pn2.add(pwdFieldSocialNum);

		JLabel lblNewLabel_2 = new JLabel("-");
		lblNewLabel_2.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(311, 229, 42, 35);
		pn2.add(lblNewLabel_2);

		JComboBox comboFirstNum = new JComboBox();
		comboFirstNum.setFont(new Font("경기천년제목 Light", Font.PLAIN, 16));
		comboFirstNum.setModel(new DefaultComboBoxModel(new String[] { "010", "011" }));
		comboFirstNum.setBounds(217, 295, 61, 36);
		pn2.add(comboFirstNum);

		txtMiddleNum = new JTextField();
		txtMiddleNum.setFont(new Font("경기천년제목 Light", Font.PLAIN, 16));
		txtMiddleNum.setColumns(10);
		txtMiddleNum.setBounds(305, 295, 61, 35);
		pn2.add(txtMiddleNum);

		txtLastNum = new JTextField();
		txtLastNum.setFont(new Font("경기천년제목 Light", Font.PLAIN, 16));
		txtLastNum.setColumns(10);
		txtLastNum.setBounds(386, 295, 61, 35);
		pn2.add(txtLastNum);

		JLabel lblNewLabel_2_1 = new JLabel("-");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(280, 295, 27, 35);
		pn2.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("-");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(367, 295, 18, 35);
		pn2.add(lblNewLabel_2_1_1);

		btnFind = new JButton("조회하기");
		btnFind.setForeground(new Color(255, 255, 255));
		btnFind.setBackground(new Color(128, 128, 128));
		btnFind.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 20));
		btnFind.setBounds(130, 368, 318, 49);
		pn2.add(btnFind);

		JPanel pn3 = new JPanel();
		pn3.setBackground(new Color(255, 255, 255));
		pn3.setBounds(0, 624, 584, 137);
		getContentPane().add(pn3);
		pn3.setLayout(null);

		txtmsg = new JTextField();
		txtmsg.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 20));
		txtmsg.setHorizontalAlignment(SwingConstants.CENTER);
		txtmsg.setText("조회된 정보 출력");
		txtmsg.setBounds(0, 0, 584, 137);
		pn3.add(txtmsg);
		txtmsg.setColumns(10);

		btnBackbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MovieLogin();
			}
		});

		// 아이디찾기버튼
		btnMidFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check = false;
				txtMid.setEditable(check);
			}
		});

		// 비밀번호 버튼
		btnMidPwdFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check = true;
				txtMid.setEditable(check);
			}
		});

		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean ok = false;
				vo = new MovieVO();

				String name = txtName.getText();
				String socialNum = txtSocialNum.getText() + "-" + new String(pwdFieldSocialNum.getPassword());
				String phonNum = comboFirstNum.getSelectedItem() + "-" + txtMiddleNum.getText() + "-" + txtLastNum.getText();
				String mid = txtMid.getText();

				boolean regexName = Pattern.matches("^[가-힣]*$", name);
				boolean regexSocialNum = Pattern.matches("^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))-[1-4][0-9]{6}$", socialNum);
				boolean regexphoneNum = Pattern.matches("^\\d{2,3}-\\d{3,4}-\\d{4}$", phonNum);
				
				vo.setMid(mid);
				vo.setName(name);
				vo.setSocialNum(socialNum);
				vo.setPhoneNum(phonNum);
				
				if (regexName) {
					if (regexSocialNum) {
						if (regexphoneNum) {
							if (check) {
								ok = dao.findCustomerInfo(vo, check);

								if (ok)txtmsg.setText("회원님의 비빌번호는 :" + vo.getPwd() + "입니다");
								else txtmsg.setText("회원님의 정보가 없거나 불러오지 못했습니다.");

							} else {
								vo.setSocialNum(socialNum);
								ok = dao.findCustomerInfo(vo, check);

								if (ok) txtmsg.setText("회원님의 아이디는 :" + vo.getMid() + "입니다");
								else txtmsg.setText("회원님의 정보가 없거나 불러오지 못했습니다.");
							}
						} else {
							JOptionPane.showMessageDialog(null, "전화번호가 형식에 맞지 않습니다. 다시 입력해주세요.");
							txtMiddleNum.requestFocus();
						}
					} else {
						JOptionPane.showMessageDialog(null, "주민번호가 형식에 맞지 않습니다. 다시 입력해주세요.");
						txtSocialNum.requestFocus();
					}
				} else {
					JOptionPane.showMessageDialog(null, "이름이 형식에 맞지 않습니다. 다시 입력해주세요.");
					txtName.requestFocus();
				}
			}
		});

		setVisible(true);
	}

	public static void main(String[] args) {
		MovieCustomerInfoDAO dao = new MovieCustomerInfoDAO();
	}
}
