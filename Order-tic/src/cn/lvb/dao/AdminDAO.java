package cn.lvb.dao;

import java.util.*;

import cn.lvb.bean.*;

public interface AdminDAO {

	
	public boolean add( Admin admin  );
	public boolean delete(String username);
	
	public boolean exist(String username);
	public boolean update(   Admin admin  );
	public Admin getOneUser(String username);
	public List<Admin> getAllUser();
	
	public int getCount();//获取需要显示的所有记录
	public List<Admin> getAll(Page page);
	
	public Admin login(String username, String password);
	
}
