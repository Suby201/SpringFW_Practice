package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:hello-di.xml")
public class HelloConSpringTest {
	@Autowired
	@Qualifier("helloC")
	Hello hello;
	
	@Test
	void helloCons() {
		System.out.println(hello.sayHello());
		assertEquals("Hello SpringC", hello.sayHello());
		
		assertEquals(3, hello.getNames().size());
		assertEquals("SpringCloud", hello.getNames().get(2));
		
		for(String name : hello.getNames()) {
			System.out.println(name);
		}
		
		//Iterable 인터페이스의 forEach(Consumer) 호출하기
		//람다식 함수형 인터페이스
	}

}
