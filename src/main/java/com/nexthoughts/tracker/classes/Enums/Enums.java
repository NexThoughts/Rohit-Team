package com.nexthoughts.tracker.classes.Enums;

/**
 * Created by yogesh on 28/1/17.
 */
public class Enums {

    public enum  Roles{
        ROLE_USER,ROLE_ADMIN
    }

    public enum  MailType{


        USER_REGISTRATION(1),ISSUE_CREATION(2),PROJECT_CREATION(3),ACCESS_TO_TEAM(4);

        private int code;

        private MailType(int c) {
            code = c;
        }
        public int getCode() {
            return code;
        }

        }




}
