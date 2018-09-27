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
        return repository.findAll();
    }

    @RequestMapping("{name}")
    public Mono<OperationTemplate> getByName(@PathVariable String name) {
        return repository.findFirstByName(name);
    }

    @RequestMapping(path = "", method = RequestMethod.PUT)
    public Mono<OperationTemplate> createOperationTemplate(@RequestBody OperationTemplate template) {
        // TODO: Allow this method to do multiple insertions (as list)
        return repository.save(template);
    }
}
