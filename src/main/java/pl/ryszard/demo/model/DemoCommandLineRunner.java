package pl.ryszard.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.ryszard.demo.repository.PersonRepository;

import java.util.List;

@Component
public class DemoCommandLineRunner implements CommandLineRunner {


    private PersonRepository personRepository;

    @Override
    public void run(String... args) {
        Person person = new Person();
        person.setName("John Doe");
        personRepository.save(person);

        List<Person> people = personRepository.findAll();
        System.out.println("People: " + people);
    }
}
