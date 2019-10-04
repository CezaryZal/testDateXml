package com.CezaryZal.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.time.LocalDate;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @GetMapping("/inside")
    public Comment getCommentInside (){
        Comment comment = new Comment(5, LocalDate.of(2018, 05, 25), 6);
        comment.setId(1);
        return comment;
    }

    @GetMapping("/id/{nrId}")
    public Comment getComment (@PathVariable int nrId){
        Comment comment = commentService.findById(nrId);

        return comment;
    }


    @GetMapping("/byDate/{date}")
    public Comment getCommentByDate (@PathVariable String date) throws ParseException {
        Comment comment = commentService.getCommentByDate(date);

        return comment;
    }

    @GetMapping("/create")
    public int createManualRecord (){
        //getNubmer to approve method
        int number = commentService.create();
        return number;
    }
}
