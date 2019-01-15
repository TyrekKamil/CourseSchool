package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

public interface PersonRepository extends CrudRepository<Person, Integer>, PagingAndSortingRepository<Person, Integer> {



    @Query("select count(*) from Person p where p.id = ?1")
    Integer checkIfExist(Integer id);
}
