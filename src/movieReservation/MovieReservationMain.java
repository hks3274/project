package movieReservation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MovieReservationMain extends JFrame {
	MovieVO vo = null;
	MovieDAO dao = new MovieDAO();
	JButton btnLeft, btnRight;
	JLabel lbltitle;
	private int check;

	public MovieReservationMain(MovieVO vo) {
		super("예매창");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(255, 255, 255));
		pn1.setBounds(0, 0, 584, 106);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblLogo1 = new JLabel("M");
		lblLogo1.setFont(new Font("HY견고딕", Font.BOLD, 52));
		lblLogo1.setBounds(12, 10, 56, 64);
		pn1.add(lblLogo1);
		
		JLabel lblLogo2 = new JLabel("OVIE");
		lblLogo2.setFont(new Font("HY견고딕", Font.BOLD, 20));
		lblLogo2.setBounds(61, 17, 115, 29);
		pn1.add(lblLogo2);
		
		JLabel lblLogo3 = new JLabel("BOOK");
		lblLogo3.setFont(new Font("HY견고딕", Font.BOLD, 20));
		lblLogo3.setBounds(61, 39, 115, 24);
		pn1.add(lblLogo3);
		

		lbltitle = new JLabel("");
		lbltitle.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 35));
		lbltitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitle.setBounds(168, 64, 251, 42);
		pn1.add(lbltitle);

		JPanel pn2 = new JPanel();
		pn2.setBackground(new Color(255, 255, 255));
		pn2.setBounds(0, 105, 584, 544);
		getContentPane().add(pn2);
		pn2.setLayout(null);

		JLabel lblPoster = new JLabel("");
		lblPoster.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoster.setBounds(121, 34, 334, 470);
		pn2.add(lblPoster);

		btnLeft = new JButton("");
		btnLeft.setIcon(new ImageIcon(MovieReservationMain.class.getResource("/movieReservation/images/left.png")));
		btnLeft.setBackground(new Color(255, 255, 255));
		btnLeft.setBorderPainted(false);
		btnLeft.setBounds(34, 265, 50, 50);
		pn2.add(btnLeft);

		btnRight = new JButton("");

		btnRight.setIcon(new ImageIcon(MovieReservationMain.class.getResource("/movieReservation/images/right.png")));
		btnRight.setBackground(new Color(255, 255, 255));
		btnRight.setBorderPainted(false);
		btnRight.setBounds(494, 265, 50, 50);
		pn2.add(btnRight);

		JPanel pn3 = new JPanel();
		pn3.setBackground(new Color(255, 255, 255));
		pn3.setBounds(0, 647, 584, 114);
		getContentPane().add(pn3);
		pn3.setLayout(null);

		JButton btnNewButton = new JButton("예매하기");
		btnNewButton.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 20));
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(173, 0, 218, 49);
		pn3.add(btnNewButton);

		ArrayList<MovieVO> movieList = dao.getTitlePoster(vo);
		MovieVO currentMovie = movieList.get(check);
		lblPoster.setIcon(new ImageIcon(MovieReservationMain.class.getResource(currentMovie.getTitlePoster())));
		lbltitle.setText(currentMovie.getTitle());
		
		JLabel lblWelcome = new JLabel(vo.getName()+"님");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 15));
		lblWelcome.setBounds(498, 59, 74, 24);
		pn1.add(lblWelcome);
		
		JButton btnMypage = new JButton("");
		btnMypage.setBackground(new Color(255, 255, 255));
		btnMypage.setIcon(new ImageIcon(MovieReservationMain.class.getResource("/movieReservation/images/mypage.png")));
		btnMypage.setBorderPainted(false);
		btnMypage.setBounds(511, 10, 50, 50);
		pn1.add(btnMypage);
		
		// 오른쪽 클릭
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check++;
				if(check == movieList.size()) check = 0;
				MovieVO currentMovie = movieList.get(check);
				lblPoster.setIcon(new ImageIcon(MovieReservationMain.class.getResource(currentMovie.getTitlePoster())));
				lbltitle.setText(currentMovie.getTitle());
			}
		});

		// 왼쪽 클릭
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check--;
        if(check < 0) check =  movieList.size()-1; 
        MovieVO currentMovie = movieList.get(check);
        lblPoster.setIcon(new ImageIcon(MovieReservationMain.class.getResource(currentMovie.getTitlePoster())));
        lbltitle.setText(currentMovie.getTitle());
			}
		});
		
		
		setVisible(true);
	}

	public static void main(String[] args) {
		MovieVO vo = new MovieVO();
		new MovieReservationMain(vo);
	}
}
