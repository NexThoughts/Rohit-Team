package com.nexthoughts.tracker.services;

import com.nexthoughts.tracker.classes.Enums.Enums;
import com.nexthoughts.tracker.classes.Enums.Enums;
import com.nexthoughts.tracker.classes.MailCommand;
import com.nexthoughts.tracker.classes.UserCommand;
import com.nexthoughts.tracker.model.Issue;
import com.nexthoughts.tracker.model.Project;
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
    private SendMailService sendMailService;

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

        MailCommand mailCommand = new MailCommand(user.getEmail(), Enums.MailType.USER_REGISTRATION, user.getUuid());
        mailCommand.setMailContentAndSubject();
        sendMailService.send(mailCommand);
        return user.getId();
    }


    public User read(Long id) {
        return (User) getSession().get(User.class, id);
    }

    public User getUserbyUsername(String username) {
        return (User) getSession().createCriteria(User.class)
                .add(Restrictions.eq("username", username)).uniqueResult();

    }


    public User getUserByName(String username) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        List<User> users = criteria.list();
        return users.get(0);

    }

    public User getUserbyUuid(String uuid) {
        return (User) getSession().createCriteria(User.class)
                .add(Restrictions.eq("uuid", uuid)).uniqueResult();

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

    public List<Project> getProjects(){
        Criteria criteria = getSession().createCriteria(Project.class);
        criteria.add(Restrictions.eq("createdBy", currentUser()));
        criteria.setMaxResults(3);
        List<Project> projects= criteria.list();
        return projects;
    }

    public List<Issue> getIssues(){
        Criteria criteria = getSession().createCriteria(Issue.class);
        criteria.add(Restrictions.eq("createdBy", currentUser()));
        criteria.setMaxResults(3);
        List<Issue> issues= criteria.list();
        return issues;
    }

    public List<User> searchUser(String username) {
        List<User> users = (List<User>) getSession().createCriteria(User.class)
                .add(Restrictions.ilike("username", '%' + username + '%')).list();
        System.out.print("-----------" + users);
        return users;
    }
}
