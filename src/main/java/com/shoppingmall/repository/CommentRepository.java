package com.shoppingmall.repository;

import com.shoppingmall.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByParentId(Long parentId);

}