package com.shoppingmall.service;

import com.shoppingmall.entity.Comment;
import com.shoppingmall.repository.CommentRepository;
import com.shoppingmall.security.login.CustomUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public void insertComment(String content, Long parentId, Authentication authentication){
        CustomUser user = (CustomUser) authentication.getPrincipal();

        Comment comment = new Comment(user.getUsername(), content, parentId);

        commentRepository.save(comment);
    }

    public List<Comment> findAllByParentId(Long parentId){

        return commentRepository.findAllByParentId(parentId);

    }

}