package pl.ryszard.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.ryszard.demo.repository.PersonRepository;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // save a new person
        Person person = new Person();
        person.setName("John");
        person.setAge(30);
        personRepository.save(person);

        // find all persons
        List<Person> persons = personRepository.findAll();
        for (Person p : persons) {
            System.out.println(p.getFirstName() + " is " + p.getAge() + " years old.");
        }
    }
}
