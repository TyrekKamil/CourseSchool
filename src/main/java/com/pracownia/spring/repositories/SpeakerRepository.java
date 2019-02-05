package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Course;
import com.pracownia.spring.entities.Speaker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource
public interface SpeakerRepository extends CrudRepository<Speaker, Integer> {


    @Query("select s.course from Speaker s where s.id = ?1")
    List<Course> courses(int id);

}
