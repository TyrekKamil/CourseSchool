package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Address;
import com.pracownia.spring.entities.Person;
import com.pracownia.spring.services.AddressService;;
import com.pracownia.spring.services.PersonService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
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
    private AddressService AddressService;

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

        Person p1 = new Person("Kamil","Pyrek",new DateTime(12,12,12,12,12), adr1, "98030408259");
        Person p2= new Person("Martyna","Paprycka",new DateTime(15,12,15,12,11), adr2, "981212408259");
        Person p3 = new Person("Maciej","Rusek",new DateTime(11,12,12,12,12), adr3, "980555408259");
        Person p4 = new Person("Michał","Gruby",new DateTime(12,5,12,12,12), adr4, "98030558259");

        PersonService.savePerson(p1);
        PersonService.savePerson(p2);
        PersonService.savePerson(p3);
        PersonService.savePerson(p4);

        AddressService.saveAddress(adr1);
        AddressService.saveAddress(adr2);
        AddressService.saveAddress(adr3);
        AddressService.saveAddress(adr4);

        return "Model Generated";
    }

}
