package myspring.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myspring.customer.dao.CustomerDAO;
import myspring.customer.vo.CustomerVO;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerDAO customerDAO;

	@Override
	public List<CustomerVO> getAllCustomerList() {
		// TODO Auto-generated method stub
		return customerDAO.selectAllCustomer();
	}

	@Override
	public CustomerVO getCustomerInfo(int id) {
		// TODO Auto-generated method stub
		return customerDAO.selectCustomer(id);
	}

	@Override
	public void insertCustomer(CustomerVO customer) {
		CustomerVO existingCustomer = customerDAO.getCustomerInfoByEmail(customer.getEmail());
        if (existingCustomer == null) {
            // 존재하지 않으면 삽입
            customerDAO.insertCustomer(customer);
        } else {
            // 존재하면 ID를 설정하고 업데이트
            customer.setId(existingCustomer.getId());
            customerDAO.updateCustomer(customer);
        }
	}
	public CustomerVO getCustomerInfoByEmail(String email) {
        return customerDAO.getCustomerInfoByEmail(email);
    }

    
    public void updateCustomer(CustomerVO customer) {
        customerDAO.updateCustomer(customer);
    }

}
