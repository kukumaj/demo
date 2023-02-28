package pl.ryszard.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import pl.ryszard.demo.repository.PersonRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaPersonRepositoryImpl implements PersonRepository {

    private final EntityManager em;

    @Autowired
    public JpaPersonRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Person> findAll() {
        return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }

    @Override
    public Optional<Person> findById(Long id) {
        return Optional.ofNullable(em.find(Person.class, id));
    }

    @Override
    @Transactional
    public <S extends Person> S save(S entity) {
        if (entity.getId() == null) {
            em.persist(entity);
            return entity;
        } else {
            return em.merge(entity);
        }
    }

    @Override
    public Page<Person> findAll(Pageable pageable) {
        List<Person> persons = em.createQuery("SELECT p FROM Person p", Person.class)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();
        long count = em.createQuery("SELECT count(p) FROM Person p", Long.class)
                .getSingleResult();
        return new PageImpl<>(persons, pageable, count);
    }

}
