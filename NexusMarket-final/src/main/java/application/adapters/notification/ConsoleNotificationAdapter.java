package application.adapters.notification;
import application.domain.ports.out.NotificationPort;
public class ConsoleNotificationAdapter implements NotificationPort { public void send(String recipient,String subject,String message){System.out.println("NOTIFICATION -> "+recipient+" | "+subject+" | "+message);} }
