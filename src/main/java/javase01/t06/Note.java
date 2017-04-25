package javase01.t06;


/**
 * Created by rusamaha on 4/23/17.
 */

/**
 *  Note which you can store in Notebooks
 *
 *  <p><code>message</code> field, stores text of note</p>
 *
 */

public class Note {
    private String message;

    /**
     * Method returns stored message
     * @return <code>String message</code>
     */
    public String getMessage() {
        return message;
    }

    /**
     * Stores <code>String</code> note in message field
     * @param message to be stored
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
