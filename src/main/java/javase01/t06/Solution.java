package javase01.t06;

import java.util.Scanner;

/**
 * Created by rusamaha on 4/26/17.
 */
public class Solution {
    public static void main(String[] args) {
        Notebook notebook = new Notebook();

        Note note = new Note();
        note.setMessage("My first note");
        notebook.addNote(note);

        note = new Note();
        note.setMessage("Second note");
        notebook.addNote(note);

        notebook.addNote(new Note("Simple Note"));

        notebook.updateNote();
        notebook.getNotes();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Action from the list: delete, add, add(), all, exit");
            String action = scanner.nextLine();

            switch (action) {
                case "update":
                    notebook.updateNote();
                    break;
                case "delete":
                    notebook.deleteNote();
                    break;
                case "add":
                    notebook.addNote();
                    break;
                case "add()":
                    notebook.addNote(new Note("Simple Note"));
                    break;
                case "all":
                    notebook.getNotes();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Appropriate commands are: update, delete, add, exit");
                    break;
            }
            System.out.println("");
        }
    }
}
