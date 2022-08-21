package io.zipcoder.crudapp.controller;

import io.zipcoder.crudapp.entity.Person;
import io.zipcoder.crudapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/people")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person p) {
        return new ResponseEntity<>(personService.createPerson(p), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    private ResponseEntity<Person> getPerson(@PathVariable int id) {
        Optional<Person> person = personService.getPerson(id);
        if (person.isPresent()) {
            return new ResponseEntity<>(person.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    private ResponseEntity<List<Person>> getPersonList() {
        return new ResponseEntity<>(personService.getPersonList(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Person> updatePerson(@RequestBody Person p, @PathVariable int id) {
        return new ResponseEntity<>(personService.updatePerson(p, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> DeletePerson(@PathVariable int id) {
        personService.DeletePerson(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
