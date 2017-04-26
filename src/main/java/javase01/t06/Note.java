package javase01.t06;


/**
 * Created by rusamaha on 4/23/17.
 */

/**
 * Note which you can store in Notebooks
 *
 * <p><code>message</code> field, stores text of note</p>
 */

public class Note {
    private String message;

    /**
     * Initializes a newly created {@code Note} object so that it contains
     * an empty {@code message} field.
     */
    public Note() {
    }

    /**
     * Initializes a newly created {@code Note} object so that it contains
     * same sequence of characters as the argument in {@code message} field.
     *
     * @param message The initial value of the {@code message} field
     */
    public Note(String message) {
        this.message = message;
    }

    /**
     * Method returns stored message
     *
     * @return <code>String message</code>
     */
    public String getMessage() {
        return message;
    }

    /**
     * Stores <code>String</code> note in message field
     *
     * @param message to be stored
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
