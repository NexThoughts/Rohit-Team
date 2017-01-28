package com.nexthoughts.tracker.services;

import com.nexthoughts.tracker.classes.ProjectCommand;
import com.nexthoughts.tracker.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
        List<Project> projectList = userService.getProjects();
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

}
