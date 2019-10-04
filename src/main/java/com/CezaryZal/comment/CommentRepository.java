package com.CezaryZal.comment;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;

@Repository
public class CommentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Comment findById (int id){
        Comment comment = entityManager.find(Comment.class, id);
        return comment;
    }

    public Comment getCommentByDate(LocalDate tmpDate) {

        Query query = entityManager.createQuery("SELECT c FROM Comment c WHERE localDate=:inputDate");
        query.setParameter("inputDate", tmpDate);

        Comment comment = (Comment) query.getSingleResult();
        return comment;
    }

    public void save(Comment comment){
        entityManager.persist(comment);
    }
}
