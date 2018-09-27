package taskmaster.operations.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import taskmaster.operations.dao.OperationTemplateRepository;
import taskmaster.operations.domain.OperationTemplate;

@RestController
@RequestMapping("templates")
public class OperationTemplateController {
    @Autowired
    private OperationTemplateRepository repository;

    @RequestMapping("")
    public Flux<OperationTemplate> getAll() {
        // TODO: Add test
        return repository.findAll();
    }

    @RequestMapping("{name}")
    public Mono<OperationTemplate> getByName(@PathVariable String name) {
        // TODO: Add test
        return repository.findFirstByName(name);
    }

    @RequestMapping(path = "", method = RequestMethod.PUT)
    public Mono<OperationTemplate> createOperationTemplate(@RequestBody OperationTemplate template) {
        // TODO: Allow this method to do multiple insertions (as list)
        // TODO: Add test
        return repository.save(template);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public Mono<OperationTemplate> updateOperationTemplate(@RequestBody OperationTemplate template) {
        // TODO: Allow this method to do multiple updates (as list)
        // TODO: Add test
        return null;
    }

    @RequestMapping(path = "", method = RequestMethod.DELETE)
    public Mono<OperationTemplate> deleteOperationTemplate(@RequestBody OperationTemplate template) {
        // TODO: Allow this method to do multiple deletions (as list)
        // TODO: Add test
        return null;
    }
}
