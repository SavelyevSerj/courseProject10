package model;

import javax.persistence.*;

/**
 * Created by BigBadVoodooDaddy on 28.11.2017.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Item.FindAll", query = "select i from Item i")
})
public class Item {

    // Поля

    /**
     * ідинтифікаційний номер
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    /**
     * порядковий номер пункту плану
     */
    @Column(length = 30)
    private String number;

    /**
     * шифр теми, до якої відноситься пункт плану
     */
    @Column(length = 40)
    private String code;

    /**
     * стислий опис робіт, які будуть виконані
     */
    @Column(length = 40)
    private String description;

    /**
     * користувач, який відповідає за виконання пункту плану
     */
    @Column(length = 40)
    private String respUser;

    /**
     * готовність робіт до кінця місяця у процентах
     */
    @Column(length = 40)
    private String complPercentage;

    /**
     * ознака того, що робота виконана
     */
    @Column(length = 200)
    private String result;

    /**
     * примітка відносно ходу виконання робіт
     */
    @Column(length = 200)
    private String notice;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != null ? !id.equals(item.id) : item.id != null) return false;
        if (number != null ? !number.equals(item.number) : item.number != null) return false;
        if (code != null ? !code.equals(item.code) : item.code != null) return false;
        if (description != null ? !description.equals(item.description) : item.description != null) return false;
        if (respUser != null ? !respUser.equals(item.respUser) : item.respUser != null) return false;
        if (complPercentage != null ? !complPercentage.equals(item.complPercentage) : item.complPercentage != null)
            return false;
        if (result != null ? !result.equals(item.result) : item.result != null) return false;
        return notice != null ? notice.equals(item.notice) : item.notice == null;
    }

    @Override
    public int hashCode() {
        int result1 = id != null ? id.hashCode() : 0;
        result1 = 31 * result1 + (number != null ? number.hashCode() : 0);
        result1 = 31 * result1 + (code != null ? code.hashCode() : 0);
        result1 = 31 * result1 + (description != null ? description.hashCode() : 0);
        result1 = 31 * result1 + (respUser != null ? respUser.hashCode() : 0);
        result1 = 31 * result1 + (complPercentage != null ? complPercentage.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (notice != null ? notice.hashCode() : 0);
        return result1;
    }
}
