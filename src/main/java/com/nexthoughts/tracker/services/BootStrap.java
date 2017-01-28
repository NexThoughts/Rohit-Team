package com.nexthoughts.tracker.services;

import com.nexthoughts.tracker.classes.UserCommand;
import com.nexthoughts.tracker.classes.TeamCommand;
import com.nexthoughts.tracker.model.Role;
import com.nexthoughts.tracker.model.User;
import org.slf4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
public class BootStrap implements InitializingBean {
    @Autowired
    StudentService studentService;

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @Autowired
    TeamService teamService;


    private final Logger log = org.slf4j.LoggerFactory.getLogger(BootStrap.class);

    @Override
    @Transactional
    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bootstrapping data...");

        if (userService.list().isEmpty()) {
            createAdminUser();
            createUser();
        }
        if (teamService.list().isEmpty()){
            createTeam();
        }

        System.out.println("...Bootstrapping completed");
    }

    public void createAdminUser() {
        UserCommand adminUserCommand = new UserCommand();
        adminUserCommand.setEmail("akash@nexthoughts.com");
        adminUserCommand.setUsername("akash@nexthoughts.com");
        adminUserCommand.setPassword("password");
        User savedAdmin = userService.read(userService.create(adminUserCommand));
        String admin = "ROLE_ADMIN";
        Role roleAdmin = roleService.read(roleService.create(admin, savedAdmin));
        System.out.println("Admin created with ROLE_ADMIN and username - " + savedAdmin.getUsername() + "  and password -  " + savedAdmin.getPassword());
    }


    public void createUser() {
        UserCommand userCommand = new UserCommand();
        userCommand.setEmail("rohit@nexthoughts.com");
        userCommand.setUsername("rohit@nexthoughts.com");
        userCommand.setPassword("password");
        User savedUser = userService.read(userService.create(userCommand));
        String user = "ROLE_USER";
        Role roleUser = roleService.read(roleService.create(user, savedUser));
        System.out.println("User created with ROLE_USER and username - " + savedUser.getUsername() + "  and password -  " + savedUser.getPassword());

    }

    public void createTeam() {
//        Set<User> users = userService.hashSetUser();
        for (int i = 1; i <= 4; i++) {
            TeamCommand teamCommand = new TeamCommand();
            teamCommand.setName("Team" + i);
            int id = teamService.create(teamCommand);
            System.out.println("Team created with users - " + id);

        }
    }
}
