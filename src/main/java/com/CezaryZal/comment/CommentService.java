package com.CezaryZal.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Transactional
@Service
public class CommentService {

    private CommentRepository repo;

    @Autowired
    public CommentService(CommentRepository repo) {
        this.repo = repo;
    }

    public Comment findById(int id){
        Comment comment = repo.findById(id);
        return comment;
    }

    public Comment getCommentByDate (String inputDate){
        LocalDate tmpDate = LocalDate.parse(inputDate);

        return  repo.getCommentByDate(tmpDate);
    }

    public String create(Comment comment){
        //must by 0!
//        Comment comment = new Comment(5, LocalDate.of(2018, 05, 25), 6);
//        comment.setId(0);
//        repo.save(comment);

        comment.setId(0);
        repo.save(comment);

        return "correct";
    }
}
