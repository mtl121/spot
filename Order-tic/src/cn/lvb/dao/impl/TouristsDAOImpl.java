package cn.lvb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import cn.lvb.bean.Page;
import cn.lvb.bean.Tourists;
import cn.lvb.dao.TouristsDAO;
import cn.lvb.dbutil.C3P0Util;
import cn.lvb.dbutil.JdbcUtil;

public class TouristsDAOImpl implements TouristsDAO {
	DataSource ds = C3P0Util.getDataSource();	
	QueryRunner qr = new QueryRunner(ds);
	
	//添加信息
	@Override
	public boolean add(Tourists tou) {
		String sql = "insert into tourists(Tou_name,Tou_phone,Tou_sex, Tou_idcardnum, Tou_password,Tou_nickname)" + "values(?,?,?,?,?,?)";
		try {
			qr.update(sql,tou.getName(),tou.getPhone(),tou.getSex(),tou.getIdcard(),tou.getPassword(),tou.getNickname());

		} catch (Exception e) {
			throw new RuntimeException(e);
		} 

		return false;
	}
	
	//删除信息
	@Override
	public boolean delete(String id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "delete from tourists where Tou_phone=? ";

		try {
			System.out.println("*****" + id);
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			int rows = stmt.executeUpdate();

			if (rows > 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(rs, stmt, conn);
		}
	}
	
	//修改信息
	@Override
	public boolean update(Tourists bean) {
		
		String sql = "update tourists set Tou_name=?," + "Tou_sex=?,"+ "Tou_idcardnum=?," + "Tou_password=?,"  + "Tou_nickname=? where Tou_phone=?";

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, bean.getName());
			stmt.setInt(2, bean.getSex());
			stmt.setString(3, bean.getIdcard());
			stmt.setString(4, bean.getPassword());
			stmt.setString(5, bean.getNickname());
			

			stmt.setString(6, bean.getPhone());
			int rows = stmt.executeUpdate();

			if (rows > 0)
				return true;

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(rs, stmt, conn);
		}
		return false;
	}
	
	//获取页数
	@Override
	public int getCount() {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		int count = 0;
		String sql = "select count(*) as idcount from tourists  ";

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

	//列出所有信息
	@Override
	public List<Tourists> getAll(Page page) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select Tou_phone, Tou_name, Tou_sex, Tou_idcardnum,Tou_password , Tou_nickname from tourists limit ?, ? ";

		try {
			List<Tourists> list = new ArrayList<Tourists>();
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, page.getBeginIndex());
			stmt.setInt(2, page.getEveryPage());

			rs = stmt.executeQuery();

			// 5���������
			while (rs.next()) {
				Tourists bean = new Tourists();

				bean.setPhone(rs.getString("Tou_phone"));
				bean.setName(rs.getString("Tou_name"));
				bean.setSex(rs.getInt("Tou_sex"));
				bean.setIdcard(rs.getString("Tou_idcardnum"));
				bean.setPassword(rs.getString("Tou_password"));
				bean.setNickname(rs.getString("Tou_nickname"));
				
				list.add(bean);
			}
			return list;

		} catch (Exception e) {
			throw new RuntimeException(e);

		} finally {
			JdbcUtil.release(rs, stmt, conn);
		}
	}
	
	public Tourists login(String name,String password)
	{
		System.out.println(name+"*---------*"+password);
		
		String sql = "select * from tourists";
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
		
		String name1=null;
		String password1=null;
		try {
			while(rs.next()) {
				try {
					name1 = rs.getString("Tou_name");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				password1 = rs.getString("Tou_password");
				if(name1.equals(name) ) 
				{
					if(password1.equals(password)) {
						Tourists user = new Tourists();
						user.setPhone(rs.getString("Tou_phone"));
						user.setName(rs.getString("Tou_name"));
						user.setSex(rs.getInt("Tou_sex"));
						user.setIdcard(rs.getString("Tou_idcardnum"));
						user.setPassword(rs.getString("Tou_password"));
						user.setNickname(rs.getString("Tou_nickname"));
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

}
