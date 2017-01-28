package com.nexthoughts.tracker.services;

import com.nexthoughts.tracker.classes.IssueCommand;
import com.nexthoughts.tracker.model.Issue;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class IssueService {

    private SessionFactory sessionFactory;

    @Autowired
    private UserService userService;


    @Autowired
    public IssueService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.openSession();
    }


    public int create(IssueCommand issueCommand) {
        issueCommand.setCreatedBy(userService.currentUser());
        Issue student = new Issue(issueCommand);
        getSession().save(student);
        getSession().close();
        return student.getId();
    }

    public int update(IssueCommand issueCommand) {
        Session session = getSession();
        Issue issue = (Issue) session.get(Issue.class, issueCommand.getId());
        issue = issue.updateIssue(issue, issueCommand);
        session.update(issue);
        session.flush();
        session.close();
        return issue.getId();
    }

    public List<IssueCommand> list() {
        List<Issue> studentList = getSession().createCriteria(Issue.class).list();
        List<IssueCommand> studentResponseList = new ArrayList<>();
        IssueCommand responseStudent = null;
        for (Issue issue : studentList) {
            responseStudent = new IssueCommand(issue);
            studentResponseList.add(responseStudent);
        }
        getSession().close();
        return studentResponseList;
    }

    public Issue read(Integer id) {
        Session session = getSession();
        Issue issue = (Issue) session.get(Issue.class, id);
        session.close();
        return issue;
    }

    public void delete(int id) {
        Session session = getSession();
        Issue issue = (Issue) getSession().get(Issue.class, id);
        session.delete(issue);
        session.flush();
        session.close();
    }
}
