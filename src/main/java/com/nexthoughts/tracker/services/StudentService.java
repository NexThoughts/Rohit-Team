package com.nexthoughts.tracker.services;

import com.nexthoughts.tracker.classes.StudentCommand;
import com.nexthoughts.tracker.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentService {

    private SessionFactory sessionFactory;

    @Autowired
    public StudentService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.openSession();
    }


    public int create(StudentCommand studentCommand) {
        Student student = new Student(studentCommand);
        getSession().save(student);
        getSession().close();
        return student.getId();
    }

    public int update(StudentCommand studentCommand) {
        Session session = getSession();
        Student student = (Student) session.get(Student.class, studentCommand.getId());
        student = student.updateStudent(student, studentCommand);
        session.update(student);
        session.flush();
        session.close();
        return student.getId();
    }

    public List<StudentCommand> list() {
        List<Student> studentList = getSession().createCriteria(Student.class).list();
        List<StudentCommand> studentResponseList = new ArrayList<>();
        StudentCommand responseStudent = null;
        for (Student student : studentList) {
            responseStudent = new StudentCommand(student);
            studentResponseList.add(responseStudent);
        }
        getSession().close();
        return studentResponseList;
    }

    public Student read(Integer id) {
        Session session = getSession();
        Student student = (Student) session.get(Student.class, id);
        session.close();
        return student;
    }

    public void delete(int id) {
        Session session = getSession();
        Student student = (Student) getSession().get(Student.class, id);
        session.delete(student);
        session.flush();
        session.close();
    }
}
