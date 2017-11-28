package dao;

import model.Item;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ItemDAO {
    @PersistenceContext
    private EntityManager em;

    /**
     * повертає список усіх створених пунктів
     *
     * @return List<Item>
     */
    public List<Item> findAll() {
        return em.createNamedQuery("Item.FindAll", Item.class).getResultList();
    }

    /**
     * знаходить пункт за ідентифікаційним номером
     *
     * @param id
     * @return
     */
    public Item get(int id) {
        return em.find(Item.class, id);
    }

    /**
     * додає пункт плану
     * @param item
     * @return
     */
    public Item add(Item item) {
        em.persist(item);
        return item;
    }

    /**
     * видаляє пункт плану
     * @param id
     */
    public void delete(int id) {
        em.remove(get(id));
    }

    /**
     * оновлює інформацію про пункта плану
     * @param id
     */
    public void update(int id) {
        em.merge(get(id));
    }

    /**
     * забезпечує корегуваня пункту плану
     * @param id
     * @param newNumber
     * @param newCode
     * @param newDescription
     * @param newRespUser
     * @param newComplPercentage
     * @param newResult
     * @param newNotice
     * @return
     */
    public Item edit(int id, String newNumber, String newCode, String newDescription, String newRespUser, String newComplPercentage, String newResult, String newNotice) {
        Item item = this.get(id);
        item.setNumber(newNumber);
        item.setCode(newCode);
        item.setDescription(newDescription);
        item.setRespUser(newRespUser);
        item.setComplPercentage(newComplPercentage);
        item.setResult(newResult);
        item.setNotice(newNotice);
        return item;
        }
 }

