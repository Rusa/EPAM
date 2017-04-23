package javase01.t06;

import java.util.HashMap;


/**
 * Created by rusamaha on 4/23/17.
 */

// Спроектировать и разработать классы Запись в блокноте и Блокнот (записи блокнота хранятся в массиве).
// Реализовать методы: Добавить запись, Удалить запись, Редактировать запись, Посмотреть все записи.
// Написать для данного кода javadoc-документацию.

public class Notebook {
    private HashMap<String, Note> notes;

    public void addNote(Note note){
        notes.put(note.getUid(), note);

    }
    public void deleteNote(String noteUid){
        notes.remove(noteUid);
    }
    public void updateNote(Note note){
    }

    public HashMap<String, Note> getNotes() {
        return null;
    }
}
