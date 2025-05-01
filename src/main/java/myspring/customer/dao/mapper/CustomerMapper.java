package myspring.customer.dao.mapper;

import java.util.List;

import myspring.customer.vo.CustomerVO;

public interface CustomerMapper {
	public List<CustomerVO> selectAllCustomer();
	public CustomerVO selectCustomerById(int id);
	public void insertCustomer(CustomerVO customer);
}
