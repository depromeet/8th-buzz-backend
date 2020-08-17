package com.depromeet.buzz.post.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommentResponses {
    private int totalComments;
    private List<CommentResponse> comments;

    private CommentResponses() {
    }

    public CommentResponses(int totalComments, List<CommentResponse> comments) {
        this.totalComments = totalComments;
        this.comments = comments;
    }

    public static CommentResponses mock() {
        List<CommentResponse> comments = new ArrayList<>();
        comments.add(CommentResponse.mock(1L, 20, "1", true, Arrays.asList(
                CommentResponse.mock(2L, 2, "2", true, new ArrayList<>()),
                CommentResponse.mock(3L, 3, "3", false, new ArrayList<>()),
                CommentResponse.mock(4L, 4, "4", true, new ArrayList<>()))));
        comments.add(CommentResponse.mock(5L, 5, "5", true, Arrays.asList(
                CommentResponse.mock(6L, 6, "6", false, new ArrayList<>()),
                CommentResponse.mock(7L, 7, "7", false, new ArrayList<>()))));
        comments.add(CommentResponse.mock(8L, 8, "8", false, new ArrayList<>()));
        return new CommentResponses(8, comments);
    }

    public int getTotalComments() {
        return totalComments;
    }

    public List<CommentResponse> getComments() {
        return comments;
    }
}
