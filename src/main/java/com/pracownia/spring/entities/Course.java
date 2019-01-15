//package kamil.appdemo.entities;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "COURSE")
//public class Course
//{
//
//    @Id
//    @GeneratedValue(generator = "gen2")
//    @SequenceGenerator(name="gen2", sequenceName = "author_seq2")
//    @Column
//    private int id;
//
//    @Column(name = "nazwa")
//    private String name;
//
//    @Column(name = "godziny")
//    private int hour;
//
//    @JsonIgnore
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Speaker speaker;
//
//
//  /* @ManyToMany(cascade = CascadeType.ALL)
//    private List<Person> person = new ArrayList<Person>();*/
//
//
//    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
//    @JsonIgnore
//    private List<Opinion> opinions = new ArrayList<Opinion>();
//
//  /*  public List<Person> getPerson() {
//        return person;
//    }
//
//    public void setPerson(List<Person> person) {
//        this.person = person;
//    }
//*/
//
//    public List<Opinion> getOpinions() {
//        return opinions;
//    }
//
//    public void setOpinions(List<Opinion> opinions) {
//        this.opinions = opinions;
//    }
//
//    public Speaker getSpeaker() {
//        return speaker;
//    }
//
//    public void setSpeaker(Speaker speaker) {
//        this.speaker = speaker;
//    }
//    @JsonIgnore
//    public String getAllInformation()
//    {
//        return name + " " + hour + " " + speaker.getImie() + " " + speaker.getNazwisko();
//    }
//
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getHour() {
//        return hour;
//    }
//
//    public void setHour(int hour) {
//        this.hour = hour;
//    }
//
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//
//
//}
