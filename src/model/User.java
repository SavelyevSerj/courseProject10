package model;

import javax.persistence.*;

/**
 * Created by BigBadVoodooDaddy on 19.11.2017.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "User.FindAll", query = "select u from User u"),
        @NamedQuery(name = "User.FindByLoginPassword", query = "select u from User u where u.login=:login and u.password=:password"),

})
public class User {

    // Поля

    /**
     * ідинтифікаційний номер
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    /**
     *логін користувача системою
     */
    @Column(length = 30)
    private String login;

    /**
     * пароль користувача системою
     */
    @Column(length = 50)
    private String password;

    /**
     * ім'я користувача системою
     */
    @Column(length = 30)
    private String name;

    /**
     * фамілія користувача системою
     */
    @Column(length = 30)
    private String surname;

    /**
     * позиція користувача системою
     */
    @Column(length = 50)
    private String position;


    // getters and setters для усіх полів

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        return position != null ? position.equals(user.position) : user.position == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Item U;

    public Item getU() {
        return U;
    }

    public void setU(Item u) {
        U = u;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Document I;

    public Document getI() {
        return I;
    }

    public void setI(Document i) {
        I = i;
    }
}
