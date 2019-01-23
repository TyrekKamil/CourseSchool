package com.pracownia.spring.services;
;
import com.pracownia.spring.entities.Opinion;

import java.util.List;

public interface OpinionService {

    Iterable<Opinion> listAllOpinions();

    Opinion getOpinionById(Integer id);

    Opinion saveOpinion(Opinion Opinion);

    void deleteOpinion(Integer id);


}
