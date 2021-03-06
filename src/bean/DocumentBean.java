package bean;

import dao.DocumentDAO;
import model.Document;
import org.primefaces.event.SelectEvent;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
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

//    private Date date;

    private Document tmpDocument = new Document();

    private boolean editMode = false;


    //getters and setters


//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }

    //getters and setters

    public boolean isEditMode() {
        return editMode;
    }

    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
    }

    public Document getTmpDocument() {
        return tmpDocument;
    }

    public void setTmpDocument(Document tmpDocument) {
        this.tmpDocument = tmpDocument;
    }


    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }


    /**
     * повертає усі документи
     * @return List<Document>
     */
    public List<Document> getAllDocument() {
       return documentDAO.findAll();
    }

    /**
     * додає новий документ
     */
    public void addDocument() {
        documentDAO.add(tmpDocument);
        tmpDocument = new Document();
    }


    public void deleteDocument() {
        documentDAO.delete(tmpDocument.getId());
        tmpDocument = new Document();
    }

    public void updateDocument(Document tmpDocument) {
        documentDAO.update(tmpDocument);
        editMode = false;
    }

    public void startEdit(int id, String newNumber, String newType, Date newdDate, String newAuthor, String newDeprtment, String newTheme, String newStatus, String newCode, Integer newMonth, Integer newYear) {
        editMode = true;
        documentDAO.edit(id, newNumber, newType, newdDate, newAuthor, newDeprtment, newTheme, newStatus, newCode, newMonth, newYear);
    }
}
