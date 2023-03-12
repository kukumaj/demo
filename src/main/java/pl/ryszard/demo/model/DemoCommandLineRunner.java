package pl.ryszard.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DemoCommandLineRunner implements CommandLineRunner {

    @Autowired

    private JpaPersonRepository personRepository;

    @Override
    public void run(String... args) {
        Person person = new Person();
        person.setName("John Doe");
        person.setId(1l);
//        personRepository.save(person);

        List<Person> people = personRepository.findAll();
        System.out.println("People: " + people);
    }
}
