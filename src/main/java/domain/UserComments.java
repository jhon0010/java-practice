package domain;

import java.util.List;

public class UserComments {

    private User user;
    private List<Comment> comments;

    public UserComments() {
    }

    public UserComments(User user, List<Comment> comments) {
        this.user = user;
        this.comments = comments;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserComments{" +
                "user=" + user +
                ", comment=" + comments +
                '}';
    }
}
