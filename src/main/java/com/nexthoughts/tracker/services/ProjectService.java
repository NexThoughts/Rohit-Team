package com.nexthoughts.tracker.services;

import com.nexthoughts.tracker.classes.ProjectCommand;
import com.nexthoughts.tracker.model.Project;
import com.nexthoughts.tracker.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class ProjectService {
    private SessionFactory sessionFactory;

    @Autowired
    private UserService userService;

    @Autowired
    public ProjectService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.openSession();
    }


    public int create(ProjectCommand projectCommand) {

        projectCommand.setCreatedBy(userService.currentUser());

        Project project = new Project(projectCommand);

        getSession().save(project);
        getSession().close();
        return project.getId();
    }

    public int update(ProjectCommand projectCommand) {
        Session session = getSession();
        Project project = (Project) session.get(Project.class, projectCommand.getId());
        project = project.updateProject(project, projectCommand);
        session.update(project);
        session.flush();
        session.close();
        return project.getId();
    }

    public List<ProjectCommand> list() {
        List<Project> projectList = getSession().createCriteria(Project.class).list();
        List<ProjectCommand> projectCommandList = new ArrayList<>();
        ProjectCommand projectCommand = null;
        for (Project project : projectList) {
            projectCommand = new ProjectCommand(project);
            projectCommandList.add(projectCommand);
        }
        getSession().close();
        return projectCommandList;
    }

    public Project read(Integer id) {
        Session session = getSession();
        Project project = (Project) session.get(Project.class, id);
        session.close();
        return project;
    }

    public void delete(int id) {
        Session session = getSession();
        Project project = (Project) getSession().get(Project.class, id);
        project.setCreatedBy(null);
        session.delete(project);
        session.flush();
        session.close();
    }

    public Set<User> users(int id) {
        Session session = getSession();
        Project project = (Project) session.get(Project.class, id);
        return project.getUsers();
    }

    public void addUser(Integer projectId, Long userId) {
        Session session = getSession();
        Project project = (Project) getSession().get(Project.class, projectId);
        User user = (User) getSession().get(User.class, userId);
        if (user != null && project != null) {
            Set<Project> projects = new HashSet<Project>();
            projects.add(project);
            user.getProjects().addAll(projects);
            session.merge(user);
            session.update(user);
            session.flush();
            session.close();
        }
    }

}
