package dao;

import model.Document;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
}
