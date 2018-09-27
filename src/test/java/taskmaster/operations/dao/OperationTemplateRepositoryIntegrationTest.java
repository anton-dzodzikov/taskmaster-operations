package taskmaster.operations.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import taskmaster.operations.OperationsApplication;
import taskmaster.operations.domain.OperationTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OperationsApplication.class)
public class OperationTemplateRepositoryIntegrationTest {
    @Autowired
    OperationTemplateRepository repository;

    @Before
    public void runBeforeEachTest() {
        if (repository != null) {
            repository.deleteAll();
        }
    }

    @Test
    public void repositoryExistsInContext() {
        assertNotNull(repository);
    }

    @Test
    public void saveWorks() {
        // Given
        OperationTemplate template = new OperationTemplate("TEST_OPERATION", "content");

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

    @Test
    public void idIsBeingGeneratedAutomatically() {
        // Given
        OperationTemplate template = new OperationTemplate("TEST_OPERATION", "content");

        // When
        Mono<OperationTemplate> result = repository.save(template);

        // Then
        StepVerifier.create(result)
                .assertNext(operationTemplate -> {
                    assertNotNull(operationTemplate.getId());
                })
                .expectComplete()
                .verify();
    }

    @Test
    public void findByNameWorks() {
        // Given
        OperationTemplate template = new OperationTemplate("FIND_ME", "content");
        Mono<OperationTemplate> saved = repository.save(template);
        saved.block();

        // When
        Mono<OperationTemplate> result = repository.findFirstByName("FIND_ME");

        // Then
        StepVerifier.create(result)
                .assertNext(operationTemplate -> {
                    assertNotNull(result);
                    assertEquals("content", operationTemplate.getBody());
                })
                .expectComplete()
                .verify();
    }
}