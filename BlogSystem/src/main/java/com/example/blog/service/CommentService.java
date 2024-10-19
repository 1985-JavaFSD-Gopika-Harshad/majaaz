package com.example.blog.service;

import com.example.blog.dto.CommentRequest;
import com.example.blog.model.BlogPost;
import com.example.blog.model.Comment;
import com.example.blog.repository.BlogPostRepository;
import com.example.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final BlogPostRepository blogPostRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, BlogPostRepository blogPostRepository) {
        this.commentRepository = commentRepository;
        this.blogPostRepository = blogPostRepository;
    }

    public Comment addComment(CommentRequest commentRequest) {
        BlogPost blogPost = blogPostRepository.findById(commentRequest.getBlogPostId())
                .orElseThrow(() -> new RuntimeException("Blog post not found"));

        Comment comment = Comment.builder()
                .content(commentRequest.getContent())
                .blogPost(blogPost)
                .build();

        return commentRepository.save(comment);
    }

    public Comment updateComment(Long id, CommentRequest commentRequest) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        comment.setContent(commentRequest.getContent());
        return commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    public List<Comment> searchComments(String keyword) {
        return commentRepository.findByContentContaining(keyword);
    }
}
