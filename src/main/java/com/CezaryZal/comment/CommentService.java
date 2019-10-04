package com.CezaryZal.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
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

    public Comment getCommentByDate (String inputDate) throws ParseException {
        LocalDate tmpDate = LocalDate.parse(inputDate);

        return  repo.getCommentByDate(tmpDate);
    }

    public int getNumber(){

        Comment comment = new Comment(2, LocalDate.of(2018, 05, 23), 3);
        comment.setId(0);

//        repo.uptabe();
        repo.save(comment);

        return 2;
    }
}
