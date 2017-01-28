package com.nexthoughts.tracker.services;

import com.nexthoughts.tracker.classes.Enums.Enums;
import com.nexthoughts.tracker.model.Role;
import com.nexthoughts.tracker.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleService {

    private SessionFactory sessionFactory;

    @Autowired
    public RoleService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.openSession();
    }

    public long create(String role, User user) {
        Role persistentRole = new Role(role, user);
        getSession().save(persistentRole);
        getSession().close();
        return persistentRole.getId();
    }


    public Role read(Long id) {
        Session session = getSession();
        Role role = (Role) session.get(Role.class, id);
        session.close();
        return role;
    }

    public Role getUserRole(){
        Criteria criteria = getSession().createCriteria(Role.class);
        criteria.add(Restrictions.eq("role", Enums.Roles.ROLE_USER.toString()));
        List<Role> roles= criteria.list();
        return roles.get(0);
    }

}
