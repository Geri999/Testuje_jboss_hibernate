package com.example.testuje_jboss_hibernate;

import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Slf4j
@Path("/start")
public class RestController {

    @Inject
    EntityManagerFactory emf;

    @GET
    @Produces("text/plain")
    public String hello() {
        log.info("before");
        EntityManager em = emf.createEntityManager();

        em.persist(new StudentEntity("test"));
        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();
        emf.close();

        return "OK";
    }
}