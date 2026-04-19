package demo.appservice.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
public class AppConfigs {

    @Value("${app.service.test.value}")
    private String value;

    public String getValue() {
        return value;
    }

    public AppConfigs setValue(String value) {
        this.value = value;
        return this;
    }
}
