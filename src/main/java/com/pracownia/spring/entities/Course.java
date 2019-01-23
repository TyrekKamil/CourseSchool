package com.pracownia.spring.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COURSE")
public class Course
{

    @Id
    @GeneratedValue(generator = "gen2")
    @SequenceGenerator(name="gen2", sequenceName = "author_seq2")
    @Column
    private int id;


    @OneToMany(mappedBy = "course", cascade=CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIgnore
    private List<Opinion> opinions = new ArrayList<Opinion>();

    @Column(name = "nazwa")
    private String name;

    @Column(name = "godziny")
    private int hour;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    private Speaker speaker;

    public Course()
    {

    }
    public Course(String name, int hour, Speaker speaker, List<Opinion> opinions) {
        this.name = name;
        this.hour = hour;
        this.speaker = speaker;
        this.opinions = opinions;
    }

    public Course(String name, int hour, Speaker speaker) {
        this.name = name;
        this.hour = hour;
        this.speaker = speaker;
    }

    public Course(String name, int hour) {
        this.name = name;
        this.hour = hour;
    }
/* @ManyToMany(cascade = CascadeType.ALL)
    private List<Person> person = new ArrayList<Person>();*/




  /*  public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }
*/

    public List<Opinion> getOpinions() {
        return opinions;
    }

    public void setOpinions(List<Opinion> opinions) {
        this.opinions = opinions;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }
    @JsonIgnore
    public String getAllInformation()
    {
        return name + " " + hour + " " + speaker.getImie() + " " + speaker.getNazwisko();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
