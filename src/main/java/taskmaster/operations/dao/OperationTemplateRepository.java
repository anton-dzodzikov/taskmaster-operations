package taskmaster.operations.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import taskmaster.operations.domain.OperationTemplate;

@Repository
public interface OperationTemplateRepository extends ReactiveCrudRepository<OperationTemplate, Integer> {
    Mono<OperationTemplate> findFirstByName(String name);
}
