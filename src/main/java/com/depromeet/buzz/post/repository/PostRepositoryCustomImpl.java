package com.depromeet.buzz.post.repository;

import com.depromeet.buzz.post.domain.Post;
import com.depromeet.buzz.post.domain.QPost;
import com.depromeet.buzz.post.domain.Sort;
import com.depromeet.buzz.post.dto.PostsRequest;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.time.LocalDateTime;
import java.util.List;

public class PostRepositoryCustomImpl extends QuerydslRepositorySupport implements PostRepositoryCustom {

    public PostRepositoryCustomImpl() {
        super(Post.class);
    }

    @Override
    public Page<Post> findPosts(PostsRequest request, Pageable pageable) {
        QPost post = QPost.post;
        BooleanExpression ex = post.productName.contains(request.getKeyword())
                .and(post.closingDate.after(LocalDateTime.now()).or(post.closingDate.eq(LocalDateTime.now())));

        if (request.getCategory() != null && request.getCategory().length() != 0) {
            ex = ex.and(post.category.name.eq(request.getCategory()));
        }

        long totalCount = from(post)
                .where(ex)
                .fetchCount();

        Sort sortOption = request.getSortOption();
        JPQLQuery<Post> query = from(post)
                .where(ex)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize());

        if (sortOption.equals(Sort.CLOSE)) {
            query = query
                    .orderBy(post.closingDate.asc(), post.id.asc());
        }
        if (sortOption.equals(Sort.LIKE)) {
            query = query
                    .orderBy(post.wishes.size().desc(), post.id.asc());
        }
        if (sortOption.equals(Sort.PRICE)) {
            query = query
                    .orderBy(post.price.asc(), post.id.asc());
        }
        if (sortOption.equals(Sort.RECOMMEND)) {
            query = query
                    .orderBy(post.participations.size().desc(), post.closingDate.asc(), post.id.asc());
        }

        List<Post> posts = query
                .fetch();
        return new PageImpl<>(posts, pageable, totalCount);
    }

}
