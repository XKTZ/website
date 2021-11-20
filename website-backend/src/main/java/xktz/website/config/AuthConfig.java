package xktz.website.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xktz.website.global.user.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class AuthConfig {

    @Bean("loginTokenMap")
    public Map<String, User> loginTokenMap() {
        return new ConcurrentHashMap<>() {{
        }};
    }

    @Bean("loginUserMap")
    public Map<User, String> loginUserMap() {
        return new ConcurrentHashMap<>() {{
        }};
    }
}
