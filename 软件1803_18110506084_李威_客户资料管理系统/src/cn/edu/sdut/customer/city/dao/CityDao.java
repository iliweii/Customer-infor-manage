package cn.edu.sdut.customer.city.dao;

import java.util.List;

import cn.edu.sdut.customer.city.entity.City;

public interface CityDao {
	
	List<City> queryAllCity(City city);
	List<City> queryCityToCustomer();
	City queryCityById(Integer cityid);
	int addCity(City city);
	int updateCity(City city);
	int deleteCity(Integer cityid);
	City queryCityByName(String cityname);
}
