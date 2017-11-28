package dao;

import model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserDAO {
    @PersistenceContext
    private EntityManager em;

    /**
     * Повертає список користувачей системи
     * @return List<User>
     */
    public List<User> findAll() {
        return em.createNamedQuery("User.FindAll", User.class).getResultList();
    }

    /**
     * Повертає користувача, якого знаходить по логіну та паролю
     * @param login
     * @param password
     * @return User
     */
    public User find(String login, String password) {
        List<User> list = em.createNamedQuery("User.FindByLoginPassword", User.class)
                .setParameter("login", login)
                .setParameter("password", password)
                .getResultList();
        if (list.isEmpty()) return null;
        return list.get(0);
    }

    /**
     * знаходить користувача за ідентифікаційним номером
     * @param id
     * @return User
     */
    public User get(int id) {
        return em.find(User.class, id);
    }

    /**
     * додає користувача в БД
     * @param
     */
    public User add(User user) {
        em.persist(user);
        return user;
    }

    /**
     * видаляє користувача з БД по ідинтифікаційному номеру
     * @param id
     */
    public void delete(int id) {
        em.remove(get(id));
    }

    /**
     * оновлення існуючого користувача
     * @param id
     */
    public void update(int id) {
        em.merge(get(id));
    }

    /**
     * забезпечує корегування даних користувача
     * @param id
     * @param newLogin
     * @param newPassword
     * @param newName
     * @param newSurname
     * @param newPosition
     * @return User
     */
    public User edit(int id, String newLogin, String newPassword, String newName, String newSurname, String newPosition) {
        User user = this.get(id);
        user.setLogin(newLogin);
        user.setPassword(newPassword);
        user.setName(newName);
        user.setSurname(newSurname);
        user.setPosition(newPosition);
        return user;
    }
}

