package com.example.testuje_jboss_hibernate;

import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Slf4j
@Path("/")
@ApplicationScoped
public class RestController {
    @Inject
    EntityManagerFactory emf;

    @GET
    @Path("/save")
    @Produces("text/plain")
    public String hello() {
        log.info("GP: before");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(new StudentEntity("test"));
        log.info("GP: after persist");
        em.getTransaction().commit();
        em.close();
//        emf.close();

        return "OK";
    }

    @GET
    @Path("/find")
    @Produces("text/plain")
    public String find() {
        log.info("GP: before1");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        TypedQuery<StudentEntity> query = em.createQuery("SELECT s from StudentEntity as s", StudentEntity.class);
        query.getResultStream().forEach(System.out::println);

        log.info("GP: after query");
        em.getTransaction().commit();
        em.close();
//        emf.close();

        return "OK1";
    }


}