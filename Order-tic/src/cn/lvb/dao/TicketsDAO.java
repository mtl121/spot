package cn.lvb.dao;

import java.util.*;

import cn.lvb.bean.*;

public interface TicketsDAO {

	
	public boolean add( Tickets tickets  );
	public boolean delete(String name);
	
	public boolean exist(String name);
	public boolean update(   Tickets tickets  );
	public Tickets getOne(String name);
	public List<Tickets> getAll();
	public int getCount();//获取需要显示的所有记录
	public List<Tickets> getAll(Page page);
	
}
