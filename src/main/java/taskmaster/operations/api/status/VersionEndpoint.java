package taskmaster.operations.api.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "version")
public class VersionEndpoint {
    @Autowired
    BuildProperties buildProperties;

    @ReadOperation
    public String getVersion() {
        return buildProperties.getVersion();
    }
}
