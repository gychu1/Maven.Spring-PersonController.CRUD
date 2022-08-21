package io.zipcoder.crudapp.service;

import io.zipcoder.crudapp.entity.Person;
import io.zipcoder.crudapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public Person createPerson(Person p) {
        return personRepository.save(p);
    }

    public Optional<Person> getPerson(int id) {
        return personRepository.findById(id);
    }

    public List<Person> getPersonList() {
        return (List<Person>) personRepository.findAll();
    }

    public Person updatePerson(Person p, int id) {
        Person oldPerson = personRepository.findById(id).get();
        oldPerson.setFirstName(p.getFirstName());
        oldPerson.setLastName(p.getLastName());

        personRepository.save(oldPerson);

        return oldPerson;
    }

    public void DeletePerson(int id) {
        personRepository.deleteById(id);
    }

}
