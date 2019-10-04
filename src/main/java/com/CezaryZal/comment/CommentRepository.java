package com.CezaryZal.comment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


@Repository
public class CommentRepository {

//    private SessionFactory sessionFactory;
//
//    @Autowired
//    public CommentRepository(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    @PersistenceContext
    private EntityManager entityManager;

    public Comment findById (int id){
//        Session curSession = sessionFactory.getCurrentSession();
//        Comment comment = curSession.get(Comment.class, id);

        Comment comment = entityManager.find(Comment.class, id);

        return comment;
    }

    public Comment getCommentByDate(LocalDate tmpDate) throws ParseException {
        System.out.println("LocalDate: " + tmpDate);

        //przesuniecie o 1 dzien do przodu
        LocalDate lDate = LocalDate.of(2018,05, 23);
        //dziala normalnie
        String dateText = "2018-05-23";
        //Przesyłając util.DATE nie rozpoznaje, nie znajduje recordu; formatujac wyrzuca bład niezgodności
        //SimpleDateFormat, rowniez nie znajduje recordu
        SimpleDateFormat foo = new SimpleDateFormat("yyyy-MM-dd");
        Date dateUni = foo.parse("2018-05-25");
        System.out.println(foo.format(dateUni));
        //Calendar podobnie jak util.DATE
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = new GregorianCalendar(2018,4,24);
        System.out.println(sdf.format(calendar.getTime()));



//        Session curSession = sessionFactory.getCurrentSession();
//
//
//        org.hibernate.query.Query <Comment>query = curSession.createQuery("FROM Comment WHERE localDate=:inputDate");
//        query.setParameter("inputDate", tmpDate);
//        Comment comment = query.getSingleResult();

        Comment comment = new Comment();

        return comment;
    }

    public void save(Comment comment){
        entityManager.persist(comment);
    }


//    public void uptabe(){
//        Comment comment = new Comment(4, LocalDate.of(2018, 04, 21), 5);
//        comment.setId(0);
//
//        Session curSession = sessionFactory.getCurrentSession();
//        Query query = curSession.createQuery("UPDATE Comment SET date='2018-06-26', nr_token=5, user_id=1 WHERE id=3");
//        query.executeUpdate();
////        curSession.saveOrUpdate(comment);
//    }


}
