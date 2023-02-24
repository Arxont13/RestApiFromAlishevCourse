package com.exam.controllers;

import com.exam.models.Person;
import com.exam.service.PeopleService;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Period;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService){
        this.peopleService = peopleService;
    }

    @GetMapping()
    public List<Person> getPeople() {
      return peopleService.findAll();// jackson конвертирует объекты в json
    }

    @GetMapping("/{id}")
    public Person getPeople(@PathVariable("id") int id) {
        return peopleService.findOne(id);
    }
}
