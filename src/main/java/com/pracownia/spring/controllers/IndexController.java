package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.*;
import com.pracownia.spring.services.AddressService;;
import com.pracownia.spring.services.CourseService;
import com.pracownia.spring.services.PersonService;
import com.pracownia.spring.services.SpeakerService;
import com.pracownia.spring.services.OpinionService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Homepage controller.
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private PersonService PersonService;

    @Autowired
    private SpeakerService SpeakerService;

    @Autowired
    private AddressService AddressService;

    @Autowired
    private CourseService CourseService;

    @Autowired
    private OpinionService OpinionService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    String index() {
        return "index";
    }


    @RequestMapping(value = "/generateModel", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateModel() {

        LocalDateTime localtDateAndTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime dateAndTime  = ZonedDateTime.of(localtDateAndTime, zoneId);


      Address adr1 = new Address("Czestochowa","Wiejska","12");
      Address adr2 = new Address("Poznan", "Osiedle Zwycięstwa", "19A");
      Address adr3 = new Address("Wrocław","Miejska","51");
      Address adr4 = new Address("Kalisz","Częstochowska","98A");
      Address adr5 = new Address("Poznań","Wrocławska","12");
      Address adr6 = new Address("Poznań","Osiedle Zwycięstwa","12");

        Person p1 = new Person("Kamil","Pyrek", adr1, "98030408259", new Date(98,7,12));
        Person p2= new Person("Martyna","Paprycka", adr2,  "981212408259", new Date(94,5,12));
        Person p3 = new Person("Maciej","Rusek", adr3, "980555408259", new Date(81,4,3));
        Person p4 = new Person("Michał","Gruby", adr4, "98030558259", new Date(84,1,13));

        Speaker s1 = new Speaker("Włodzimierz","Lewy",adr5, "72121209091");
        Speaker s2 = new Speaker("Maciej","Prawy",adr6, "7998121298");



        Course c1 = new Course("C++ poznaj go prędko",12, s1);
        Course c2 = new Course("C# - czym jest?",15, s2 );
        Course c3 = new Course("Frontend - z czym się to je?",19, s2);
        Course c4 = new Course("Java - wygraj z komputerem",20, s2 );

        List<Course> speaker1 = new ArrayList<Course>();
        List<Course> speaker2 = new ArrayList<Course>();
        speaker1.add(c1);
        speaker2.add(c2);
        speaker2.add(c3);
        speaker2.add(c4);

        s1.setCourse(speaker1);
        s2.setCourse(speaker2);

        Opinion o1 = new Opinion(p1, c1, "Spoko kurs, da się nauczyć");
        Opinion o2 = new Opinion(p2, c1, "Za dużo teorii");
        Opinion o3 = new Opinion(p1,c2, "Super prowadzący!");
        Opinion o4 = new Opinion(p4, c2, "Więcej takich zajęć, polecam!");
        Opinion o5 = new Opinion(p2, c3, "Nawet dobrze... :) ");
        Opinion o6 = new Opinion(p3, c1,"Słabo, bez fajerwerek..");
        Opinion o7 = new Opinion(p2, c4, "Spałem... TYLKO BACKEND!!!");

        List<Opinion> course1 = new ArrayList<Opinion>();
        List<Opinion> course2 = new ArrayList<Opinion>();
        List<Opinion> course3 = new ArrayList<Opinion>();
        List<Opinion> course4 = new ArrayList<Opinion>();
        course1.add(o1);
        course1.add(o2);
        course1.add(o6);
        course2.add(o3);
        course2.add(o4);
        course3.add(o5);
        course1.add(o6);
        course4.add(o7);
        c1.setOpinions(course1);
        c2.setOpinions(course2);
        c3.setOpinions(course3);
        c3.setOpinions(course4);

        PersonService.savePerson(p1);
        PersonService.savePerson(p2);
        PersonService.savePerson(p3);
        PersonService.savePerson(p4);

        AddressService.saveAddress(adr1);
        AddressService.saveAddress(adr2);
        AddressService.saveAddress(adr3);
        AddressService.saveAddress(adr4);
        AddressService.saveAddress(adr5);
        AddressService.saveAddress(adr6);

        SpeakerService.saveSpeaker(s1);
        SpeakerService.saveSpeaker(s2);

        OpinionService.saveOpinion(o1);
        OpinionService.saveOpinion(o2);
        OpinionService.saveOpinion(o3);
        OpinionService.saveOpinion(o4);
        OpinionService.saveOpinion(o5);
        OpinionService.saveOpinion(o6);
        OpinionService.saveOpinion(o7);

        CourseService.saveCourse(c1);
        CourseService.saveCourse(c2);
        CourseService.saveCourse(c3);
        CourseService.saveCourse(c4);



        return "Model Generated";
    }

}
