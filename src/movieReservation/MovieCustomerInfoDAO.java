package movieReservation;

import java.sql.SQLException;

public class MovieCustomerInfoDAO extends DBConn {
	MovieVO vo = null;

	public boolean duplCheck(String duplMid) {
		boolean ok = false;
		try {
			sql = "select * from customerInfo where mid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, duplMid);
			rs = pstmt.executeQuery();

			if (rs.next())
				ok = false;
			else
				ok = true;

		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}

		return ok;
	}

	public int CustomerInfoInput(MovieVO vo) {
		int res = 0;
		try {
			sql = "insert into customerInfo values(?,?,?,?,?,?,date_format(?, '%y-%m-%d'))";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getSocialNum());
			pstmt.setString(5, vo.getPhoneNum());
			pstmt.setString(6, vo.getGender());
			pstmt.setString(7, vo.getBirthDate());
			res = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}

		return res;
	}

	public boolean loginCheck(MovieVO vo) {
		boolean ok = false;
		try {
			sql = "select * from customerInfo where mid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("pwd").equals(vo.getPwd())) {
					vo.setName(rs.getString("name"));
					vo.setMid(rs.getString("mid"));
					vo.setPwd(rs.getString("pwd"));
					vo.setPhoneNum(rs.getString("phoneNum"));
					vo.setSocialNum(rs.getString("socialNum"));
					vo.setGender(rs.getString("gender"));
					vo.setBirthDate(rs.getString("birthDate"));
					ok = true;
				}
			}

		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}

		return ok;
	}

	public boolean findCustomerInfo(MovieVO vo, boolean check) {
		boolean ok = false;
		try {

			if (check) {
				sql = "select * from customerInfo where mid = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getMid());
				rs = pstmt.executeQuery();

				if (rs.next()) {
					if (rs.getString("name").equals(vo.getName()) && rs.getString("socialNum").equals(vo.getSocialNum()) && rs.getString("phoneNum").equals(vo.getPhoneNum())) {
						vo.setPwd(rs.getString("pwd"));
						ok = true;
					}
				}
			} else {
				sql = "select * from customerInfo where socialNum = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getSocialNum());
				rs = pstmt.executeQuery();
				
				
				if (rs.next()) {
					if (rs.getString("name").equals(vo.getName()) && rs.getString("phoneNum").equals(vo.getPhoneNum())) {
						vo.setMid(rs.getString("mid"));
						ok = true;
					}
				}
			}

		} catch (

		SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}

		return ok;
	}

}
