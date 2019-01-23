package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Speaker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpeakerRepository extends CrudRepository<Speaker, Integer> {


}
