package model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by BigBadVoodooDaddy on 26.11.2017.
 */
@Entity
@NamedQueries({

})
public class Item {

    // поля

    /**
     * Ідинтифікаційний номер
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    /**
     * порядковий номер пункту
     */
    private int number;

    @Column(length = 40)
    private String code;

    @Column(length = 200)
    private String description;

    @Column(length = 40)
    private String respUser;

    @Column(length = 30)
    private String complPercentage;

    @Column(length = 40)
    private String result;

    @Column(length = 200)
    private String notice;


    // getters and setters

    @Basic
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }


    @Basic
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Basic
    public String getRespUser() {
        return respUser;
    }

    public void setRespUser(String respUser) {
        this.respUser = respUser;
    }


    @Basic
    public String getComplPercentage() {
        return complPercentage;
    }

    public void setComplPercentage(String complPercentage) {
        this.complPercentage = complPercentage;
    }


    @Basic
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }


    @Basic
    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private Collection<User> I;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "U")
    public Collection<User> getI() {
        return I;
    }

    public void setI(Collection<User> i) {
        I = i;
    }

    private String id;


}
