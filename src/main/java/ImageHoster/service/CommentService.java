package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.Tag;
import ImageHoster.repository.CommentRepository;
import ImageHoster.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment getComment(Comment comment) {
        return commentRepository.getComment(comment);
    }

    public List<Comment> getAllComments(Integer imageId) {
        return commentRepository.getAllComments(imageId);
    }

    public Comment createComment(Comment comment) {
        return commentRepository.createComment(comment);
    }

    public void deleteComment(Comment comment) {
        commentRepository.deleteComment(comment);
    }

    public void deleteCommentByImage(Integer imageId) {
        commentRepository.deleteCommentByImage(imageId);
    }
}
