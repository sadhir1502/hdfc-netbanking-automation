package health.trayt.automation.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
@Getter
public class ApplicationConfig {

    @Value("${portal.url}")
    private String portalURL;
    @Value("#{${portal.credentials}}")
    private Map<String, String> credentials;

    public Credentials getUserCredentials(String userType) {
        //ToDO add code to decrypt credentials
        Optional<Credentials> loginCredentials = credentials.entrySet().stream().filter(type -> userType.equalsIgnoreCase(type.getKey())).map(entry -> Credentials.builder().userName(entry.getValue().split("=")[0]).password(entry.getValue().split("=")[1]).build()).findFirst();
        return loginCredentials.orElse(null);
    }

}
