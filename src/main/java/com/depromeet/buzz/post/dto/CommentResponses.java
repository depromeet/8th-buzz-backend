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
        comments.add(CommentResponse.mock(1L, "1", Arrays.asList(
            CommentResponse.mock(2L, "2", new ArrayList<>()),
            CommentResponse.mock(3L, "3", new ArrayList<>()),
            CommentResponse.mock(4L, "4", new ArrayList<>()))));
        comments.add(CommentResponse.mock(5L, "5", Arrays.asList(
            CommentResponse.mock(6L, "6", new ArrayList<>()),
            CommentResponse.mock(7L, "7", new ArrayList<>()))));
        comments.add(CommentResponse.mock(8L, "8", new ArrayList<>()));
        return new CommentResponses(8, comments);
    }

    public int getTotalComments() {
        return totalComments;
    }

    public List<CommentResponse> getComments() {
        return comments;
    }
}
