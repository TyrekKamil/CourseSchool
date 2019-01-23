package com.pracownia.spring.services;

import com.pracownia.spring.entities.Person;
import com.pracownia.spring.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Person service implement.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository PersonRepository;

    @Override
    public Iterable<Person> listAllPersonsPaging(Integer pageNr, Integer howManyOnPage) {
        return PersonRepository.findAll(new PageRequest(pageNr,howManyOnPage));
    }

    @Override
    public Iterable<Person> listAllPersons() {
        return PersonRepository.findAll();
    }

    @Override
    public Person getPersonById(Integer id) {
        return PersonRepository.findOne(id);
    }

    @Override
    public Person savePerson(Person Person) {
        return PersonRepository.save(Person);
    }

    @Override
    public void deletePerson(Integer id) {
        PersonRepository.delete(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (PersonRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }



}
