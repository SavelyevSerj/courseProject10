package model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * Created by BigBadVoodooDaddy on 19.11.2017.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Document.FindAll", query = "select d from Document d"),

})
public class Document {

    // Поля

    /**
     * ідинтифікаційний номер
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    /**
     * номер, що присвоєний канцелярією
     */
    @Column(length = 30)
    private String number;

    /**
     * тип документа (може бути: службова записка, докладна записка, факс, письмо, распорядження, приказ і таке інше)
     */
    @Column(length = 40)
    private String type;

    /**
     * дата регістрації документа
     */
    @Column(length = 30)
    private Date date;

    /**
     * автор документа
     */
    @Column(length = 40)
    private String author;

    /**
     * відділ автора документа
     */
    @Column(length = 40)
    private String department;

    /**
     * куди направляється документ
     */
    @Column(length = 40)
    private String destination;

    /**
     * тема документа
     */
    @Column(length = 40)
    private String theme;

    /**
     * статус документа, тобто вход чи виход
     */
    @Column(length = 40)
    private String status;

    /**
     * шифр теми, якої стосується даний документ
     */
    @Column(length = 40)
    private String code;

    /**
     * місяць випуску документа
     */
    @Column(length = 20)
    private Integer month;

    /**
     * рік випуску документа
     */
    @Column(length = 20)
    private Integer year;

    //Constructor

    public Document(String number, String type, Date date, String author, String department, String destination, String theme, String status, String code, Integer month, Integer year) {
        this.number = number;
        this.type = type;
        this.date = date;
        this.author = author;
        this.department = department;
        this.destination = destination;
        this.theme = theme;
        this.status = status;
        this.code = code;
        this.month = month;
        this.year = year;
    }

    public Document() {
    }

    //getters and setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Basic
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }



    @Basic
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    @Basic
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    @Basic
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }



    @Basic
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }



    @Basic
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }



    @Basic
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }



    @Basic
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    @Basic
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    @Basic
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Document document = (Document) o;

        if (id != null ? !id.equals(document.id) : document.id != null) return false;
        if (number != null ? !number.equals(document.number) : document.number != null) return false;
        if (type != null ? !type.equals(document.type) : document.type != null) return false;
        if (date != null ? !date.equals(document.date) : document.date != null) return false;
        if (author != null ? !author.equals(document.author) : document.author != null) return false;
        if (department != null ? !department.equals(document.department) : document.department != null) return false;
        if (destination != null ? !destination.equals(document.destination) : document.destination != null)
            return false;
        if (theme != null ? !theme.equals(document.theme) : document.theme != null) return false;
        if (status != null ? !status.equals(document.status) : document.status != null) return false;
        if (code != null ? !code.equals(document.code) : document.code != null) return false;
        if (month != null ? !month.equals(document.month) : document.month != null) return false;
        return year != null ? year.equals(document.year) : document.year == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (theme != null ? theme.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (month != null ? month.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "I")
    private Collection<User> D;

    public Collection<User> getD() {
        return D;
    }

    public void setD(Collection<User> d) {
        D = d;
    }
}
