package cn.edu.sdut.customer.customer.dao;

import java.util.List;

import cn.edu.sdut.customer.customer.entity.Customer;


public interface CustomerDao {
	
	List<Customer> queryAllCustomer(Customer customer);
	Customer queryCustomerById(Integer custid);
	int addCustomer(Customer customer);
	int updateCustomer(Customer customer);
	int deleteCustomer(Integer custid);
}
