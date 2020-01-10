package cn.edu.sdut.customer.test.customer;

import java.util.List;

import cn.edu.sdut.comm.prorperties.factory.BeanFactory;
import cn.edu.sdut.customer.comm.CommonUtils;
import cn.edu.sdut.customer.customer.dao.CustomerDao;
import cn.edu.sdut.customer.customer.entity.Customer;

public class TestCustomer {

	private CustomerDao dao = BeanFactory.getInstance(CommonUtils.CustomerInof.CUSTOMERDAO);
	public static void main(String[] args) {
		TestCustomer test = new TestCustomer();
		test.testQueryAll();
//		test.testDetailCustomer();
//		test.testAddCustomer();
//		test.testUpdateCustomer();
	}
	private void testUpdateCustomer() {
		Customer customer = new Customer();
		customer.setCustid(12);
		customer.setCustname("蔡徐坤");
		customer.setCustphone("120");
		customer.setCuetemail("123@qq.com");
		customer.setCustgender("女");
		customer.setCityid(3);
		customer.setCuslevel(1);
		int rows = dao.updateCustomer(customer);
		if(rows > 0) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
		
	}
	private void testAddCustomer() {
		Customer customer = new Customer();
		customer.setCustname("蔡某人");
		customer.setCustphone("123");
		customer.setCuetemail("123@qq.com");
		customer.setCustgender("女");
		customer.setCityid(4);
		customer.setCuslevel(2);
		int rows = dao.addCustomer(customer);
		if(rows > 0) {
			System.out.println("保存成功");
		}else {
			System.out.println("保存失败");
		}
		
	}
	private void testDetailCustomer() {
		Integer custid = 4;
		Customer customer = dao.queryCustomerById(custid);
		System.out.println(customer);
		
	}
	private void testQueryAll() {
		Customer customer = new Customer();
		customer.setCustname("蔡");
		List<Customer> list = dao.queryAllCustomer(customer);
		for (Customer g : list) {
			System.out.println(g);
		}
	}
}
