package com.freestack.evaluation;

import com.freestack.evaluation.models.Booking;
import com.freestack.evaluation.models.UberDriver;
import com.freestack.evaluation.models.UberUser;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;

import static java.lang.System.out;

public class UberApi {

    public static void enrollUser(UberUser uberUser) {
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(uberUser);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public static void enrollDriver(UberDriver uberDriver) {
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(uberDriver);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public static Booking bookOneDriver(UberUser uberUser) {
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();

            Booking newBooking = new Booking();
            newBooking.setUser(uberUser);
            newBooking.setStartOfTheBooking(LocalDateTime.now());

            Query queryAllAvailableDrivers = em.createQuery("select d from UberDriver d where d.available = true");
            List<UberDriver> availableDrivers = queryAllAvailableDrivers.getResultList();

            if (availableDrivers.isEmpty()) {
                newBooking = null;
                out.println("Il n'y a plus de chauffeurs disponibles, veuillez réessayer plus tard.");
            } else {
                newBooking.setDriver(availableDrivers.get(0));
                newBooking.getDriver().setAvailable(false);
                em.persist(newBooking);
            }
            em.getTransaction().commit();

            return newBooking;

        } finally {
            em.close();
        }
    }

    public static Booking finishBooking(Booking booking1) {
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            /*Query queryBooking = em.createQuery("select b from Booking b where b.id = :id");
            queryBooking.setParameter("id", booking1.getId());
            Booking booking1db = (Booking) queryBooking.getSingleResult();

            booking1db.getDriver().setAvailable(true);
            booking1db.setEndOfTheBooking(LocalDateTime.now());*/

            out.println(">> FIN DE RESERVATION 1" + booking1);

            //em.merge(booking1);
            booking1.setEndOfTheBooking(LocalDateTime.now());

            out.println(">> FIN DE RESERVATION 2" + booking1);
            //out.println(">> FIN DE RESERVATION" + booking1db);

            em.merge(booking1);
            em.getTransaction().commit();

            return booking1;

        } finally {
            em.close();
        }
    }

    public static Booking evaluateDriver(Booking booking1, int evaluationOfTheUser) {
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
/*            Booking bookingToEvaluate = em.find(Booking.class, booking1.getId());

            bookingToEvaluate.setEvaluation(evaluationOfTheUser);
            out.println(">> AVANT EVAL" + booking1);
            out.println(">> APRES EVAL" + bookingToEvaluate);

            em.persist(bookingToEvaluate);*/
            out.println(">> EVAL 1 " + booking1);

            //em.merge(booking1);
            booking1.setEvaluation(evaluationOfTheUser);

            out.println(">> EVAL 2 " + booking1);

            em.merge(booking1);
            em.getTransaction().commit();

            return booking1;

        } finally {
            em.close();
        }
    }


}

