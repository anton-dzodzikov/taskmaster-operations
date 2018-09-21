package taskmaster.operations.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OperationTemplate {
    // TODO: Generate ID automatically
    // TODO: Make ID unique
    @Id
    private Integer id;
    private String name;
    private String body;

    public OperationTemplate(Integer id, String name, String body) {
        this.id = id;
        this.name = name;
        this.body = body;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
