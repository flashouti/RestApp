package ru.alishev.springcourse.FirstRestApp1.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.alishev.springcourse.FirstRestApp1.models.Person;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PeopleRepositoryTest {

    @Autowired
    private PeopleRepository peopleRepository;

    @Test
    void existsPersonByEmail() {
        String email = "jamila@gmail.com";
        Person person = new Person(
                "Jamila",
                19,
                email
        );
        peopleRepository.save(person);

        boolean exist = peopleRepository.existsPersonByEmail(email);

        assertThat(exist).isTrue();

    }

    @Test
    void itShouldCheckByEmailNotExist() {
        String email = "jamila@gmail.com";
        boolean exist = peopleRepository.existsPersonByEmail(email);

        assertThat(exist).isFalse();

    }
}