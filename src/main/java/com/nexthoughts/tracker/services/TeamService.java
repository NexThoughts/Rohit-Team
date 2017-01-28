package com.nexthoughts.tracker.services;


import com.nexthoughts.tracker.classes.TeamCommand;
import com.nexthoughts.tracker.model.Team;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TeamService {

    private SessionFactory sessionFactory;

    @Autowired
    public TeamService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.openSession();
    }
    public int create(TeamCommand teamCommand) {
        Team team = new Team(teamCommand);
        getSession().save(team);
        getSession().close();
        return team.getId();
    }

    public List<TeamCommand> list() {
        List<Team> teams = getSession().createCriteria(Team.class).list();
        List<TeamCommand> teamCommandList = new ArrayList<TeamCommand>();
        TeamCommand teamCommand = null;
        for (Team team : teams) {
            teamCommand = new TeamCommand(team);
            teamCommandList.add(teamCommand);
        }
        getSession().close();
        return teamCommandList;
    }

    public Team read(Long id) {
        return (Team) getSession().get(Team.class, id);
    }
}
