package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Opinion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OpinionRepository extends CrudRepository<Opinion, Integer> {


}
