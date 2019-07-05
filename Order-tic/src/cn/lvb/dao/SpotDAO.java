package cn.lvb.dao;

import java.util.*;

import cn.lvb.bean.*;

public interface SpotDAO {

	
	public boolean add( Spot spot  );
	public boolean delete(int id);
	
	public boolean exist(String name);
	public boolean update( Spot spot   );
	public Spot getOne(String name);
	public List<Spot> getAll();
	public int getCount();//获取需要显示的所有记录
	public List<Spot> getAll(Page page);
	
	
}
