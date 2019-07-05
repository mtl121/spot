package cn.lvb.dao;

import java.util.List;

import cn.lvb.bean.*;

public interface TouristsDAO {
	
	public int getCount();//获取需要显示的所有记录
	public boolean add( Tourists bean  );
	public boolean delete(int id);
	public boolean update(   Tourists bean );
	public Tourists login(String name, String password);
	public List<Tourists> getAll(Page page);
	public boolean exist(String phone);

	
}
