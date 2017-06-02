package javase04.t04;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rusamaha on 6/1/17.
 */
public class Movie implements Serializable {
    private String title;
    private List<Actor> cast;

    public Movie(String title, List<Actor> cast) {
        this.title = title;
        this.cast = cast;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Actor> getCast() {
        return cast;
    }

    public void setCast(List<Actor> cast) {
        this.cast = cast;
    }
}
