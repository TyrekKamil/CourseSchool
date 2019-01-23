package com.pracownia.spring.services;

import com.pracownia.spring.entities.Speaker;
import com.pracownia.spring.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SpeakerServiceImpl implements SpeakerService {

    @Autowired
    private SpeakerRepository SpeakerRepository;

    @Override
    public Iterable<Speaker> listAllSpeakers() {
        return SpeakerRepository.findAll();
    }

    @Override
    public Speaker getSpeakerById(Integer id) {
        return SpeakerRepository.findOne(id);
    }

    @Override
    public Speaker saveSpeaker(Speaker Speaker) {
        return SpeakerRepository.save(Speaker);
    }

    @Override
    public void deleteSpeaker(Integer id) {
        SpeakerRepository.delete(id);
    }



}
