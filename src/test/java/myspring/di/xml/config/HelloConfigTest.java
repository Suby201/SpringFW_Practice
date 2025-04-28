package myspring.di.xml.config;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HelloConfig.class )
public class HelloConfigTest {
	@Autowired
	List<String> namesList;
	
	@Autowired
	Hello hello;
	
	@Resource(name="stringPrinter")
	Printer printer;
	
	@Test
	void testHelloConfig() {
		assertEquals("Hello Spring", hello.sayHello());
		hello.print();
		assertEquals("Hello Spring", printer.toString());
		assertEquals("Spring", hello.getNames().get(1));
	}
	
	
	
	@Test
	void testNameList() {
		for (String name : namesList) {
			System.out.println(name);
		}
	}
	
}