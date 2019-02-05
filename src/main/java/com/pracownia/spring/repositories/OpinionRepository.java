package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Course;
import com.pracownia.spring.entities.Opinion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface OpinionRepository extends CrudRepository<Opinion, Integer>, PagingAndSortingRepository<Opinion, Integer>
{

    @Query("select o.course from Opinion o")
    List<Course> max();

}
