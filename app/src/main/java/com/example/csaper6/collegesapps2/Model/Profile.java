package com.example.csaper6.collegesapps2.Model;

import java.util.Date;

/**
 * Created by csaper6 on 12/7/16.
 */
public class Profile extends Person{
    private String fname;
    private Date birthday;
    private String lname;

    public Profile(String firstName, String lastName, Date birthday) {
        super(firstName, lastName);
        this.fname = firstName;
        this.birthday = birthday;
        this.lname = lastName;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
