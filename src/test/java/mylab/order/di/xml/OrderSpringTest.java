package mylab.order.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {
	@Autowired
	ShoppingCart shoppingCart;
	
	@Autowired
	OrderService orderService;

	@Test @Disabled
	void testShopingCart() {
		assertNotNull(shoppingCart);
		System.out.println(shoppingCart.toString());
		assertEquals("coke", shoppingCart.getProducts().get(1).getName());
		assertEquals(4800, shoppingCart.getTotalPrice());
	}
	
	@Test
	void testSerivice() {
		assertEquals(4800, orderService.calculateOrderTotal());
		assertEquals(shoppingCart, orderService.getShoppingCart());
	}
}
