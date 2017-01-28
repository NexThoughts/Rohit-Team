package com.nexthoughts.tracker.services;

import com.nexthoughts.tracker.classes.LabelCommand;
import com.nexthoughts.tracker.model.Label;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LabelService {

    private SessionFactory sessionFactory;

    @Autowired
    private UserService userService;


    @Autowired
    public LabelService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.openSession();
    }



    public int create(LabelCommand labelCommand) {
        labelCommand.setCreatedBy(userService.currentUser());
        Label student = new Label(labelCommand);
        getSession().save(student);
        getSession().close();
        return student.getId();
    }

    public int update(LabelCommand labelCommand) {
        Session session = getSession();
        Label label = (Label) session.get(Label.class, labelCommand.getId());
        label = label.updateLabel(label, labelCommand);
        session.update(label);
        session.flush();
        session.close();
        return label.getId();
    }

    public List<LabelCommand> list() {
        List<Label> labelList = getSession().createCriteria(Label.class).list();
        List<LabelCommand> labelCommands = new ArrayList<>();
        LabelCommand labelCommand = null;
        for (Label label : labelList) {
            labelCommand = new LabelCommand(label);
            labelCommands.add(labelCommand);
        }
        getSession().close();
        return labelCommands;
    }

    public Label read(Integer id) {
        Session session = getSession();
        Label label = (Label) session.get(Label.class, id);
        session.close();
        return label;
    }

    public void delete(int id) {
        Session session = getSession();
        Label label = (Label) getSession().get(Label.class, id);
        label.setCreatedBy(null);
        session.delete(label);
        session.flush();
        session.close();
    }
}
