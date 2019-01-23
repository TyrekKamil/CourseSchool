package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Person;
import com.pracownia.spring.repositories.PersonRepository;
import com.pracownia.spring.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * Person controller.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonService PersonService;
    @Autowired
    private PersonRepository personRepository;


    /**
     * List all Persons.
     *
     */
    @RequestMapping(value = "/Persons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Person> list(Model model) {
        return PersonService.listAllPersons();
    }

    // Only for redirect!
    @ApiIgnore
    @RequestMapping(value = "/Persons", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Person> redirect(Model model) {
        return PersonService.listAllPersons();
    }

    @RequestMapping(value = "/Persons/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Person> list(@PathVariable("page") Integer pageNr,@RequestParam("size") Optional<Integer> howManyOnPage) {
        return PersonService.listAllPersonsPaging(pageNr, howManyOnPage.orElse(2));
    }


    /**
     * View a specific Person by its id.
     *
     */
    @RequestMapping(value = "/Person/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getByPublicId(@PathVariable("id") Integer publicId) {
        return PersonService.getPersonById(publicId);
    }

    /**
     * View a specific Person by its id.
     *
     */
    @RequestMapping(value = "/Person", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getByParamPublicId(@RequestParam("id") Integer publicId) {
        return PersonService.getPersonById(publicId);
    }

    /**
     * Save Person to database.
     *
     */
    @RequestMapping(value = "/Person", method = RequestMethod.POST)
    public ResponseEntity<Person> create(@RequestBody @Valid @NotNull Person Person) {
        Random random = new Random();
        int i = random.nextInt(20);
        Person.setPersonId(i);
        PersonService.savePerson(Person);
        return ResponseEntity.ok().body(Person);
    }


    /**
     * Edit Person in database.
     *
     */
    @RequestMapping(value = "/Person", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Person Person) {
        if(!PersonService.checkIfExist(Person.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            PersonService.savePerson(Person);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    /**
     * Delete Person by its id.
     *
     */
    @RequestMapping(value = "/Person/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(HttpServletResponse response, @PathVariable Integer id) {
        PersonService.deletePerson(id);
        return new RedirectView("/api/Persons", true);
    }


}
