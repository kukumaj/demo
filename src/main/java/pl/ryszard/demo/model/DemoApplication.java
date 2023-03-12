package pl.ryszard.demo.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DemoApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        JpaPersonRepository personRepository = context.getBean(JpaPersonRepository.class);
        //System.out.println(personRepository.findAll());
//        SpringApplication.run(DemoApplication.class, args);
//        System.out.println(JpaPersonRepository.findAll());

    }

}
