package ch.bbw.th;

import javax.persistence.*;

@Entity
@Table(name = "title")
@NamedQuery(name = "title.findAll", query = "SELECT e FROM title e")
public class Title {

    @Id
    @Column(name = "tid", unique = true)
    private int tid;

    @Column(name = "name")
    private String text;

    public Title(){    }


    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Title{" +
                "tid=" + tid +
                ", text='" + text + '\'' +
                '}';
    }
}
