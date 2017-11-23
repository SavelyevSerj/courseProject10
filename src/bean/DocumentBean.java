package bean;

import dao.DocumentDAO;
import model.Document;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by BigBadVoodooDaddy on 19.11.2017.
 */
@Named
@SessionScoped
public class DocumentBean implements Serializable{
    @EJB
    DocumentDAO documentDAO;

    //Поля

    private Document tmpDocument = new Document();


    //getters and setters


    public Document getTmpDocument() {
        return tmpDocument;
    }

    public void setTmpDocument(Document tmpDocument) {
        this.tmpDocument = tmpDocument;
    }

    /**
     * повертає усі документи
     * @return List<Document>
     */
    public List<Document> getAllDocument() {
       return documentDAO.findAll();
    }

    public void addDocument() {}

    public void deleteDocument() {}

    public void updateDocument() {}
}
