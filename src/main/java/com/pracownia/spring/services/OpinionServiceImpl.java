package com.pracownia.spring.services;

import com.pracownia.spring.entities.Course;
import com.pracownia.spring.entities.Opinion;
import com.pracownia.spring.entities.Person;
import com.pracownia.spring.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OpinionServiceImpl implements OpinionService {

    @Autowired
    private OpinionRepository OpinionRepository;

    @Override
    public List<Opinion> listAllOpinions() {
        return (List<Opinion>) OpinionRepository.findAll();
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
    @Override
    public List<Opinion> takePerson(Person P)
    {
        List<Opinion> result = new ArrayList<Opinion>();
        for(int i=0;i<listAllOpinions().size();i++)
            if(listAllOpinions().get(i).getPerson().getId() == P.getId())
                result.add(listAllOpinions().get(i));
            return result;
    }

    @Override
    public Iterable<Opinion> listAllProductsPaging(Integer pageNr, Integer howManyOnPage) {
        return OpinionRepository.findAll(new PageRequest(pageNr,howManyOnPage));
    }


    @Override
    public List<Course> mostOpinions()
    {
        return OpinionRepository.max();
    }
}
