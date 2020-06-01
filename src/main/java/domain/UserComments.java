package domain;

public class UserComments {

    private User user;
    private Comment comment;

    public UserComments() {
    }

    public UserComments(User user, Comment comment) {
        this.user = user;
        this.comment = comment;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
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
                ", comment=" + comment +
                '}';
    }
}
