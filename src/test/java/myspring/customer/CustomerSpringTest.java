package myspring.customer;



import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.customer.service.CustomerService;
import myspring.customer.vo.CustomerVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans-mybatis.xml")
public class CustomerSpringTest {
	protected static final Logger logger = LogManager.getLogger();
	@Autowired
	CustomerService customerService;
	
	@Test
	void service() {
		customerService.insertCustomer(new CustomerVO("sub@spring.com","종섭", 28));
		CustomerVO customer = customerService.getCustomerInfo(2);
		logger.debug(customer);
		List<CustomerVO> customerList = customerService.getAllCustomerList();
		for (CustomerVO customerVO : customerList) {
			logger.debug(customerVO);
		}
	}
}
