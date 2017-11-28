package dao;

import model.Document;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

/**
 * Created by BigBadVoodooDaddy on 19.11.2017.
 */
@Stateless
public class DocumentDAO {
    @PersistenceContext
    private EntityManager em;

    /**
     * Повертає список користувачей усіх документів, що зарегестровані
     * @return List<User>
     */
    public List<Document> findAll() {return em.createNamedQuery("Document.FindAll", Document.class).getResultList();}

    /**
     * знаходить документ за ідентифікаційним номером
     * @param id
     * @return Document
     */
    public Document get(int id) {return em.find(Document.class, id);}

    /**
     * додоає документ у БД
     * @param document
     * @return Document
     */
    public Document add(Document document) {
        Document documentFromDB = em.merge(document);
        return documentFromDB;
    }

    /**
     * видаляє документ з БД
     * @param id
     */
    public void delete(int id) {
        em.remove(get(id));
    }

    /**
     * оновлює доданий документ
     * @param document
     */
    public void update(Document document) {
        em.merge(document);
    }

    /**
     * забезпечує корегування даних про документ
     * @param id
     * @param newNumber
     * @param newType
     * @param newDate
     * @param newAuthor
     * @param newDepartment
     * @param newTheme
     * @param newStatus
     * @param newCode
     * @param newMonth
     * @param newYear
     * @return Document
     */
    public Document edit(int id, String newNumber, String newType, Date newDate, String newAuthor, String newDepartment, String newTheme, String newStatus, String newCode, Integer newMonth, Integer newYear) {
       Document document = this.get(id);
       document.setNumber(newNumber);
       document.setType(newType);
       document.setDate(newDate);
       document.setAuthor(newAuthor);
       document.setDepartment(newDepartment);
       document.setTheme(newTheme);
       document.setStatus(newStatus);
       document.setCode(newCode);
       document.setMonth(newMonth);
       document.setYear(newYear);
       return document;
    }
}
