package com.pracownia.spring.entities;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.joda.time.DateTime;

@Entity
@Table(name = "ADDRESSES")
public class Address
{

    @Id
    @GeneratedValue(generator = "gen")
    @SequenceGenerator(name="gen", sequenceName = "author_seq")
    @Column
    private int id;
    public Address(int id, String miasto, String ulica, String numer) {
        this.id = id;
        this.miasto = miasto;
        this.ulica = ulica;
        this.numer = numer;
    }
    public Address(String miasto, String ulica, String numer) {
        this.miasto = miasto;
        this.ulica = ulica;
        this.numer = numer;
    }


    public Address()
    {

    }
    @Column(nullable = false)
    String miasto;

    @Column(nullable = false)
    String ulica;

    @Column(nullable = false)
    String numer;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNumer() {
        return numer;
    }

    public void setNumer(String numer) {
        this.numer = numer;
    }




}
