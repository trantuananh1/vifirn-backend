package com.vifrin.common.repository;

import com.vifrin.common.entity.Comment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: tranmanhhung
 * @since: Sun, 12/12/2021
 **/

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query(value = "SELECT * FROM comments WHERE post_id=?1", nativeQuery = true)
    List<Comment> findAllByPostId(Long postId, Pageable pageable);

    List<Comment> findByDestinationId(Long destinationId, Pageable pageable);

    List<Comment> findByDestinationIdAndStar(Long destinationId, int star, Pageable pageable);

    @Query(value = "SELECT post_id FROM comments WHERE id=?1", nativeQuery = true)
    Long getPostIdByCommentId(Long commentId);
}
