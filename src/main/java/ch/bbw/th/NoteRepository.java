package ch.bbw.th;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class NoteRepository {
    EntityManagerFactory emfactory;
    EntityManager entityManager;

    public void setup() {
        this.emfactory = Persistence.createEntityManagerFactory("TimsPersistenceUnit");
        this.entityManager = this.emfactory.createEntityManager();
    }

    public void closeup() {
        this.entityManager.close();
        this.emfactory.close();
    }

    public Note readNote(int id) {
        Note emp = entityManager.find(Note.class, id);
        return emp;
    }

    public void updateNote(Note note) {
        this.entityManager.getTransaction().begin();
        Note empfromdb = entityManager.find(Note.class, note.getId());
        empfromdb.setCategory(note.getCategory());
        empfromdb.setText(note.getText());
        empfromdb.setChecked(note.isChecked());
        empfromdb.setTitle(note.getTitle());
        entityManager.getTransaction().commit();
        System.out.println("Note with ID " + note.getId() + " successfully updated");
    }

    public void deleteNote(int id) {
        this.entityManager.getTransaction().begin();
        entityManager.remove(readNote(id));
        System.out.println("Note with ID " + id + " successfully deleted");
        this.entityManager.getTransaction().commit();
    }


    public void createNote(Note note) {
        this.entityManager.getTransaction().begin();
        entityManager.persist(note);
        System.out.println("Note successfully created");
        entityManager.getTransaction().commit();
    }

    public List<Note> getAllNotes() {
        List<Note> noteList = this.entityManager.createNamedQuery("Note.findAll").getResultList();
        return noteList;
    }
}
