package com.pracownia.spring.entities;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
        property="person_id", scope=Opinion.class)
@Entity
@Table(name = "Opinion")
public class Opinion {



    @Id
    @GeneratedValue(generator = "gen5")
    @SequenceGenerator(name="gen5", sequenceName = "author_seq5")
    private int id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JsonIgnore
    @JoinColumn(name="person_id", referencedColumnName = "id")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="course_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Course course;

    @Column
    private String text;



    public Opinion(Person person, Course course, String text) {
        this.person = person;
        this.course = course;
        this.text = text;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() { return id; }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static Opinion copy(Opinion e) {
        Opinion o = new Opinion();
        o.setPerson(e.getPerson());
        o.setText(e.getText());
        o.setCourse(e.getCourse());

        return o;
    }

    public Opinion()
    {}



}
