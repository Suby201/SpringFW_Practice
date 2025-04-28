package mylab.notification.di.annot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mylab.notification.di.annot.EmailNotificationService;
import mylab.notification.di.annot.NotificationManager;
import mylab.notification.di.annot.SmsNotificationService;

@Configuration
public class NotificationConfig {
	@Bean
	public EmailNotificationService emailNotificationService() {
		String smtpServer = "smtp.gmail.com"; int port = 587;
		return new EmailNotificationService(smtpServer, port);
	}
	
	@Bean
	public SmsNotificationService smsNotificationService() {
		String provider="SKT";
		return new SmsNotificationService(provider);
	}
	@Bean
	public NotificationManager notificationManager() {
		return new NotificationManager(emailNotificationService(), smsNotificationService());
	}
}
