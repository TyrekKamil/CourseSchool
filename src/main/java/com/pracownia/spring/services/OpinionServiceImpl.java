package com.pracownia.spring.services;

import com.pracownia.spring.entities.Opinion;
import com.pracownia.spring.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OpinionServiceImpl implements OpinionService {

    @Autowired
    private OpinionRepository OpinionRepository;

    @Override
    public Iterable<Opinion> listAllOpinions() {
        return OpinionRepository.findAll();
    }

    @Override
    public Opinion getOpinionById(Integer id) {
        return OpinionRepository.findOne(id);
    }

    @Override
    public Opinion saveOpinion(Opinion Opinion) {
        return OpinionRepository.save(Opinion);
    }

    @Override
    public void deleteOpinion(Integer id) {
        OpinionRepository.delete(id);
    }



}
