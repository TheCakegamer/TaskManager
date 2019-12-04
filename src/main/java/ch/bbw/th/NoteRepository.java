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

    public Category readCategory(int id) {
        Category emp = entityManager.find(Category.class, id);
        return emp;
    }

    public void updateCategory(Category category) {
        this.entityManager.getTransaction().begin();
        Category empfromdb = entityManager.find(Category.class, category.getId());
        empfromdb.setName(category.getName());
        entityManager.getTransaction().commit();
        System.out.println("Category with ID " + category.getId() + " successfully updated");
    }

    public void deleteCategory(int id) {
        this.entityManager.getTransaction().begin();
        entityManager.remove(readCategory(id));
        System.out.println("Category with ID " + id + " successfully deleted");
        this.entityManager.getTransaction().commit();
    }


    public void createCategory(Category category) {
        this.entityManager.getTransaction().begin();
        entityManager.persist(category);
        System.out.println("Category successfully created");
        entityManager.getTransaction().commit();
    }

    public List<Category> getAllCategorys() {
        List<Category> categoryList = this.entityManager.createNamedQuery("Category.findAll").getResultList();
        return categoryList;
    }

    public Title readTitle(int id) {
        Title emp = entityManager.find(Title.class, id);
        return emp;
    }

    public void updateTitle(Title title) {
        this.entityManager.getTransaction().begin();
        Title empfromdb = entityManager.find(Title.class, title.getTid());
        empfromdb.setText(title.getText());
        entityManager.getTransaction().commit();
        System.out.println("Title with ID " + title.getTid() + " successfully updated");
    }

    public void deleteTitle(int id) {
        this.entityManager.getTransaction().begin();
        entityManager.remove(readTitle(id));
        System.out.println("Title with ID " + id + " successfully deleted");
        this.entityManager.getTransaction().commit();
    }


    public void createTitle(Title title) {
        this.entityManager.getTransaction().begin();
        entityManager.persist(title);
        System.out.println("Title successfully created");
        entityManager.getTransaction().commit();
    }

    public List<Title> getAllTitles() {
        List<Title> titleList = this.entityManager.createNamedQuery("Title.findAll").getResultList();
        return titleList;
    }
}
