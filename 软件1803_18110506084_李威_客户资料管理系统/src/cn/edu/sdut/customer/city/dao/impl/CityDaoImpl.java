package cn.edu.sdut.customer.city.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.edu.sdut.comm.base.dao.BaseDaoImpl;
import cn.edu.sdut.customer.city.dao.CityDao;
import cn.edu.sdut.customer.city.entity.City;

public class CityDaoImpl extends BaseDaoImpl<City> implements CityDao {

	@Override
	public List<City> queryAllCity(City city) {
		String sql = "select * from city";
		StringBuffer sb = new StringBuffer();
		sb.append(sql);
		List<Object> list = new ArrayList<Object>();
		// WHERE cityname LIKE '%t%'
		if(city != null && city.getCityname()!=null && !city.getCityname().isEmpty()) {
			sb.append(" WHERE cityname LIKE ?");
			list.add("%" + city.getCityname()+"%");
		}
		sb.append(" order by cityid desc");
		sql = sb.toString();
		return super.selectAll(sql, City.class, list.toArray());
	}

	@Override
	public List<City> queryCityToCustomer() {
		String sql = "select * from city order by cityid desc";
		
		return super.selectAll(sql, City.class, null);
	}

	@Override
	public City queryCityById(Integer cityid) {
		String sql = "SELECT  * FROM  city WHERE cityid = ?";
		
		return super.selectOne(sql, City.class, cityid);
	}

	@Override
	public int addCity(City city) {
		String sql = "INSERT INTO city VALUES (NULL,?)";
		return super.saveOrUpdate(sql, city.getCityname());
	}

	@Override
	public int updateCity(City city) {
		String sql = "UPDATE city SET cityname = ?  WHERE cityid = ?";
		return super.saveOrUpdate(sql, city.getCityname(),city.getCityid());
	}

	@Override
	public int deleteCity(Integer cityid) {
		String sql = "DELETE FROM city WHERE cityid=?";
		
		return super.saveOrUpdate(sql, cityid);
	}

	@Override
	public City queryCityByName(String cityname) {
		String sql = "SELECT  * FROM  city WHERE cityname = ?";
		
		return super.selectOne(sql, City.class, cityname);
	}

}
