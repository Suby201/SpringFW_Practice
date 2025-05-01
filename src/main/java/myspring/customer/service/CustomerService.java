package myspring.customer.service;

import java.util.List;

import myspring.customer.vo.CustomerVO;

public interface CustomerService {
    void insertCustomer(CustomerVO customer);
    CustomerVO getCustomerInfo(int id);
	List<CustomerVO> getAllCustomerList();
	CustomerVO getCustomerInfoByEmail(String email);
    void updateCustomer(CustomerVO customer);
}