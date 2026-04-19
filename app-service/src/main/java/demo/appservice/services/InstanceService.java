package demo.appservice.services;

import demo.appservice.configs.AppConfigs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class InstanceService {

    private final Environment environment;
    private final AppConfigs appConfigs;

    public InstanceService(Environment environment,
                           AppConfigs appConfigs) {
        this.environment = environment;
        this.appConfigs = appConfigs;
    }


    public String getValueProperty() {
        return Optional.ofNullable(appConfigs.getValue())
                .map(port -> {
                    String message = "Current properties value is: %s".formatted(port);
                    log.info(message);
                    return message;
                })
                .orElse("Value from properties is not present");
    }

    public String getPort() {
        return Optional.ofNullable(environment.getProperty("local.server.port"))
                .map(port -> {
                    String message = "Server port is: %s".formatted(port);
                    log.info(message);
                    return message;
                })
                .orElse("Port is not present");
    }
}
