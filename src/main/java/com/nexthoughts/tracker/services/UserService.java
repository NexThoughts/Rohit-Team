package com.nexthoughts.tracker.services;

import com.nexthoughts.tracker.classes.UserCommand;
import com.nexthoughts.tracker.model.Role;
import com.nexthoughts.tracker.model.User;
import com.nexthoughts.tracker.services.security.PasswordEncoderService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserService {

    @Autowired
    PasswordEncoderService encoderService;

    private SessionFactory sessionFactory;

    @Autowired
    private RoleService roleService;

    @Autowired
    public UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    protected Session getSession() {
        return sessionFactory.openSession();
    }


    public long create(UserCommand userCommand) {

        Role role = roleService.getUserRole();
        Set<Role> roles = new HashSet<Role>();
        roles.add(role);
        userCommand.setRoles(roles);

        User user = new User(userCommand);
        user.setPassword(encoderService.encode(userCommand.getPassword()));
        getSession().save(user);
        getSession().close();
        return user.getId();
    }


    public User read(Long id) {
        return (User) getSession().get(User.class, id);
    }

    public User getUserbyUsername(String username) {
        return (User) getSession().createCriteria(User.class)
                .add(Restrictions.eq("username", username)).uniqueResult();

    }

    public List<UserCommand> list() {
        List<User> userList = getSession().createCriteria(User.class).list();
        List<UserCommand> userCommandList = new ArrayList<>();
        UserCommand userCommand = null;
        for (User user : userList) {
            userCommand = new UserCommand(user);
            userCommandList.add(userCommand);
        }
        getSession().close();
        return userCommandList;
    }

    public User currentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username", name));
        List<User> users = criteria.list();
        return users.get(0);
    }
}
