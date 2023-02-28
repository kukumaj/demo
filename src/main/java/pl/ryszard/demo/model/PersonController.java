package pl.ryszard.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final JpaPersonRepository personRepository;

    @Autowired
    public PersonController(JpaPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @PostMapping
    public Person save(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @GetMapping("/search")
    public List<Person> search(@RequestParam(name = "q") String query, Pageable pageable) {
        return personRepository.findByFirstName(query);
    }


}
