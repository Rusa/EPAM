package javase01.t06;

import static java.util.UUID.randomUUID;

/**
 * Created by rusamaha on 4/23/17.
 */
public class Note {
    private String message;
    private String uid;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = randomUUID().toString();
    }
}
