package cn.edu.sdut.customer.test.city;

import java.util.List;

import cn.edu.sdut.comm.prorperties.factory.BeanFactory;
import cn.edu.sdut.customer.city.dao.CityDao;
import cn.edu.sdut.customer.city.entity.City;
import cn.edu.sdut.customer.comm.CommonUtils;

public class TestCity {
	
	private CityDao dao = BeanFactory.getInstance(CommonUtils.CityInfo.CITYDAO);
	private List<City> queryCityById;
	public static void main(String[] args) {
		TestCity test = new TestCity();
		test.testQueryAll();
//		test.testQueryCityToCustomer();
//		test.testDetailCity();
//		test.testAddCity();
//		test.testUpdateCity();
		
	}
	private void testUpdateCity() {
		City city = new City();
		city.setCityid(4);
		city.setCityname("济北");
		int rows = dao.updateCity(city);
		if(rows > 0) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
		
	}
	private void testAddCity() {
		City city = new City();
		city.setCityname("西京");
		int rows = dao.addCity(city);
		if(rows > 0) {
			System.out.println("保存成功");
		}else {
			System.out.println("保存失败");
		}
	}
	private void testDetailCity() {
		Integer cityid = 4;
		City city = dao.queryCityById(cityid);
		System.out.println(city);
	}
	private void testQueryCityToCustomer() {
		List<City> list = dao.queryCityToCustomer();
		for (City city : list) {
			System.out.println(city);
		}
	}
	private void testQueryAll() {
		City city = new City();
		city.setCityname("北");
		List<City> list = dao.queryAllCity(city);
		for (City g : list) {
			System.out.println(g);
		}
	}
}
