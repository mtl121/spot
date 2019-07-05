package cn.lvb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.lvb.bean.Page;
import cn.lvb.bean.Spot;
import cn.lvb.dao.SpotDAO;
import cn.lvb.dbutil.JdbcUtil;

public class SpotDAOImpl implements SpotDAO {
	
	@Override
	public boolean add( Spot spot  ) {
		
		String sql = "insert into spot(Spot_id,Spot_name,Spot_ad,Spot_abst,Spot_pic,Spot_sta,Spot_end,keyword)values(?,?,?,?,?,?,?,?)";
		
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		
		try
		{
				
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, spot.getId());
			stmt.setString(2, spot.getName());
			stmt.setString(3, spot.getAddress());
			stmt.setString(4, spot.getAbst());
			stmt.setString(5, spot.getPic());
			stmt.setDate(6, spot.getStart());
			stmt.setDate(7, spot.getEnd());
			stmt.setString(8, spot.getKeyword());
			
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
		String sql = "delete from spot where Spot_id=? ";
		
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
	public boolean exist(String name) {
		// TODO Auto-generated method stub
		
		
		
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		

		String sql = "select  Spot_name from Spot where Spot_name=? ";
		
	
		
		try
		{
				
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, name);
		
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
	public boolean update(Spot spot) {
		String sql = "update  spot set Spot_name=?,Spot_ad=?,Spot_abst=?,Spot_pic=?,Spot_sta=?,Spot_end=?, keyword=?where Spot_id=?";
		
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		
		//System.out.println(sql);
		try
		{
				
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(8, spot.getId());
			stmt.setString(1, spot.getName());
			stmt.setString(2, spot.getAddress());
			stmt.setString(3, spot.getAbst());
			stmt.setString(4, spot.getPic());
			stmt.setDate(5, spot.getStart());
			stmt.setDate(6, spot.getEnd());
			stmt.setString(7, spot.getKeyword());
			
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
	public Spot getOne(String name) {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
			
		String sql = "select Spot_id, Spot_name, Spot_ad,Spot_abst,Spot_pic,Spot_sta,Spot_end,keyword from spot where Spot_name=?  ";
		
		
		try
		{
				
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, name);
			
			rs  = stmt.executeQuery();

			//5���������
			if(rs.next()){
				Spot  spot = new Spot();
				
				spot.setId(rs.getInt("Spot_id"));
				spot.setName(rs.getString("Spot_name"));
				spot.setAddress(rs.getString("Spot_ad"));
				spot.setAbst(rs.getString("Spot_abst"));
				spot.setPic(rs.getString("Spot_pic"));
				spot.setStart(rs.getDate("Spot_sta"));
				spot.setEnd(rs.getDate("Spot_end"));
				spot.setKeyword(rs.getString("keyword"));
				
				return spot;
			}
			return null;
			
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
	public List<Spot> getAll() {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		
		String sql = "select Spot_id, Spot_name, Spot_ad,Spot_abst,Spot_pic,Spot_sta,Spot_end,keyword from spot ";
		
		
		try
		{
			 List<Spot> list= new ArrayList<Spot>();
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			rs  = stmt.executeQuery();

			//5���������
			while(rs.next()){
				Spot spot = new Spot();
				spot.setId(rs.getInt("Spot_id"));
				spot.setName(rs.getString("Spot_name"));
				spot.setAddress(rs.getString("Spot_ad"));
				spot.setAbst(rs.getString("Spot_abst"));
				spot.setPic(rs.getString("Spot_pic"));
				spot.setStart(rs.getDate("Spot_sta"));
				spot.setEnd(rs.getDate("Spot_end"));
				spot.setKeyword(rs.getString("keyword"));
				
				list.add(spot);
				
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
	}

	@Override
	public int getCount() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		int count = 0;
		String sql = "select count(*) as idcount from spot  ";

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
	public List<Spot> getAll(Page page) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select Spot_id, Spot_name, Spot_ad,Spot_abst,Spot_pic,Spot_sta,Spot_end,keyword from spot limit ?, ? ";

		try {
			List<Spot> list = new ArrayList<Spot>();
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, page.getBeginIndex());
			stmt.setInt(2, page.getEveryPage());

			rs = stmt.executeQuery();

			// 5���������
			while (rs.next()) {
				Spot spot = new Spot();
				spot.setId(rs.getInt("Spot_id"));
				spot.setName(rs.getString("Spot_name"));
				spot.setAddress(rs.getString("Spot_ad"));
				spot.setAbst(rs.getString("Spot_abst"));
				spot.setPic(rs.getString("Spot_pic"));
				spot.setStart(rs.getDate("Spot_sta"));
				spot.setEnd(rs.getDate("Spot_end"));
				spot.setKeyword(rs.getString("keyword"));
				
				
				list.add(spot);
			}
			return list;

		} catch (Exception e) {
			throw new RuntimeException(e);

		} finally {
			JdbcUtil.release(rs, stmt, conn);
		}
	}

}
