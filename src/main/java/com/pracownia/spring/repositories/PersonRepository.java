package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource
public interface PersonRepository extends CrudRepository<Person, Integer>, PagingAndSortingRepository<Person, Integer> {



    @Query("select count(*) from Person p where p.id = ?1")
    Integer checkIfExist(Integer id);

    @Query("select count(*) from Person p where p.date > '1/1/1990' ")
    int young();
}
