package pl.ryszard.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

//    @DeleteMapping("/{id}")
//    public void findById(@PathVariable Long id) {
//         personRepository.deleteById(id);
//    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        personRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable Long id, @RequestBody Person person) {
        Person updatedPerson = personRepository.findById(id).orElse(null);
        if (updatedPerson != null) {
            updatedPerson.setFirstName(person.getFirstName());
            updatedPerson.setLastName(person.getLastName());
            updatedPerson.setAge(person.getAge());
            personRepository.save(updatedPerson);
        }
        return updatedPerson;
    }


//    @GetMapping("/{id}")
//    public Person findById(@PathVariable Long id, @RequestParam int age) {
//        Person person = personRepository.findById(id).orElse(null);
//        if (person != null) {
//            person.setAge(age);
//            personRepository.save(person);
//        }
//        return person;
//    }
    @GetMapping("/{id}")
    public Person findById(@PathVariable Long id) {
        return personRepository.findById(id).orElse(null);
    }


    @GetMapping("/search")
    public List<Person> search(@RequestParam(name = "q") String query) {
        return personRepository.findByFirstName(query);
    }
    @PostMapping("/init")
    public List<Person> init(@RequestBody Person person) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", "Doe", 30));
        persons.add(new Person("John", "Doee", 31));
        persons.add(new Person("John", "Doeee", 32));
        persons.add(new Person("Jane", "Doe", 25));
        persons.add(new Person("Bob", "Smith", 40));
        persons.add(new Person("Alice", "Jones", 36));
        persons.add(new Person("Alice", "Jones", 37));
        persons.add(new Person("Alice", "Jones", 38));
        persons.add(new Person("Alice", "Jones", 39));
        personRepository.saveAll(persons);
        return persons;
    }


}
