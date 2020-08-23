package com.depromeet.buzz.comment.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;

@DataJpaTest
class CommentRepositoryTest {
    @Autowired
    private CommentRepository commentRepository;

    /**
     *
     select count(comment0_.id) as col_0_0_
     from comment comment0_
     where comment0_.post_id = ?

     select comment0_.id                 as id1_1_,
     comment0_.created_by         as created_2_1_,
     comment0_.created_date       as created_3_1_,
     comment0_.last_modified_by   as last_mod4_1_,
     comment0_.last_modified_date as last_mod5_1_,
     comment0_.comment            as comment6_1_,
     comment0_.parent_comment_id  as parent_c7_1_,
     comment0_.post_id            as post_id8_1_,
     comment0_.user_id            as user_id9_1_
     from comment comment0_
     where comment0_.post_id = ?
     and (comment0_.parent_comment_id is null)
     order by comment0_.created_date desc
     limit ?
     offset ?
     */
    @Test
    void test() {
        commentRepository.findCommentsByPostId(1L, PageRequest.of(1, 10));
    }
}