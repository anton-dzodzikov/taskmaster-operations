package taskmaster.operations.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OperationTemplate {
    @Id
    private String id;

    @Indexed(unique = true)
    private String name;
    private String body;

    public OperationTemplate(String name, String body) {
        this.name = name;
        this.body = body;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
