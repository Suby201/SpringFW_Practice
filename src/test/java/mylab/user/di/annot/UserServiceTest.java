package mylab.user.di.annot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {
	@Autowired
	private UserService userService;

	@Test
	void testUserService() {
		assertNotNull(userService);
		assertNotNull(userService.getUserRepository());
		assertEquals("MySQL",userService.getUserRepository().getDbType());
		assertTrue(userService.getUserRepository().saveUser("suby", "종섭"));
		assertNotNull(userService.getSecurityService());
		assertTrue(userService.getSecurityService().authorize("suby", "MySQL"));
		assertTrue(userService.registerUser("suby", "종섭", "dkagh"));
	}
}
