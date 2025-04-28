package myspring.di.annot.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import mylab.user.di.annot.config.HelloBeanConfig;
import myspring.di.annot.HelloBean;
import myspring.di.annot.PrinterBean;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HelloBeanConfig.class, loader = AnnotationConfigContextLoader.class)
public class HelloBeanConfigTest {
	@Autowired
	HelloBean hello;
	
	@Autowired
	@Qualifier("stringPrinter")
	PrinterBean printer;
	
	@Test
	void helloBean() {
		assertEquals("Hello annotation", hello.sayHello());
		hello.print();
		assertEquals("Hello annotation", printer.toString());
		
		assertEquals(3, hello.getNames().size());
		assertEquals("Spring", hello.getNames().get(1));
	}
}
