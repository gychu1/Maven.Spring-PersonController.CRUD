package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public Person createPerson(@RequestBody Person p) {
        return personRepository.save(p);
    }

    public Person getPerson(@PathVariable int id) {
        return personRepository.findOne(id);
    }

    public List<Person> getPersonList() {
        return (List<Person>) personRepository.findAll();
    }

    public Person updatePerson(@RequestBody Person p, @PathVariable int id) {
        Person oldPerson = personRepository.findOne(id);
        oldPerson.setFirstName(p.getFirstName());
        oldPerson.setLastName(p.getLastName());

        personRepository.save(oldPerson);

        return oldPerson;
    }

    public void DeletePerson(int id) {
        personRepository.delete(id);
    }

}
