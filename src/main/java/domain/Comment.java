package domain;

import java.util.List;

public class Comment {

    private String comments;

    public Comment(String comments) {
        this.comments = comments;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public static List<Comment> getExampleCommentList(){
        return List.of(
                new Comment("Comment 1"),
                new Comment("Comment 2"),
                new Comment("Comment 3"),
                new Comment("Comment 4"),
                new Comment("Comment 5")
        );
    }

}
