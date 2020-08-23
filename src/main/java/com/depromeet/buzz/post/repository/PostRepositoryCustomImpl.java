package com.depromeet.buzz.post.repository;

import com.depromeet.buzz.post.domain.Post;
import com.depromeet.buzz.post.domain.QPost;
import com.depromeet.buzz.post.domain.Sort;
import com.depromeet.buzz.post.dto.PostsRequest;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
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
        OrderSpecifier sort = post.createdDate.desc();
        if (sortOption.equals(Sort.CLOSE)) {
            sort = post.closingDate.asc();
        }
        if (sortOption.equals(Sort.LIKE)) {
            sort = post.wishes.size().desc();
        }
        if (sortOption.equals(Sort.PRICE)) {
            sort = post.price.asc();
        }
        if (sortOption.equals(Sort.RECOMMEND)) {
            //            sort = post.closingDate.asc();
        }

        List<Post> posts = from(post)
            .where(ex)
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .orderBy(sort)
            .fetch();
        return new PageImpl<>(posts, pageable, totalCount);
    }

}
