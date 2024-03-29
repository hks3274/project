package movieReservation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class MovieMain extends JFrame {
	MovieDAO dao = new MovieDAO();
	MovieVO vo = null;
	private int[][] movieBackgroundColor = { { 0, 0, 0 }, { 6, 4, 53 }, { 255, 230, 204 }, { 213, 213, 213 } };
	private JButton btnReservation, btnCheck;
	private JLabel lblMovieList;
	private JPanel pn2;
	private int check = 1;

	public MovieMain() {
		super("영화예매 메인창");
		getContentPane().setBackground(new Color(255, 255, 255));

		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(255, 255, 255));
		pn1.setBounds(0, 0, 586, 155);
		getContentPane().add(pn1);
		pn1.setLayout(null);

		JLabel lblNewLabel = new JLabel("M");
		lblNewLabel.setFont(new Font("HY견고딕", Font.BOLD, 84));
		lblNewLabel.setBounds(194, 49, 93, 84);
		pn1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("OVIE");
		lblNewLabel_1.setFont(new Font("HY견고딕", Font.BOLD, 38));
		lblNewLabel_1.setBounds(266, 49, 115, 46);
		pn1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("BOOK");
		lblNewLabel_1_1.setFont(new Font("HY견고딕", Font.BOLD, 33));
		lblNewLabel_1_1.setBounds(266, 85, 115, 40);
		pn1.add(lblNewLabel_1_1);

		pn2 = new JPanel();
		pn2.setBackground(new Color(0, 0, 0));
		pn2.setBounds(0, 153, 586, 470);
		getContentPane().add(pn2);
		pn2.setLayout(null);

		lblMovieList = new JLabel("");
		lblMovieList.setBackground(new Color(78, 78, 78));
		lblMovieList.setForeground(new Color(0, 0, 0));
		lblMovieList.setFont(new Font("LG Smart UI Light", Font.PLAIN, 18));
		lblMovieList.setIcon(new ImageIcon(MovieMain.class.getResource("/movieReservation/images/movie1.png")));
		lblMovieList.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieList.setBounds(0, 0, 586, 470);
		pn2.add(lblMovieList);

		JPanel pn3 = new JPanel();
		pn3.setBackground(new Color(255, 255, 255));
		pn3.setBounds(0, 623, 586, 140);
		getContentPane().add(pn3);
		pn3.setLayout(null);

		btnReservation = new JButton("예매하기");
		btnReservation.setBackground(new Color(255, 255, 255));
		btnReservation.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 20));
		btnReservation.setBounds(96, 33, 145, 54);
		btnReservation.setBorderPainted(false);
		pn3.add(btnReservation);

		btnCheck = new JButton("예매확인");
		btnCheck.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 20));
		btnCheck.setBorderPainted(false);
		btnCheck.setBackground(Color.WHITE);
		btnCheck.setBounds(339, 33, 145, 54);
		pn3.add(btnCheck);

		Timer timer = new Timer(3000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				movieChange();
			}
		});
		timer.start();
		
		//예매창
		btnReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MovieLogin();
			}
		});
		
		
		setVisible(true);

	}
	
	//영화포스터 자동 넘기기메소드
	void movieChange() {
		vo = new MovieVO();
		ArrayList<MovieVO> movieList = dao.getTitlePoster(vo);
		
		for (int i = 0; i < movieBackgroundColor[check].length; i++) {
			pn2.setBackground(new Color(movieBackgroundColor[check][0], movieBackgroundColor[check][1], movieBackgroundColor[check][2]));
		}
		
		vo = movieList.get(check);
		lblMovieList.setIcon(new ImageIcon(MovieMain.class.getResource(vo.getTitlePoster())));
		check++;
		
		if (check == movieList.size())
			check = 0;
	}

	public static void main(String[] args) {
		new MovieMain();
	}
}