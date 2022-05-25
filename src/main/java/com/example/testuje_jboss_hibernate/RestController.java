package com.example.testuje_jboss_hibernate;

import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Slf4j
@Path("/start")
@ApplicationScoped
public class RestController {
    @Inject
    EntityManagerFactory emf;

    @GET
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
}