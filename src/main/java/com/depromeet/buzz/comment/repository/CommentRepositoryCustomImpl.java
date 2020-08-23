package com.depromeet.buzz.comment.repository;

import com.depromeet.buzz.comment.domain.Comment;
import com.depromeet.buzz.comment.domain.QComment;
import com.depromeet.buzz.comment.domain.QCommentLike;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentRepositoryCustomImpl extends QuerydslRepositorySupport implements CommentRepositoryCustom {

    public CommentRepositoryCustomImpl() {
        super(Comment.class);
    }

    @Override
    public Page<Comment> findCommentsByPostId(Long postId, Pageable pageable) {
        QComment comment = QComment.comment1;
        long offset = pageable.getOffset();
        int pageSize = pageable.getPageSize();

        BooleanExpression eq = comment.post.id.eq(postId);
        JPQLQuery<Comment> where = from(comment).where(eq);
        long totalCount = from(comment)
            .where(eq)
            .fetchCount();


        List<Comment> comments = from(comment)
            .where(comment.post.id.eq(postId)
                .and(comment.parentComment.isNull()))
            .orderBy(comment.createdDate.desc())
            .offset(offset)
            .limit(pageSize)
            .fetch();

        return new PageImpl<>(comments, pageable, totalCount);
    }

    @Override
    public Map<Comment, Long> findPopularCommentsByPostId(Long postId) {
        QComment comment = QComment.comment1;
        QCommentLike commentLike = QCommentLike.commentLike;

        Map<Comment, Long> comentsLikeCnt = new HashMap<>();
        from(comment)
            .where(comment.post.id.eq(postId)
                .and(comment.parentComment.isNull()))
            .fetch()
            .stream()
            .forEach(c -> {
                long cnt = from(commentLike)
                    .where(commentLike.comment.id.eq(c.getId()))
                    .fetchCount();
                comentsLikeCnt.put(c, cnt);
            });

        return comentsLikeCnt;
    }

}
