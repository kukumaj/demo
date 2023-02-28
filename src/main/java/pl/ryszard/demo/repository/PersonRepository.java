package pl.ryszard.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.ryszard.demo.model.Person;

@Repository
@Component
public interface PersonRepository extends JpaRepository<Person, Long> {

}
