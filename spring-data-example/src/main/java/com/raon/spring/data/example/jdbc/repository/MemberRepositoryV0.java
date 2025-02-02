package com.raon.spring.data.example.jdbc.repository;

import static com.raon.spring.data.example.jdbc.connection.DBConnectionUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.NoSuchElementException;

import com.raon.spring.data.example.jdbc.domain.Member;

import lombok.extern.slf4j.Slf4j;

/**
 * JDBC - DriverManger
 */
@Slf4j
public class MemberRepositoryV0 {
	public Member save(Member member) throws SQLException {
		String sql = "insert into member(member_id, money) values(?, ?)";

		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setInt(2, member.getMoney());
			pstmt.executeUpdate();
			return member;
		} catch (SQLException e) {
			log.error("db error", e);
			throw e;
		} finally {
			close(connection, pstmt, null);
		}
	}

	public Member findById(String memberId) throws SQLException {
		String sql = "select * from member where member_id = ?";
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return new Member(rs.getString("member_id"), rs.getInt("money"));
			} else {
				throw new NoSuchElementException("member not ofund memberId = " + memberId);
			}
		} catch (SQLException e) {
			log.error("db error", e);
			throw e;
		} finally {
			close(connection, pstmt, rs);
		}
	}

	public void update(String memberId, int money) throws SQLException {
		String sql = "update member set money = ? where member_id = ?";
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, money);
			pstmt.setString(2, memberId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			log.error("db error", e);
			throw e;
		} finally {
			close(connection, pstmt, null);
		}
	}

	public void delete(String memberId) throws SQLException {
		String sql = "delete from member where member_id = ?";
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			log.error("db error", e);
			throw e;
		} finally {
			close(connection, pstmt, null);
		}
	}

	private void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				log.error("error", e);
			}
		}

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				log.error("error", e);
			}
		}

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				log.error("error", e);
			}
		}
	}
}
