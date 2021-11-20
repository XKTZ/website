package xktz.website.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * Email util
 */
@Component
@Slf4j
public class EmailUtil {

    @Autowired
    private JavaMailSender mailSender;

    /**
     * Send email
     * @param content content
     */
    public void send(String receiver, String subject, String content) throws MailException {
        var msg = new SimpleMailMessage();
        msg.setTo(receiver);
        msg.setSubject(subject);
        msg.setText(content);
        mailSender.send(msg);
    }
}
