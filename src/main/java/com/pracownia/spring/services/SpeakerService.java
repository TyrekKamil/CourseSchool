package com.pracownia.spring.services;
;
import com.pracownia.spring.entities.Course;
import com.pracownia.spring.entities.Speaker;

import java.util.List;

public interface SpeakerService {

    Iterable<Speaker> listAllSpeakers();

    Speaker getSpeakerById(Integer id);

    Speaker saveSpeaker(Speaker Speaker);

    void deleteSpeaker(Integer id);

    List<Course> courses(int id);

}
