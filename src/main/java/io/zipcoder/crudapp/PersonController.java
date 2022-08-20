package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return new ResponseEntity<>(personService.getPerson(id), HttpStatus.OK);
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
    private void DeletePerson(@PathVariable int id) {
        personService.DeletePerson(id);
    }
}
