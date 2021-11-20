package xktz.website.global.activation.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import xktz.website.util.EmailUtil;

import java.util.UUID;

@Component
public class ActivationCodeUtil {

    private static final String ACTIVATION_EMAIL_SUBJECT = "Activation Code";

    private static final String ACTIVATION_EMAIL_PREFIX = "Your activation code is:\n";

    @Value("${websiteConfig.url.activation}")
    private String ACTIVATION_EMAIL_WEBSITE_PREFIX;

    @Autowired
    private EmailUtil emailUtil;

    public void sendActivationCode(String email, String uuid) {
        emailUtil.send(email, ACTIVATION_EMAIL_SUBJECT,
                ACTIVATION_EMAIL_PREFIX + ACTIVATION_EMAIL_WEBSITE_PREFIX + uuid);
    }

    public String getUUID() {
        return UUID.randomUUID().toString();
    }
}
