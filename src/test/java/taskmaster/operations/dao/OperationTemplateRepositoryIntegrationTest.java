package taskmaster.operations.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import taskmaster.operations.OperationsApplication;
import taskmaster.operations.domain.OperationTemplate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OperationsApplication.class)
public class OperationTemplateRepositoryIntegrationTest {
    @Autowired
    OperationTemplateRepository repository;

    @Test
    public void repositoryExistsInContext() {
        assertNotNull(repository);
    }

    @Test
    public void saveWorks() {
        // Given
        repository.deleteAll();
        OperationTemplate template = new OperationTemplate(1, "TEST_OPERATION", "content");

        // When
        Mono<OperationTemplate> result = repository.save(template);

        // Then
        StepVerifier.create(result)
                .assertNext(operationTemplate -> {
                    assertNotNull(operationTemplate);
                    assertEquals("TEST_OPERATION", operationTemplate.getName());
                })
                .expectComplete()
                .verify();
    }
}