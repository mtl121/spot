package cn.lvb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.lvb.bean.Admin;
import cn.lvb.bean.Page;
import cn.lvb.dao.AdminDAO;
import cn.lvb.dbutil.JdbcUtil;

public class AdminDAOImpl implements AdminDAO {
	
	@Override
	public boolean add(Admin admin) {
		
		String sql = "insert into admin(username,password)values(?,?)";
		
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		
		try
		{
				
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(2, admin.getPassword());
			stmt.setString(1, admin.getUsername());
			
			int rows  = stmt.executeUpdate();

		    if(rows>0)
		    	return true;

		}
		catch(Exception e)
		{
			throw new RuntimeException(e);	
		}
		finally
		{
			JdbcUtil.release(rs, stmt, conn);
		}

		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		

		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		

		String sql = "delete from admin where id=? ";
		
		try
		{
			
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			
			int rows  = stmt.executeUpdate();
			
			if(rows>0)
			
			return true;
			else
				return false;
		
		
			
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
			
		}
		finally
		{
			JdbcUtil.release(rs, stmt, conn);
			
		}
		
		
		
		
	
	}

	@Override
	public boolean update(Admin admin) {
	
		String sql = "update  admin set  username=?, password=? where id=?";
		
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		
		//System.out.println(sql);
		try
		{
				
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(3, admin.getId());
			stmt.setString(2, admin.getPassword());
			stmt.setString(1, admin.getUsername());
			
			int rows  = stmt.executeUpdate();

		    if(rows>0)
		    	return true;

		}
		catch(Exception e)
		{
			throw new RuntimeException(e);	
		}
		finally
		{
			JdbcUtil.release(rs, stmt, conn);
		}

		return false;
		
		
		
		
		
		
		
	}

	@Override
	public Admin getOneUser(String username) {


		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		
		
		String sql = "select id, username, password from admin where username=?  ";
		
		
		try
		{
				
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, username);
			
			rs  = stmt.executeQuery();

			//5���������
			if(rs.next()){
				Admin admin = new Admin();
			
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				admin.setId(rs.getInt("id"));
				return admin;
			}else {
				return null;
			}
			
//			6���ͷ�ռ�õ���Դ
		
			
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
			
		}
		finally
		{
			JdbcUtil.release(rs, stmt, conn);
			
		}
		
	}

	@Override
	public List<Admin> getAllUser() {
		
		

		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		
		String sql = "select id, username,userpassword from admin  ";
		
		
		try
		{
			 List<Admin> list= new ArrayList<Admin>();
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			rs  = stmt.executeQuery();

			//5���������
			while(rs.next()){
				Admin admin = new Admin();
				
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				admin.setId(rs.getInt("id"));
				
				list.add(admin);
				
			}
			return list;
		
		
			
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
			
		}
		finally
		{
			JdbcUtil.release(rs, stmt, conn);
			
		}
		
		
		
		
		// TODO Auto-generated method stub
		//return null;
	}

	public Admin login(String username,String password)
	{
		System.out.println(username+"*---------*"+password);
		
		String sql = "select * from admin";
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connection = JdbcUtil.getConnection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			stmt = connection.prepareStatement(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String name=null;
		String password1=null;
		try {
			while(rs.next()) {
				try {
					name = rs.getString("username");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				password1 = rs.getString("password");
				if(name.equals(username) ) 
				{
					if(password1.equals(password)) {
						Admin user = new Admin();
						user.setUsername(username);
						user.setPassword(password);
						user.setId(rs.getInt("id"));
						System.out.println(user.getUsername()+"---"+user.getPassword());
						JdbcUtil.release(null,stmt,connection);
						return user;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	

	@Override
	public boolean exist(String username) {
		// TODO Auto-generated method stub
		
		
		
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		

		String sql = "select  username from admin where username=? ";
		
	
		
		try
		{
				
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, username);
		
			rs  = stmt.executeQuery();

		
			if(rs.next()){
				return true;
				//(rs.getString("birthday"));
				
			}
			return false;
		
			
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
			
		}
		finally
		{
			JdbcUtil.release(rs, stmt, conn);
			
		}
	}

	@Override
	public int getCount() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		int count = 0;
		String sql = "select count(*) as idcount from username  ";

		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();

			// 5���������
			while (rs.next()) {
				count = rs.getInt("idcount");
			}
			return count;

		} catch (Exception e) {
			throw new RuntimeException(e);

		} finally {
			JdbcUtil.release(rs, stmt, conn);

		}
	}

	@Override
	public List<Admin> getAll(Page page) {
		// TODO Auto-generated method stub

				Connection conn = null;
				PreparedStatement stmt = null;
				ResultSet rs = null;
				String sql = "select id, username,userpassword from admin limit ?, ? ";

				try {
					List<Admin> list = new ArrayList<Admin>();
					conn = JdbcUtil.getConnection();
					stmt = conn.prepareStatement(sql);

					stmt.setInt(1, page.getBeginIndex());
					stmt.setInt(2, page.getEveryPage());

					rs = stmt.executeQuery();

					// 5���������
					while (rs.next()) {
						Admin admin = new Admin();

						admin.setUsername(rs.getString("username"));
						admin.setPassword(rs.getString("password"));
						admin.setId(rs.getInt("id"));
						
						list.add(admin);
					}
					return list;

				} catch (Exception e) {
					throw new RuntimeException(e);

				} finally {
					JdbcUtil.release(rs, stmt, conn);
				}
			}
	

}
