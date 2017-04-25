package javase01.t06;

import java.util.Arrays;
import java.util.Scanner;


/**
 * Created by rusamaha on 4/23/17.
 */

// Спроектировать и разработать классы Запись в блокноте и Блокнот (записи блокнота хранятся в массиве).
// Реализовать методы: Добавить запись, Удалить запись, Редактировать запись, Посмотреть все записи.
// Написать для данного кода javadoc-документацию.


/**
 *  Notebook class for store Notes
 *
 *
 */
public class Notebook {
    public static void main(String[] args) {
        Notebook notebook = new Notebook();

//        Note note = new Note();
//        note.setMessage("My first note");
//        notebook.addNote(note);
//
//        note = new Note();
//        note.setMessage("Second note");
//        notebook.addNote(note);
//
//        notebook.updateNote();
//        notebook.getNotes();


        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Action: ");
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

    private Note[] notes = new Note[0];
    private int N = 0;
    private Scanner scanner = new Scanner(System.in);

    /**
     * Add note to the end of notebook with index N+1.
     *
     * N is number of current existing note
     * <p>Asking you enter message for new note</p>
     * <p>If length of <cod>notes</cod> array equals 0, create new Note[1]</p>
     * <p>If array of <cod>notes</cod> is full, creates a new array of notes with twice length of current and copy old notes</p>
     *
     * @param note type of Note to be added in Notebook
     */
    public void addNote(Note note){
        if(N == notes.length){
            Note[] copy = N == 0 ? new Note[1]: new Note[N*2];
            for (int i = 0; i < N; i++)
                copy[i] = notes[i];
            notes = copy;
        }
        notes[N++] = note;
    }

    /**
     * Add note to the end of notebook with index N+1.
     *
     * <p>If array is full, creates a new array of notes with twice length of current and copy old notes</p>
     * <p>Asking you enter message for new note</p>
     */
    public void addNote(){
        if(N == notes.length){
            Note[] copy = N == 0 ? new Note[1]: new Note[N*2];
            for (int i = 0; i < N; i++)
                copy[i] = notes[i];
            notes = copy;
        }

        System.out.println("Enter your new message for note: ");
        String message = scanner.nextLine();

        Note note = new Note();
        note.setMessage(message);
        notes[N++] = note;
    }

    /**
     *  Delete note by index
     *
     *  <p>Prints all notes with indices and asking which note you want to delete.</p>
     *  Deletes note with index you point and shifts entire array.
     *  <p>if array is one-quarter full half size array </p>
     */
    public void deleteNote(){
        getNotes();

        System.out.println("Enter index of note, you want to delete: ");
        int id = Integer.valueOf(scanner.nextLine());
        notes[id] = null;
        N--;
        for(int i = id; i<N; i++){
            notes[i] = notes[i+1];
        }
        if(N>0 && N == notes.length/4) {

            notes = Arrays.copyOfRange(notes, 0, notes.length/2);
        }
    }

    /**
     *  Update note by index
     *
     *  <p>Prints all notes with indices and asking which note you want to update.</p>
     *  if this index exist, asking you to enter new message for this notebook.
     */
    public void updateNote(){
        getNotes();

        System.out.println("Enter index of note, wich you want to update: ");
        int id = Integer.valueOf(scanner.nextLine());
        if(id>=N || id<0) {
            System.out.println("There is no such note with index: " + id);
            return;
        }

        System.out.println("Enter your new message for note number: " + id);
        String message = scanner.nextLine();

        notes[id].setMessage(message);
    }

    /**
     *  Prints all indices and notes from Notebook
     *
     */
    public void getNotes() {
        if(N == 0 ) {
            System.out.println("There is no notes in notebook!");
        } else {
            for(int i=0; i<N; i++){
                System.out.printf("%d. %s \n",i, notes[i].getMessage());
            }
        }
    }
}
