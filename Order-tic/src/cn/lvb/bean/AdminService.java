package cn.lvb.bean;

import java.sql.SQLException;

import cn.lvb.dao.AdminDAO;
import cn.lvb.dao.impl.AdminDAOImpl;



public class AdminService {
	
	private AdminDAO dao = new AdminDAOImpl();
	public Admin login(String username,String password) throws SQLException {
		return dao.login(username, password);
	}
}
