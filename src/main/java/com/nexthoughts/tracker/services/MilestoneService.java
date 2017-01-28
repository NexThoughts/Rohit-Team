package com.nexthoughts.tracker.services;

import com.nexthoughts.tracker.classes.Enums.MilestoneCommand;
import com.nexthoughts.tracker.model.Milestone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MilestoneService {

    private SessionFactory sessionFactory;

    @Autowired
    private UserService userService;


    @Autowired
    public MilestoneService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.openSession();
    }

    public int create(MilestoneCommand milestoneCommand) {
        milestoneCommand.setCreatedBy(userService.currentUser());
        Milestone milestone = new Milestone(milestoneCommand);
        getSession().save(milestone);
        getSession().close();
        return milestone.getId();
    }

    public int update(MilestoneCommand milestoneCommand) {
        Session session = getSession();
        Milestone milestone = (Milestone) session.get(Milestone.class, milestoneCommand.getId());
        milestone = milestone.updateMilestone(milestone, milestoneCommand);
        session.update(milestone);
        session.flush();
        session.close();
        return milestone.getId();
    }

    public List<MilestoneCommand> list() {
        List<Milestone> milestoneList = getSession().createCriteria(Milestone.class).list();
        List<MilestoneCommand> milestoneCommands = new ArrayList<>();
        MilestoneCommand milestoneCommand = null;
        for (Milestone milestone : milestoneList) {
            milestoneCommand = new MilestoneCommand(milestone);
            milestoneCommands.add(milestoneCommand);
        }
        getSession().close();
        return milestoneCommands;
    }

    public Milestone read(Integer id) {
        Session session = getSession();
        Milestone milestone = (Milestone) session.get(Milestone.class, id);
        session.close();
        return milestone;
    }

    public void delete(int id) {
        Session session = getSession();
        Milestone milestone = (Milestone) getSession().get(Milestone.class, id);
        milestone.setCreatedBy(null);
        session.delete(milestone);
        session.flush();
        session.close();
    }
}
