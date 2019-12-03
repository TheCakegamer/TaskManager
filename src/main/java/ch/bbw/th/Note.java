package ch.bbw.th;


import javax.persistence.*;

@Entity
@Table(name = "notes")
@NamedQuery(name = "notes.findAll", query = "SELECT e FROM notes e")
public class Note {
    @Id
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "text")
    private String text;

    @Column(name = "checked")
    private boolean checked;

    @OneToOne
    private Title title;

    @ManyToOne
    private Category category;

    public Note() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }


    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", checked=" + checked +
                ", title=" + title +
                ", category=" + category +
                '}';
    }
}
