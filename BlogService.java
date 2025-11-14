package com.susu.blog.Service;

import com.susu.blog.Entity.commentEntity;
import com.susu.blog.Entity.upvoteEntity;
import com.susu.blog.Repository.CommentRepository;
import com.susu.blog.Repository.UpvoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UpvoteRepository upvoteRepository;

    public upvoteEntity addUpvote(upvoteEntity upvote) {
        return upvoteRepository.save(upvote);
    }

    public commentEntity addComment(commentEntity comment) {

        return commentRepository.save(comment);
    }

    public void deleteComment(Integer commentId) {
        if (!commentRepository.existsById(commentId)) {
            throw new RuntimeException("评论不存在，ID: " + commentId);
        }
        commentRepository.deleteById(commentId);
    }

    public commentEntity updateComment(commentEntity comment) {

        return commentRepository.save(comment);
    }

    public void deleteUpvote(Integer upvoteId) {
        if (!upvoteRepository.existsById(upvoteId)) {
            throw new RuntimeException("点赞记录不存在，ID: " + upvoteId);
        }
        upvoteRepository.deleteById(upvoteId);
    }

    // 根据文章ID获取评论
    public List<commentEntity> getCommentsByArticleId(int articleId) {
        return commentRepository.findByArticleId(articleId);
    }

}
