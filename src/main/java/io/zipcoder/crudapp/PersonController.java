package io.zipcoder.crudapp;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/people")
public class PersonController {

    @PostMapping
    Person createPerson(@RequestBody Person p) {
        return null;
    }
    @GetMapping("/{id}")
    Person getPerson(@PathVariable int id) {
        return null;
    }

    @GetMapping
    List<Person> getPersonList() {
        return null;
    }

    @PutMapping("/{id}")
    Person updatePerson(@RequestBody Person p, @PathVariable int id) {
        return null;
    }

    @DeleteMapping("/{id}")
    void DeletePerson(int id) {

    }
}
