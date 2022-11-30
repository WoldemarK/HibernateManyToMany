package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            Transaction transaction = session.beginTransaction();

//            Movie movie = new Movie("SomeMovie", 1994);
//            Actor actor1 = new Actor("Bob", 22);
//            Actor actor2 = new Actor("Tom", 33);
//
//            movie.setActor(new ArrayList<>(List.of(actor1, actor2)));
//
//            actor1.setMovies(new ArrayList<>(Collections.singleton(movie)));
//            actor2.setMovies(new ArrayList<>(Collections.singleton(movie)));
//
//            session.save(movie);
//
//            session.save(actor1);
//            session.save(actor2);

            Movie movie = session.get(Movie.class,1);
            System.out.println(movie.getActor());

            Actor actor = session.get(Actor.class,2);
            actor.getMovies().forEach(System.out::println);

            transaction.commit();
            session.close();
        } finally {
            sessionFactory.close();
        }
    }
}
