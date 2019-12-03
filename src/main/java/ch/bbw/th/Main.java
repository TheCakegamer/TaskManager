package ch.bbw.th;

public class Main {
    public static void main(String[] args) {

        NoteRepository nr = new NoteRepository();
        nr.setup();

        Note mynote = new Note();
        Title mytitle = new Title();
        Category mycategory = new Category();
        mycategory.setName("Homework");
        mytitle.setText("Do Homework");
        mynote.setTitle(mytitle);
        mynote.setCategory(mycategory);
        mynote.setChecked(false);
        mynote.setText("Do the homework for thursday");

        nr.createNote(mynote);

        nr.closeup();


    }
}
