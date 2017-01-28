package com.nexthoughts.tracker.services;

import com.nexthoughts.tracker.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WelcomeService {

    private SessionFactory sessionFactory;

    @Autowired
    public WelcomeService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public String getTitle() {
        return "Spring MVC 4.3.4 + gradle 3.2.1 + Hibernate 4.3.6";
    }

    public String getMessage() {
        return "My SQL Connector 5.1.29";
    }


    public void saveOrUpdateStudent(Student student) {
        sessionFactory.openSession().saveOrUpdate(student);
    }
}
