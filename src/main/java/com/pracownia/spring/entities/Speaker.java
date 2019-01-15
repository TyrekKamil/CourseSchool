//package kamil.appdemo.entities;
//import javax.persistence.*;
//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import org.joda.time.DateTime;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Entity
//@Table(name = "speaker", uniqueConstraints = {
//        @UniqueConstraint(columnNames = {"pesel"})})
//public class Speaker
//{
//    @Id
//    @GeneratedValue(generator = "gen1")
//    @SequenceGenerator(name="gen1", sequenceName = "author_seq1")
//    @Column
//    private int id;
//
//    @Column
//    private String imie;
//
//    @Column
//    private String nazwisko;
//
//
//
//    @OneToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name="add_id", referencedColumnName = "id")
//    Address adres;
//
//
//    @OneToMany(mappedBy = "speaker", fetch = FetchType.LAZY)
//    private List<Course> course = new ArrayList<Course>();
//
//
//    @JsonIgnore
//    @Column(nullable = false, unique = true)
//    private String pesel;
//
//    // @Column(name="data urodzenia")
//    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
//    //private DateTime birth;
//
//
//    /* public DateTime getBirth() {
//         return birth;
//     }
//
//     public void setBirth(DateTime birth) {
//         this.birth = birth;
//     }
//
// */
//    public List<Course> getCourse() {
//        return course;
//    }
//
//    public void setCourse(List<Course> course) {
//        this.course = course;
//    }
//
//
//    public Address getAdres() {
//        return adres;
//    }
//
//    public void setAdres(Address adres) {
//        this.adres = adres;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getImie() {
//        return imie;
//    }
//
//    public void setImie(String imie) {
//        this.imie = imie;
//    }
//
//    public String getNazwisko() {
//        return nazwisko;
//    }
//
//    public void setNazwisko(String nazwisko) {
//        this.nazwisko = nazwisko;
//    }
//
//    public String getPesel() {
//        return pesel;
//    }
//
//    public void setPesel(String pesel) {
//        this.pesel = pesel;
//    }
//
//
//}
