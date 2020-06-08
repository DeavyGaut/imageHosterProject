package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private CommentService commentService;

    //AddingComments
    @RequestMapping(value = "/image/{imageId}/{title}/comments", method = RequestMethod.POST)
    public String addComments(@PathVariable("imageId") Integer imageId, @PathVariable("title") String title, HttpSession session, Comment newComment) {

        User user = (User) session.getAttribute("loggeduser");
        newComment.setUser(user);
        Image image = imageService.getImageByIdAndTitle(imageId,title);
        newComment.setImage(image);
        newComment.setDate(new Date());
        commentService.createComment(newComment);
        return "redirect:/images/{imageId}/{title}";
    }

}
