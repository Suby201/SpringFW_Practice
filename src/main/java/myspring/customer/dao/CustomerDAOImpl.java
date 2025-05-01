package myspring.customer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myspring.customer.dao.mapper.CustomerMapper;
import myspring.customer.vo.CustomerVO;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
	@Autowired
	private CustomerMapper customerMapper;
	
	@Autowired
    private SqlSession sqlSession;

    private static final String NS = "myspring.customer.dao.mapper.CustomerMapper";
	
	@Override
	public void insertCustomer(CustomerVO customer) {
		customerMapper.insertCustomer(customer);
		System.out.println("등록된 정보  이름: "+customer.getName()+", 나이: "+customer.getAge());
	}
	@Override
	public List<CustomerVO> selectAllCustomer() {
		List<CustomerVO> customerList = customerMapper.selectAllCustomer();
		return customerList;
	}
	@Override
	public CustomerVO selectCustomer(int id) {
		CustomerVO customer = customerMapper.selectCustomerById(id);
		return customer;
	}
	
	public CustomerVO getCustomerInfoByEmail(String email) {
        return sqlSession.selectOne(NS + ".getCustomerInfoByEmail", email);
    }

    
    public void updateCustomer(CustomerVO customer) {
        sqlSession.update(NS + ".updateCustomer", customer);
        System.out.println("업데이트된 정보  이름: "+customer.getName()+", 나이: "+customer.getAge());
    }
	
}