package domain;

import java.util.ArrayList;
import java.util.List;

public class Comment {

    private List<String> comments;


    public Comment() {
        this.comments = new ArrayList<>();
    }

    public void addComment(String comment) {
        this.comments.add(comment);
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comments=" + comments +
                '}';
    }
}
