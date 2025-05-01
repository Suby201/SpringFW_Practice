package myspring.customer.dao;

import java.util.List;

import myspring.customer.vo.CustomerVO;

public interface CustomerDAO {
	public List<CustomerVO> selectAllCustomer();
	public CustomerVO selectCustomer(int id);
	public void insertCustomer(CustomerVO customer);
	CustomerVO getCustomerInfoByEmail(String email);
    void updateCustomer(CustomerVO customer);
}
