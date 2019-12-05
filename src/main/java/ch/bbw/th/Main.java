package ch.bbw.th;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        NoteRepository nr = new NoteRepository();
        nr.setup();

        System.out.println("Tasks:\n======================");
        System.out.println("1. Create new Note");
        System.out.println("2. Read all Notes");
        System.out.println("3. Check Note");
        System.out.println("4. Delete Note");
        switch (scanner.nextLine()) {
            case "1":
                Note mynote = new Note();
                System.out.print("Title: ");
                Title mytitle = new Title(scanner.nextLine());
                nr.createTitle(mytitle);
                mynote.setTitle(mytitle);

                System.out.print("1) New Category\n2) Chose existing Category\nInput: ");
                switch (scanner.nextLine()) {
                    case "1":
                        System.out.print("Category: ");
                        Category mycategory = new Category(scanner.nextLine());
                        nr.createCategory(mycategory);
                        mynote.setCategory(mycategory);
                        break;

                    case "2":
                        List<Category> ListCategory = nr.getAllCategorys();

                        System.out.println("All Notes:\n=========================");
                        if (ListCategory == null) {
                            System.out.println("No Categories found");
                        } else {
                            for (Category cat : ListCategory) {
                                System.out.println(cat);
                            }
                        }
                        System.out.print("Category: ");
                        Category pickedcategory = nr.readCategory(scanner.nextInt());
                        nr.createCategory(pickedcategory);
                        mynote.setCategory(pickedcategory);
                }

                System.out.print("Text: ");
                mynote.setText(scanner.nextLine());
                mynote.setChecked(false);

                nr.createNote(mynote);
                break;
            case "2":
                List<Note> listNotes = nr.getAllNotes();

                System.out.println("All Notes:\n=========================");
                if (listNotes == null) {
                    System.out.println("No Notes found");
                } else {
                    for (Note note : listNotes) {
                        System.out.println(note);
                    }
                }
                break;
            case "3":
                List<Note> NoteList = nr.getAllNotes();

                System.out.println("All Notes:\n=========================");
                if (NoteList == null) {
                    System.out.println("No Notes found");
                } else {
                    for (Note note : NoteList) {
                        System.out.println(note);
                    }
                }
                System.out.print("ID: ");
                Note pickednote = nr.readNote(scanner.nextInt());
                pickednote.setChecked(!pickednote.isChecked());
                nr.updateNote(pickednote);
                break;
            case "4":
                List<Note> AllTheNotes = nr.getAllNotes();

                System.out.println("All Notes:\n=========================");
                if (AllTheNotes == null) {
                    System.out.println("No Notes found");
                } else {
                    for (Note note : AllTheNotes) {
                        System.out.println(note);
                    }
                }
                System.out.print("ID: ");
                nr.deleteNote(scanner.nextInt());
                break;
            default:
                break;
        }

        nr.closeup();


    }
}
