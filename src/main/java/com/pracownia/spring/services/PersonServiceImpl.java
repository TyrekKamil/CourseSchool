package com.pracownia.spring.services;

import com.pracownia.spring.entities.Opinion;
import com.pracownia.spring.entities.Person;
import com.pracownia.spring.repositories.OpinionRepository;
import com.pracownia.spring.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Person service implement.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository PersonRepository;
    @Autowired
    private OpinionService opinionService;
    @Autowired
    private PersonService personService;
    @Autowired
    private OpinionRepository opinionRepository;

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
        Person a = new Person();
        a = personService.getPersonById(id);
        List<Opinion> result = opinionService.takePerson(a);
        for(int i=0;i<result.size();i++)
            opinionRepository.delete(result.get(i));
        PersonRepository.delete(id);


    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (PersonRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }



    @Override
    public int olderThan()
    {
        return PersonRepository.young();
    }
}
