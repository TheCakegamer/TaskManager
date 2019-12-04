package ch.bbw.th;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
@NamedQuery(name = "category.findAll", query = "SELECT e FROM Category e")
public class Category {

    @Id
    @Column(name = "cID", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cid;

    @Column(name = "name")
    private String name;

    @OneToMany
    private List<Note> notes;

    public Category(String name){
        this.name = name;
    }

    public Category() {

    }

    public Integer getId() {
        return cid;
    }

    public void setId(Integer id) {
        this.cid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + cid +
                ", name='" + name + '\'' +
                '}';
    }
}
