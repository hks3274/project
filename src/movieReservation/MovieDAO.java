package movieReservation;

import java.sql.SQLException;
import java.util.ArrayList;

public class MovieDAO  extends DBConn {
	MovieVO vo = null;
	public ArrayList<MovieVO> getTitlePoster(MovieVO vo) {
		ArrayList<MovieVO> movieList = new ArrayList<MovieVO>();
		try {
			sql = "select * from movie";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new MovieVO();
				vo.setTitle(rs.getString("title"));
				vo.setTitlePoster(rs.getString("titlePoster"));
				movieList.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}

		return movieList;
	}
	
	
}
