package com.pracownia.spring.entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlRootElement
@XmlType(propOrder={"date"})
@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
        property="refId", scope=Person.class)
public class Person
{

    @Id     @GeneratedValue(generator = "gen6")
    @SequenceGenerator(name="gen6", sequenceName = "author_seq6")
    @Column
    private int id;

    @Column
    private String imie;

    @Column
    private String nazwisko;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date;
//
//    @Column
//    private String newDate(DateTime x)
//    {
//        return x.toString();
//    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="add_id", referencedColumnName = "id")
    Address adres;

    @Column(nullable = false, unique = true)
    private String pesel;

    public Person(String imie, String nazwisko, Address adres, String pesel, Date date) {
        this.imie = imie;
        this.nazwisko = nazwisko;
       this.adres = adres;
        this.pesel = pesel;
        this.date = date;
    }
    public Person()
    {

    }


  /* @ManyToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<Course>();

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }*/
//    @Column(name="data urodzenia")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
//    private DateTime birth;

//
//   public DateTime getBirth() {
//        return birth;
//    }
//
//    public void setBirth(DateTime birth) {
//        this.birth = birth;
//    }


   public Address getAdres() {
       return adres;
   }

    public void setAdres(Address adress) {
        this.adres = adress;
    }

   public int getId() {
        return id;
    }

    public void setPersonId(int personId) {
        this.id = personId;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }


}
