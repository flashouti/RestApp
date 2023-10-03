package ru.alishev.springcourse.FirstRestApp1.services;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.alishev.springcourse.FirstRestApp1.models.Person;
import ru.alishev.springcourse.FirstRestApp1.repositories.PeopleRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PeopleServiceTest {

    @Mock
    private PeopleRepository peopleRepository;
    private PeopleService peopleService;

    @BeforeEach
    void setUp(){
        peopleService = new PeopleService(peopleRepository);
    }

    @Test
    void findAll() {
        peopleService.findAll();

        verify(peopleRepository).findAll();
    }

    @Test
    void findOne() {
    }

    @Test
    void save() {
        Person person = new Person(
                "Jamila",
                19,
                "jamila@gmail.com"
        );
        peopleService.save(person);

        ArgumentCaptor<Person> personArgumentCaptor = ArgumentCaptor.forClass(Person.class);

        verify(peopleRepository).save(personArgumentCaptor.capture());

        Person capturedPerson = personArgumentCaptor.getValue();

        assertThat(capturedPerson).isEqualTo(person);

    }

}