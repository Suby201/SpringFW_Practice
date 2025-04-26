package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:hello-di.xml")
public class HelloSpringTest {
	@Autowired
	Hello hello;
	@Autowired
	Printer strPrinter;
	@Autowired
	@Qualifier("strPrinter")
	Printer printer;
	
	@Resource(name="hello")
	Hello helloBean;
	
	@Test
	void helloSpringBean() {
		assertEquals("Hello Spring", hello.sayHello());
		hello.print();
		
		assertEquals("Hello Spring", printer.toString());
		System.out.println(printer.getClass().getName());
		
		assertEquals("Hello Spring", helloBean.sayHello());
	}
}
