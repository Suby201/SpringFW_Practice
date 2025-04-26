package myspring.di.xml;


import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class HelloJunitTest {
	ApplicationContext context;
	
	@BeforeEach
	void container() {
		//1.container 객체 생성
		context = new GenericXmlApplicationContext("classpath:hello-di.xml");		
	}
	
	@Test
	void helloBean() {
		//2. container객체가 생성한 spring bean을 요청하기
		Hello helloById = (Hello) context.getBean("hello");
		Hello helloByType = context.getBean("hello", Hello.class);
		
		
		//spring bean 주소 비교
		System.out.println(helloById==helloByType);
		assertSame(helloById, helloByType);
		
		//값 비교
		assertEquals("Hello Spring", helloById.sayHello());
		
		helloById.print();
		
		Printer printer = context.getBean("strPrinter", Printer.class);
		assertEquals("Hello Spring", printer.toString());
	}
}
