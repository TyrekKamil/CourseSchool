package com.pracownia.spring.services;

import com.pracownia.spring.entities.Person;
import java.util.Optional;

public interface PersonService {

    Iterable<Person> listAllPersons();

    Person getPersonById(Integer id);

    Person savePerson(Person Person);

    void deletePerson(Integer id);

    Boolean checkIfExist(Integer id);

    public Iterable<Person> listAllPersonsPaging(Integer pageNr, Integer howManyOnPage);
    public int olderThan();
}
