package com.pracownia.spring.services;
;
import com.pracownia.spring.entities.Course;
import com.pracownia.spring.entities.Opinion;
import com.pracownia.spring.entities.Person;

import java.util.List;

public interface OpinionService {

    List<Opinion> listAllOpinions();

    Opinion getOpinionById(Integer id);

    Opinion saveOpinion(Opinion Opinion);

    void deleteOpinion(Integer id);

    public List<Opinion> takePerson(Person P);

    public List<Course> mostOpinions();

    public Iterable<Opinion> listAllProductsPaging(Integer pageNr, Integer howManyOnPage);

    }
