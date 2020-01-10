package cn.edu.sdut.customer.customer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.edu.sdut.comm.base.dao.BaseDaoImpl;
import cn.edu.sdut.customer.customer.dao.CustomerDao;
import cn.edu.sdut.customer.customer.entity.Customer;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

	@Override
	public List<Customer> queryAllCustomer(Customer customer) {
		String sql = "select * from customer";
		StringBuffer sb = new StringBuffer();
		List<Object> list = new ArrayList<Object>();
		sb.append(sql);
		
		
		if(customer != null && customer.getCustname()!=null && !customer.getCustname().isEmpty()) {
			sb.append(" WHERE custname LIKE ?");
			list.add("%" + customer.getCustname()+"%");
		}
		sb.append(" order by custid desc");
		sql = sb.toString();
		return super.selectAll(sql, Customer.class, list.toArray());
	}
	
	@Override
	public Customer queryCustomerById(Integer custid) {
		String sql = "SELECT * FROM customer  WHERE custid=?";
		return super.selectOne(sql, Customer.class,  custid);
	}

	@Override
	public int addCustomer(Customer customer) {
		String sql = "INSERT INTO customer VALUES (NULL,?,?,?,?,?,?)";
		return super.saveOrUpdate(sql, customer.getCustname(),customer.getCustphone(),customer.getCuetemail(),customer.getCustgender(),customer.getCityid(),customer.getCuslevel());
	}

	@Override
	public int updateCustomer(Customer customer) {
		String sql = "UPDATE customer SET custname = ?,custphone = ?,cuetemail = ?,custgender = ?,cityid = ?,cuslevel = ?  WHERE custid = ?";

		return super.saveOrUpdate(sql, customer.getCustname(),customer.getCustphone(),customer.getCuetemail(),customer.getCustgender(),customer.getCityid(),customer.getCuslevel(),customer.getCustid());
	}

	@Override
	public int deleteCustomer(Integer custid) {
		String sql = "DELETE FROM customer WHERE custid=?";
		
		return super.saveOrUpdate(sql, custid);
	}

	

}
