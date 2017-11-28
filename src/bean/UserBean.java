package bean;

import dao.UserDAO;
import model.User;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class UserBean implements Serializable {
    @EJB
    UserDAO userDAO;

    // Поля

    /**
     * користувач, що залогинився
     */
    private User loginUser = new User();

    /**
     * користувач, що вже пройшов аутентифікацію
     */
    private User workingUser = new User();

    private User tmpUser = new User();

    /**
     * boolean поле для процессу - логін
     */
    private boolean login = false;

    /**
     * поле дорывнює true, якщо користувач залогинився як адміністратор
     */
    private boolean admin = false;
    /**
     * поле дорывнює true, якщо користувач залогинився як начальник відділу
     */
    private boolean boss = false;
    /**
     * поле дорывнює true, якщо користувач залогинився як брігадір
     */
    private boolean supervisor = false;
    /**
     * поле дорывнює true, якщо користувач залогинився як інженер-конструктор
     */
    private boolean engineer = false;

    private boolean editMode = false;

    //getters and setters


    public boolean isEditMode() {
        return editMode;
    }

    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
    }

    public boolean isLogin() {
        return login;
    }

    public boolean isAdmin() {
        return admin;
    }

    public boolean isBoss() {
        return boss;
    }

    public boolean isSupervisor() {
        return supervisor;
    }

    public boolean isEngineer() {
        return engineer;
    }

    public User getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
    }

    public User getWorkingUser() {
        return workingUser;
    }

    public void setWorkingUser(User workingUser) {
        this.workingUser = workingUser;
    }

    public User getTmpUser() {
        return tmpUser;
    }

    public void setTmpUser(User tmpUser) {
        this.tmpUser = tmpUser;
    }

    //Методи

    /**
     * Повертає список усіх користувачей системи
     * @return List<User>
     */
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    /**
     * 1) знаходить користувача по паролю та логіну;
     * 2) якщо знаходить користувача у базі даних, прирівнює даного користувача до користувача, що буде працювати
     * у системі;
     * 3) відповідне boolean поле стає true;
     */
    public void doLogin() {
        User foundUser = userDAO.find(loginUser.getLogin(), loginUser.getPassword());
        if (foundUser != null)
            login = true;
        workingUser = foundUser;
        admin = "admin".equals(workingUser.getPosition());
        boss = "boss".equals(workingUser.getPosition());
        supervisor = "supervisor".equals(workingUser.getPosition());
        engineer = "engineer".equals(workingUser.getPosition());
    }

    /**
     * повертає користувача на початкову сторінку для аутентифікації
     */
    public void exit() {
        login = false;
        admin = false;
        boss = false;
        supervisor = false;
        engineer = false;
    }

    /**
     * додає нового користувача системи у БД
     */
    public void addUser() {
       userDAO.add(tmpUser);
       tmpUser = new User();
    }

    /**
     * Видаляє вказаного користувача
     */
    public void deleteUser() {
        userDAO.delete(tmpUser.getId());
        tmpUser = new User();
    }

    /**
     * поновлює дані про користувача
     * @param tmpUser
     */

    public void updateUser(User tmpUser) {
        //TODO Обновить информацию про юзера в БД
        userDAO.update(tmpUser.getId());
        editMode = false;
    }

    /**
     * корегування даних користувача
     * @param id
     * @param newLogin
     * @param newPassword
     * @param newName
     * @param newSurname
     * @param newPosition
     */
    public void startEdit(int id, String newLogin, String newPassword, String newName, String newSurname, String newPosition) {
        editMode = true;
        userDAO.edit(id, newLogin, newPassword, newName, newSurname, newPosition);
    }
}
