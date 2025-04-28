package mylab.notification.di.annot.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mylab.notification.di.annot.NotificationManager;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = NotificationConfig.class)
public class NotificationConfigTest {
	@Autowired
	private NotificationManager notificationManager;
	
	@Test
	public void testNotificationManager() {
		assertNotNull(notificationManager);
//		assertEquals(587, notificationManager.getEmailService());
		String message = "Hello World";
		notificationManager.getEmailService().sendNotification(message);
		notificationManager.getSmsService().sendNotification(message);
	}
}
