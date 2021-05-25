package br.com.erudio.controller;

import br.com.erudio.model.Person;
import br.com.erudio.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService services;

    @GetMapping(value = "/{id}")
    public Person findById(@PathVariable(value = "id") Long id ) {
        return services.findById(id);
    }

    @GetMapping(value = "/all")
    public List<Person> findAll() {
        return services.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person p) {
        return services.create(p);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person p) {
        return services.update(p);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id ) {
        services.delete(id);
        return ResponseEntity.ok().build();
    }

}