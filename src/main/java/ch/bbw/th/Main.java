package ch.bbw.th;

public class Main {
    public static void main(String[] args) {

        NoteRepository nr = new NoteRepository();
        nr.setup();

        Note mynote = new Note();

        Category mycategory = new Category("Homework");
        nr.createCategory(mycategory);

        Title mytitle = new Title();
        mytitle.setText("Do Homework");
        nr.createTitle(mytitle);

        mynote.setTitle(mytitle);
        mynote.setCategory(mycategory);
        mynote.setChecked(false);
        mynote.setText("Do the homework for thursday");

        nr.createNote(mynote);
        nr.closeup();


    }
}
