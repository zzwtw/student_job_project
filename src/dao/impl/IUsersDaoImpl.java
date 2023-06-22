package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Users;
import dao.IUsersDao;
import util.JDBCUtil;

public class IUsersDaoImpl implements IUsersDao{
	
	@Override
	public int register(Users user) {
		Connection conn = JDBCUtil.getConn();
		String sql = "insert into users(nickname,sex,password) values(?,?,?)";
		int i = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getNickname());
			pstmt.setInt(2, user.getSex());
			pstmt.setString(3, user.getPassword());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(null, pstmt, null);
		}
		return i;
	}

	@Override
	public int login(Users user) {
		Connection conn = JDBCUtil.getConn();
		String sql = "select uid from users where nickName=? and password = ?";
		int uid = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getNickname());
			pstmt.setString(2, user.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next()){
				uid = rs.getInt("uid");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uid;
	}

}
