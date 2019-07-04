package cn.lvb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.lvb.bean.Page;
import cn.lvb.bean.Tickets;
import cn.lvb.dao.TicketsDAO;
import cn.lvb.dbutil.JdbcUtil;

public class TicketsDAOImpl implements TicketsDAO {
	
	@Override
	public boolean add(Tickets tickets) {
		
		String sql = "insert into ticket(Ticket_id,Ticket_price,Ticket_name,Spot_i)values(?,?,?,?)";
		
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
	
		try
		{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			

			stmt.setString(1, tickets.getId());
			stmt.setString(2, tickets.getPrice());
			stmt.setString(3, tickets.getName());
			stmt.setString(4, tickets.getSpotid());
			
			
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
	public boolean delete(String name) {
		// TODO Auto-generated method stub
		

		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		
		
		String sql = "delete from ticket where Ticket_name=? ";
		
		try
		{
			
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			
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
	public boolean update(Tickets tickets) {
	
		String sql = "update  ticket set  Spot_i=?, Ticket_price=?, Ticket_name=? where Ticket_id=?";
		
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		
		//System.out.println(sql);
		try
		{
				
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, tickets.getSpotid());
			stmt.setString(2, tickets.getPrice());
			stmt.setString(3, tickets.getName());
			
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
	public Tickets getOne(String name) {


		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		
		
		String sql = "select Ticket_id, Ticket_name, Ticket_price,Spot_i from ticket where Ticket_name=?  ";
		
		
		try
		{
				
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, name);
			
			rs  = stmt.executeQuery();

			//5���������
			if(rs.next()){
				Tickets tickets = new Tickets();
			
				tickets.setId(rs.getString("Ticket_id"));
				tickets.setName(rs.getString("Ticket_name"));
				tickets.setPrice(rs.getString("Ticket_price"));
				tickets.setSpotid(rs.getString("Spot_i"));
				return tickets;
			}
			return null;
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
	public List<Tickets> getAll() {
		
		

		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		
		String sql = "select Ticket_id, Ticket_name, Ticket_price,Spot_i from ticket  ";
		
		try
		{
			 List<Tickets> list= new ArrayList<Tickets>();
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			rs  = stmt.executeQuery();

			//5���������
			while(rs.next()){
				
				Tickets tickets = new Tickets();
				
				tickets.setId(rs.getString("Ticket_id"));
				tickets.setName(rs.getString("Ticket_name"));
				tickets.setPrice(rs.getString("Ticket_price"));
				tickets.setSpotid(rs.getString("Spot_i"));
				
				
				list.add(tickets);
				
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


	@Override
	public boolean exist(String name) {
		// TODO Auto-generated method stub
		
		
		
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		

		String sql = "select  Ticket_name from ticket where Ticket_name=? ";
		
	
		
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
	public int getCount() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		int count = 0;
		String sql = "select count(*) as idcount from ticket  ";

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
	public List<Tickets> getAll(Page page) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select Ticket_id, Ticket_name, Ticket_price,Spot_i from ticket limit ?, ? ";

		try {
			List<Tickets> list = new ArrayList<Tickets>();
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, page.getBeginIndex());
			stmt.setInt(2, page.getEveryPage());

			rs = stmt.executeQuery();

			// 5���������
			while (rs.next()) {
				Tickets tickets = new Tickets();
				
				tickets.setId(rs.getString("Ticket_id"));
				tickets.setName(rs.getString("Ticket_name"));
				tickets.setPrice(rs.getString("Ticket_price"));
				tickets.setSpotid(rs.getString("Spot_i"));
				
				
				list.add(tickets);
			}
			return list;

		} catch (Exception e) {
			throw new RuntimeException(e);

		} finally {
			JdbcUtil.release(rs, stmt, conn);
		}
	}
}
