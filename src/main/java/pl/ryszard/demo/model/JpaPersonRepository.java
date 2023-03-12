package pl.ryszard.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaPersonRepository extends JpaRepository<Person, Long> {
    public List<Person> findByFirstName(String firstName);
}
